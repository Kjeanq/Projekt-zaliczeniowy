package gameworld;

import graphics.Sprite;
import graphics.SpriteSheet;

public class Player {
    public float x,y;
    public static final Sprite player = new Sprite(0,0,16, SpriteSheet.daf1);

    public Player(float x, float y){
        this.x = x;
        this.y = y;
    }



}
