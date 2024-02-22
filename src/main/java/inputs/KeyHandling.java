package inputs;

import bussystem.BusSystem;
import logger.Logger;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandling  implements KeyListener {

    private final  BusSystem busSystem;




 ;


    public KeyHandling(BusSystem busSystem){

        /*
          Add Class to list of Listener in bus-System.
          Standard init process for Classes with BusSystem and BusSystemObserver
         */
        this.busSystem =  busSystem;


        //Init default values
        busSystem.saveInit("menuUp", true);
        busSystem.saveInit("menuDown", false);


        busSystem.saveInit("moveRight", false);
        busSystem.saveInit("moveLeft", false);



    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        boolean maniLabelVisible = busSystem.get("lbl1b", Boolean.class);
        if(maniLabelVisible){
            if (e.getKeyCode() == KeyEvent.VK_A) {
                busSystem.save("moveLeft", true);
                Logger.debug("moveLeft == true");
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                busSystem.save("moveRight", true);
                Logger.debug("moveRight == true");
            }


                //...


//            busSystem.save("defaultBackground", "iboss1background");



            busSystem.updateGraphics();
        }


        if(busSystem.get("lbl2b", Boolean.class)){
            menuLogicPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        boolean maniLabelVisible = busSystem.get("lbl1b", Boolean.class);
        if(maniLabelVisible){
            if (e.getKeyCode() == KeyEvent.VK_A) {
                busSystem.save("moveLeft", false);
                Logger.debug("moveLeft == false");
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                busSystem.save("moveRight", false);
                Logger.debug("moveRight == false");

            }
        }
    }


    private void menuLogicPressed(KeyEvent e){
        boolean menuUp           = busSystem.get("menuUp", Boolean.class);
        boolean menuDown         = busSystem.get("menuDown", Boolean.class);
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP && !menuUp) {
            busSystem.save("menuDown", false);
            busSystem.save("menuUp", true);
            busSystem.updateGraphics();
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN && !menuDown) {
            busSystem.save("menuDown", true);
            busSystem.save("menuUp", false);
            busSystem.updateGraphics();
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER &&  menuUp){
            busSystem.save("lbl2b", false);
            busSystem.save("lbl1b", true);
        }
    }

}
