package gameworld;

import gameworld.tiles.Air;
import gameworld.tiles.Gras;
import gameworld.tiles.Stone;
import graphics.Camera;
import graphics.Screen;


public class Tile {
    int id;
    boolean collider;


    public static Tile getTile(int id) {
        if (id == 0) return new Air();
        if (id == 1) return new Gras();
        if (id == 2) return new Stone();
        return null;
    }

    public void update(){

    }


    public void render(int x, int y, Screen s, Camera c){

    }
}
