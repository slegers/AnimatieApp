package View;

import Controller.AaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 25/12/16.
 */
public class MainMenu extends JFrame {
    private AaController controller;
    private JButton timesUp, countDownTimer, timer;
    public MainMenu(AaController c ){
        setLocationRelativeTo(null);
        controller = c;
        init();
        setVisible(true);
    }

    private void init() {
        setElements();
    }

    private void setElements() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(5,1);
        setLayout(layout);
        timesUp = new JButton("Time's up");
        timesUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startTimesUpSettings();
                dispose();
            }
        });
        countDownTimer = new JButton("Countdown timer");
        countDownTimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        timer = new JButton("Stopwatch");
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startStopwatch();
                dispose();
            }
        });

        add(timesUp);
        add(countDownTimer);
        add(timer);
        getContentPane().setBackground(Color.red);
        this.pack();
    }


    public AaController getController(){
        return controller;
    }
}
