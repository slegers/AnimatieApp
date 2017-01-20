package model.Timer;

import Controller.TimesUp.TimesUpController;
import model.TimesUp.TimesUpGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 15/01/17.
 */
public class CountDownTimer {
    private int timePast;
    private Timer timer;
    private int maxTime;
    private TimesUpController controller;


    public CountDownTimer(TimesUpController controller, TimesUpGame game) {
        maxTime = controller.getTimesUpSettingsFacade().getMaxTime();
        timePast = 0;
       // stoptedStatus = new StoptedState();
       // runningStatus = new RunningState();
       // status = getStoptedStatus();
        this.controller = controller;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (maxTime - timePast >= 0) {
                    timePast++;
                    game.setTime(getTime());
                    controller.notifyObservers();
                }else{
                    stop();
                    game.setState(game.getOutOfTimeState());
                }
            }
        });
    }

    public void resertTimer(){
        setTimePast(0);
    }

    private void setTimePast(int timePast) {
        this.timePast = timePast;
    }

    public String getTime() {
        return parseTimeToString(maxTime - timePast);
    }
    private String parseTimeToString(int time){
        if(time < 1){
            stop();
        }
        int min = time/60;
        int sec = time % 60;
        return min +":" + sec;
    }

    public void stop() {
        //setStatus(getStoptedStatus());
        timer.stop();
    }

    public void start() {
        //setStatus(getRunningStatus());
        timer.start();
    }
    public int getTimeInt(){
        return maxTime - timePast;
    }
}
