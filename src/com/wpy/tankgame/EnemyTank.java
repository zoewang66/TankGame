package com.wpy.tankgame;

import com.wpy.tankgame.BulletShooting;
import com.wpy.tankgame.Tank;

import java.util.Vector;
public class EnemyTank extends Tank implements Runnable{

    // use Vector to store enemy tanks' shoots
    Vector<BulletShooting> eShoots = new Vector<>();

    Vector<EnemyTank> enemyTanks = new Vector<>();
    public EnemyTank(int x, int y){
        super(x,y);
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public boolean isOverfitted() {
        boolean isFlag = false;
        switch (this.getDirection()) {
            case 0:
                // current enemy tank direction towards up
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        // if other tank towards up or down
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+40]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            // the current tank top-left position (this.getX(), this.getY())
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60){
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank top-right position (this.getX()+40, this.getY())
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60){
                                isFlag = true;
                                return isFlag;
                            }
                        }
                        // if other tank towards left or right
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+60]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            // the current tank top-left position (this.getX(), this.getY())
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40){
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank top-left position (this.getX()+40, this.getY())
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40){
                                isFlag = true;
                                return isFlag;
                            }
                        }
                    }
                }
                break;
            case 1:
                // current enemy tank direction towards right
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        // if other tank towards up or down
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+40]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            // the current tank top-right position (this.getX()+60, this.getY())
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60){
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank bottom-right position (this.getX()+60, this.getY()+40)
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 60) {
                                isFlag = true;
                                return isFlag;
                            }
                        }
                        // if other tank towards left or right
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+60]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            // the current tank top-right position (this.getX()+60, this.getY())
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40){
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank bottom-right position (this.getX()+60, this.getY()+40)
                            if (getX() + 60 >= enemyTank.getX()
                                    && getX() + 60 <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 40){
                                isFlag = true;
                                return isFlag;
                            }
                        }
                    }
                }
                break;
            case 2:
                // current enemy tank direction towards down
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        // if other tank towards up or down
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+40]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            // the current tank bottom-left position (this.getX(), this.getY()+60)
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 60){
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank bottom-right position (this.getX()+40, this.getY()+60)
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 40
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 60){
                                isFlag = true;
                                return isFlag;
                            }
                        }
                        // if other tank towards left or right
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+60]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            // the current tank bottom-left position (this.getX(), this.getY()+60)
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 40){
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank bottom-right position (this.getX()+40, this.getY()+60)
                            if (getX() + 40 >= enemyTank.getX()
                                    && getX() + 40 <= enemyTank.getX() + 60
                                    && getY() + 60 >= enemyTank.getY()
                                    && getY() + 60 <= enemyTank.getY() + 40) {
                                isFlag = true;
                                return isFlag;
                            }
                        }
                    }
                }
                break;
            case 3:
                // current enemy tank direction towards left
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        // if other tank towards up or down
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+40]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+60]
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2) {
                            // the current tank top-left position (this.getX(), this.getY())
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 60) {
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank bottom-left position (this.getX(), this.getY()+40)
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 40
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 60){
                                isFlag = true;
                                return isFlag;
                            }
                        }
                        // if other tank towards left or right
                        // the range of x-axis is [enemyTank.getX(), enemyTank.getX()+60]
                        // the range of y-axis is [enemyTank.getY(), enemyTank.getY()+40]
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3) {
                            // the current tank top-left position (this.getX(), this.getY())
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() >= enemyTank.getY()
                                    && getY() <= enemyTank.getY() + 40) {
                                isFlag = true;
                                return isFlag;
                            }

                            // the current tank bottom-left position (this.getX(), this.getY()+40)
                            if (getX() >= enemyTank.getX()
                                    && getX() <= enemyTank.getX() + 60
                                    && getY() + 40 >= enemyTank.getY()
                                    && getY() + 40 <= enemyTank.getY() + 40) {
                                isFlag = true;
                                return isFlag;
                            }
                        }
                    }
                }
                break;
        }
        return isFlag;
    }

    @Override
    public void run(){
        while(true){
            if(isAlive && eShoots.size() < 2){
                BulletShooting shoot = null;

                switch (getDirection()){
                    case 0:
                        shoot = new BulletShooting(getX()+20, getY(), 0);
                        break;
                    case 1:
                        shoot = new BulletShooting(getX()+60, getY()+20, 1);
                        break;
                    case 2:
                        shoot = new BulletShooting(getX()+20, getY()+60, 2);
                        break;
                    case 3:
                        shoot = new BulletShooting(getX(), getY()+20, 3);
                        break;
                }
                eShoots.add(shoot);
                new Thread(shoot).start();
            }

            switch (getDirection()){
                case 0:
                    for(int i = 0; i < 30; i++){
                        if(getY() > 0 && !isOverfitted()){
                            moveUp();
                        }
                        try{
                            Thread.sleep(50);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for(int i = 0; i < 30; i++){
                        if(getX()+60 < 1000 && !isOverfitted()){
                            moveRight();
                        }
                        try{
                            Thread.sleep(50);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for(int i = 0; i < 30; i++){
                        if(getY()+60 < 750 && !isOverfitted()){
                            moveDown();
                        }
                        try{
                            Thread.sleep(50);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for(int i = 0; i < 30; i++){
                        if(getX() > 0 && !isOverfitted()){
                            moveLeft();
                        }
                        try{
                            Thread.sleep(50);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            // randomly change tanks' direction
            setDirection((int)(Math.random()*4));

            // exit thread
            if(!isAlive){
                break;
            }
        }
    }

}
