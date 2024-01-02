package screens.menu;

import bussystem.BusSystem;
import bussystem.informationStore.Observer;
import config.ConfigLoader;
import config.ImageLoader;
import logger.Logger;
import pack1.Var;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class LabelM extends JLabel implements ConfigLoader, Observer {
    HashMap<String, Object> configs;
    private final BusSystem busSystem;



    private final BufferedImage  ibackM;
    private final BufferedImage iheadline;

    //Key inputs
    private boolean menuUp;
    private boolean menuDown;

    public LabelM(BusSystem busSystem) {

        /*
          Load configs for this class.
          Standard init process for Classes with BusSystem and config loader.
         */
        try {
            load(this, busSystem);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.busSystem =  busSystem;

        //Load Images
        this.ibackM = ImageLoader.loadImage((String) configs.get("ibackM"));
        this.iheadline = ImageLoader.loadImage((String) configs.get("iheadline"));

        //Get KeyInputs
        menuUp      = busSystem.get("menuUp", Boolean.class);
        menuDown    = busSystem.get("menuDown", Boolean.class);

        Logger.info("Load Key-Listener");
    }




    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Logger.info("Paint");

// Linux performance Test
//        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice device = env.getDefaultScreenDevice();
//        GraphicsConfiguration config = device.getDefaultConfiguration();
//        BufferedImage buffy = config.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
//        Graphics g = buffy.getGraphics();
//



        //todo: not really used, maybe use Graphics2D instead of Graphics in the future
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(ibackM, 0, 0, busSystem.get("screenWeight", Integer.class) , busSystem.get("screenHeight", Integer.class), null);
        g.drawImage(iheadline, 100 , busSystem.get("screenHeight", Integer.class)/2 -200, 609,168,null);

        if(menuUp){
            Logger.info("UP");

//            if (Var.menuanimation == 1) {
//                g.drawImage(Var.istart, Var.menux, Var.menuy, 200, 70, null);
//                g.drawImage(Var.ioptionen, Var.menux, Var.menuy + 80, 200, 70, null);
//            } else if (Var.menuanimation == 2) {
//                g.drawImage(Var.istart1, Var.menux, Var.menuy, 200, 70, null);
//                g.drawImage(Var.ioptionen, Var.menux, Var.menuy + 80, 200, 70, null);
//            }

        }
        if (menuDown){
            Logger.info("Down");
//            if (Var.menuanimation == 1) {
//                g.drawImage(Var.ioptionen, Var.menux, Var.menuy + 80, 200, 70, null);
//                g.drawImage(Var.istart, Var.menux, Var.menuy, 200, 70, null);
//            } else if (Var.menuanimation == 2) {
//                g.drawImage(Var.ioptionen1, Var.menux, Var.menuy + 80, 200, 70, null);
//                g.drawImage(Var.istart, Var.menux, Var.menuy, 200, 70, null);
//            }

        }

        repaint();

    }

    /*
        Flush Images when methode is no longer needed.
     */
    private void disposeResources() {
        ibackM.flush();
        iheadline.flush();
    }

    @Override
    public void setConfig(HashMap<String, Object> configs) {
        this.configs = configs;
    }

    @Override
    public void listen(String name) {
        //Get KeyInputs
        menuUp      = busSystem.get("menuUp", Boolean.class);
        menuDown    = busSystem.get("menuDown", Boolean.class);


    }
}

