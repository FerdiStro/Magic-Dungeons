package screens;


import bussystem.BusSystem;

import java.util.concurrent.TimeUnit;

public class Test {
    private final BusSystem busSystem;


    public Test(BusSystem busSystem) throws InterruptedException {
        this.busSystem = busSystem;
        TimeUnit.SECONDS.sleep(5);
        busSystem.save("screenHeight", 1000);

        //test Class


    }






}
