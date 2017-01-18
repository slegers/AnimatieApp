package Controller.Stopwatch;

import View.Timer.StopWatchView;
import model.Stopwatch.Stopwatch;
import model.Stopwatch.StopwatchObserver.Observer;
import model.Stopwatch.StopwatchObserver.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanice on 18/01/17.
 */
public class StopwatchController implements Subject{
    private StopWatchView stopWatchView;
    private ArrayList<Observer> observers = new ArrayList<>();
    private Stopwatch stopwatch ;
    public void createStopwatchView() {
        stopWatchView = new StopWatchView(this);
        stopwatch = new Stopwatch(this);
        addObserver(stopWatchView);
    }

    public void startStopwatch(){
        stopwatch.startTimer();
    }
    public void stopStopwatch(){
        stopwatch.stopTimer();
    }
    public void resetStopwatch(){
        stopwatch.reset();
    }
    public String getTime(){
        return stopwatch.getTime();
    }

    @Override
    public void notifyObserver(Observer o) {
        o.update();
    }

    @Override
    public void notifyObservers() {
        for(Observer o : getObservers()){
            o.update();
        }
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void addObserver(Observer observer) {
        getObservers().add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        getObservers().remove(observer);
    }

}
