package View.Timer;

import Controller.TimesUp.TimesUpController;
import model.TimesUp.Obeserver.Observer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yanice on 25/12/16.
 */
public class TimesUpTimerView extends JFrame implements Observer{
    private JLabel timerLabel,teamNameL,score;

    private TimesUpController controller;
    public TimesUpTimerView(TimesUpController controller) {
        this.controller = controller;
        setElements();
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        setSize(400,400);
    }

    private void setElements() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(getStandardBackColor());
        this.setLayout(new GridLayout(3,1));
        timerLabel = new JLabel();
        timerLabel.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        timerLabel.setForeground(getStandardTextColor());
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setBackground(getStandardBackColor());
        add(timerLabel);
        
        teamNameL = new JLabel();
        teamNameL.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        teamNameL.setForeground(getStandardTextColor());
        teamNameL.setHorizontalAlignment(SwingConstants.CENTER);
        teamNameL.setBackground(getStandardBackColor());

        add(teamNameL);

        score = new JLabel();
        score.setForeground(getStandardTextColor());
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        score.setBackground(getStandardBackColor());
        add(score);
    }

    @Override
    public void update(String name, String teamName, String time, String teamScore) {
        timerLabel.setText(time);
        teamNameL.setText(teamName);
        score.setText(teamScore);
    }

    @Override
    public void update() {

    }

    public int getTextSize() {
        return 60;
    }

    public Color getStandardTextColor() {
        return Color.yellow;
    }
    public Color getStandardBackColor() {
        return Color.red;
    }
}

