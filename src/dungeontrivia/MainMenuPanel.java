/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author luisf
 */
public class MainMenuPanel {

    public static Rectangle playButton = new Rectangle();
    private Rectangle highScore = new Rectangle();
    private Rectangle exitButton = new Rectangle();

    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        playButton = new Rectangle(width / 2 - 110, 340, 215, 100);
        highScore = new Rectangle(width / 2 - 110, 465, 215, 100);
        exitButton = new Rectangle(width / 2 - 110, 615, 215, 100);
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        //g.setColor(Color.);
        g2d.draw(playButton);
        g2d.draw(highScore);
        g2d.draw(exitButton);
    }
}
