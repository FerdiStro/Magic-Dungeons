package model;

import bussystem.BusSystem;
import lombok.AllArgsConstructor;
import lombok.Setter;
import model.player.HitBox;
import model.player.Movement;

import java.awt.*;


public class Square implements Model{

    private HitBox hitBox;
    private final String name;
    private boolean hitBoxVisible;

    private BusSystem busSystem;

    public Square(String name,  int x, int y, int with, int height,  BusSystem busSystem){
        this.busSystem = busSystem;
        this.name = name;
        setX(x);
        setY(y);

        setHitBox(with, height);
    }


    @Override
    public void draw(Graphics2D g) {
        Integer x = busSystem.get(name + "X", Integer.class);
        Integer y = busSystem.get(name + "Y", Integer.class);



        g.setBackground(Color.RED);
        g.fillRect(x,y, hitBox.getWidth(), hitBox.getHeight());
        g.drawRect(x,y, hitBox.getWidth(), hitBox.getHeight());

    }

    @Override
    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }

    @Override
    public HitBox getHitbox() {
        return null;
    }

    @Override
    public void setHitBoxVisible(boolean hitBoxVisible) {
        this.hitBoxVisible = hitBoxVisible;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BusSystem getBusSystem() {
        return this.busSystem;
    }

    @Override
    public void setMovement(Movement movement) {

    }

    @Override
    public Movement getMovement() {
        return null;
    }

    @Override
    public void disposeResources() {

    }
}
