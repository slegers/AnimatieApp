package model.Timer;

import Controller.TimesUp.TimesUpController;
import com.sun.tools.javadoc.Start;
import model.Game.GameState.StartStatus;
import model.Timer.Status.StoptedStatus;
import model.Timer.Status.TimerStatus;
import model.Timer.Status.RunningStatus;

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
    private TimerStatus status;
    private StoptedStatus stoptedStatus = new StoptedStatus();
    private RunningStatus runningStatus = new RunningStatus();

    public CountDownTimer(TimesUpController controller) {
        maxTime = controller.getTimesUpSettingsFacade().getMaxTime();
        timePast = 0;
        this.controller = controller;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (0 != 0) {
                    timePast++;
                   controller.notifyAll();
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
        System.out.println(time);
        int min = time/60;
        int sec = time % 60;
        return min +":" + sec;
    }

    public void setTime(int time) {
        this.maxTime = time;
    }

    public void stop() {
        setStatus(getStoptedStatus());
        timer.stop();
    }

    public void start() {
        setStatus(getRunningStatus());
        timer.start();
    }
    public boolean isRunning() {
        return status.isRunning();
    }

    public void setStatus(TimerStatus status) {
        this.status = status;
    }

    public StoptedStatus getStoptedStatus() {
        return stoptedStatus;
    }

    public RunningStatus getRunningStatus() {
        return runningStatus;
    }
}
