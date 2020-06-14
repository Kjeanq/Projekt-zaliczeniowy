package graphics;

public class Sprite {


    /* klasa pomagająca w wycinaniu poszczególnych spritów pierwszy konstruktor działa na kwadratowych spritach, drugi na prostokątnych
        na przykład napisy w menu
     */

        public int x, y, width, height;
        public SpriteSheet sp;

        public Sprite(int x, int y, int size, SpriteSheet sp){
            this.x = x;
            this.y = y;
            this.sp = sp;
            this.width = size;
            this.height = size;
        }
        public Sprite(int x, int y, int width, int height, SpriteSheet sp){
            this.x = x;
            this.y = y;
            this.sp = sp;
            this.width = width;
            this.height = height;
        }

}

