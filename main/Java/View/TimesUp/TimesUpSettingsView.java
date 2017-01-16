package View.TimesUp;

import Controller.TimesUp.TimesUpController;
import model.AaRepo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 27/12/16.
 */
public class TimesUpSettingsView extends JFrame{
    private TimesUpController controller;
    private JPanel content;
    private JButton save;
    private JComboBox numbTeamList,numbNamesList,timeStringList, namesList;
    private JCheckBox adminView;
    public TimesUpSettingsView(TimesUpController controller){
        this.controller = controller;
        createElements();
        setLayout();
        setElements();

        this.setTitle("Time's Up");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);

    }
    private void setElements(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel teamsText = new JLabel("Number of Teams:");
        teamsText.setFont(new Font("Serif", Font.PLAIN, getTextSize()));

        teamsText.setForeground(Color.yellow);
        String[] numbTeamsString = {"2", "3", "4", "5","6","7","8","9"};
        numbTeamList = new JComboBox(numbTeamsString);
        content.add(teamsText);
        content.add(numbTeamList);
        content.setBackground(getBackgroundColor());
        add(content);

        JLabel namesText = new JLabel("Number of Names:");
        namesText.setFont(new Font("Serif", Font.PLAIN, getTextSize()));

        namesText.setForeground(Color.yellow);
        String[] namesNumbString = {"20","30","40" ,"50"};
        numbNamesList = new JComboBox(namesNumbString);
        content.add(namesText);
        content.add(numbNamesList);
        content.setBackground(getBackgroundColor());
        add(content);

        JLabel timeText = new JLabel("Time for each round:");
        timeText.setFont(new Font("Serif", Font.PLAIN, getTextSize()));

        timeText.setForeground(Color.yellow);
        String[] timeString = {"20s","30s","45s"};
        timeStringList = new JComboBox(timeString);

        content.add(timeText);
        content.add(timeStringList);
        JLabel nameText = new JLabel("Which type:");
        nameText.setFont(new Font("Serif", Font.PLAIN, getTextSize()));

        nameText.setForeground(Color.yellow);
        String[] nString = {"BV","Disney","Strips","TV", "BP"};
        namesList = new JComboBox(nString);
        content.add(nameText);
        content.add(namesList);

        adminView = new JCheckBox("Admin view");
        adminView.setFont(new Font("serif",Font.PLAIN,getTextSize()));
        adminView.setForeground(Color.yellow);
        content.add(adminView);
        content.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSettings();
                controller.readNames();
                controller.createTeams();
                dispose();
            }
        });

        add(content);
        getContentPane().setBackground(getBackgroundColor());
        this.setResizable(false);
        this.pack();
    }

    private void saveSettings() {
        int nmbTeams = Integer.parseInt(numbTeamList.getSelectedItem().toString());
        int nmbNames = Integer.parseInt(numbNamesList.getSelectedItem().toString());
        int time = Integer.parseInt(timeStringList.getSelectedItem().toString().substring(0,timeStringList.getSelectedItem().toString().length()-1));
        String file = namesList.getSelectedItem().toString();
        boolean adminView = this.adminView.isSelected();

        controller.saveTimesUpSettings(nmbTeams,nmbNames,time,file,adminView);
    }

    private void createElements(){
        save = new JButton("Save");
        content = new JPanel();
    }
    private  void setLayout(){
        this.content.setLayout(new GridLayout(5,2));
        this.setLayout(new GridLayout(1,1));
    }
    private int getTextSize(){
        return 60;
    }
    public Color getBackgroundColor() {
        return Color.red;
    }
}
