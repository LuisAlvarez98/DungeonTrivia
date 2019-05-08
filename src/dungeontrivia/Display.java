package dungeontrivia;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Display Class es una clase para crear y mostrar la pantalla del juego
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class Display {
    private JFrame jframe;
    private Canvas canvas;
    private String title;
    private int width;
    private int height;
    /**
     * Display Constructor utilizado para instanciar la clase
     * @param title un <code>String</code> que contiene el titulo de la pantalla
     * @param width un <code>int</code> que contiene el ancho de la pantalla
     * @param height un <code>int</code> que contiene la altura de la pantalla
     */
    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    /**
     * Metodo para accesar el JFrame del Display
     * @return jframe un <code>JFrame</code> con el JFrame
     */
    public JFrame getJframe() {
        return jframe;
    }
    /**
     * Metodo para acceder al canvas de la pantalla
     * @return canvas un <code>Canvas</code> con el Canvas
     */
    public Canvas getCanvas(){
        return canvas;
    }
    
    /**
     * Metodo para modificar el JFrame del Display
     * @param jframe un <code>JFrame</code> con el JFrame
     */
    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }
    
    /**
     * Metodo para crear la pantalla
     */
    public void createDisplay(){
        jframe = new JFrame(title);
        jframe.setSize(width, height);
        jframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        
        jframe.add(canvas);
        jframe.pack();
    }
    
}
