/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import javax.swing.*;
import java.awt.*;

/**
 * MainMenu utilizada para crear el menu principal
 * @author Luis, Adrian, Antonio and Rodrigo
 */
class MainMenu extends JFrame {

    // Variables
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem newFile, open, save, saveas, exit;

    /**
     * MainMenu Constructor
     */
    public MainMenu() {
        // Establecer sus atributos
        setTitle("Menu Button");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Modificar el color a un color visible
        getContentPane().setBackground(Color.darkGray);
        
        menuBar = new JMenuBar();
        menuBar.setBorderPainted(false);

        menu = new JMenu("File");

        menu.setBorderPainted(false);

        // Crear los items
        newFile = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveas = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");

        // Agregar los items
        menu.add(newFile);
        menu.add(open);
        menu.add(save);
        menu.add(saveas);
        menu.add(exit);

        // Agregar la barra al menu
        menuBar.add(menu);
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
