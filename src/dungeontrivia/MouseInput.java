/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import static dungeontrivia.DungeonTrivia.n;
import static dungeontrivia.Game.players;
import static dungeontrivia.Game.state;
import static dungeontrivia.HighscoresPanel.stats;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author luisf
 */
public class MouseInput implements MouseListener, MouseMotionListener {

    private boolean izquierdo;
    private boolean derecho;
    private int x;
    private int y;
    DbConnect connect = new DbConnect();

    public MouseInput() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println(me.getX() + ":" + me.getY());

        if (state == Game.STATE.MENU) {
            if (me.getX() >= 433 && me.getX() <= 642) {
                if (me.getY() >= 338 && me.getY() <= 435) {
                    //play button
                    System.out.println("Play");
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

            if (me.getX() >= 296 && me.getX() <= 503) {
                if (me.getY() >= 359 && me.getY() <= 393) {
                    state = Game.STATE.PLAYERSELECT;
                    System.out.println("ajaja");
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
                    state = Game.STATE.GAME;
                }
            }
            //P2
            if (me.getX() >= 447 && me.getX() <= 690) {
                if (me.getY() >= 257 && me.getY() <= 337) {
                    initPlayers(2);
                    state = Game.STATE.GAME;
                }
            }
            //P3
            if (me.getX() >= 452 && me.getX() <= 689) {
                if (me.getY() >= 453 && me.getY() <= 541) {
                    initPlayers(3);
                    state = Game.STATE.GAME;
                }
            }
            //P4
            if (me.getX() >= 450 && me.getX() <= 689) {
                if (me.getY() >= 608 && me.getY() <= 691) {
                    initPlayers(4);
                    state = Game.STATE.GAME;
                }
            }
        }
        if (state == Game.STATE.ENDGAME) {
            if (me.getX() >= 53 && me.getX() <= 115) {
                if (me.getY() >= 107 && me.getY() <= 163) {
                    state = Game.STATE.MENU;
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
