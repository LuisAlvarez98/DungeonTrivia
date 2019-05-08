package dungeontrivia;

import java.awt.image.BufferedImage;

/**
 * Assets Class es una clase para instanciar las imagenes y sonidos
 *
 * @author Luis, Adrian, Antonio and Rodrigo
 */
public class Assets {

    // Assets generales
    public static SoundClip sound;
    public static SoundClip deathSound;
    public static SoundClip openDoor;
    public static SoundClip closeDoor;
    public static BufferedImage bg, bg1, heart, menu, controls, reloj, puertaCerrada, puertaMal, puertaBien, level_select;
    public static BufferedImage player, sprites;
    public static BufferedImage foco;
    public static BufferedImage qmark;
    public static BufferedImage pause_bg;
    public static BufferedImage back;
    public static BufferedImage P1;
    public static BufferedImage P2;
    public static BufferedImage P3;
    public static BufferedImage P4;
    public static BufferedImage bg_hs;

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

    public static BufferedImage explosion[];

    /**
     * Cargar el asset
     */
    public static void init() {
        pause_bg = ImageLoader.loadImage("/images/paused.png");
        bg_hs = ImageLoader.loadImage("/images/bghs.png");
        back = ImageLoader.loadImage("/images/back.png");
        bg = ImageLoader.loadImage("/images/bg_end.jpg");
        bg1 = ImageLoader.loadImage("/images/bg.png");
        level_select = ImageLoader.loadImage("/images/level_select.PNG");
        menu = ImageLoader.loadImage("/images/menu_bg.png");
        sound = new SoundClip("/sounds/soundtrack.wav");
        deathSound = new SoundClip("/sounds/DeathSound.wav");
        openDoor = new SoundClip("/sounds/openDoor.wav");
        closeDoor = new SoundClip("/sounds/closeDoor.wav");
        heart = ImageLoader.loadImage("/images/heart.png");
        sprites = ImageLoader.loadImage("/images/players.png");
        controls = ImageLoader.loadImage("/images/controls.PNG");
        foco = ImageLoader.loadImage("/images/foco.png");
        reloj = ImageLoader.loadImage("/images/Reloj.png");
        puertaCerrada = ImageLoader.loadImage("/images/puertacerrada.png");
        puertaMal = ImageLoader.loadImage("/images/puertamal.png");
        puertaBien = ImageLoader.loadImage("/images/puertabien.png");
        qmark = ImageLoader.loadImage("/images/qmark.png");

        P1 = ImageLoader.loadImage("/images/1P.png");
        P2 = ImageLoader.loadImage("/images/P2.png");
        P3 = ImageLoader.loadImage("/images/3P.png");
        P4 = ImageLoader.loadImage("/images/4P.png");

        SpreadSheet spritesheet = new SpreadSheet(sprites);
        SpreadSheet spritesheet2 = new SpreadSheet(ImageLoader.loadImage("/images/explosion.png"));

        // Player 1
        p1Front = spritesheet.crop(50, 0, 50, 71);
        p1Back = spritesheet.crop(50, 216, 50, 71);
        p1Right = new BufferedImage[3];
        p1Left = new BufferedImage[3];

        // Player 2
        p2Front = spritesheet.crop(50, 284, 50, 71);
        p2Back = spritesheet.crop(50, 502, 50, 71);
        p2Right = new BufferedImage[3];
        p2Left = new BufferedImage[3];

        // Player 3
        p3Front = spritesheet.crop(350, 284, 50, 71);
        p3Back = spritesheet.crop(350, 502, 50, 71);
        p3Right = new BufferedImage[3];
        p3Left = new BufferedImage[3];

        // Player 4
        p4Front = spritesheet.crop(505, 290, 50, 71);
        p4Back = spritesheet.crop(505, 502, 50, 71);
        p4Right = new BufferedImage[3];
        p4Left = new BufferedImage[3];

        // Cargar los sprite sheets a un arreglo de imagenes
        explosion = new BufferedImage[15];

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

        for (int i = 0; i < 15; i++) {
            explosion[i] = spritesheet2.crop(i * 52, 0, 52, 62);
        }
    }

}
