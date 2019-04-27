package dungeontrivia;

import java.awt.image.BufferedImage;

/**
 * Assets Class
 *
 * @author Luis Felipe Alvarez Sanchez 4 Feb 2019
 */
public class Assets {

    public static SoundClip sound;
    public static BufferedImage bg;
    public static BufferedImage player, sprites;

    //Player 1
    public static BufferedImage p1Sprites[];
    public static BufferedImage p1Front;
    public static BufferedImage p1Back;
    public static BufferedImage p1Right[];
    public static BufferedImage p1Left[];

    /**
     * loads the assets
     */
    public static void init() {
        bg = ImageLoader.loadImage("/images/bg_end.jpg");
        sound = new SoundClip("/sounds/soundtrack.wav");

        sprites = ImageLoader.loadImage("/images/players.png");
        SpreadSheet spritesheet = new SpreadSheet(sprites);

        p1Right = new BufferedImage[3];
        p1Left = new BufferedImage[3];

        p1Front = spritesheet.crop(50, 0, 50, 72);
        p1Back = spritesheet.crop(50, 216, 50, 72);

        for (int i = 0; i < 3; i++) {
            p1Right[i] = spritesheet.crop(i * 50, 144, 51, 72);
            p1Left[i] = spritesheet.crop(i * 50, 72, 51, 72);
        }

    }

}
