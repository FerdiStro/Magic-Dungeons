package model.player;

import bussystem.BusSystem;
import bussystem.HitBoxList;
import bussystem.clock.GameGlockObserver;
import logger.Logger;
import lombok.Setter;

import java.util.Map;


public class Movement implements GameGlockObserver {

    private BusSystem busSystem;



    @Setter
    private int speed = 1;
    @Setter
    private boolean disableMovement;
    @Setter
    private int jumpHeight = 20;

    private static final int GRAVITATIONAL_CONSTANT = 1;

    /*
        Gravity System
     */
    @Setter
    private boolean gravity;
    @Setter
    private int mass = 1;
    private boolean observe;
    @Setter
    private HitBox hitBox;


    private final String name;



    public Movement(String name, BusSystem busSystem, HitBox hitBox){
        this.hitBox = hitBox;
        this.name = name;
        init(busSystem);

    }
    public Movement(String name, BusSystem busSystem, int speed, HitBox hitBox){
        this.hitBox = hitBox;
        this.name = name;
        this.speed = speed;
        init(busSystem);
    }


    private void init(BusSystem busSystem){
        this.busSystem = busSystem;
        busSystem.addGameClockListener(this);
        this.observe = true;
    }


    @Override
    public boolean observe() {
        return this.observe;
    }

    private int verticalSpeed = 0 ;
    private boolean fall = false;
    @Override
    public void clock() {
        /*
            Movement with Input-System
         */

        Boolean moveRight = busSystem.get("moveRight", Boolean.class);
        Boolean moveLeft = busSystem.get("moveLeft", Boolean.class);

        Boolean moveUp = busSystem.get("moveUp", Boolean.class);

        if(moveRight){
            move(DIR.X, speed);

        }
        if(moveLeft){
            move(DIR.X, -speed);
        }
        if(moveUp){
            move(DIR.Y, -jumpHeight);
        }


        /*
            Gravity
         */
        applyGravity();


    }
    boolean firstHitBox = false;

    public void applyGravity() {
        if (gravity&&fall) {
            verticalSpeed += GRAVITATIONAL_CONSTANT * mass;
            move(DIR.Y, verticalSpeed);
        }


        Integer y = busSystem.get(name + "Y", Integer.class);
        Integer x = busSystem.get(name + "X", Integer.class);


        Map<String, HitBox> stringHitBoxMap = HitBoxList.get();
        for(String key : stringHitBoxMap.keySet()){
            HitBox hitBoxL = stringHitBoxMap.get(key);
            if(!key.equals(name)){
                if (
                        y + hitBox.getHeight() >= hitBoxL.getY() &&
                        x + hitBox.getWidth() >= hitBoxL.getX() &&
                        x <= hitBoxL.getX() + hitBoxL.getWidth()


                )


                {
                    fall = false;
                    firstHitBox = true;
                    verticalSpeed = 0;
                } else if (!firstHitBox) {

                    fall = true;

                }

            }
        }
    }


    private void move(DIR dir, Integer value){
        firstHitBox = false;
        switch (dir){
            case X -> {
                Integer x = busSystem.get(name + "X", Integer.class);
                busSystem.save(name + "X", x+value);
                busSystem.updateGraphics();
            }
            case Y -> {

                Integer y = busSystem.get(name + "Y", Integer.class);
                busSystem.save(name + "Y", y+value);
                busSystem.updateGraphics();
            }
        }

    }
    enum DIR{
        X,
        Y
    }
}
