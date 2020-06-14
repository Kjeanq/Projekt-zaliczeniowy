package core.gamestates;

import input.Keyboard;
import core.GameState;
import core.GameStateManager;
import graphics.Screen;

import java.awt.event.KeyEvent;

public class GS_Credits extends GameState {
    private GameStateManager gameStateManager;
    public GS_Credits(){
        gameStateManager = new GameStateManager();
    }



    public void udpdate() {
        if (Keyboard.getKeyOnce(KeyEvent.VK_ESCAPE)){
            gameStateManager.changeGameState(0);
        }
    }


    public void render(Screen s) {
        s.clear(0xff0000);
    }
}
