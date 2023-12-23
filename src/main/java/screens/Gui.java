package screens;

import config.ConfigLoader;
import config.ConfigObject;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

public class Gui implements ConfigLoader {
    HashMap<String, Object> configs;


    private final JFrame frame;

    public Gui() throws IOException {
        load(this);



        frame =  new JFrame( );
        frame.setSize( (Integer) configs.get("screenHeight"), (Integer) configs.get("screenWeight"));


        frame.setVisible((Boolean) configs.get("visible"));
//


//        frame.setSize(guiConfigs.getScreenWith(), guiConfigs.getScreenHeigt());


    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }


}
