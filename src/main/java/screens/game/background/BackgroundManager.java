package screens.game.background;

import bussystem.BusSystem;
import config.ConfigLoader;
import config.ImageLoader;
import logger.Logger;
import lombok.Setter;
import screens.game.background.boss.BossBackground;
import screens.game.background.standard.DefaultBackground;


import java.awt.*;
import java.io.IOException;
import java.util.*;


//todo: Backgrounds only loaded when needed. So flush when no use for it to save memory
public class BackgroundManager implements ConfigLoader {
    private BusSystem busSystem;
    private HashMap<String, Object> configs;
    private final Map<String,  Background> backgrounds;
    private final String defaultBackground;
    @Setter
    private String selectedBackground;
    @Setter
    private Integer backgroundX = 0;
    @Setter
    private Integer backgroundY = 0;


    public BackgroundManager(BusSystem busSystem, String defaultBackground) throws IOException {
        this.defaultBackground = defaultBackground;
        this.busSystem = busSystem;
        this.busSystem.saveInit("defaultBackground", defaultBackground);
        load(this, busSystem);

        /*
            Background List, when a new Background created, need to add here.
         */
        Map<String, Background> backgroundMap =  new HashMap<>();
        backgroundMap.put("ib1", new DefaultBackground(0));
        backgroundMap.put("ib2", new DefaultBackground(1));
        backgroundMap.put("iboss1background", new BossBackground());



        this.backgrounds = backgroundMap;
        busSystem.saveInit("backgroundX", backgroundX);
        busSystem.saveInit("backgroundY", backgroundY);
        initState();
    }

    private void  initState(){
        for(String key: backgrounds.keySet()){
            busSystem.saveInit(key, false);
            if(defaultBackground.equals(key)){
                setSelectedBackground(key);
                busSystem.save(key, true);
            }
            Background background = backgrounds.get(key);
            background.setBusSystem(busSystem);
            background.setBackground( ImageLoader.loadImage((String) configs.get(key)));
        }
    }


    public void draw(Graphics2D g){
        Background b = backgrounds.get(selectedBackground);
        g.drawImage(b.getBackground(), backgroundX , backgroundY, b.getWidth() , b.getHeight() , null);
    }


    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }
}