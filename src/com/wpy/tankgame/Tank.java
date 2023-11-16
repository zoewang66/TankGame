package com.wpy.tankgame;
@SuppressWarnings({"all"})
public class Tank {
    private int x;
    private int y;
    private int direction = 0;
    private int speed = 2;
    boolean isAlive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //methods for directions moving
    public void moveUp(){
        y -= speed;
    }

    public void moveRight(){
        x += speed;
    }

    public void moveDown(){
        y += speed;
    }

    public void moveLeft(){
        x -= speed;
    }
}
