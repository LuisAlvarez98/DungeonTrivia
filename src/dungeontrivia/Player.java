package dungeontrivia;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Player Class utilizada para crear un jugador
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class Player extends Item {

    // Variables 
    private int direction;
    private int width;
    private int height;
    private Game game;
    private int lives;
    private char move;
    private Animation leftAnim;
    private Animation rightAnim;
    private int counter;
    private boolean showMove;
    private boolean showMark;
    private int playerNum;
    private boolean idle;
    private boolean moving;
    private ArrayList<Heart> hearts;
    private boolean enabled;
    private boolean answer;
    private boolean sec;
    private int counter4 = 0;

    int score;
    private boolean dead;
    private Animation death;

    /**
     * Player Constructor
     *
     * @param x un <code>int</code> con la posicion del jugador en el eje x
     * @param y un <code>int</code> con la posicion del jugador en el eje y
     * @param direction un <code>int</code> con la direccon del jugador
     * @param width un <code>int</code> con la anchura del jugador
     * @param height un <code>int</code> con la altura del jugador
     * @param game un <code>Game</code> con el juego donde esta el jugador
     */
    public Player(int x, int y, int direction, int width, int height, Game game, int lives, int playerNum) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.lives = lives;
        this.playerNum = playerNum;
        setAnimations();
        idle = true;
        moving = false;
        this.rect = new Rectangle(x, y, width, height);
        hearts = new ArrayList<Heart>();
        score = 0;
        showMove = false;
        showMark = false;
        enabled = true;
        move = 'n';
        answer = false;
        dead = false;
    }

    /**
     * Metodo para acceder al puntaje del jugador
     *
     * @return un <code>int</code> con el puntaje
     */
    public int getScore() {
        return score;
    }

    /**
     * Metodo para acceder al arreglo de Heart del jugador
     *
     * @return un <code>ArrayList<Heart></code> con el arreglo de Heart
     */
    public ArrayList<Heart> getHearts() {
        return hearts;
    }

    /**
     * Metodo para acceder a el counter #4
     *
     * @return un <code>int</code> con el counter
     */
    public int getCounter4() {
        return counter4;
    }

    /**
     * Metodo para acceder la opcione que selecciono el jugador
     *
     * @return un <code>char</code> con su opcion seleccionada
     */
    public char getMove() {
        return move;
    }

    /**
     * Metodo para acceder al numero del juegador
     *
     * @return un <code>int</code> con el numero del jugador
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * Metodo para acceder a las vidas del juegador
     *
     * @return un <code>int</code> con las vidas restantes
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Metodo para acceder a la direccion del jugador
     *
     * @return direction un <code>int</code> con la direccion del jugador
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Metodo para acceder a la anchura del jugador
     *
     * @return width un <code>int</code> con la anchura del jugador
     */
    public int getWidth() {
        return width;
    }

    /**
     * Metodo para acceder a la altura del jugador
     *
     * @return height un <code>int</code> con la altura del jugador
     */
    public int getHeight() {
        return height;
    }

    /**
     * Metodo para acceder al flag, checando si puede marcar una respuesta
     *
     * @return un <code>boolean</code>
     */
    public boolean getEnabled() {
        return enabled;
    }

    /**
     * Metodo para acceder al flag del juegador, para saber si ya contesto
     *
     * @return un <code>boolean</code>
     */
    public boolean isAnswer() {
        return answer;
    }

    /**
     * Metodo para acceder al sec del juegador
     *
     * @return un <code>boolean</code>
     */
    public boolean isSec() {
        return sec;
    }

    /**
     * Metodo para modificar el puntaje del juegador
     *
     * @param score un <code>int</code> con el puntaje nuevo
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Metodo para modificar el contador #4
     *
     * @param counter4 un <code>int</code> con el nuevo tiempo
     */
    public void setCounter4(int counter4) {
        this.counter4 = counter4;
    }

    /**
     * Metodo para modificar sec
     *
     * @param sec un <code>boolean</code>
     */
    public void setSec(boolean sec) {
        this.sec = sec;
    }

    /**
     * Metodo para modificar las vidas del juegador
     *
     * @param lives un <code>int</code> con la nueva cantidad de vidas
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Metodo para modificar la opcion seleccionada por el jugador
     *
     * @param move un <code>char</code> con el nuevo movimiento
     */
    public void setMove(char move) {
        this.move = move;
    }

    /**
     * Metodo para modificar el flag de respuesta
     *
     * @param answer un <code>boolean</code>
     */
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    /**
     * Metodo para modificar la direccion del juegador
     *
     * @param direction un <code>int</code> con la nueva direccion
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * Metodo para modificar el flag en relacion a que si se esta moviendo
     *
     * @param moving un <code>boolean</code>
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * Metodo para modificar para marcar a un jugador como muerto
     *
     * @param dead un <code>boolean</code>
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * Metodo para modificar el estado del juegador
     *
     * @param idle un <code>boolean</code>
     */
    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    /**
     * Metodo para modificar el flag, dejando al jugador seleccionar una opcion
     *
     * @param enabled un <code>boolean</code>
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Metodo para modificar la anchura del jugador
     *
     * @param width un <code>int</code> con la nueva anchura
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Metodo para modificar la altura del jugador
     *
     * @param height un <code>int</code> con la nueva altura
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Metodo para modificar el flag para mostrar si no selecciono una opcion
     *
     * @param showMark un <code>boolean</code>
     */
    public void setShowMark(boolean showMark) {
        this.showMark = showMark;
    }

    /**
     * Metodo para cambiar la posicion en el eje x
     *
     * @param x un <code>int</code> con la nueva posicion en el eje x
     */
    public void setX(int x) {
        this.x = x;
        this.rect.setLocation(x, getY());
        for (int i = 0; i < hearts.size(); i++) {
            hearts.get(i).setX(x + 10 + i * 20);
        }
    }

    /**
     * Metodo para cambiar la animacion del jugador
     */
    public void setAnimations() {

        this.death = new Animation(Assets.explosion, 100);
        switch (playerNum) {
            case 1:
                this.leftAnim = new Animation(Assets.p1Left, 100);
                this.rightAnim = new Animation(Assets.p1Right, 100);
                break;
            case 2:
                this.leftAnim = new Animation(Assets.p2Left, 100);
                this.rightAnim = new Animation(Assets.p2Right, 100);
                break;
            case 3:
                this.leftAnim = new Animation(Assets.p3Left, 100);
                this.rightAnim = new Animation(Assets.p3Right, 100);
                break;
            case 4:
                this.leftAnim = new Animation(Assets.p4Left, 100);
                this.rightAnim = new Animation(Assets.p4Right, 100);
                break;
        }
    }

    /**
     * Metodo que reduce las vidas del jugador
     */
    public void decreasePlayerLive() {
        this.lives--;
    }

    /**
     * Metodo para actualizar el jugador
     */
    @Override
    public void tick() {
        // Si se puede responder, checar la respuesta
        if (enabled) {
            switch (playerNum) {
                case 1:
                    if (game.getKeyManager().left) {
                        setMove('l');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().right) {
                        setMove('r');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().up) {
                        setMove('u');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    break;
                case 2:
                    if (game.getKeyManager().j) {
                        setMove('l');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().l) {
                        setMove('r');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().k) {
                        setMove('u');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    break;
                case 3:
                    if (game.getKeyManager().q) {
                        setMove('l');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().e) {
                        setMove('r');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().w) {
                        setMove('u');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    break;
                case 4:
                    if (game.getKeyManager().z) {
                        setMove('l');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().c) {
                        setMove('r');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    if (game.getKeyManager().x) {
                        setMove('u');
                        if (game.isFasePregunta()) {
                            showMove = true;
                        }
                    }
                    break;
            }
        }

        // Cuando se acabe la fase pregunta, dejar de mostrar el signo
        if (!game.isFasePregunta()) {
            showMove = false;
        }

        // Re establecer la posicion
        if (getX() + 200 >= game.getWidth()) {
            setX(game.getWidth() - 200);
        } else if (getX() <= -5) {
            setX(-5);
        }
        //this.playerAnim.tick();
        this.leftAnim.tick();
        this.rightAnim.tick();
        this.death.tick();
    }

    /**
     * Metodo para pintar el jugador en pantalla
     *
     * @param g un <code>Graphics</code> con el graficador
     */
    @Override
    public void render(Graphics g) {
        // En caso de no moverse, pintar al jugador sin movimiento
        if (idle) {
            switch (playerNum) {
                case 1:
                    g.drawImage(Assets.p1Front, getX(), getY(), getWidth(), getHeight(), null);
                    if (showMove) {
                        g.drawImage(Assets.foco, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    if (answer) {
                        g.drawImage(Assets.qmark, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    break;
                case 2:
                    g.drawImage(Assets.p2Front, getX(), getY(), getWidth(), getHeight(), null);
                    if (showMove) {
                        g.drawImage(Assets.foco, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    if (answer) {
                        g.drawImage(Assets.qmark, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    break;

                case 3:
                    g.drawImage(Assets.p3Front, getX(), getY(), getWidth(), getHeight(), null);
                    if (showMove) {
                        g.drawImage(Assets.foco, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    if (answer) {
                        g.drawImage(Assets.qmark, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    break;
                case 4:
                    g.drawImage(Assets.p4Front, getX(), getY(), getWidth(), getHeight(), null);
                    if (showMove) {
                        g.drawImage(Assets.foco, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    if (answer) {
                        g.drawImage(Assets.qmark, getX() + 35, getY() - 20, 16, 16, null);
                    }
                    break;
            }
        }

        // Si el jugador se esta moviendo, animar al jugador
        if (moving) {
            if (getDirection() < 0) {
                g.drawImage(leftAnim.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
            } else {
                g.drawImage(rightAnim.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
            }
        }
        // Mostrar la animacion de muerte, cuando no tenga vidas
        if (dead) {
            g.drawImage(death.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }

    }
}
