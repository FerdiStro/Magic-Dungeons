package bussystem.informationStore;

public interface InformationStore {


     void addObserver(Observer observer);

     void notifyAllObservers();

     void notifyObserverByName(String observerName);


     <T> T get(String name, Class<T> type);
     <T> void save(String name, T data);



     <T> void saveInit(String name, T data, boolean isDefault);

}
