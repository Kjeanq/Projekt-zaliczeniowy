package core;

import core.gamestates.GS_Credits;
import core.gamestates.GS_Game;
import core.gamestates.GS_Menu;
import graphics.Screen;

public class GameStateManager {


    private static GameState gs;

    public static final int game_state_exit = -1;
    public static final int game_state_menu = 0;
    public static final int game_state_game = 1;
    public static final int game_state_credits = 2;

    public static boolean exit = false;


    public static void changeGameState(int id) {
        if (id == game_state_menu){
            gs = new GS_Menu();
        }if (id == game_state_game){
            gs = new GS_Game();
        }if (id == game_state_credits){
            gs = new GS_Credits();
        }if (id == game_state_exit){
            exit = true;
        }
    }



    public GameStateManager() {
        changeGameState(game_state_menu);
    }
    public void update(){
        gs.udpdate();
    }
    public void render(Screen s){
        gs.render(s);
    }
}
