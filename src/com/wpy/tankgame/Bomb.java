package com.wpy.tankgame;

public class Bomb {
    int  x, y;
    int lifeRemaining = 9;
    boolean isAlive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void ReduceLife(){
        if(lifeRemaining > 0){
            lifeRemaining--;
        }else{
            isAlive = false;
        }
    }
}
