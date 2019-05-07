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
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author student
 */
public class EndGame {
    
    private Game game;
    private ArrayList<Player> players;
    
    public EndGame(Game game){
        this.game = game;
        players = new ArrayList<Player>(game.getPlayers());
        
    }
    
    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Assets.back, 50, 100,70, 70,null);
        
        Font fnt1 = new Font("arial", Font.BOLD, 40);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g2d.drawString("Scores", width / 2, 100);
        
        fnt1 = new Font("arial", Font.BOLD, 25);
        g.setFont(fnt1);
        g.setColor(Color.white);
        
        Collections.sort(
                players,
                (player1, player2) -> player2.getScore()
                        - player1.getScore());
        
        for(int i = 0; i < players.size(); i++){
            g2d.drawString(""+ (i+1) + ") ", width / 2 - 200, 300 + 100 * i);
            g2d.drawString("Player " + players.get(i).getPlayerNum(), width / 2, 300 + 100 * i);
            g2d.drawString("" + players.get(i).getScore(), width / 2 + 200, 300 + 100 * i);
            
        }
        
        
    }
}
