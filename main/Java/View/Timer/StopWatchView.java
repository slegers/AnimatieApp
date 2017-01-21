package View.Timer;

import Controller.Stopwatch.StopwatchController;
import model.Timer.GameTimerObserver.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 18/01/17.
 */
public class StopWatchView extends JFrame implements Observer{
    private JButton start,reset,round;
    private JLabel timer;
    private JLabel[] rounds;
    private StopwatchController controller;

    public StopWatchView(StopwatchController stopwatchController) {
        controller = stopwatchController;
        createElements();
        setElements();
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void setElements() {
        this.setLayout(new GridLayout(5,1));
        add(timer);
        getContentPane().setBackground(getStandardBackgroundColor());
        timer.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        timer.setForeground(getStandardTextColor());
        timer.setHorizontalAlignment(SwingConstants.CENTER);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startStopwatch();
            }
        });
        add(start);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.resetStopwatch();
            }
        });
        add(reset);
        add(round);

        for(JLabel r : rounds){
            //add(r);
        }

    }

    private Color getStandardBackgroundColor() {
        return Color.BLUE;
    }

    private void createElements() {
        start = new JButton("Start");
        reset = new JButton("reset");
        round = new JButton("round");
        timer = new JLabel("00:00:00:00");
        rounds = new JLabel[5];
    }


    public int getTextSize() {
        return 60;
    }

    public Color getStandardTextColor() {
        return Color.red;
    }

    @Override
    public void update() {
        timer.setText(controller.getTime());
    }
}
