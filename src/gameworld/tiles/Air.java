package gameworld.tiles;

import gameworld.Tile;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

import java.util.Objects;

public class Air extends Tile {

    public static final Sprite AIR = new Sprite (40, 0,8, SpriteSheet.daf1);

    int id = 0;
    boolean collider = false;



    public void render(int x, int y, Screen s, Camera c) {
        s.renderSprite(x * 8,y * 8, AIR, c);
    }
}
