package model.Timer;
/**
 * Created by yanice on 18/01/17.
 */
public class Stopwatch extends GameTimer {

    public Stopwatch() {
        setCentiSeconds(0);
        setSeconds(0);
        setMinutes(0);
        setHours(0);
    }

    @Override
    public void performAction() {
        setCentiSeconds(getCentiSeconds() + 1);
        if (getCentiSeconds() >= 93) {
            setCentiSeconds(0);
            setSeconds(getSeconds() + 1);
        }
        if (getSeconds() >= 60) {
            setSeconds(0);
            setMinutes(getMinutes() + 1);
        }
        if (getMinutes() >= 60) {
            setMinutes(0);
            setHours(getHours() + 1);
        }
        notifyObservers();
    }

    @Override
    public void reset() {
        setCentiSeconds(0);
        setSeconds(0);
        setMinutes(0);
        setHours(0);
    }
}