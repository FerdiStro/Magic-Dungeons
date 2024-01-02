package screens;

import config.ConfigLoader;
import bussystem.BusSystem;
import bussystem.informationStore.Observer;
import pack1.KeyHandler;
import pack1.Label;
import pack1.LabelM;
import pack1.LabelRot;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Gui implements ConfigLoader, Observer {
    HashMap<String, Object> configs;


    private final JFrame frame;
    private final BusSystem busSystem;

    //Labels
    //todo: rename vars when structure is ready
    private final Label lbl1;
    private final boolean lbl1b;

    private final LabelRot lablrot;

    private final LabelM lbl2;
    private final boolean lbl2b;



    public Gui(BusSystem busSystem) throws IOException {

        /*
          Add Class to list of Listener in bus-System. Also load configs for this class.
          Standard init process for Classes with Subsystem and config loader.
         */
        this.busSystem =  busSystem;
        busSystem.addListener(this);
        load(this, busSystem);


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
        frame.addKeyListener(new KeyHandler());
        frame.requestFocus();
        frame.setVisible(true);


        /*
           init labels and add them to screen.
         */

        //Main-label
        this.lbl1 = new Label();
        this.lbl1.setBounds(0,0, busSystem.get("screenWeight", Integer.class), busSystem.get("screenHeight", Integer.class));
        this.lbl1b = false;
        busSystem.save("lbl1b", true);

        //Rotation-label
        this.lablrot = new LabelRot();
        this.lablrot.setBounds(0,0, busSystem.get("screenWeight", Integer.class), busSystem.get("screenHeight", Integer.class));

        //Menu-label
        this.lbl2 =  new LabelM();
        this.lbl2.setBounds(0,0, busSystem.get("screenWeight", Integer.class), busSystem.get("screenHeight", Integer.class));
        this.lbl2b  = true;
        busSystem.save("lbl2b", true);

        this.frame.add(this.lbl1);
        this.frame.add(this.lablrot);
        this.frame.add(this.lbl2);




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
            this.lablrot.setVisible(true);
        }





    }
}
