package bussystem.informationStore;

public interface InformationStore {


     void addObserver(StateObserver stateObserver);

     void notifyAllObservers();

     void notifyObserverByName(String observerName);


     <T> T get(String name, Class<T> type);
     <T> void save(String name, T data);



     <T> void saveInit(String name, T data );

}
