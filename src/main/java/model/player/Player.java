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
    private final String  name;
    @Setter
    private String path;



    /*
        HitBox-Settings
     */
    private int hitBoxW = 50;
    private int hitBoxH = 50;
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
        this.name   = name;
        init(x ,y, busSystem);


    }
      /*
        Create player
     */
    public Player(String name, int x ,int y, int hitBoxW , int hitBoxH, BusSystem busSystem){
        this.hitBoxW    = hitBoxW;
        this.hitBoxH    = hitBoxH;
        this.name   = name;
        init( x ,y, busSystem );



    }
    public Player(String name, int x ,int y, int hitBoxW , int hitBoxH, String path, BusSystem busSystem){
        this.hitBoxW    = hitBoxW;
        this.hitBoxH    = hitBoxH;
        this.path       = path;
        this.name      = name;
        init( x ,y, busSystem );


    }




    private void init( int x, int y, BusSystem busSystem){
        this.busSystem = busSystem;
        setX(x);
        setY(y);



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

        busSystem.saveInit(name + "X", x);
        busSystem.saveInit(name + "Y", x);

    }




    @Override
    public void draw(Graphics2D g) {
        Integer x = busSystem.get(name + "X", Integer.class);
        Integer y = busSystem.get(name + "Y", Integer.class);


        if(hitBoxVisible){
            g.setBackground(Color.RED);
            g.fillRect(x,y, hitBoxW, hitBoxH);
            g.drawRect(x,y, hitBoxW, hitBoxH);
        }
        g.drawImage(head, x, y, head.getWidth(), head.getHeight(), null);
        g.drawImage(body, x, y + head.getHeight(), body.getWidth(), head.getHeight(), null);

    }


    @Override
    public void setHitBox(int w, int h) {
        this.hitBoxW = w;
        this.hitBoxH = h;
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
