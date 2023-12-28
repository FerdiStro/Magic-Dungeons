package bussystem.treads;

import bussystem.informationStore.temporary.InformationStore;

import java.util.Timer;
import java.util.TimerTask;

public class Listen extends Thread{


    //Name of listened state
    private final String name;
    private final InformationStore store;

    Timer timer = new Timer();

    public Listen(String name, InformationStore store){
        this.name  =  name ;
        this.store =  store;
    }

    private int count = 0 ;

    public void run(){
        timer.scheduleAtFixedRate(new TimerTask() {

            int lol;

            @Override
            public void run() {
                count += 1;
                System.out.println(
                        "Thread : " + name );
                System.out.println("Count: " +  count);
                System.out.println();

            }
        }, 0, 9);



    }
}
