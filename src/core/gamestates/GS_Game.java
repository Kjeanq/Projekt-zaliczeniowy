package core.gamestates;

import core.GameState;
import gameworld.Player;
import gameworld.TitleGrid;
import graphics.Camera;
import graphics.Screen;
import graphics.SpriteSheet;
import input.Keyboard;
import graphics.Sprite;
import math.Vector;

import java.awt.event.KeyEvent;

public class GS_Game extends GameState {
    int x = 40,y = 40;
    public static final Sprite sprite = new Sprite(0,0,16, SpriteSheet.daf1);
//    int[][] map = {
//            {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 2, 2, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 2, 0, 0, 3, 0, 0, 0},
//            {0, 0, 0, 2, 0, 2, 0, 0, 0, 0},
//            {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 2, 0, 0, 0, 0, 0},
//            {0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
//    };

    TitleGrid titleGrid;
    Player player;
    public Camera camera;
    public Vector gravity = new Vector(0.0f, 0.3f);

    public GS_Game() {
        camera = new Camera(-10,0);
        titleGrid = new TitleGrid("mapa0.txt");
        //titleGrid = new TitleGrid(10, 10, map);
        player = new Player(20.0f, 20.0f);
    }


    public void udpdate() {
        int speed = 1;
        player.y += gravity.y;
//        if (Keyboard.getKey(KeyEvent.VK_W)){
//            y -= speed;
//            camera.y -= speed;
//        } else if (Keyboard.getKey(KeyEvent.VK_S)) {
//            y += speed;
//            camera.y += speed;
//        }if (Keyboard.getKey(KeyEvent.VK_A)){
//            x -= speed;
//            camera.x -= speed;
//        } else if (Keyboard.getKey(KeyEvent.VK_D)){
//            camera.x += speed;
//            x += speed;
//        }
    }


    public void render(Screen s) {
        //s.clear(0x7CCEE2);
        s.clear(0xff00FF);
        titleGrid.render(s, camera);
//        s.renderSprite(x, y, sprite);
        s.renderSprite((int) player.x, (int)player.y, player.player);

    }
}
