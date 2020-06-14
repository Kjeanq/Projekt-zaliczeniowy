package graphics;


import core.Window;
import math.Vector;

public class Camera {

    public static final Camera cam0 = new Camera(0,0);

    public int x, y;
    public static final int WIDTH = Window.WIDTH1 / 2, HEIGHT = Window.HEIGHT1 / 2;
    public Camera(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector getPosition(){
        return new Vector(x, y);
    }

}
