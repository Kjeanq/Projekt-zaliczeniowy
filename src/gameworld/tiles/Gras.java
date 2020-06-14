package gameworld.tiles;

import gameworld.Tile;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class Gras extends Tile {

    public static final Sprite GRAS = new Sprite (32, 8,8, SpriteSheet.daf1);


    int id = 1;
    boolean collider = true;

    public void render(int x, int y, Screen s, Camera c) {
        s.renderSprite(x * 8,y * 8,GRAS, c);
    }
}
