/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author luisfelipealvarez
 */
public class DungeonTrivia extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Game n = new Game("Dungeon Trivia", 1080, 800);
        n.start();//       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
