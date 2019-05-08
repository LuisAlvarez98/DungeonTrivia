/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

/**
 * Highscore dialog class, Creates the dialog for the highscore insertion
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
import static dungeontrivia.DungeonTrivia.con;
import static dungeontrivia.Game.highScoreDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;
import java.awt.event.*;

public class HighScoreDialog {

    DbConnect connect = new DbConnect();
    JTextField tf1, tf2, tf3;
    JButton b1, b2;
    public boolean available;
    JFrame f = new JFrame();

    private String name;
    private int score;
    private boolean highscoreUpdated = false;

    /**
     * HighScoreDialog constructor
     *
     * @param available
     */
    HighScoreDialog(boolean available) {
        //submit button
        f.setTitle("Insert highscore");
        JButton b = new JButton("Submit");
        b.setBounds(100, 100, 140, 40);
        //enter name label
        JLabel label = new JLabel();
        label.setText("Enter Name :");
        label.setBounds(10, 10, 100, 100);
        //empty label which will show event after button clicked
        JLabel label1 = new JLabel();
        label1.setBounds(10, 110, 200, 100);
        //textfield to enter name
        JTextField textfield = new JTextField();
        textfield.setBounds(110, 50, 130, 30);
        //add to frame
        f.add(label1);
        f.add(textfield);
        f.add(label);
        f.add(b);
        f.setSize(400, 200);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(false);
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                f.setVisible(false);
                setHighscoreUpdated(true);
            }
        });
        //action listener
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                label1.setText("Highscore has been submitted.");
                String name = textfield.getText();
                setHighscoreUpdated(true);
                connect.insertTop(name, score);
                setAvailable(false);
                f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
                textfield.setText("");
                label1.setText("");
            }
        });
    }

    /**
     * setHighscoreUpdated method
     *
     * @param highscoreUpdated
     */
    public void setHighscoreUpdated(boolean highscoreUpdated) {
        this.highscoreUpdated = highscoreUpdated;
    }

    /**
     * isHighscoreUpdated method
     *
     * @return highscoreUpdated
     */
    public boolean isHighscoreUpdated() {
        return highscoreUpdated;
    }

    /**
     * isAvailable method
     *
     * @return available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * setAvailable method
     *
     * @param available
     */
    public void setAvailable(boolean available) {
        this.available = available;
        f.setVisible(available);
    }

    /**
     * setName method
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setScore method
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * getName method
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getScore method
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        new HighScoreDialog(false);
    }
}
