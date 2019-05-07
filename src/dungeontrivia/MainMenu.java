/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import javax.swing.*;
import java.awt.*;

class MainMenu extends JFrame {

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem newFile, open, save, saveas, exit;

    public MainMenu() {
        setTitle("Menu Button");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Set a background for menubutton to have a visible look
        getContentPane().setBackground(Color.darkGray);

        menuBar = new JMenuBar();
        menuBar.setBorderPainted(false);

        menu = new JMenu("File");

        // It's my style!
        menu.setBorderPainted(false);

        newFile = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveas = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");

        menu.add(newFile);
        menu.add(open);
        menu.add(save);
        menu.add(saveas);
        menu.add(exit);

        // Add menu to menubar
        menuBar.add(menu);

        // Add(don't set) menubar to frame
        add(menuBar);

        // Make frame maximized for a good look
        //setExtendedState(MAXIMIZED_BOTH);
        // or pack
        pack();
    }

    public static void main(String args[]) {
        new MainMenu();
    }

}
