package core;

import graphics.Screen;
import input.Keyboard;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Window extends Canvas implements Runnable {
    public static final int WIDTH1 = 1280, HEIGHT1 = 720;
    public String title = "Russian mario";
    private static final int maxfps = 60;
    private GameStateManager gsm;
    private boolean running = false;
    private JFrame frame;                           //deklaracja zmiennuch


    public Keyboard keyboard = new Keyboard();
    private Screen screen;

    public Window() {                                       //konstruktor
        setPreferredSize(new Dimension(WIDTH1, HEIGHT1));
        setMaximumSize(new Dimension(WIDTH1, HEIGHT1));
        setMaximumSize(new Dimension(WIDTH1, HEIGHT1));     // wielkości okna

        frame = new JFrame();                               //tworzymy ramkę
        frame.add(this, new BorderLayout().CENTER);
        addKeyListener(keyboard);                           //dodajemy sterowanie klawiaturom
        frame.pack();                                       //ustawiamy okno w preferowanym rozmiarze

        frame.setResizable(false);                          // ustawiamy brak możliwości zmiany rozmiaru okna
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // wyście po "skreśleniu okna"
        frame.setVisible(true);                             // ramka będzie widzialna

        //frame.setLocationRelativeTo(null);                  // okno wyświetla się na środku
        int sc = 30;
        screen = new Screen(16 * sc, 9 * sc);       // ustawienie rozdzielczości 16 na 9 razy sc
        gsm = new GameStateManager();                           // inicjacja zmiennej zarządzającej stanem gry
    }

    //zmienne do ograniczenia liczby fps
    private double timer = System.currentTimeMillis();
    private int fps = 0;
    private int ups = 0;
    private double delta;
    private double frameTime = 1000000000.0 / maxfps;       //nanosekundy przez liczbę fps = czas jednej klatki
    private long timeNow = System.nanoTime();
    private long timeLast = System.nanoTime();

    public void run() {                                     // metoda z interfejsu runnable
        while (running && !gsm.exit) {
            timeNow = System.nanoTime();
            delta += (timeNow - timeLast) / frameTime;
            timeLast = System.nanoTime();

            while (delta >= 1) {
                update();                                   // aktualizacja
                fps++;
                delta -= 1;
            }
            render();
            ups++;
            if (System.currentTimeMillis() - timer >= 1000) {
                timer = System.currentTimeMillis();
                frame.setTitle(title + " FPS: " + fps + " UPS: " + ups);        //wyświetlanie tytułu ramki + fps i ups
                fps = 0;
                ups = 0;
            }
        }
        stop();
    }

    private void update() {                     //aktualizowanie stanu gry i klawiatury
        keyboard.update();
        gsm.update();
    }

    private void render() {
        BufferStrategy buff = getBufferStrategy();              // ustalanie renderowania 3 klatek do przodu
        if (buff == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = buff.getDrawGraphics();


        gsm.render(screen);

        g.drawImage(screen.getImg(), 0, 0, WIDTH1 + 10, HEIGHT1 + 10, null);

        g.dispose();
        buff.show();

    }

    public void start() {                                   //nowy wątek
        if (running) return;
        running = true;

        new Thread(this, "Game" + title).start();
    }

    private void stop() {                   //wyłącznie gry
        if (!running) return;
        running = false;
        frame.dispose();
        System.exit(0);
    }
}



