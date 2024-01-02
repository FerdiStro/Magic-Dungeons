package bussystem.informationStore.temporary;

import bussystem.informationStore.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InformationStore implements bussystem.informationStore.InformationStore {

    private List<Observer> observers = new ArrayList<>();
    private HashMap<String,Object > data = new HashMap<>();

    private String name;

    @Override
    public void addObserver(Observer observer){
        this.observers.add(observer);

    }

    @Override
    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.listen(name);
        }
    }

    @Override
    public void notifyObserverByName(String observerName) {
        //todo: only observer which is named

    }

    @Override
    public <T>  T get(String name, Class<T> type ) {
        return (T) this.data.get(name);
    }

    @Override
    public <T> void save(String name, T data) {
        this.name =  name;
        this.data.put(name, data);
        notifyAllObservers();

    }

    @Override
    public <T> void saveInit(String name, T data, boolean isDefault) {
        this.name =  name;
        this.data.put(name, data);
    }
}
