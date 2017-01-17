package View.TimesUp;

import Controller.TimesUp.TimesUpController;
import View.MenuBar;
import model.TimesUp.Obeserver.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 27/12/16.
 */
public class TimesUpView extends JFrame implements Observer{
    private TimesUpController controller;
    private JPanel timerP, teamP, buttonP;
    private JLabel timerL, nameL,teamNameL,score;
    private JButton next, pass, start;


    public TimesUpView(TimesUpController controller){
        this.controller = controller;
        createElements();
        setElements();
        //update();
        addActionListners();
        setSize(350,600);
        setLocationRelativeTo(null);
        controller.notifyObservers();
    }

    private void addActionListners() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startButtonPushed();
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.nextButtonPushed();
            }
        });
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.passButtonPushed();
            }
        });
    }

    private void createElements() {
        timerP = new JPanel();
        teamP = new JPanel();
        buttonP = new JPanel();
        timerL = new JLabel();
        nameL = new JLabel();
        teamNameL = new JLabel();
        score = new JLabel();
        next = new JButton("next");
        pass = new JButton("pass");
        start = new JButton("start");
    }

    private void setElements() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));
        setJMenuBar(new MenuBar());
        timerL.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        timerL.setForeground(getStandardTextColor());
        timerL.setHorizontalAlignment(SwingConstants.CENTER);

        timerP.setLayout(new GridLayout(2,1));
        timerP.add(timerL);
        nameL.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        nameL.setHorizontalAlignment(SwingConstants.CENTER);
        nameL.setForeground(getStandardTextColor());
        timerP.add(nameL);
        timerP.setBackground(getStandardBackgroundColor());
        add(timerP);

        this.getContentPane().setBackground(getStandardBackgroundColor());
        teamP.setLayout(new GridLayout(2,1));
        teamNameL.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        teamNameL.setHorizontalAlignment(SwingConstants.CENTER);
        teamNameL.setForeground(getStandardTextColor());
        teamP.setBackground(getStandardBackgroundColor());
        teamP.add(teamNameL);

        score.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        score.setForeground(getStandardTextColor());
        score.setHorizontalAlignment(SwingConstants.CENTER);
        teamP.add(score);

        add(teamP);

        buttonP.setLayout(new GridLayout(3,1));
        buttonP.add(start);
        buttonP.add(next);
        buttonP.add(pass);
        buttonP.setBackground(getStandardBackgroundColor());
        add(buttonP);
        setVisible(true);
        pack();
    }
    private int getTextSize(){
        return 60;
    }
    private Color getStandardBackgroundColor() {
        return Color.red;
    }
    private Color getStandardTextColor() {
        return Color.yellow;
    }
    private void notImpl(){
        JOptionPane.showMessageDialog(null,"Sorry to inform you, this method is not impl yet!");
    }

    @Override
    public void update(String name, String teamName, String time, String teamScore) {
        timerL.setText(time);
        nameL.setText(name);
        teamNameL.setText(teamName);
        score.setText(teamScore);
    }
}
