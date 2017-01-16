package View.Team;

import Controller.TimesUp.TimesUpController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by yanice on 14/01/17.
 */
public class CreateTeamView extends JFrame{
    private JLabel name;
    private JTextField nameField;
    private JButton save;
    private TimesUpController controller;
    public CreateTeamView(TimesUpController controller) {
        this.controller = controller;
        createElements();
        setElements();
        this.setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }


    private void setElements() {
        this.setTitle("Create Team");
        setLayout(new GridLayout(2,2));
        name.setFont(new Font("Serif", Font.PLAIN, 60));
        name.setForeground(Color.yellow);
        add(name);
        add(nameField);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addTeam(nameField.getText());
                controller.createTeams();
                dispose();
            }
        });
        add(save);
        this.getContentPane().setBackground(Color.red);
    }

    private void createElements() {
        name = new JLabel("Name:");
        nameField = new JTextField();
        save = new JButton("Save");
    }
}
