package bussystem.graphicState;

import bussystem.informationStore.StateObserver;

import java.util.ArrayList;
import java.util.List;

public class GraphicStore {

    private List<GraphicObserver> graphicObservers =  new ArrayList<>();


    public void addGraphicObserver(GraphicObserver observer){
        this.graphicObservers.add(observer);
    }

    public void notifyAllObservers(){
       for (GraphicObserver observer: graphicObservers){
           observer.updateGraphics();
       }
    }





}
