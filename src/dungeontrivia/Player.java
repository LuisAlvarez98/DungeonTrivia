package dungeontrivia;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Player Class
 *
 * @author Luis Felipe Alvarez Sanchez A01194173 12 Feb 2019
 */
public class Player extends Item {

    //Instance variables
    private int direction;
    private int width;
    private int height;
    private Game game;
    private int lives;
    private char move;
    private Animation playerAnim;

    private int playerNum;

    /**
     * Player constructor
     *
     * @param x
     * @param y
     * @param direction
     * @param width
     * @param height
     * @param game
     * @param bullet
     */
    public Player(int x, int y, int direction, int width, int height, Game game, int lives, int playerNum) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.lives = lives;
        this.playerNum = playerNum;
        this.playerAnim = new Animation(Assets.p1Left,100);
        this.rect = new Rectangle(x,y, width, height);
    }

    /**
     * decreases the player lives by one
     */
    public void decreasePlayerLive() {
        this.lives--;
    }

    /**
     * setLives method
     *
     * @param lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setMove(char move) {
        this.move = move;
    }

    public char getMove() {
        return move;
    }

    /**
     * getLives method
     *
     * @return lives
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * getDirection method
     *
     * @return direction
     */
    public int getDirection() {
        return direction;
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
     * getHeight method
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * setDirection method
     *
     * @param direction
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * setWidth method
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * setHeight method
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * tick method overall movement of the player
     */
    @Override
    public void tick() {
        if (game.getKeyManager().left) {
            //System.out.println("left");
            
            setMove('l');
        }
        // vertical left down
        if (game.getKeyManager().right) {
            //System.out.println("righ");
            setMove('r');
        }
        if (game.getKeyManager().up) {
            //System.out.println("up");
            setMove('u');
        }

        // reset x position and y position if colision
        if (getX() + 200 >= game.getWidth()) {
            setX(game.getWidth() - 200);
        } else if (getX() <= -5) {
            setX(-5);
        }
        this.playerAnim.tick();
    }

    /**
     * render method
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        //draws the player
        switch (playerNum) {
            case 1:
                g.drawImage(Assets.p1Front, getX(), getY(), getWidth(), getHeight(), null);

                break;
            case 2:
                g.drawImage(Assets.p2Front, getX(), getY(), getWidth(), getHeight(), null);

                break;

            case 3:
                g.drawImage(Assets.p3Front, getX(), getY(), getWidth(), getHeight(), null);

                break;
            case 4:
                g.drawImage(Assets.p4Front, getX(), getY(), getWidth(), getHeight(), null);

                break;
        }
    }
}
