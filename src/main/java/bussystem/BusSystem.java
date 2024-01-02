package bussystem;


import bussystem.informationStore.InformationStore;
import bussystem.informationStore.Observer;

public class BusSystem {

    private final InformationStore store;

    public BusSystem(){
        //one Store for each bus-System
        this.store  = new bussystem.informationStore.temporary.InformationStore();
    }


    public void addListener(Observer observer){
        store.addObserver(observer);
    }

    public <T> T get(String name, Class<T> t){
        return store.get(name,  t);
    }

    public <T> void save(String name, T data) {
        store.save(name, data);

    }
    public <T> void saveInit(String name, T data, boolean isDefault) {
        store.saveInit(name, data, isDefault);

    }

}
