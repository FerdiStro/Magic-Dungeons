package model.player;

import lombok.Setter;
import model.Model;

public class Movement {

    @Setter
    private int speed = 1;

    /*
        Standard speed of Movement is 1
     */




    //Movement
    public void update(Model model, String updateName){
        if(updateName.equals("moveRight")){
            model.setX(model.getX() + speed);
        }
        if (updateName.equals("moveLeft")){
            model.setX(model.getX() - speed);
        }
    }
}
