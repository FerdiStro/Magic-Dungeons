package screens;


import bussystem.BusSystem;
import logger.Logger;

import java.util.concurrent.TimeUnit;

public class Test {
    private final BusSystem busSystem;


    public Test(BusSystem busSystem) throws InterruptedException {
        this.busSystem = busSystem;
        TimeUnit.SECONDS.sleep(5);
        Logger.info("update");

        busSystem.save("screenWidth", 200);
        busSystem.updateGraphics();


        //test Class


    }






}
