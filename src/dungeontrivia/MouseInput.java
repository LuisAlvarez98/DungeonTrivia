/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import static dungeontrivia.DungeonTrivia.n;
import static dungeontrivia.Game.highScoreDialog;
import static dungeontrivia.Game.players;
import static dungeontrivia.Game.preguntas;
import static dungeontrivia.Game.state;
import static dungeontrivia.Game.numeroPreguntas;
import static dungeontrivia.Game.paused;
import static dungeontrivia.HighscoresPanel.stats;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * MouseInput utilizada para checar los eventos con el mouse
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class MouseInput implements MouseListener, MouseMotionListener {

    // Variables
    private boolean izquierdo;
    private boolean derecho;
    private int x;
    private int y;
    DbConnect connect = new DbConnect();

    /**
     * Constructor MouseInput
     */
    public MouseInput() {

    }

    /**
     * Metodo para acceder la x
     *
     * @return un <code>int</code> con la posicion en x
     */
    public int getX() {
        return x;
    }

    /**
     * Metodo para acceder la y
     *
     * @return un <code>int</code> con la posicion en y
     */
    public int getY() {
        return y;
    }

    /**
     * Metodo para actuar en case de pinchar el mouse
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    /**
     * Metodo para actuar en caso de tener el mouse presionado
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println(me.getX() + ":" + me.getY());
        // Delimitaciones de posiciones para los botones
        if (state == Game.STATE.MENU) {
            if (me.getX() >= 433 && me.getX() <= 642) {
                if (me.getY() >= 338 && me.getY() <= 435) {
                    //play button
                    System.out.println("Play");
                    highScoreDialog.setHighscoreUpdated(false);
                    state = Game.STATE.LEVELS;
                }
            }
            if (me.getX() >= 435 && me.getX() <= 643) {
                if (me.getY() >= 616 && me.getY() <= 709) {
                    System.out.println("Exit");
                    state = Game.STATE.EXIT;
                }
            }
            if (me.getX() >= 432 && me.getX() <= 642) {
                if (me.getY() >= 465 && me.getY() <= 564) {
                    //Run stats query
                    stats = connect.getHighscores();
                    state = Game.STATE.HIGHSCORES;
                }
            }
            if (me.getX() >= 992 && me.getX() <= 1067) {
                if (me.getY() >= 599 && me.getY() <= 750) {
                    System.out.println("Instructions");
                    state = Game.STATE.CONTROLS;
                }
            }
        }
        if (state == Game.STATE.HIGHSCORES) {
            if (me.getX() >= 53 && me.getX() <= 104) {
                if (me.getY() >= 118 && me.getY() <= 165) {
                    state = Game.STATE.MENU;
                }
            }
        }
        if (state == Game.STATE.CONTROLS) {
            if (me.getX() >= 53 && me.getX() <= 104) {
                if (me.getY() >= 118 && me.getY() <= 165) {
                    state = Game.STATE.MENU;
                }
            }

        }

        if (state == Game.STATE.LEVELS) {
            if (me.getX() >= 53 && me.getX() <= 115) {
                if (me.getY() >= 107 && me.getY() <= 163) {
                    state = Game.STATE.MENU;
                }
            }

            if (me.getX() >= 262 && me.getX() <= 506) {
                if (me.getY() >= 368 && me.getY() <= 419) {
                    //boton All
                    state = Game.STATE.PLAYERSELECT;
                    preguntas = connect.getQuestions();
                    numeroPreguntas = preguntas.size();
                }
            }

            if (me.getX() >= 568 && me.getX() <= 811) {
                if (me.getY() >= 362 && me.getY() <= 419) {
                    //boton Math
                    state = Game.STATE.PLAYERSELECT;
                    preguntas = connect.getMathQuestions();
                    numeroPreguntas = preguntas.size();
                }
            }
            if (me.getX() >= 266 && me.getX() <= 501) {
                if (me.getY() >= 473 && me.getY() <= 522) {
                    //boton Science
                    state = Game.STATE.PLAYERSELECT;
                    preguntas = connect.getScienceQuestions();
                    numeroPreguntas = preguntas.size();
                }
            }
            if (me.getX() >= 573 && me.getX() <= 811) {
                if (me.getY() >= 470 && me.getY() <= 521) {
                    //boton History
                    state = Game.STATE.PLAYERSELECT;
                    preguntas = connect.getHistoryQuestions();
                    numeroPreguntas = preguntas.size();
                }
            }
            if (me.getX() >= 266 && me.getX() <= 501) {
                if (me.getY() >= 575 && me.getY() <= 624) {
                    //boton Geography
                    state = Game.STATE.PLAYERSELECT;
                    preguntas = connect.getGeographyQuestions();
                    numeroPreguntas = preguntas.size();
                }
            }
            if (me.getX() >= 573 && me.getX() <= 811) {
                if (me.getY() >= 575 && me.getY() <= 620) {
                    //boton Comp Sci
                    state = Game.STATE.PLAYERSELECT;
                    preguntas = connect.getCSQuestions();
                    numeroPreguntas = preguntas.size();
                }
            }

        }
        if (state == Game.STATE.GAME) {
            if (paused) {
                if (me.getX() >= 280 && me.getX() <= 494) {
                    if (me.getY() >= 406 && me.getY() <= 471) {
                        state = Game.STATE.MENU;
                        paused = false;
                    }
                }
                if (me.getX() >= 590 && me.getX() <= 802) {
                    if (me.getY() >= 407 && me.getY() <= 475) {
                        paused = false;
                    }
                }
            }
        }
        if (state == Game.STATE.PLAYERSELECT) {
            if (me.getX() >= 53 && me.getX() <= 115) {
                if (me.getY() >= 107 && me.getY() <= 163) {
                    state = Game.STATE.LEVELS;
                }
            }
            //P1
            if (me.getX() >= 451 && me.getX() <= 685) {
                if (me.getY() >= 109 && me.getY() <= 181) {
                    initPlayers(1);
                    Game.endGamelvl = new EndGame(n);
                    state = Game.STATE.GAME;
                }
            }
            //P2
            if (me.getX() >= 447 && me.getX() <= 690) {
                if (me.getY() >= 257 && me.getY() <= 337) {
                    initPlayers(2);
                    Game.endGamelvl = new EndGame(n);
                    state = Game.STATE.GAME;
                }
            }
            //P3
            if (me.getX() >= 452 && me.getX() <= 689) {
                if (me.getY() >= 453 && me.getY() <= 541) {
                    initPlayers(3);
                    Game.endGamelvl = new EndGame(n);
                    state = Game.STATE.GAME;
                }
            }
            //P4
            if (me.getX() >= 450 && me.getX() <= 689) {
                if (me.getY() >= 608 && me.getY() <= 691) {
                    initPlayers(4);
                    Game.endGamelvl = new EndGame(n);
                    state = Game.STATE.GAME;
                }
            }
        }
        if (state == Game.STATE.ENDGAME) {
            if (me.getX() >= 53 && me.getX() <= 115) {
                if (me.getY() >= 107 && me.getY() <= 163) {
                    state = Game.STATE.MENU;
                    System.out.println("ajaja");
                }
            }
        }
    }

    public void initPlayers(int nPlayers) {
        //Create objectcs
        players = new ArrayList<Player>();
        for (int i = 0; i < nPlayers; i++) {
            Player player = new Player(200 + 200 * i, 620, 1, 100, 120, n, 3, i + 1);
            player.getHearts().add(new Heart(player.getX() + 10, player.getY(), 20, 20));
            player.getHearts().add(new Heart(player.getX() + 30, player.getY(), 20, 20));
            player.getHearts().add(new Heart(player.getX() + 50, player.getY(), 20, 20));
            players.add(player);
        }
        Game.numPlayers = players.size();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
