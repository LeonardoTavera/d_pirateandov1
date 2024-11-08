package com.mycompany.mundorpg;

import java.awt.Color;
import java.awt.Graphics;

public class World {
    public Tile[][] map;
    public int width, height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Tile[width][height];
        generateWorld();
    }

    private void generateWorld() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (Math.random() > 0.5) {
                    map[x][y] = new Tile("Tierra");
                } else {
                    map[x][y] = new Tile("Agua");
                }
            }
        }
    }

    // Dibuja el mapa en un panel gráfico
    public void renderWorld(Graphics g, Character character, int tileSize) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Dibujar terreno
                if (map[x][y].getType().equals("Tierra")) {
                    g.setColor(new Color(139, 69, 19));  // Color marrón para tierra
                } else {
                    g.setColor(Color.BLUE);  // Color azul para agua
                }
                g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);

                // Dibujar personaje si está en esta celda
                if (x == character.getPosX() && y == character.getPosY()) {
                    g.setColor(Color.GREEN);  // Color verde para el personaje
                    g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
                }

                // Dibujar borde de cada celda
                g.setColor(Color.BLACK);
                g.drawRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }
    }

    public boolean isWalkable(int x, int y) {
        return map[x][y].getType().equals("Tierra");
    }
}