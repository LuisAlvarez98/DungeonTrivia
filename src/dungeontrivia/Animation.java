/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeontrivia;

import java.awt.image.BufferedImage;

/**
 * Animation class es utilizada para poder generar y cargar una animacion
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class Animation {

    // Variables
    private int speed;              // Para guardar la velocidad
    private int index;              // Para guardar el indice
    private long lastTime;          // Para guardar el ultimo tiempo
    private long timer;             // Para guardar el tiempo actual
    private BufferedImage[] frames; // Para guardar el arreglo de imagenes
    private BufferedImage frame;    // Para guardar una imagen del arreglo

    /**
     * Utilizado para crear una instancia de una animacion
     * 
     * @param frame un <code>BufferedImage</code> con la imagen a cargar
     * @param speed un <code>int</code> con la velocidad de la imagen
     */
    public Animation(BufferedImage frame, int speed) {
        this.frame = frame;
        this.speed = speed;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    /**
     * Utilizado para crear una instancia de una animacion
     *
     * @param frames un <code>BufferedImage</code> con el arreglo de imagenes
     * @param speed un <code>int</code> con la velocidad de la animacion
     */
    public Animation(BufferedImage[] frames, int speed) {
        this.frames = frames;
        this.speed = speed;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    /**
     * Para recibir la imagen que actualmente se esta utilizando
     *
     * @return un <code>BufferedImage</code> con la imagen actual
     */
    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
   
    /**
     * Utilizado para actualizar 
     */
    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (timer > speed) {
            index++;
            timer = 0;

            if (index >= frames.length) {
                index = 0;
            }
        }
    }

}
