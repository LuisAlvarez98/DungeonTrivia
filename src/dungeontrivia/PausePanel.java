package dungeontrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Panel para la pantalla de pausa
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class PausePanel {

    public static ArrayList<Stat> stats;
    private Rectangle backButton = new Rectangle();

    /**
     * render method para pausepanel
     *
     * @param g
     * @param width
     * @param height
     */
    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        //Dibuja el bg de pausa
        g2d.drawImage(Assets.pause_bg, 0, 0, width, height, null);
    }
}
