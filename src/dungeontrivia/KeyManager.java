/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyManager Class
 *
 * @author Luis Felipe Alvarez Sanchez A01194173 4 Feb 2019
 */
public class KeyManager implements KeyListener {

    //Flags to move the player
    public boolean down;
    public boolean space;
    public boolean pause;
    public boolean enter;
    public boolean save;
    public boolean load;
    
    //player 1
    public boolean up;
    public boolean left;
    public boolean right;
    //player 2
    public boolean j;
    public boolean k;
    public boolean l;
    //player 3
    public boolean q;
    public boolean w;
    public boolean e;
    //player 4
    public boolean z;
    public boolean x;
    public boolean c;

    private boolean keys[]; // to store all the flags for every key

    /**
     * KeyManager Constructor
     */
    public KeyManager() {
        keys = new boolean[256];
    }
  /**
     * keyPressed method
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        keys[e.getKeyCode()] = true;
    }
    /*
    Set Key Down method
    */
    public void setKeyDown(){
          keys[KeyEvent.VK_P] = false;
    }
    /**
     * KeyReleased method
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        keys[e.getKeyCode()] = false;

    }

    public boolean getPause() {
        return pause;
    }

    /**
     * setPause method
     *
     * @param pause
     */
    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public void keyCheck(int key, boolean checker) {
        keys[key] = checker;
    }

    /**
     * to enable or disable moves on every tick
     */
    public void tick() {
        up = keys[KeyEvent.VK_UP];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        
        j = keys[KeyEvent.VK_J];
        k = keys[KeyEvent.VK_K];
        l = keys[KeyEvent.VK_L];
        
        q = keys[KeyEvent.VK_Q];
        w = keys[KeyEvent.VK_W];
        e = keys[KeyEvent.VK_E];
                
        z = keys[KeyEvent.VK_Z];
        x = keys[KeyEvent.VK_X];
        c = keys[KeyEvent.VK_C];
                
        space = keys[KeyEvent.VK_SPACE];
        pause = keys[KeyEvent.VK_P];
        enter = keys[KeyEvent.VK_ENTER];
        save = keys[KeyEvent.VK_S];
        load = keys[KeyEvent.VK_L];
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
