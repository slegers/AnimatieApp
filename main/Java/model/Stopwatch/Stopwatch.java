package model.Stopwatch;

import Controller.Stopwatch.StopwatchController;
import model.TimesUp.Timer.Status.RunningState;
import model.TimesUp.Timer.Status.StoptedState;
import model.TimesUp.Timer.Status.TimerState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 18/01/17.
 */
public class Stopwatch {

    private int centiSeconds,seconds,minutes,hours;
    private  StopwatchController controller;
    private Timer timer;
    private TimerState status;
    private RunningState runningState;
    private StoptedState stoptedState;
    public Stopwatch(StopwatchController controller){
        runningState = new RunningState();
        stoptedState = new StoptedState();
        setStatus(getStopptedState());
        this.controller = controller;
        centiSeconds = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        this.timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increaseTime();
                controller.notifyObservers();
            }
        });
    }
    private void increaseTime() {
        centiSeconds++;
        if(centiSeconds >=87){
            centiSeconds = 0;
            seconds++;
        }if(seconds >=60){
            seconds = 0;
            minutes++;
        }if(minutes >= 60){
            minutes = 0;
            hours ++;
        }
    }
    public String getTime(){
        String centiSecondsS,secondsS,minutsS,hoursS;

        centiSecondsS = this.centiSeconds + "";
        secondsS = this.seconds + "";
        minutsS = this.minutes + "";
        hoursS = this.hours + "";

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

    public void startTimer(){
        timer.start();
        setStatus(getRunningState());
    }
    public void stopTimer(){
        timer.stop();
    }
    public void reset(){
        centiSeconds = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
    }

    public RunningState getRunningState() {
        return runningState;
    }

    public StoptedState getStopptedState() {

        return stoptedState;
    }

    public void setStatus(TimerState status) {
        this.status = status;
    }
}
