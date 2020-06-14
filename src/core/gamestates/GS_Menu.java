package core.gamestates;

import core.GameState;
import core.GameStateManager;
import graphics.Screen;
import graphics.Sprite;
import graphics.SpriteSheet;
import input.Keyboard;

import java.awt.event.KeyEvent;

public class GS_Menu  extends GameState {
    public static final Sprite s_pointer = new Sprite (16, 0,16,SpriteSheet.daf1);
    public static final Sprite s_logo = new Sprite (0,16, 160, 32 ,  SpriteSheet.daf1);
    public static final Sprite s_newGame = new Sprite (0,48, 63, 16 ,  SpriteSheet.daf1);
    public static final Sprite s_continue = new Sprite (0,64, 63, 16 ,  SpriteSheet.daf1);
    public static final Sprite s_credits = new Sprite (0,80, 48, 16 ,  SpriteSheet.daf1);
    public static final Sprite s_exit= new Sprite (0,96, 32, 16 ,  SpriteSheet.daf1);

    private int choose = 0;
    private float pointerPosition = 0;

    public GS_Menu(){

    }
    public void udpdate() {
        if (Keyboard.getKey(KeyEvent.VK_ENTER)){
            if (choose == 0) GameStateManager.changeGameState(GameStateManager.game_state_game);
            if (choose == 2) GameStateManager.changeGameState(GameStateManager.game_state_credits);
            if (choose == 3) GameStateManager.changeGameState(GameStateManager.game_state_exit);

        }
        if (Keyboard.getKeyOnce(KeyEvent.VK_DOWN)) choose++;
        if (Keyboard.getKeyOnce(KeyEvent.VK_UP))choose--;
        if (choose > 3) choose = 0;
        if (choose < 0) choose = 3;

        if (choose == 0) setPointerPosition(32);
        if (choose == 1) setPointerPosition(48);
        if (choose == 2) setPointerPosition(64);
        if (choose == 3) setPointerPosition(80);




    }

    private void setPointerPosition(int i){
        pointerPosition += (i - pointerPosition)/6;
    }

    public void render(Screen s) {
        s.clear(0x00ffff);
        s.renderSprite(50, 0 , s_logo);
        s.renderSprite(20, 32 , s_newGame);
        s.renderSprite(20, 48 , s_continue);
        s.renderSprite(20, 64 , s_credits);
        s.renderSprite(20, 80 , s_exit);
        s.renderSprite(0, (int) pointerPosition, s_pointer);
    }
}
