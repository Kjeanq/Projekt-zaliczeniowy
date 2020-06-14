package gameworld;

import graphics.Camera;
import graphics.Screen;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TitleGrid {
    Tile [][]map;
    int height,width;
    ArrayList<ArrayList<Integer>> temp = new ArrayList<>();


    public TitleGrid (String file) {                  //
        mapLoad(file);

    }
    public TitleGrid (int height, int width, int [][] newMap){   //konstruktor wczytuje mapę z istniejącej w programie tablicy
        this.height = height;
        this.width = width;
        map = new Tile[width][height];

        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[x].length; y++){
                     if (newMap[x][y] == 0){
                        map[x][y] = Tile.getTile(0);
                    }
                    else if (newMap[x][y] == 1){
                        map[x][y] = Tile.getTile(1);
                    }
                    else {
                        map[x][y] = Tile.getTile(2);
                    }
            }
        }


    }

    public void mapLoad(String filename) {
        try (BufferedReader file = new BufferedReader(new FileReader(filename))){
            String currentLine;
            while ((currentLine = file.readLine()) != null) {
                if (currentLine.isEmpty()) continue;
                ArrayList<Integer> row = new ArrayList<>();

                String[] values = currentLine.trim().split(" ");
                for (String x : values) {
                    if (!x.isEmpty()) {
                        int id = Integer.parseInt(x);
                        row.add(id);
                    }
                }
                temp.add(row);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        width = temp.get(0).size();
        height = temp.size();
        map = new Tile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                map[y][x] = Tile.getTile(temp.get(y).get(x));
                System.out.println(map[y][x]);

            }
        }
    }

    public void render(Screen s, Camera c){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                map[y][x].render(x,y , s, c);
            }
        }
    }


}





