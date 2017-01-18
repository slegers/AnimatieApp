package model.Stopwatch.StopwatchObserver;

import java.util.List;

/**
 * Created by yanice on 18/01/17.
 */
public interface Subject {
    void notifyObserver(Observer o);

    void notifyObservers();

    List<Observer> getObservers();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);
}
