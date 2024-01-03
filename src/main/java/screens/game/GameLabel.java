package screens.game;

import bussystem.BusSystem;
import bussystem.graphicState.GraphicObserver;
import bussystem.informationStore.StateObserver;
import config.ConfigLoader;
import logger.Logger;
import screens.game.background.BackgroundManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Observer;

public class GameLabel extends JLabel implements StateObserver, GraphicObserver, ConfigLoader {

    private BusSystem busSystem;
    private BackgroundManager backgroundManager;
    private HashMap<String, Object> configs;


    public GameLabel(BusSystem busSystem) throws IOException {
        load(this, busSystem);
        this.busSystem =  busSystem;
        busSystem.addListener((StateObserver) this);
        busSystem.addListener((GraphicObserver) this);
        this.backgroundManager =  new BackgroundManager(busSystem, (String) configs.get("defaultBackground"));
        Logger.debug("Game-Label loaded");
    }

    private int width;
    private int height;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        backgroundManager.setSelectedBackground(busSystem.get("defaultBackground", String.class));

        width   = busSystem.get("screenWidth", Integer.class);
        height  = busSystem.get("screenHeight", Integer.class);



        backgroundManager.draw(g2d);






    }




    @Override
    public void updateGraphics() {
        repaint(0,0 , width, height);
    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;

    }

    @Override
    public void update(String name) {

        if(backgroundManager != null){
            if(name.equals("defaultBackground")){
                this.backgroundManager.setSelectedBackground(this.busSystem.get("defaultBackground", String.class));
            }
            this.backgroundManager.setBackgroundX(this.busSystem.get("backgroundX", Integer.class));
            this.backgroundManager.setBackgroundY(this.busSystem.get("backgroundY", Integer.class));

        }
    }
}
