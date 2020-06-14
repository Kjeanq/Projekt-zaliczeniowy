package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    public static final SpriteSheet daf1 = new SpriteSheet("/res/SpriteSheet.png"); // stworzenie zmiennej spritesheet


    public int width, height;
    public int [] pixels;

    public SpriteSheet(String path) {   // konstruktor pobierający ścieżę do obrazu
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));    //pobieranie obrazu
            width = image.getWidth();                                                   // pobieranie wysokości i szerokości
            height = image.getHeight();
            pixels = new int[width * height];                                           // tworzenie tabeli z  pixelami

            image.getRGB(0,0,width,height,pixels,0,width);              // zwracanie tabeli pixeli
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}