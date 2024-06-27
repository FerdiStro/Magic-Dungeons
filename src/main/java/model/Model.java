package model;

import bussystem.BusSystem;
import bussystem.HitBoxList;
import logger.Logger;
import model.player.HitBox;
import model.player.Movement;

import java.awt.*;

public interface Model {
    void draw(Graphics2D g);

    void setHitBox(HitBox hitBox);
    default void setHitBox(int w, int h){
        /*
        HitBox objet
         */
       HitBox hitbox = getHitbox();
       if(hitbox == null){
           hitbox = new HitBox(getX(), getY(), 0, 0);
       }
       hitbox.setWidth(w);
       hitbox.setHeight(h);
       setHitBox(hitbox);

       /*
       Globale hitBox list
        */
       if(w == 0 && h == 0 ){
        HitBoxList.remove(getName());
       }
       HitBoxList.add(getName(), hitbox);


       /*
       Movement
        */
       Movement movement = getMovement();
       if(movement != null){
           movement.setHitBox(hitbox);
           setMovement(movement);
       }
    }
    HitBox getHitbox();

    void setHitBoxVisible(boolean hitBoxVisible);



    String getName();

    default  Integer getX(){
        return getBusSystem().get(getName() + "X", Integer.class);
    }
    default Integer getY(){
        return getBusSystem().get(getName() + "Y", Integer.class);
    }
    default  void setX(Integer x){
        getBusSystem().saveInit(getName() + "X", x);

    }
    default void setY(Integer y){
        getBusSystem().saveInit(getName() + "Y", y);

    }

    BusSystem getBusSystem();


    /*
        Movement Settings
     */
    void setMovement(Movement movement);


    Movement getMovement();

    default void addMovement(){
        if(getHitbox() != null){
            setMovement(new Movement(getName() ,getBusSystem(), getHitbox()));
        }else{
            Logger.error("Hitbox is null ");
            Logger.debug(getName()  + "Can't add movement ");
        }
    }

    default void addMovement(int speed){
        if(getHitbox() != null){
            setMovement(new Movement(getName(), getBusSystem(), speed,getHitbox()));
        }else{
            Logger.error("Hitbox is null ");
            Logger.debug(getName()  + " Can't add movement ");
        }


    }

    default void setGravity(boolean gravity, int mass){
        Movement movement = getMovement();
        if(checkMovement(movement)){
            movement.setGravity(gravity);
            movement.setMass(mass);
            setMovement(movement);
        }

    }
    default  void setGravity(boolean gravity){
        Movement movement = getMovement();
        if(checkMovement(movement)){
            movement.setGravity(gravity);
            setMovement(movement);
        }
    }

    default void setSpeed(Integer speed){
        Movement movement = getMovement();
        if(checkMovement(movement)){
            movement.setSpeed(speed);
            setMovement(movement);
        }
    }


    private boolean checkMovement(Movement movement){
        if(movement == null){
            Logger.error("Model: "+this.getName()+" is null! You need to add movement to Model to add gravity ");
            return false;
        }
        return  true;
    }


    /*
        Flush Images when methode is no longer needed. This save Memory
     */
    void disposeResources();



}
