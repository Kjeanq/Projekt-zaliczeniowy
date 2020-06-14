package gameworld.tiles;

import gameworld.Tile;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class Stone extends Tile {
    public static final Sprite STONE = new Sprite (32, 0,8,SpriteSheet.daf1);


    int id = 2;
    boolean collider = true;

    public void render(int x, int y, Screen s, Camera c) {
        s.renderSprite(x * 8,y * 8, STONE, c);
    }
}
