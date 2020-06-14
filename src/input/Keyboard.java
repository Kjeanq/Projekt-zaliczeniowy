package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private static final int count = 200;
    private static boolean keys [] = new boolean[count];
    private static boolean keys_prev [] = new boolean[count];
    public Keyboard() {                                     // konstruktor tworzący 2 tablice
        for (int i = 0; i < count; i++){
            keys[i] = false;
        }
        for(int i = 0; i < count; i++){
            keys_prev[i] = false;
        }

    }

    public static boolean getKey(int key) {             // metoda zwracająca stan danego klawisza
        return keys[key];
    }

    public void keyTyped(KeyEvent keyEvent) {           //metoda z interfejsu
    }


    public void keyPressed(KeyEvent keyEvent) {           // jeśli klawisz jest wciśnięty dodajemy informację do tabeli
        keys[keyEvent.getKeyCode()] = true;
    }


    public void keyReleased(KeyEvent keyEvent) {          // jeśli puścimy klawisz usuwamy informację o wciśnięciu
        keys[keyEvent.getKeyCode()] = false;
    }

    public void update(){                           // wprowadzamy informację o poprzednio wciśniętym klawiszu
        for (int i = 0; i < count; i++){
            if (!keys[i]){
                keys_prev[i] = false;
            }
        }
    }
    public static  boolean getKeyOnce(int key){            // metoda do pobierania klawisza raz
        if (!keys_prev[key] && keys[key]){
            keys_prev[key] = true;
            return true;
        }
        return false;
    }
}
