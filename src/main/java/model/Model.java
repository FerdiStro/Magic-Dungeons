package model;

import bussystem.BusSystem;
import bussystem.informationStore.StateObserver;
import logger.Logger;
import model.player.Movement;

import java.awt.*;

public interface Model {
    void draw(Graphics2D g);


    void setHitBox(int w, int h);

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
        setMovement(new Movement(getName() ,getBusSystem()));
    }
    default void addMovement(int speed){
         setMovement(new Movement(getName(), getBusSystem(), speed));
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
            Logger.error("Model: "+this.getName()+"is null! You need to add movement to Model to add gravity ");
            return false;
        }
        return  true;
    }


    /*
        Flush Images when methode is no longer needed. This save Memory
     */
    void disposeResources();



}
