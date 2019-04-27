package dungeontrivia;

import java.awt.image.BufferedImage;

/**
 * Assets Class
 * @author Luis Felipe Alvarez Sanchez
 * 4 Feb 2019
 */
public class Assets {
    public static SoundClip sound;
    public static BufferedImage bg;
    public static BufferedImage player;
    /**
     * loads the assets
     */
    public static void init(){
         bg = ImageLoader.loadImage("/images/bg_scroll.png");
         player = ImageLoader.loadImage("/images/Jugador.png");
         sound = new SoundClip("/sounds/soundtrack.wav");
    }
    
}
