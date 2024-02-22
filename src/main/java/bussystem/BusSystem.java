package bussystem;


import bussystem.clock.GameClock;
import bussystem.clock.GameGlockObserver;
import bussystem.graphicState.GraphicObserver;
import bussystem.graphicState.GraphicStore;
import bussystem.informationStore.InformationStore;
import bussystem.informationStore.StateObserver;

import java.util.ArrayList;
import java.util.List;

public class BusSystem {

    private final InformationStore informationStore;
    private final GraphicStore graphicStore;
    private final GameClock gameClock;


    public BusSystem(){
        //one Store for each bus-System
        this.informationStore = new bussystem.informationStore.temporary.InformationStore();
        this.graphicStore     = new GraphicStore();
        this.gameClock        =  new GameClock();

    }


    public void addListener(StateObserver stateObserver){
        informationStore.addObserver(stateObserver);
    }
    public void addListener(GraphicObserver observer){
        graphicStore.addGraphicObserver(observer);
    }

    public <T> T get(String name, Class<T> t){
        return informationStore.get(name,  t);
    }

    public <T> void save(String name, T data) {
        informationStore.save(name, data);

    }
    public <T> void saveInit(String name, T data) {
        informationStore.saveInit(name, data);
    }

    public void updateGraphics(){
        graphicStore.notifyAllObservers();
    }

    public void addGameClockListener(GameGlockObserver gameGlockObserver){
        gameClock.addListener(gameGlockObserver);

    }



}
