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
 * LevelSelect utilizada para crear un Hitbox de los botones
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class LevelSelect {

    // Variables
    public static Rectangle playButton = new Rectangle();
    private Rectangle highScore = new Rectangle();
    private Rectangle exitButton = new Rectangle();
    private Rectangle instructionButton = new Rectangle();

    /**
     * Metodo para pintar en pantalla
     * @param g un <code>Graphics</code> con el graficador
     * @param width un <code>int</code> con la anchura
     * @param height un <code>int</code> con la altura
     */
    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Assets.back, 50, 100,70, 70,null);
    }
}
