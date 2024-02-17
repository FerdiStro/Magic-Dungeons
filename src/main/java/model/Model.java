package model;

import bussystem.informationStore.StateObserver;

import java.awt.*;

public interface Model {
    void draw(Graphics2D g);
    void setHitBox(int w, int h);

    void setHitBoxVisible(boolean hitBoxVisible);

    void setName(String name);

    String getName();

    Integer getX();
    Integer getY();
    void setX(Integer x);
    void setY(Integer y);

    StateObserver getObserver();


}
