package com.mycompany.mundorpg;

public class Character {
    private int posX, posY;
    private World world;

    public Character(World world, int startX, int startY) {
        this.world = world;
        this.posX = startX;
        this.posY = startY;
    }

    public void move(String direction) {
        int newX = posX, newY = posY;
        switch (direction) {
            case "up": newY--; break;
            case "down": newY++; break;
            case "left": newX--; break;
            case "right": newX++; break;
        }

        // Verifica si el personaje puede moverse a la nueva posición
        if (newX >= 0 && newX < world.width && newY >= 0 && newY < world.height && world.isWalkable(newX, newY)) {
            posX = newX;
            posY = newY;
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}