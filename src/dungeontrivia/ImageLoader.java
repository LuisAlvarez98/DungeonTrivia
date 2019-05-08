package dungeontrivia;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * ImageLoader Class es utilizada para cargar imagenes
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class ImageLoader {
    /**
     * ImageLoader Constructor
     * @param path un <code>String</code> con la direccion de la imagen
     * @return bufferedImage
     */
  public static BufferedImage loadImage(String path) {
    BufferedImage bi = null;
    try {
        bi = ImageIO.read(ImageLoader.class.getResource(path));
    } catch (IOException ioe) {
        System.out.println("Error loading image " + path + ioe.toString());
        System.exit(1);
    }
        return bi;
    }
    
}
