package View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by yanice on 15/01/17.
 */
public class MenuBar extends JMenuBar {
    private JMenu menu, help,exit;
    private JMenuItem menuItem;

    public MenuBar(){
        createItems();
        setElements();
        setActionHandlers();
        setVisible(true);
    }

    private void setActionHandlers() {
        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,"Deze applicatie is geschreven door Yanice Slegers (c) in 2016. ","Animatie App",JOptionPane.INFORMATION_MESSAGE);

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
    }

    private void createItems() {
        menu = new JMenu("Menu");
        help = new JMenu("help");
        exit = new JMenu("exit");

    }
    private void setElements(){
        this.add(menu);
        this.add(help);
        this.add(exit);

    }
}
