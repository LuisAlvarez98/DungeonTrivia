package dungeontrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
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
    private int timerStart = 10;
    private int counter = 0;
    private int counter2 = 0;
    private boolean timerOff = false;
    //Players
    private ArrayList<Player> players = new ArrayList<Player>();

    private int numPlayers = 4;
    //EndPlayers
    private String answer;
    private String posZero;
    private String posOne;
    private String posTwo;
    private String resultado = "";
    private boolean finalDePregunta;
    private int counter3 = 0;

    private int direction;
    private Rectangle rectanguloUno;
    private Rectangle rectanguloDos;
    private Rectangle rectanguloTres;
    private Rectangle rectangulo;

    private Player player;
    private boolean check;
    private boolean faseMovimiento;
    private int speed = 7;

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
        finalDePregunta = false;
        faseMovimiento = false;
        firstRandomIndex = (int) (Math.random() * 3);
        secondRandomIndex = (int) (Math.random() * 2);
        if (firstRandomIndex == 0 && secondRandomIndex == 0) {
            secondRandomIndex = 1;
        } else if (firstRandomIndex == 1 && secondRandomIndex == 1) {
            secondRandomIndex = 2;
        }
        thirdRandomIndex = 3 - (firstRandomIndex + secondRandomIndex);

        //Create objectcs
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player(200 + 200 * i, 620, 1, 100, 120, this, 3, i + 1);
            player.getHearts().add(new Heart(player.getX() + 10, player.getY(), 20, 20));
            player.getHearts().add(new Heart(player.getX() + 30, player.getY(), 20, 20));
            player.getHearts().add(new Heart(player.getX() + 50, player.getY(), 20, 20));
            players.add(player);
        }

        //Player player = new Player(200, 620, 1, 10, 10, this, 1);
        rectanguloUno = new Rectangle(200, 620, 10, 10);
        rectanguloDos = new Rectangle(500, 620, 10, 10);
        rectanguloTres = new Rectangle(900, 620, 10, 10);

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
                    //System.out.println("Pregunta");
                    preguntas.get(numeroPreguntas).setPregunta(line);
                } else {
                    respuestas.add(line);
                    //System.out.println("respuesta");
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

        answer = preguntas.get(counter3).getRespuestas().get(0);
        //System.out.println(answer);
        if (firstRandomIndex == 0 && secondRandomIndex == 1) {
            posZero = preguntas.get(counter3).getRespuestas().get(0);
            posOne = preguntas.get(counter3).getRespuestas().get(1);
            posTwo = preguntas.get(counter3).getRespuestas().get(2);
        } else if (firstRandomIndex == 0 && secondRandomIndex == 2) {
            posZero = preguntas.get(counter3).getRespuestas().get(0);
            posOne = preguntas.get(counter3).getRespuestas().get(2);
            posTwo = preguntas.get(counter3).getRespuestas().get(1);
        } else if (firstRandomIndex == 1 && secondRandomIndex == 0) {
            posZero = preguntas.get(counter3).getRespuestas().get(1);
            posOne = preguntas.get(counter3).getRespuestas().get(0);
            posTwo = preguntas.get(counter3).getRespuestas().get(2);
        } else if (firstRandomIndex == 1 && secondRandomIndex == 2) {
            posZero = preguntas.get(counter3).getRespuestas().get(1);
            posOne = preguntas.get(counter3).getRespuestas().get(2);
            posTwo = preguntas.get(counter3).getRespuestas().get(0);
        } else if (firstRandomIndex == 2 && secondRandomIndex == 0) {
            posZero = preguntas.get(counter3).getRespuestas().get(2);
            posOne = preguntas.get(counter3).getRespuestas().get(0);
            posTwo = preguntas.get(counter3).getRespuestas().get(1);
        } else {
            posZero = preguntas.get(counter3).getRespuestas().get(2);
            posOne = preguntas.get(counter3).getRespuestas().get(1);
            posTwo = preguntas.get(counter3).getRespuestas().get(0);
        }

        keyManager.tick();
        //if(!timerOff){
        for (int i = 0; i < players.size(); i++) {
            players.get(i).tick();
        }
        if (counter < 50) {
            counter++;
        } else {
            if (timerStart != 0) {
                timerStart--;
                updateTimer(timerStart);
            } else {

                for (int i = 0; i < players.size(); i++) {
                    switch (players.get(i).getMove()) {
                        case 'l':
                            System.out.println("hola");
                            rectangulo = getRectangulo('l');
                            System.out.println(rectangulo);
                            if (rectangulo.getX() - players.get(i).getX() > 0) {
                                players.get(i).setDirection(1);
                            } else {
                                players.get(i).setDirection(-1);
                            }
                            if (!posZero.equals(answer)) {
                                System.out.println("meco");
                                players.get(i).decreasePlayerLive();
                            }
                            break;
                        case 'u':
                            rectangulo = getRectangulo('u');
                            if (rectangulo.getX() - players.get(i).getX() > 0) {
                                players.get(i).setDirection(1);
                            } else {
                                players.get(i).setDirection(-1);
                            }
                            if (!posOne.equals(answer)) {
                                System.out.println("meco");
                                players.get(i).decreasePlayerLive();
                            }
                            break;
                        case 'r':
                            rectangulo = getRectangulo('r');
                            if (rectangulo.getX() - players.get(i).getX() > 0) {
                                players.get(i).setDirection(1);
                            } else {
                                players.get(i).setDirection(-1);
                            }
                            if (!posTwo.equals(answer)) {
                                System.out.println("meco");
                                players.get(i).decreasePlayerLive();
                            }
                            break;
                    }
                    System.out.println(players.get(i).getRect());

                }
                faseMovimiento = true;

            }
            counter = 0;
        }

        if (faseMovimiento) {
            check = true;
            for (int i = 0; i < players.size(); i++) {
                if (!getRectangulo(players.get(i).getMove()).intersects(players.get(i).getRect())) {
                    players.get(i).setMoving(true);
                    players.get(i).setIdle(false);
                    players.get(i).setX(players.get(i).getX() + players.get(i).getDirection() * speed);
                } else {
                    players.get(i).setMoving(false);
                    players.get(i).setIdle(true);
                }

                check &= getRectangulo(players.get(i).getMove()).intersects(players.get(i).getRect());

            }

            if (check) {
                faseMovimiento = false;
                finalDePregunta = true;
            }

        }

        if (finalDePregunta) {

            if (counter2 < 250) {
                counter2++;
            } else {
                finalDePregunta = false;
                timerStart = 10;
                updateTimer(timerStart);
                firstRandomIndex = (int) (Math.random() * 3);
                secondRandomIndex = (int) (Math.random() * 2);
                if (firstRandomIndex == 0 && secondRandomIndex == 0) {
                    secondRandomIndex = 1;
                } else if (firstRandomIndex == 1 && secondRandomIndex == 1) {
                    secondRandomIndex = 2;
                }
                thirdRandomIndex = 3 - (firstRandomIndex + secondRandomIndex);
                //obtener siguiente pregunta
                if (counter3 < numeroPreguntas - 1) {
                    counter3++;
                } else {
                    //fin de juego
                    counter3 = 0;
                }
                counter2 = 0;
            }
        }

    }

    public Rectangle getRectangulo(char c) {
        if (c == 'l') {
            return rectanguloUno;
        } else if (c == 'u') {
            return rectanguloDos;
        } else {
            return rectanguloTres;
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
            for (int i = 0; i < players.size(); i++) {
                players.get(i).render(g);
                for (int j = 0; j < players.get(i).getLives(); j++) {
                    Heart heart = players.get(i).getHearts().get(j);
                    heart.render(g);
                }
            }
            //lives

            //player.render(g);
            myFont = new Font("Courier New", 1, 14);
            g.setFont(myFont);
            g.setColor(Color.WHITE);

            g.drawString(preguntas.get(counter3).getPregunta(), getWidth() / 2 - 250, 100);
            g.drawString(posZero, getWidth() / 2 - 455, 350);
            g.drawString(posOne, getWidth() / 2 - 60, 350);
            g.drawString(posTwo, getWidth() / 2 + 320, 350);

            if (finalDePregunta) {
                if (resultado == "Correcto") {
                    g.setColor(Color.green);
                } else {
                    g.setColor(Color.red);
                }
                g.drawString(resultado, 200, 200);
            }
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
