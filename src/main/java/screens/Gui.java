package screens;

import config.ConfigLoader;
import bussystem.BusSystem;
import bussystem.informationStore.StateObserver;
import inputs.KeyHandling;
import logger.Logger;
import pack1.LabelRot;
import screens.game.GameLabel;
import screens.menu.MenuLabel;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Gui implements ConfigLoader, StateObserver {
    HashMap<String, Object> configs;
    private final JFrame frame;
    private final BusSystem busSystem;
    //todo: rename vars when structure is ready
    private final GameLabel lbl1;
    private final LabelRot lablrot;
    private final MenuLabel menuLabel;


    public Gui(BusSystem busSystem) throws IOException {

        /*
          Add Class to list of Listener in bus-System. Also load configs for this class.
          Standard init process for Classes with BusSystem, BusSystemObserver and config loader.
         */
        load(this, busSystem);
        this.busSystem =  busSystem;
        busSystem.addListener(this);


        /*
            Init Screen with all Vars and settings.
         */
        frame =  new JFrame( );
        frame.setTitle( (String) configs.get("gameTitle"));
        frame.setSize(busSystem.get("screenWidth", Integer.class), busSystem.get("screenHeight", Integer.class) );
        //todo: config or setting system for this vars
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);



        //todo: rework KeyHandler
        frame.addKeyListener(new KeyHandling(busSystem));
        frame.requestFocusInWindow();

        //Visibility options
        if((Boolean) configs.get("fullScreen")){
            frame.setUndecorated(true);
        }
        frame.setVisible(true);


        /*
           Init labels and add them to screen.
         */
        //Main-label
        busSystem.saveInit("lbl1b", false);
        this.lbl1 = new GameLabel(busSystem);
        this.lbl1.setBounds(0,0, busSystem.get("screenWidth", Integer.class), busSystem.get("screenHeight", Integer.class));


        //Rotation-label
        //todo: rework complete logic of rotation label
        this.lablrot = new LabelRot();
        this.lablrot.setBounds(0,0, busSystem.get("screenWidth", Integer.class), busSystem.get("screenHeight", Integer.class));

        //Menu-label
        busSystem.saveInit("lbl2b", true);
        this.menuLabel =  new MenuLabel(busSystem);
        this.menuLabel.setBounds(0,0, busSystem.get("screenWidth", Integer.class), busSystem.get("screenHeight", Integer.class));


        this.frame.add(this.lbl1);
        this.frame.add(this.lablrot);
        this.frame.add(this.menuLabel);



        SwingUtilities.invokeLater(() -> {
            this.lbl1.setVisible(false);
            this.menuLabel.setVisible(true);
            Logger.success("Set menuLabel true and gameLabel false");
        });


        update("");
    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }


    @Override
    public void update(String name) {

        if(name.equals("lbl2b")){
            Boolean menuVis = busSystem.get("lbl2b", Boolean.class);
            if(!menuVis){
                SwingUtilities.invokeLater(() -> {
                    this.lbl1.setVisible(busSystem.get("lbl1b", Boolean.class));
                    this.menuLabel.setVisible(busSystem.get("lbl2b", Boolean.class));
                    Logger.success("Set menuLabel false and gameLabel true");
                    this.menuLabel.destroy();
                    Logger.info("Eliminate Menu");
                });
            }
        }
    }
}
