package dungeontrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/**
 * Dungeon Trivia
 *
 * @author Luis Felipe Alvarez Sanchez
 */
public class Menu implements Runnable {

    private BufferStrategy bs; // BufferStrategy var
    private Graphics g; // for the graphics
    private Display display; // for the display of the game
    String title; // the title of the game
    private int width; // the width of the game
    private int height; //the height of the game
    private Thread thread; //the thread of the game
    private boolean running; //boolean saying if it is running

    private KeyManager keyManager; //key manager

    /**
     * Game Constructor
     *
     * @param title
     * @param width
     * @param height
     */
    public Menu(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
    }

    /**
     * getHeight method
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * getWidth method
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * inits the game with the display and player
     */
    public void init() {
        display = new Display(title, getWidth(), getHeight());
        display.getJframe().addKeyListener(keyManager);
    }

    /**
     * run method
     */
    @Override
    public void run() {
        init();
        int fps = 50;
        double timeTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timeTick;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    /**
     * getKeyManager method
     *
     * @return keyManager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    /**
     * tick method
     */
    private void tick() {
        //tick
    }

    /**
     * render method where all the magic happens
     */
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            JButton b = new JButton("Click Here");
            b.setBounds(50, 100, 95, 30);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //StartGame
                    
                }
            });
            display.getJframe().add(b);
            g = bs.getDrawGraphics();
            g.drawImage(Assets.bg, 0, 0, width, height, null);
            bs.show();
            g.dispose();
        }
    }

    /**
     * start method
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stop method
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
