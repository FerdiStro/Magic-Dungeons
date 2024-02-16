package model.player;

import bussystem.informationStore.StateObserver;
import config.ConfigLoader;
import logger.Logger;

import lombok.Setter;
import model.Model;


import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class Player implements Model, StateObserver, ConfigLoader {

    private HashMap<String, Object> configs;

    private String name;
    @Setter
    private String path;
    private int x;
    private int y;
    private Graphics2D g;


    //HitBox Settings
    private int hitBoxW = 50;
    private int hitBoxH = 50;
    private boolean hitBoxVisible;






    /*
        Create player with basic HitBox w = 50 ; h = 50
     */
    public Player(String name,Graphics2D g , int x, int y  ){
        init(name, g, x ,y );


    }
      /*
        Create player
     */
    public Player(String name, Graphics2D g, int x ,int y, int hitBoxW , int hitBoxH){
        this.hitBoxW    = hitBoxW;
        this.hitBoxH    = hitBoxH;

        init(name, g, x ,y );


    }

    public Player(String name, Graphics2D g, int x ,int y, int hitBoxW , int hitBoxH, String path){
        this.hitBoxW    = hitBoxW;
        this.hitBoxH    = hitBoxH;
        this.path       = path;
        init(name, g, x ,y );


    }


    private void init(String name, Graphics2D g, int x, int y ){
        this.x      = x;
        this.y      = y;
        this.name   = name;
        this.g      = g;


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
    }




    @Override
    public void draw(Graphics2D g) {


        if(hitBoxVisible){
            g.setBackground(Color.RED);
            g.fillRect(x,y, hitBoxW, hitBoxH);
            g.drawRect(x,y, hitBoxW, hitBoxH);
        }






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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public StateObserver getObserver() {
        return this;
    }


    @Override
    public void update(String name) {
        if(name.equals("moveRight")){
            this.x += x ;


        }


    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }
}
