/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import static dungeontrivia.Game.state;
import static dungeontrivia.Game.width;
import static dungeontrivia.MainMenuPanel.playButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author luisf
 */
public class MouseInput implements MouseListener, MouseMotionListener {

    private boolean izquierdo;
    private boolean derecho;
    private int x;
    private int y;

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

        if (me.getX() >= 433 && me.getX() <= 642) {
            if (me.getY() >= 338 && me.getY() <= 435) {
                //play button
                System.out.println("Play");
                state = Game.STATE.GAME;
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
                System.out.println("HighScores");
            }
        }
          if (me.getX() >= 992 && me.getX() <= 1067) {
            if (me.getY() >= 599 && me.getY() <= 750) {
                System.out.println("Instructions");
                state = Game.STATE.CONTROLS;
            }
        }
           if (me.getX() >= 52 && me.getX() <= 107) {
            if (me.getY() >= 45 && me.getY() <= 119) {
                state = Game.STATE.MENU;
            }
        }
          
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
