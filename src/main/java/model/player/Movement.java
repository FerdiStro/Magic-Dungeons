package model.player;

import bussystem.BusSystem;
import bussystem.clock.GameGlockObserver;
import logger.Logger;
import lombok.Setter;


public class Movement implements GameGlockObserver {

    private BusSystem busSystem;



    @Setter
    private int speed = 1;
    @Setter
    private boolean disableMovement;

    private static final int GRAVITATIONAL_CONSTANT = 1;

    /*
        Gravity System
     */
    @Setter
    private boolean gravity;
    @Setter
    private int mass = 1;
    private boolean observe;

    private final String name;



    public Movement(String name, BusSystem busSystem){
        this.name = name;
        init(busSystem);

    }
    public Movement(String name, BusSystem busSystem, int speed){
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

        if(moveRight){
            move(DIR.X, speed);

        }
        if(moveLeft){
            move(DIR.X, -speed);
        }

        /*
            Gravity
         */
        applyGravity();


    }

    public void applyGravity() {
        if (gravity&&fall) {
            verticalSpeed += GRAVITATIONAL_CONSTANT * mass;
            move(DIR.Y, verticalSpeed);
        }


        Integer y = busSystem.get(name + "Y", Integer.class);

        //todo: hitbox system
        if (y >= 500) {
            verticalSpeed = 0;
            fall=false;
        }
        if(y <= 500){
            fall=true;
        }
    }


    private void move(DIR dir, Integer value){
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