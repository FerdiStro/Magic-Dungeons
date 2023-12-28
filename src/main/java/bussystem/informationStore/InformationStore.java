package bussystem.informationStore;

public interface InformationStore {


    public void addObserver(Observer observer);

    public void notifyAllObservers();

    public void notifyObserverByName(String observerName);


    public <T> T get(String name, Class<T> type);
    public <T> void save(String name, T data);



}
