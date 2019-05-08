/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import static dungeontrivia.Game.highScoreDialog;
import static dungeontrivia.Game.isAvailableForHighscore;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author luisf
 */
public class HighscoresPanel {

    public static ArrayList<Stat> stats;
    private Rectangle backButton = new Rectangle();

    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        backButton = new Rectangle(50, 50, 60, 70);

        //g2d.draw(backButton);
        g2d.drawImage(Assets.back, 50, 100, 70, 70, null);
        Font fnt0 = new Font("timesroman", Font.BOLD, 17);
        g.setFont(fnt0);
        g.setColor(Color.black);
        for (int i = 0; i < stats.size(); i++) {
            g2d.drawString(stats.get(i).getName() + " : " + stats.get(i).getScore(), width / 2 - 100, height / 2 - 50 -80 * (-i) );
        }
    }
}
