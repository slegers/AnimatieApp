package model.Timer;

import model.Timer.GameTimerObserver.Observer;
import model.Timer.GameTimerObserver.Subject;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by yanice on 20/01/17.
 */
public abstract class GameTimer implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private Timer timer;
    private int centiSeconds,seconds,minutes,hours;

    public GameTimer(){
        timer = new Timer(9, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performAction();
            }
        });
    }
    public abstract void performAction();

    public Timer getTimer(){
        return timer;
    }

    public void setTimer(Timer timer){
        this.timer = timer;
    }
    public void startTimer(){
        timer.start();
    }

    public void stopTimer(){
        timer.stop();
    }
    public int getCentiSeconds(){
        return centiSeconds;
    }
    public int getSeconds(){
        return seconds;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getHours(){
        return hours;
    }
    public String getTime(){
        String centiSecondsS,secondsS,minutsS,hoursS;

        centiSecondsS = getCentiSeconds() + "";
        secondsS = getSeconds() + "";
        minutsS = getMinutes() + "";
        hoursS = getHours()+ "";

        if(centiSecondsS.length() == 1){
            centiSecondsS = "0" + centiSecondsS;
        }if(secondsS.length() == 1){
            secondsS = "0" + secondsS;
        }if(minutsS.length() == 1){
            minutsS = "0" + minutsS;
        }if(hoursS.length() == 1){
            hoursS = "0" + hoursS;
        }
        return hoursS + ":" + minutsS + ":" + secondsS + ":" + centiSecondsS;
    }

    public abstract void reset();

    public void setCentiSeconds(int centiSeconds){
        this.centiSeconds = centiSeconds;
    }
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public void setHours(int hours){
        this.hours = hours;
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public void addObserver(Observer o) {
        getObservers().add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        getObservers().remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : getObservers()){
            o.update();
        }
    }
    @Override
    public void notifyObserver(Observer o) {
        o.update();
    }
}
