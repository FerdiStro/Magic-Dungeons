package screens;

import config.ConfigLoader;
import bussystem.BusSystem;
import bussystem.informationStore.Observer;
import config.types.ScopeType;
import pack1.KeyHandler;
import pack1.Label;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Gui implements ConfigLoader, Observer {
    HashMap<String, Object> configs;


    private final JFrame frame;
    private final BusSystem busSystem;

    public Gui(BusSystem busSystem) throws IOException {
        this.busSystem =  busSystem;
        busSystem.addListener(this);
        load(this, busSystem);


        frame =  new JFrame( );
        frame.setTitle( (String) configs.get("gameTitle"));

        frame.setSize(busSystem.get("screenHeight", Integer.class), busSystem.get("screenWeight", Integer.class) );


        //todo: config or setting system for this vars
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.addKeyListener(new KeyHandler());
        frame.requestFocus();
        frame.setVisible(true);


        //todo: add other labels



        Label label1 = new Label();







    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }


    @Override
    public void listen(String name) {
        if(name.equals("screenHeight") && frame !=  null ||  name.equals("screenWeight")  && frame !=  null ){
            frame.setSize(busSystem.get("screenHeight", Integer.class), busSystem.get("screenWeight", Integer.class) );
        }
        System.out.println("Bus Updated");
    }
}
