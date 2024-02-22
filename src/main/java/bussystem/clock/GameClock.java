package bussystem.clock;

import logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public  class GameClock {
    private final int TICK = 10;


    private static List<GameGlockObserver> clockList = new ArrayList<>();


    public void addListener(GameGlockObserver gameClockListener){
        clockList.add(gameClockListener);
    }

    public GameClock(){
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                for(GameGlockObserver clock: clockList){
                    if(clock.observe()){
                        clock.clock();
                    }
                }



            }
        }, 0 ,TICK );








    }






}
