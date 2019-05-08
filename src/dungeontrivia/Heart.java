package dungeontrivia;

import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Heart class utilizado para poder instanciar las vidas de los jugadores
 * en pantalla
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class Heart extends Item{
    // Variables
    private int width;
    private int height;
    /**
     * Constructor del Heart
     * @param x un <code>int</code> con la posicion en el eje x
     * @param y un <code>int</code> con la posicion en el eje y
     * @param width un <code>int</code> con la anchura
     * @param height un <code>int</code> con la altura
     */
    public Heart(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.rect = new Rectangle(x,y, width, height);
    }
    
    /**
     * Metodo para acceder a la altura
     * @return height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Metodo para acceder a la anchura
     * @return width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Metodo para modificar a la altura
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Metodo para modificar la anchura
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
      * Metodo para actualizar
     */
    @Override
    public void tick() {  
        
    }
    
    /**
     * Metodo para pintar
     * @param g un <code>Graphics</code> con el graficador
     */
    @Override
    public void render(Graphics g) {
         g.drawImage(Assets.heart,getX(), getY(), getWidth(), getHeight(), null);
    }
}
