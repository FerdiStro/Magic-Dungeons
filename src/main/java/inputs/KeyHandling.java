package inputs;

import bussystem.BusSystem;
import bussystem.informationStore.Observer;
import logger.Logger;
import pack1.KeyHandler;
import pack1.Var;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.ref.PhantomReference;

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
        busSystem.saveInit("menuUp", true, true);
        busSystem.saveInit("menuDown", false ,  true);


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        Logger.info("Key-Pressed: " + e.getKeyCode());

        boolean maniLabelVisible = busSystem.get("lbl1b", Boolean.class);
        if(maniLabelVisible){
                //...
        }

        //Menu logic
        boolean menuUp           = busSystem.get("menuUp", Boolean.class);
        boolean menuDown         = busSystem.get("menuDown", Boolean.class);
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP && menuUp == false) {
            busSystem.save("menuDown", false);
            busSystem.save("menuUp", true);
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN && menuDown == false) {
            busSystem.save("menuDown", true);
            busSystem.save("menuUp", false);
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
