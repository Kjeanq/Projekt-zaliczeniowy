package graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen {

        public final int WHITH;
        public final int HEIGHT;

        private BufferedImage img;
        private int [] pixels;

        public Screen(int whith, int height){
            HEIGHT = height;
            WHITH = whith;
            img = new BufferedImage(WHITH,HEIGHT,BufferedImage.TYPE_INT_RGB);
            pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();   // zalęcie do stworzenia tebeli pixeli dająca nam dostęp do każdego pixela
        }                                                                           // jest ona modyfikowalna



        public void clear (int color){                                          // funkcja czyszcząca ekran jednym kolorem
            for (int i = 0; i < pixels.length; i++){
                pixels[i] = color;
            }
        }

        public BufferedImage getImg() {
            return img;
        }

        public void renderSprite(int px, int py, Sprite s){                     // funkcja dodająca kamerę do funkcji poniżej
            renderSprite( px, py, s, Camera.cam0);
        }
        public void renderSprite(int px, int py, Sprite s, Camera c){           // funkcja wyświetlająca nam obrazek na ekranie
            // px i py to położenie obrazka
            for (int y = 0; y < s.height; y++){
                for (int x = 0; x < s.width; x++){
                    pixel(x + px - c.x,y + py - c.y,  s.sp.pixels[s.x + x + (s.y  + y) *s.sp.width]);
                }
            }
        }


        private void pixel (int x, int y, int color){                                           // funkcja zabezpieczająca rysowanie po za ekranem
            if (x<0 || x >= WHITH || y < 0 || y >= HEIGHT || color == 0xFFFF00FF ) return;
            pixels[x + y * WHITH] = color;
        }

}

