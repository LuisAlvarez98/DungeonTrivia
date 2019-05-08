package dungeontrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class PlayerSelectPanel {

    private Rectangle backButton = new Rectangle();

    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        backButton = new Rectangle(50, 50, 60, 70);
        Font fnt0 = new Font("helvetica", Font.BOLD, 20);
        g.setFont(fnt0);
        g.setColor(Color.white);
        //g2d.draw(backButton);
        g2d.drawImage(Assets.back, 50, 100, 70, 70, null);

        g2d.drawImage(Assets.P1, width / 2 - 100, height / 2 - 300, 260, 100, null);
        g2d.drawImage(Assets.P2, width / 2 - 100, height / 2 - 150, 260, 100, null);
        g2d.drawImage(Assets.P3, width / 2 - 100, height / 2 + 50, 260, 100, null);
        g2d.drawImage(Assets.P4, width / 2 - 100, height / 2 + 200, 260, 100, null);

        g2d.drawString("SINGLE PLAYER", width / 2 - 75, height / 2 - 300);
        g2d.drawString("2 PLAYERS", width / 2 - 75, height / 2 - 150);
        g2d.drawString("3 PLAYERS", width / 2 - 75, height / 2 + 50);
        g2d.drawString("PARTY MODE", width / 2 - 75, height / 2 + 200);
    }
}
