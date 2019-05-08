package dungeontrivia;

import java.awt.Button;
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
import javax.swing.JButton;
import javax.swing.JFrame;

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
    public static int width; // the width of the game
    public static int height; //the height of the game
    private Thread thread; //the thread of the game
    private boolean running; //boolean saying if it is running

    private KeyManager keyManager; //key manager
    private MouseInput mouseManager;

    private ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
    private int numeroPreguntas = 0;
    private int firstRandomIndex;
    private int secondRandomIndex;
    private int thirdRandomIndex;

    private String timer = "0:00";
    private int timerStart = 4;
    private int counter = 0;
    private int counter2 = 0;
    private boolean timerOff = false;
    //Players
    public static ArrayList<Player> players = new ArrayList<Player>();

    public static int numPlayers = 4;
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
    private boolean fasePregunta = true;
    private int speed = 7;

    //menu helper
    boolean gameStarted = false;
    private MainMenuPanel menu;
    private InstructionsPanel controls;
    private LevelSelect levelSelect;
    private EndGame endGamelvl;
    private HighscoresPanel highscoresPanel;
    PlayerSelectPanel playerSelect;

    private boolean puertaZero;
    private boolean puertaOne;
    private boolean puertaTwo;
    private boolean endgame;

    public static enum STATE {
        MENU,
        GAME,
        ENDGAME,
        HIGHSCORES,
        CONTROLS,
        LEVELS,
        PLAYERSELECT,
        EXIT
    };
    public static STATE state = STATE.ENDGAME;

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
        mouseManager = new MouseInput();
    }

    /**
     * getHeight method
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
    
    /**
     * getWidth method
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    public boolean isFasePregunta() {
        return fasePregunta;
    }

    /**
     * inits the game with the display and player
     */
    public void init() {
        menu = new MainMenuPanel();
        controls = new InstructionsPanel();
        playerSelect = new PlayerSelectPanel();
        levelSelect = new LevelSelect();
        highscoresPanel = new HighscoresPanel();
        display = new Display(title, getWidth(), getHeight());
        display.getCanvas().addMouseListener(mouseManager);
        Assets.init();
        readTxt();

        Assets.sound.setLooping(true);
        Assets.sound.play();
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

      

        //Player player = new Player(200, 620, 1, 10, 10, this, 1);
        rectanguloUno = new Rectangle(200, 620, 10, 10);
        rectanguloDos = new Rectangle(500, 620, 10, 10);
        rectanguloTres = new Rectangle(900, 620, 10, 10);

        endGamelvl = new EndGame(this);

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

                    preguntas.get(numeroPreguntas).setPregunta(line);
                } else {
                    respuestas.add(line);
                }

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
    
        if (state == STATE.GAME) {
            answer = preguntas.get(counter3).getRespuestas().get(0);
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

            for (int i = 0; i < numPlayers; i++) {
                if (players.get(i).getLives() > 0) {
                    players.get(i).tick();

                }
            }

            if (counter < 50) {
                counter++;
            } else {
                if (timerStart != 0) {
                    timerStart--;
                    updateTimer(timerStart);
                } else {

                    if (fasePregunta) {

                        for (int i = 0; i < numPlayers; i++) {

                            switch (players.get(i).getMove()) {
                                case 'l':

                                    rectangulo = getRectangulo('l');
                                    if (rectangulo.getX() - players.get(i).getX() > 0) {
                                        players.get(i).setDirection(1);
                                    } else {
                                        players.get(i).setDirection(-1);
                                    }
                                    if (!posZero.equals(answer)) {
                                        players.get(i).decreasePlayerLive();
                                        if (players.get(i).getLives() == 0) {
                                            Assets.deathSound.play();
                                        }
                                    } else {
                                        //sets score
                                        if (players.get(i).getLives() > 0) {
                                            int score = players.get(i).getScore() + 10;
                                            players.get(i).setScore(score);
                                        }
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
                                        players.get(i).decreasePlayerLive();
                                        if (players.get(i).getLives() == 0) {
                                            Assets.deathSound.play();
                                        }
                                    } else {
                                        //sets score
                                        if (players.get(i).getLives() > 0) {
                                            int score = players.get(i).getScore() + 10;
                                            players.get(i).setScore(score);
                                        }
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
                                        players.get(i).decreasePlayerLive();
                                        if (players.get(i).getLives() == 0) {
                                            Assets.deathSound.play();
                                        }
                                    } else {
                                        //sets score
                                        if (players.get(i).getLives() > 0) {
                                            int score = players.get(i).getScore() + 10;
                                            players.get(i).setScore(score);
                                        }
                                    }
                                    break;
                                default:
                                    players.get(i).decreasePlayerLive();
                                    if (players.get(i).getLives() == 0) {
                                        Assets.deathSound.play();
                                    }
                                    players.get(i).setAnswer(true);
                                    break;
                            }

                        }

                        fasePregunta = false;
                        faseMovimiento = true;
                    }

                }
                counter = 0;

            }

            if (faseMovimiento) {

                if (posZero.equals(answer)) {
                    puertaZero = true;
                } else {
                    puertaZero = false;
                }

                if (posOne.equals(answer)) {
                    puertaOne = true;
                } else {
                    puertaOne = false;
                }

                if (posTwo.equals(answer)) {
                    puertaTwo = true;
                } else {
                    puertaTwo = false;
                }

                check = true;
                for (int i = 0; i < players.size(); i++) {

                    //deshabilitar teclado
                    players.get(i).setEnabled(false);

                    if (!getRectangulo(players.get(i).getMove()).intersects(players.get(i).getRect()) && !players.get(i).isAnswer()) {
                        players.get(i).setMoving(true);
                        players.get(i).setIdle(false);
                        players.get(i).setX(players.get(i).getX() + players.get(i).getDirection() * speed);
                    } else {
                        players.get(i).setMoving(false);
                        players.get(i).setIdle(true);
                    }

                    if (!players.get(i).isAnswer()) {
                        check &= getRectangulo(players.get(i).getMove()).intersects(players.get(i).getRect());
                    }

                }

                if (check) {
                    System.out.println("Hola");
                    Assets.openDoor.setLooping(false);
                    Assets.openDoor.play();
                    faseMovimiento = false;
                    finalDePregunta = true;
                    for (int i = 0; i < players.size(); i++) {

                        if (!getRectangulo(players.get(i).getMove()).intersects(players.get(i).getRect()) && !players.get(i).isAnswer()) {
                            players.get(i).setMoving(true);
                            players.get(i).setIdle(false);
                            players.get(i).setX(players.get(i).getX() + players.get(i).getDirection() * speed);
                        } else {
                            players.get(i).setMoving(false);
                            players.get(i).setIdle(true);
                        }

                    }
                }

            }

            if (finalDePregunta) {

                if (counter2 < 250) {
                    counter2++;
                } else {

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
                        //fin de preguntas
                        counter3 = 0;
                    }
                    counter2 = 0;
                    for (int i = 0; i < players.size(); i++) {
                        players.get(i).setEnabled(true);
                        players.get(i).setAnswer(false);
                        players.get(i).setMove('n');
                        players.get(i).setX(200 + 200 * i);
                    }

                    finalDePregunta = false;
                    fasePregunta = true;
                    Assets.closeDoor.play();

                    endgame = false;
                    for (int i = 0; i < players.size(); i++) {
                        endgame |= (players.get(i).getLives() > 0);
                    }

                    if (!endgame) {
                        state = Game.STATE.ENDGAME;
                    }
                }
            }

        } else if (state == STATE.EXIT) {
            System.exit(0);
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
            //if game has started load all stuff
            if (state == STATE.GAME) {
                g.drawImage(Assets.bg, 0, 0, width, height, null);
                Font myFont = new Font("Courier New", 1, 22);
                g.setFont(myFont);
                g.setColor(Color.WHITE);
                g.drawString(timer, 950, 100);
                g.drawImage(Assets.reloj, 1010, 75, 20, 30, null);
                if (finalDePregunta) {

                    if (puertaZero) {
                        g.drawImage(Assets.puertaBien, 40, 445, 200, 280, null);
                    } else {
                        g.drawImage(Assets.puertaMal, 40, 445, 200, 280, null);
                    }
                    if (puertaOne) {
                        g.drawImage(Assets.puertaBien, 440, 445, 200, 280, null);
                    } else {
                        g.drawImage(Assets.puertaMal, 440, 445, 200, 280, null);
                    }
                    if (puertaTwo) {
                        g.drawImage(Assets.puertaBien, 840, 445, 200, 280, null);
                    } else {
                        g.drawImage(Assets.puertaMal, 840, 445, 200, 280, null);
                    }

                } else {
                    g.drawImage(Assets.puertaCerrada, 40, 445, 200, 280, null);
                    g.drawImage(Assets.puertaCerrada, 440, 445, 200, 280, null);
                    g.drawImage(Assets.puertaCerrada, 840, 445, 200, 280, null);
                }

                //render stuff
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getLives() > 0) {
                        players.get(i).render(g);
                    }
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
                //Draw score
                g.drawString("Scores", 10, 10);
                for (int i = 0; i < players.size(); i++) {
                    g.drawString("Player " + (i + 1) + ":" + Integer.toString(players.get(i).getScore()), 10, (i * 5) * 3 + 25);
                }

                myFont = new Font("Courier New", 1, 14);
                g.setFont(myFont);
                g.setColor(Color.BLACK);

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
            } else if (state == state.CONTROLS) {
                g.drawImage(Assets.controls, 0, 0, width, height, null);
                controls.render(g, getWidth(), getHeight());
            } else if (state == state.HIGHSCORES) {
                g.drawImage(Assets.bg_hs, 0, 0, width, height, null);
                highscoresPanel.render(g, getWidth(), getHeight());
                //Player select
            }else if (state == state.LEVELS) {
                g.drawImage(Assets.level_select, 0, 0, width, height, null);
                levelSelect.render(g, getWidth(), getHeight());
            } else if (state == state.ENDGAME) {
                g.drawImage(Assets.bg1, 0, 0, width, height, null);
                endGamelvl.render(g, getWidth(), getHeight());
                //Player select
            } else if (state == state.PLAYERSELECT) {
                g.drawImage(Assets.bg1, 0, 0, width, height, null);
                playerSelect.render(g, getWidth(), getHeight());
            } else {
                g.drawImage(Assets.menu, 0, 0, width, height, null);
                menu.render(g, getWidth(), getHeight());
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
