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

        busSystem.save("screenWidth", 200);
        busSystem.updateGraphics();


        //test Class


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
