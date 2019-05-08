/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyManager Class utilizada para poder recibir eventos del teclado
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class KeyManager implements KeyListener {

    // Flags para mover jugadores
    public boolean down;
    public boolean space;
    public boolean pause;
    public boolean enter;
    public boolean save;
    public boolean load;
    
    // Player 1
    public boolean up;
    public boolean left;
    public boolean right;
    
    // Player 2
    public boolean j;
    public boolean k;
    public boolean l;
    
    // Player 3
    public boolean q;
    public boolean w;
    public boolean e;
    
    // Player 4
    public boolean z;
    public boolean x;
    public boolean c;

    private boolean keys[]; // Para guardar los flags de cada tecla

    /**
     * KeyManager Constructor
     */
    public KeyManager() {
        keys = new boolean[256];
    }
    
    /**
     * Metodo para marcar una teclada como presionada
     *
     * @param e un <code>KeyEvent</code> con el evento de la tecla
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        keys[e.getKeyCode()] = true;
    }
    
    /**
     * Metodo para marcar una tecla como presionada (actualmente)
     */
    public void setKeyDown(){
          keys[KeyEvent.VK_P] = false;
    }
    /**
     * Metodo para marcar una tecla como soltada
     * @param e 
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        keys[e.getKeyCode()] = false;

    }
    
    /**
     * Metodo para actualizar checker con el estado de la tecla
     * @param key un <code>int</code> con el valor de la tecla
     * @param checker un <code>boolean</code> con el estado de checker
     */
    public void keyCheck(int key, boolean checker) {
        keys[key] = checker;
    }
    
    /**
     * Metodo para acceder el valor de pausa
     * @return un <code>boolean</code> con el estado de pantalla
     */
    public boolean getPause() {
        return pause;
    }

    /**
     * Metodo para modifciar el estado de pausa
     * @param pause un <code>boolean</code> con el nuevo estado de pausa
     */
    public void setPause(boolean pause) {
        this.pause = pause;
    }
    
    /**
     * Para actualizar los valores de las teclas
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

    /**
     * Metodo para checar si una llave fue escrita
     * @param ke un <code>KeyEvent</code>
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
