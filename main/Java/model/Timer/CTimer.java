package model.Timer;

import model.Timer.GameTimer;

/**
 * Created by yanice on 20/01/17.
 */
public class CTimer extends GameTimer {

    private int maxTime;
    /**
     * Creates a Countdown timer.
     *
     * @param maxTime
     *        The maximum time this Timer has expressed in seconds.
     */
    public CTimer(int maxTime){
        this.maxTime = maxTime;
        seconds = maxTime % 60;
        minutes = maxTime /60;
        hours = maxTime / 60 * 60;
    }

    @Override
    public void performAction() {
        setCentiSeconds(getCentiSeconds() - 1);
        if (getCentiSeconds() <= 0) {
            setCentiSeconds(93);
            setSeconds(getSeconds() -1);
        }
        if (getSeconds() <= 0) {
            setSeconds(59);
            setMinutes(getMinutes() - 1);
        }
        if (getMinutes() <= 0) {
            setMinutes(60);
            setHours(getHours() - 1);
        }
        notifyObservers();
    }

    @Override
    public void reset() {
        seconds = maxTime % 60;
        minutes = maxTime /60;
        hours = maxTime / 60 * 60;
    }
}
