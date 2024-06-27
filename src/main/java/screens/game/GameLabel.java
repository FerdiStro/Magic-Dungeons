package screens.game;

import bussystem.BusSystem;
import bussystem.HitBoxList;
import bussystem.graphicState.GraphicObserver;
import bussystem.informationStore.StateObserver;
import bussystem.clock.GameClock;
import com.fasterxml.jackson.annotation.JsonCreator;
import config.ConfigLoader;
import logger.Logger;
import lombok.Setter;
import model.Model;
import model.Square;
import model.player.Player;
import screens.GameScreen;
import screens.game.background.BackgroundManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class GameLabel extends JLabel implements GameScreen, StateObserver, GraphicObserver, ConfigLoader {

    private BusSystem busSystem;
    private BackgroundManager backgroundManager;
    private HashMap<String, Object> configs;


    @Setter
    private GameClock gameClock;


    public GameLabel(BusSystem busSystem) throws IOException {
        load(this, busSystem);
        this.busSystem = busSystem;
        busSystem.addListener((StateObserver) this);
        busSystem.addListener((GraphicObserver) this);
        this.backgroundManager =  new BackgroundManager(busSystem, (String) configs.get("defaultBackground"));
        Logger.debug("Game-Label loaded");
    }

    private int width;
    private int height;

    private HashMap<String, Model> modelList = new HashMap<>();
    private HitBoxList hitBoxList;

    Player player = null;
    Square floor = null;
    Square test = null;

    private boolean init = false;
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        backgroundManager.setSelectedBackground(busSystem.get("defaultBackground", String.class));

        width   = busSystem.get("screenWidth", Integer.class);
        height  = busSystem.get("screenHeight", Integer.class);



        /*
            Init process for objects
         */
        if(!init){

            player = new Player("player", 0,  10 ,100, 200,"screens/game/models/Player",busSystem );
            player.addMovement(1);
            player.setGravity(true);
            player.setHitBoxVisible(true);


            floor =  new Square("floor", 0, 450 , 900, 200, busSystem);

            test =  new Square("test", 200, 300 , 100, 200, busSystem);






            addModel(player);
            addModel(floor);


        }



        backgroundManager.draw(g2d);
        player.draw(g2d);
        floor.draw(g2d);
        test.draw(g2d);


















        init = true;
    }

    private void addModel(Model model){
        this.modelList.put(model.getName(), model);
    }


    @Override
    public void updateGraphics() {
        repaint(0,0 , width, height);
    }

    @Override
    public void destroy() {
        for(Model model: modelList.values()){
            model.disposeResources();
        }

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

    @Override
    public void setHitBoxList(HitBoxList hitBoxList) {
        this.hitBoxList = hitBoxList;
    }

    @Override
    public HitBoxList getHitBoxList() {
        return this.hitBoxList;
    }
}
