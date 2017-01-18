package View.TimesUp;

import Controller.Main;
import Controller.TimesUp.TimesUpController;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by yanice on 15/01/17.
 */
public class TimesUpMenuBar extends JMenuBar {
    private JMenu menu, help,exit,timer;
    private JMenuItem menuItem;
    private TimesUpController controller;
    public TimesUpMenuBar(TimesUpController controller){
        createItems();
        setElements();
        setActionHandlers();
        setVisible(true);
        this.controller = controller;

    }

    private void setActionHandlers() {
        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,"Deze applicatie is geschreven door (c)Yanice Slegers  in 2016. \n" +
                        "Voor verdere info yanice@wina.be","Animatie App",JOptionPane.INFORMATION_MESSAGE);


            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Are You Sure? All your process will be lost!" ,
                        "Exit?",
                        JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        timer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controller.createTimerView();
            }
        });
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               controller.dispose();
                Main.main(null);
            }
        });

    }

    private void createItems() {
        menu = new JMenu("Menu");
        help = new JMenu("help");
        exit = new JMenu("exit");
        timer = new JMenu("Timer");

    }
    private void setElements(){
        this.add(menu);
        this.add(help);
        this.add(exit);
        this.add(timer);

    }
}
