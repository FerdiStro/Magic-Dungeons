package screens;

import config.ConfigLoader;
import bussystem.BusSystem;
import bussystem.informationStore.Observer;
import inputs.KeyHandling;
import logger.Logger;
import pack1.KeyHandler;
import pack1.Label;
import pack1.LabelRot;
import screens.menu.LabelM;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Gui implements ConfigLoader, Observer {
    HashMap<String, Object> configs;
    private final JFrame frame;
    private final BusSystem busSystem;
    //todo: rename vars when structure is ready
    private final Label lbl1;
    private final LabelRot lablrot;
    private final LabelM lbl2;


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
        frame.setSize(busSystem.get("screenWeight", Integer.class), busSystem.get("screenHeight", Integer.class) );
        //todo: config or setting system for this vars
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);



        //todo: rework KeyHandler
        frame.addKeyListener(new KeyHandling(busSystem));
        frame.requestFocus();
        frame.setVisible(true);


        /*
           Init labels and add them to screen.
         */
        //Main-label
        busSystem.saveInit("lbl1b", true, true);
        this.lbl1 = new Label();
        this.lbl1.setBounds(0,0, busSystem.get("screenWeight", Integer.class), busSystem.get("screenHeight", Integer.class));


        //Rotation-label
        //todo: rework complete logic of rotation label
        this.lablrot = new LabelRot();
        this.lablrot.setBounds(0,0, busSystem.get("screenWeight", Integer.class), busSystem.get("screenHeight", Integer.class));

        //Menu-label
        busSystem.saveInit("lbl2b", true, true);
        this.lbl2 =  new LabelM(busSystem);
        this.lbl2.setBounds(0,0, busSystem.get("screenWeight", Integer.class), busSystem.get("screenHeight", Integer.class));


        this.frame.add(this.lbl1);
        this.frame.add(this.lablrot);
        this.frame.add(this.lbl2);


        listen(null);
    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }


    @Override
    public void listen(String name) {

        if(lbl2 != null && lbl1 != null){
            this.lbl1.setVisible(busSystem.get("lbl1b", Boolean.class));
            this.lbl2.setVisible(busSystem.get("lbl2b", Boolean.class));
            Logger.success("SET TRUE");
        }
    }
}
