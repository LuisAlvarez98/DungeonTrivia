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
        JFrame frame = new JFrame("Dungeon Trivia");
        frame.setSize(1080, 800);
        
        
        
        JButton b = new JButton("Click Here");
        b.setBounds(50, 100, 95, 30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //StartGame
                Game g = new Game("Dungeon Trivia", 1080, 800);
                g.start();
            }
        });
        frame.add(b);
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel textLabel = new JLabel("I'm a label in the window", SwingConstants.CENTER);
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // TODO code application logic here
//       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
