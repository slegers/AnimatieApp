package model.TimesUp.Obeserver;

import java.util.List;

/**
 * Created by yanice on 15/01/17.
 */
public interface Subject {
    List<Observer> getObservers();
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
