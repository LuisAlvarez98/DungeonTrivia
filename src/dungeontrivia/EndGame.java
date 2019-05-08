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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * EndGame class es una clase para instanciar el Highscore al final del juego
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class EndGame {

    private Game game;
    private ArrayList<Player> players;
    public static boolean gameDone;
    DbConnect connect = new DbConnect();

    /**
     * Constructor para instanciar EndGame
     *
     * @param game
     */
    public EndGame(Game game) {
        this.game = game;
        players = new ArrayList<Player>(game.getPlayers());
    }

    public static void setGameDone(boolean gameDone) {
        EndGame.gameDone = gameDone;
    }

    public static boolean isGameDone() {
        return gameDone;
    }

    /**
     * Metodo para poder pintar en pantalla la instancia
     *
     * @param g un <code>Graphics</code> con el graficador
     * @param width un <code>int</code> con el ancho de la imagen
     * @param height un <code>int</code> con la altura de la imagen
     */
    public void render(Graphics g, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        // Inicializar el fondo de pantalla
        g2d.drawImage(Assets.back, 50, 100, 70, 70, null);

        // Inivializar el texto
        Font fnt1 = new Font("arial", Font.BOLD, 40);
        g.setFont(fnt1);
        g.setColor(Color.white);
        g2d.drawString("Scores", width / 2, 100);

        // Inicializar el texto
        fnt1 = new Font("arial", Font.BOLD, 25);
        g.setFont(fnt1);
        g.setColor(Color.white);

        // Ordenar los jugadores por puntaje
        Collections.sort(
                players,
                (player1, player2) -> player2.getScore()
                - player1.getScore());

        // Pintar los puntajes de los jugadores
        //System.exit(0);
        for (int i = 0; i < players.size(); i++) {
            g2d.drawString("" + (i + 1) + ") ", width / 2 - 200, 300 + 100 * i);
            g2d.drawString("Player " + players.get(i).getPlayerNum(), width / 2, 300 + 100 * i);
            g2d.drawString("" + players.get(i).getScore(), width / 2 + 200, 300 + 100 * i);

        }

    }
}
