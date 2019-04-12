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
    /**
     * loads the assets
     */
    public static void init(){
         bg = ImageLoader.loadImage("/images/bg_doors.png");
    }
    
}
