package dungeontrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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

/**
 * Dungeon Trivia
 *
 * @author Luis Felipe Alvarez Sanchez
 */
public class Game implements Runnable {

    private BufferStrategy bs; // BufferStrategy var
    private Graphics g; // for the graphics
    private Display display; // for the display of the game
    String title; // the title of the game
    private int width; // the width of the game
    private int height; //the height of the game
    private Thread thread; //the thread of the game
    private boolean running; //boolean saying if it is running

    private KeyManager keyManager; //key manager

    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private int numeroPreguntas = 0;

    private int firstRandomIndex;
    private int secondRandomIndex;
    private int thirdRandomIndex;

    private String timer = "0:00";
    private int timerStart = 20;
    private int counter = 0;
    private boolean timerOff = false; 

    //  private ArrayList<Player> players = new ArrayList<Player>();
    private Player player;

    /**
     * Game Constructor
     *
     * @param title
     * @param width
     * @param height
     */
    public Game(String title, int width, int height) {
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
        Assets.init();
        Assets.sound.setLooping(true);
        Assets.sound.play();
        readTxt();

        firstRandomIndex = (int) (Math.random() * 3);
        secondRandomIndex = (int) (Math.random() * 2);
        if (firstRandomIndex == 0 && secondRandomIndex == 0) {
            secondRandomIndex = 1;
        } else if (firstRandomIndex == 1 && secondRandomIndex == 1) {
            secondRandomIndex = 2;
        }
        thirdRandomIndex = 3 - (firstRandomIndex + secondRandomIndex);
        //Create objectcs
        player = new Player(getWidth() / 2 - 90, 620, 1, 100, 120, this, 1);

        display.getJframe().addKeyListener(keyManager);
    }

    /**
     * Load questions now work!
     */
    public void readTxt() {

        // The name of the file to open.
        String fileName = "questions.txt";
        ArrayList<String> respuestas = new ArrayList<String>();
        Pregunta pregunta = new Pregunta();
        preguntas.add(pregunta);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    fileName));
            String line = reader.readLine();
            int counter = 0;
            while (line != null) {
                if (counter == 0) {
                    System.out.println("Pregunta");
                    preguntas.get(numeroPreguntas).setPregunta(line);
                } else {
                    respuestas.add(line);
                    System.out.println("respuesta");
                }
                //System.out.println(line);
                // read next line
                counter++;
                line = reader.readLine();
                if (counter > 3) {

                    preguntas.get(numeroPreguntas).setRespuestas(respuestas);
                    respuestas = new ArrayList<String>();
                    numeroPreguntas++;
                    Pregunta p = new Pregunta();
                    preguntas.add(p);
                    counter = 0;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    private void updateTimer(int time) {

        if (time < 10) {
            timer = "0:0" + time;
        } else {
            timer = "0:" + time;
        }
    }

    /**
     * tick method
     */
    private void tick() {
        //tick
        keyManager.tick();
        if(!timerOff){
            player.tick();
        }
        if (counter < 50) {
            counter++;
        } else {
            if (timerStart != 0) {
                timerStart--;
                updateTimer(timerStart);
            } else {
                timerOff = true;
                switch(player.getMove()){
                    case 'l':
                        System.out.println("l");
                        break;
                    case 'r':
                         System.out.println("r");
                        break;
                    case 'u':
                         System.out.println("u");
                        break;
                }
            }
            counter = 0;
        }

    }

    /**
     * render method where all the magic happens
     */
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.bg, 0, 0, width, height, null);
            Font myFont = new Font("Courier New", 1, 22);

            g.setFont(myFont);
            g.setColor(Color.WHITE);
            g.drawString(timer, 950, 100);
            //render stuff
            player.render(g);
            
            g.drawString(preguntas.get(0).getPregunta(), getWidth() / 2 - 250, 100);
            g.drawString(preguntas.get(0).getRespuestas().get(firstRandomIndex), getWidth() / 2 - 350, 250);
            g.drawString(preguntas.get(0).getRespuestas().get(secondRandomIndex), getWidth() / 2 - 60, 250);
            g.drawString(preguntas.get(0).getRespuestas().get(thirdRandomIndex), getWidth() / 2 + 230, 250);

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
