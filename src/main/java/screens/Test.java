package screens;


import bussystem.BusSystem;
import bussystem.informationStore.StateObserver;
import logger.Logger;

import java.util.concurrent.TimeUnit;

public class Test implements StateObserver {
    private final BusSystem busSystem;


    public Test(BusSystem busSystem) throws InterruptedException {
        this.busSystem = busSystem;
        this.busSystem.addListener(this);
        TimeUnit.SECONDS.sleep(5);
        Logger.info("update");

        updateDefaultBackground();

        testBiggerScreenWith();






    }

    private void updateDefaultBackground(){
        busSystem.save("defaultBackground", "iboss1background");
        busSystem.updateGraphics();

    }

    //test with not x
    private void testBiggerScreenWith(){
        busSystem.save("backgroundX", 2);
        busSystem.updateGraphics();
    }



    @Override
    public void update(String name) {

        if(name.equals("moveLeft")){
            Integer backgroundX = busSystem.get("backgroundX", Integer.class);
            backgroundX += 2;
            busSystem.save("backgroundX", backgroundX);
            busSystem.updateGraphics();

        }

    }
}
