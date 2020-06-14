package gameworld.tiles;

import gameworld.Tile;
import graphics.Camera;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;

public class NextLvl extends Tile {
    public static final Sprite NEXTLVL = new Sprite (40, 8,8, SpriteSheet.daf1);


    int id = 3;
    boolean collider = true;

    public void render(int x, int y, Screen s, Camera c) {
        s.renderSprite(x * 8,y * 8,NEXTLVL, c);
    }
}
