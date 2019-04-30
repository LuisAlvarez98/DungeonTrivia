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
    private Animation leftAnim;
    private Animation rightAnim;

    private int playerNum;
    private boolean idle;
    private boolean moving;
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
        setAnimations();
        idle = true;
        moving = false;
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
    
    public void setMoving(boolean moving){
        this.moving = moving;
    }
    
    public void setIdle(boolean idle){
        this.idle = idle;
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
    
    public void setAnimations(){
        
        switch(playerNum){
            case 1:
                this.leftAnim = new Animation(Assets.p1Left, 100);
                this.rightAnim = new Animation(Assets.p1Right,100);
            break;
            case 2:
                this.leftAnim = new Animation(Assets.p2Left, 100);
                this.rightAnim = new Animation(Assets.p2Right,100);
            break;
            case 3:
                this.leftAnim = new Animation(Assets.p3Left, 100);
                this.rightAnim = new Animation(Assets.p3Right,100);
            break;
            case 4:
                this.leftAnim = new Animation(Assets.p4Left, 100);
                this.rightAnim = new Animation(Assets.p4Right,100);
            break;
        }
    }
    /**
     * tick method overall movement of the player
     */
    @Override
    public void tick() {
        
        switch(playerNum){
            case 1:
                if (game.getKeyManager().left) {
                    setMove('l');
                }
                if (game.getKeyManager().right) {
                    setMove('r');
                }
                if (game.getKeyManager().up) {
                    setMove('u');
                }
            break;
            case 2:
                if (game.getKeyManager().j) {
                    setMove('l');
                }
                if (game.getKeyManager().k) {
                    setMove('r');
                }
                if (game.getKeyManager().l) {
                    setMove('u');
                }
            break;
            case 3:
                if (game.getKeyManager().q) {
                    setMove('l');
                }
                if (game.getKeyManager().w) {
                    setMove('r');
                }
                if (game.getKeyManager().e) {
                    setMove('u');
                }
            break;
            case 4:
                if (game.getKeyManager().z) {
                    setMove('l');
                }
                if (game.getKeyManager().x) {
                    setMove('r');
                }
                if (game.getKeyManager().c) {
                    setMove('u');
                }
            break;
        }
        

        // reset x position and y position if colision
        if (getX() + 200 >= game.getWidth()) {
            setX(game.getWidth() - 200);
        } else if (getX() <= -5) {
            setX(-5);
        }
        //this.playerAnim.tick();
        this.leftAnim.tick();
        this.rightAnim.tick();
    }

    /**
     * render method
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        //draws the player
        if(idle){
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
        
        if(moving){
            if(getDirection() < 0){
                g.drawImage(leftAnim.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
            }else{
                g.drawImage(rightAnim.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
            }
        }
        
    }
}
