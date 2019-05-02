package dungeontrivia;

import java.awt.image.BufferedImage;

/**
 * Assets Class
 *
 * @author Luis Felipe Alvarez Sanchez 4 Feb 2019
 */
public class Assets {

    public static SoundClip sound;
    public static BufferedImage bg, heart, menu, controls, reloj, puertaCerrada, puertaMal, puertaBien;
    public static BufferedImage player, sprites;
    public static BufferedImage foco;
    public static BufferedImage qmark;

    //Player 1
    public static BufferedImage p1Front;
    public static BufferedImage p1Back;
    public static BufferedImage p1Right[];
    public static BufferedImage p1Left[];

    //Player 2
    public static BufferedImage p2Front;
    public static BufferedImage p2Back;
    public static BufferedImage p2Right[];
    public static BufferedImage p2Left[];

    //Player 3
    public static BufferedImage p3Front;
    public static BufferedImage p3Back;
    public static BufferedImage p3Right[];
    public static BufferedImage p3Left[];

    //Player 4
    public static BufferedImage p4Front;
    public static BufferedImage p4Back;
    public static BufferedImage p4Right[];
    public static BufferedImage p4Left[];

    /**
     * loads the assets
     */
    public static void init() {
        bg = ImageLoader.loadImage("/images/bg_end.jpg");
        menu = ImageLoader.loadImage("/images/menu_bg.png");
        sound = new SoundClip("/sounds/soundtrack.wav");
        heart = ImageLoader.loadImage("/images/heart.png");
        sprites = ImageLoader.loadImage("/images/players.png");
        controls = ImageLoader.loadImage("/images/controls.png");
        foco = ImageLoader.loadImage("/images/foco.png");
        reloj = ImageLoader.loadImage("/images/Reloj.png");
        puertaCerrada = ImageLoader.loadImage("/images/Puerta Cerrada.png");
        puertaMal = ImageLoader.loadImage("/images/Puerta mal 1.png");
        puertaBien = ImageLoader.loadImage("/images/Puerta Bien.png");
        qmark = ImageLoader.loadImage("/images/qmark.png");
        
        SpreadSheet spritesheet = new SpreadSheet(sprites);

        //player 1
        p1Front = spritesheet.crop(50, 0, 50, 71);
        p1Back = spritesheet.crop(50, 216, 50, 71);
        p1Right = new BufferedImage[3];
        p1Left = new BufferedImage[3];

        //player 2
        p2Front = spritesheet.crop(50, 284, 50, 71);
        p2Back = spritesheet.crop(50, 502, 50, 71);
        p2Right = new BufferedImage[3];
        p2Left = new BufferedImage[3];

        //player 3
        p3Front = spritesheet.crop(350, 284, 50, 71);
        p3Back = spritesheet.crop(350, 502, 50, 71);
        p3Right = new BufferedImage[3];
        p3Left = new BufferedImage[3];

        //player 4
        p4Front = spritesheet.crop(505, 290, 50, 71);
        p4Back = spritesheet.crop(505, 502, 50, 71);
        p4Right = new BufferedImage[3];
        p4Left = new BufferedImage[3];

        for (int i = 0; i < 3; i++) {
            p1Right[i] = spritesheet.crop(i * 50, 144, 51, 71);
            p1Left[i] = spritesheet.crop(i * 50, 71, 51, 71);

            p2Right[i] = spritesheet.crop(i * 50, 428, 51, 71);
            p2Left[i] = spritesheet.crop(i * 50, 358, 51, 71);

            p3Right[i] = spritesheet.crop(300 + (i * 50), 428, 51, 71);
            p3Left[i] = spritesheet.crop(300 + (i * 50), 358, 51, 71);

            p4Right[i] = spritesheet.crop(455 + (i * 50), 428, 51, 71);
            p4Left[i] = spritesheet.crop(455 + (i * 50), 358, 51, 71);

        }

    }

}
