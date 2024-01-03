package screens.menu;

import bussystem.BusSystem;
import bussystem.graphicState.GraphicObserver;
import config.ConfigLoader;
import config.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabelM extends JLabel implements ConfigLoader, GraphicObserver {
    /*
        Config and busSystem
     */
    private HashMap<String, Object> configs;
    private final BusSystem busSystem;

    /*
        All Images in which needed in the Menu
     */
    private final BufferedImage backgroundImage;
    private final BufferedImage logoImage;
    private final BufferedImage startButton_0;
    private final BufferedImage startButton_1;
    private final BufferedImage optionButton_0;
    private final BufferedImage optionButton_1;

    /*
        Define Button-Size and Button-Margin. Switch these values for custom menu buttons
     */
    private final static int BUTTON_HEIGHT     = 70;
    private final static int BUTTON_WIDTH      = 200;
    private final static int BUTTON_MARGIN_TOP = 10;





    public LabelM(BusSystem busSystem) throws IOException {

        /*
          Load configs for this class. Also add these class to the Graphics Observer
          Standard init process for Classes with BusSystem, GraphicObserver and config loader.
         */
        load(this, busSystem);
        busSystem.addListener( this);
        this.busSystem =  busSystem;

        /*
            Load Images form ImageLoader. Classpath ot file is defined in LabelM.yml in the config Folder.
            For full customization change LabelM.yml and Resourcefulness path in the ImageLoader class.
        */
        this.backgroundImage = ImageLoader.loadImage((String) configs.get("background"));
        this.logoImage = ImageLoader.loadImage((String) configs.get("logo"));

        this.startButton_0 =  ImageLoader.loadImage((String) configs.get("start-button-0"));
        this.startButton_1 =  ImageLoader.loadImage((String) configs.get("start-button-1"));

        this.optionButton_0 =  ImageLoader.loadImage((String) configs.get("option-button-0"));
        this.optionButton_1 =  ImageLoader.loadImage((String) configs.get("option-button-1"));



    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width   = busSystem.get("screenWidth", Integer.class);
        int height  = busSystem.get("screenHeight", Integer.class);
        boolean menuUp      = busSystem.get("menuUp", Boolean.class);
        boolean menuDown    = busSystem.get("menuDown", Boolean.class);

        //Background and Logo
        g2d.drawImage(backgroundImage, 0           , 0                   , width,        height, null);
        g2d.drawImage(logoImage, 0 , height/2 - height/3 , width,height/3,null);

        /*
            Display Selected Buttons. When menuUp == true  is the startButton selected. When menuDown == true is the option Button Selected.
            The selected button is in a animation between the different state 0 and 1.
         */
        int x = width/2  - BUTTON_WIDTH/2;
        int y = height/2 + BUTTON_MARGIN_TOP;

        if(menuUp){
            g2d.drawImage(startButton_1,  x, y                                      , BUTTON_WIDTH, BUTTON_HEIGHT, null );
            //Animation missed
            g2d.drawImage(optionButton_0,  x, y + BUTTON_HEIGHT + BUTTON_MARGIN_TOP, BUTTON_WIDTH, BUTTON_HEIGHT, null );


        }
        if (menuDown){
            g2d.drawImage(startButton_0,  x, y                                      , BUTTON_WIDTH, BUTTON_HEIGHT, null );
            //Animation missed
            g2d.drawImage(optionButton_1,  x, y + BUTTON_HEIGHT + BUTTON_MARGIN_TOP, BUTTON_WIDTH, BUTTON_HEIGHT, null );
        }


    }

    /*
        Flush Images when methode is no longer needed. This save Memory
     */
    public void disposeResources() {
        this.backgroundImage.flush();
        this.logoImage.flush();
        this.startButton_0.flush();
        this.startButton_1.flush();
        this.optionButton_0.flush();
        this.optionButton_1.flush();
    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }

    @Override
    public void updateGraphics() {
        repaint(0,0 ,busSystem.get("screenWidth", Integer.class) , busSystem.get("screenHeight", Integer.class));
    }


}

