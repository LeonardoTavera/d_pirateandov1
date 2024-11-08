package com.mycompany.mundorpg;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel {
    private World world;
    private Character character;
    private final int tileSize = 15;  // Tamaño de cada celda en píxeles

    public Game() {
        this.world = new World(90, 600);  // Mundo de 50x50 celdas
        this.character = new Character(world, 25, 25);  // Personaje en el centro del mapa

        // Detectar teclas para mover al personaje
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W: character.move("up"); break;
                    case KeyEvent.VK_S: character.move("down"); break;
                    case KeyEvent.VK_A: character.move("left"); break;
                    case KeyEvent.VK_D: character.move("right"); break;
                }
                repaint();  // Redibujar el mapa después de mover al personaje
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.renderWorld(g, character, tileSize);  // Renderizar el mundo
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pirateando - Mapa grande");
        Game game = new Game();
        frame.add(game);
        frame.setSize(1200, 1200);  // Ventana grande para mostrar más celdas
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}