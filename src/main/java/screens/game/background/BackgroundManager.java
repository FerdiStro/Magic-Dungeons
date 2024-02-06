package screens.game.background;

import bussystem.BusSystem;
import config.ConfigLoader;
import config.ImageLoader;
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


        //Map out of Yaml configs. For new Background add in the config-file
        Map<String, Background> backgroundMap =  new HashMap<>();

        for( String  key : configs.keySet() ){
            String data =  (String) configs.get(key);
            String backgroundType = data.split("\\|")[0];
            String path = data.split("\\|")[1];
            Background background = switch (backgroundType) {
                case "default" -> new DefaultBackground();
                case "boss" -> new BossBackground();
                default -> null;
            };

            busSystem.saveInit(key, false);
            if(defaultBackground.equals(key)){
                setSelectedBackground(key);
                busSystem.save(key, true);
            }

            background.setBusSystem(busSystem);
            background.setBackground(ImageLoader.loadImage(path));


            backgroundMap.put(key, background);

        }



        this.backgrounds = backgroundMap;
        busSystem.saveInit("backgroundX", backgroundX);
        busSystem.saveInit("backgroundY", backgroundY);

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