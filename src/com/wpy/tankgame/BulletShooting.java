package com.wpy.tankgame;
@SuppressWarnings({"all"})
public class BulletShooting implements Runnable{
    int x;
    int y;
    int bDirection = 0;
    int bSpeed = 2;
    boolean isAlive = true;

    public BulletShooting(int x, int y, int bDirection) {
        this.x = x;
        this.y = y;
        this.bDirection = bDirection;
    }

    @Override
    public void run(){
        while(true){
            // sleep 50 ms
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            // according to direction to change x-axis and y-axis
            switch (bDirection){
                case 0:
                    y -= bSpeed;
                    break;
                case 1:
                    x += bSpeed;
                    break;
                case 2:
                    y += bSpeed;
                    break;
                case 3:
                    x -= bSpeed;
                    break;
            }

            //scenarios for bullet disappears
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750) || !isAlive){
                isAlive = false;
                break;
            }
        }
    }
}
