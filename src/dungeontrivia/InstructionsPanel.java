package dungeontrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * InstructionsPanel es utilizada para desplegar en pantalla las 
 * instrucciones del juego
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class InstructionsPanel {

    // Variables
    private Rectangle backButton = new Rectangle();

    /**
     * Metodo para pintar en pantalla
     * @param g un <code>Graphics</code> con el graficador
     * @param width un <code>int</code> con la anchura
     * @param height un <code>int</code> con la altura
     */
    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        backButton = new Rectangle(50, 50, 60, 70);
        
        // Inicializar el texto
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        Color c = new Color(1f, 0f, 0f, .5f);
        g.setColor(c);
        //g2d.draw(backButton);
        g2d.drawImage(Assets.back, 50, 100, 70, 70, null);
    }
}

