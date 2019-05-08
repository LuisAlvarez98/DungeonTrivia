/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;

/**
 * DungeonTrivia class es utilizada para poder ejecutar el metodo main
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class DungeonTrivia extends JFrame implements ActionListener {

    // Variables
    public static Connection con;
    public static Statement st;
    public static ResultSet rs;

    public static boolean offline;
    public static Game n;

    /**
     * Metodo Main
     */
    public static void main(String[] args) {
        n = new Game("Dungeon Trivia - Arkamys", 1080, 800);
        n.start();
    }

    /**
     * Metodo heredado por extension
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
