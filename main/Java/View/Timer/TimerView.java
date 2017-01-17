package View.Timer;

import Controller.TimesUp.TimesUpController;
import model.TimesUp.Obeserver.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yanice on 25/12/16.
 */
public class TimerView extends JFrame implements Observer{
    private JLabel timerLabe;
    private TimesUpController controller;
    public TimerView(TimesUpController controller){
        this.controller = controller;
        setElements();
    }

    private void setElements() {
        this.setLayout(new GridLayout(1,1));
        timerLabe = new JLabel();
        add(timerLabe);
        setVisible(true);
    }

    @Override
    public void update(String name, String teamName, String time, String teamScore) {

    }

}

