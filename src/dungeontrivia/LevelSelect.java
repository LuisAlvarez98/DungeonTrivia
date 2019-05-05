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
public class LevelSelect {

    public static Rectangle playButton = new Rectangle();
    private Rectangle highScore = new Rectangle();
    private Rectangle exitButton = new Rectangle();
    private Rectangle instructionButton = new Rectangle();

    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Assets.back, 50, 100,70, 70,null);
    }
}
