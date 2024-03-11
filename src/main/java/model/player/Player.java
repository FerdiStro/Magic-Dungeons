package model.player;

import bussystem.BusSystem;
import config.ConfigLoader;
import logger.Logger;

import lombok.Getter;
import lombok.Setter;
import model.Model;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;


public class Player implements Model, ConfigLoader {

    private HashMap<String, Object> configs;

    @Getter
    private BusSystem busSystem;
    @Getter
    private String  name;
    @Setter
    private String path;



    /*
        HitBox-Settings
     */
    private HitBox hitBox;
    private boolean hitBoxVisible = false;

    /*
        Movement
     */
    @Setter
    @Getter
    private Movement movement;

    /*
       Images
     */
    private  BufferedImage head;
    private BufferedImage body;





    /*
        Create player with basic HitBox w = 50 ; h = 50
     */
    public Player(String name, int x, int y, BusSystem busSystem ){
        init(name, x ,y, 0, 0, busSystem);
    }
      /*
        Create player
     */
    public Player(String name, int x ,int y, int hitBoxW , int hitBoxH, BusSystem busSystem){
        init(name, x ,y, 0, 0, busSystem);
    }
    public Player(String name, int x ,int y, int hitBoxW , int hitBoxH, String path, BusSystem busSystem) {
        this.path = path;
        init(name, x, y, hitBoxW, hitBoxH, busSystem);
    }




    private void init(String name, int x, int y, int hitBoxW, int hitBoxH, BusSystem busSystem){
        this.name   = name;
        this.busSystem = busSystem;

        setX(x);
        setY(y);

        setHitBox(hitBoxW, hitBoxH);





        /*
            Load configs with or without path
         */
        try {
            if(path != null){
                load(this, null, path );
            }else{
                load(this, null);
            }
        } catch (IOException e) {
            Logger.error("Can't load config of player objected Named: " + name);
            throw new RuntimeException(e);
        }

        head =  (BufferedImage ) configs.get("head");
        body =  (BufferedImage ) configs.get("body");

    }




    @Override
    public void draw(Graphics2D g) {
        Integer x = busSystem.get(name + "X", Integer.class);
        Integer y = busSystem.get(name + "Y", Integer.class);


        if(hitBoxVisible){
            g.setBackground(Color.RED);
            g.fillRect(x,y, hitBox.getWidth(), hitBox.getHeight());
            g.drawRect(x,y, hitBox.getWidth(), hitBox.getHeight());
        }
        g.drawImage(head, x, y, head.getWidth(), head.getHeight(), null);
        g.drawImage(body, x, y + head.getHeight(), body.getWidth(), head.getHeight(), null);

    }


    @Override
    public void setHitBox(HitBox hitBox) {
        this.hitBox = hitBox;
    }

    @Override
    public HitBox getHitbox() {
        return this.hitBox;
    }

    @Override
    public void setHitBoxVisible(boolean hitBoxVisible) {
        this.hitBoxVisible = hitBoxVisible;
    }


    @Override
    public void disposeResources() {
        body.flush();
        head.flush();
    }


    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }
}
