package Controller.Stopwatch;

import View.Timer.StopWatchView;
import model.Timer.Stopwatch;
import model.Timer.GameTimerObserver.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanice on 18/01/17.
 */
public class StopwatchController {
    private StopWatchView stopWatchView;
    private ArrayList<Observer> observers = new ArrayList<>();
    private Stopwatch stopwatch;
    public void createStopwatchView() {
        stopWatchView = new StopWatchView(this);
        stopwatch = new Stopwatch();
        stopwatch.addObserver(stopWatchView);
    }

    public void startStopwatch() {
        stopwatch.startTimer();
    }

    public void stopStopwatch() {
        stopwatch.stopTimer();
    }

    public void resetStopwatch() {
        stopwatch.reset();
    }

    public String getTime() {
        return stopwatch.getTime();
    }

}