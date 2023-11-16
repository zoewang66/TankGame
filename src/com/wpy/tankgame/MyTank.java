package com.wpy.tankgame;

import com.wpy.tankgame.BulletShooting;
import com.wpy.tankgame.Tank;

import java.util.Vector;
@SuppressWarnings({"all"})
public class MyTank extends Tank{

    public int speed;
    // given we need to shoot enemy tanks, so define a com.wpy.tankgame.BulletShooting variable
    BulletShooting shooting = null;
    Vector<BulletShooting> shootings = new Vector<>();

    public MyTank(int x, int y, int speed) {
        super(x, y);
        this.speed = speed;
    }

    public void shootEnemyTank(){
        // create an object of com.wpy.tankgame.BulletShooting class, variable shoot is created by the direction and the position of
        // the com.wpy.tankgame.MyTank class

        switch (getDirection()){
            case 0:
                shooting = new BulletShooting(getX()+20, getY(),0);
                break;
            case 1:
                shooting = new BulletShooting(getX()+60,getY()+20,1);
                break;
            case 2:
                shooting = new BulletShooting(getX()+20,getY()+60,2);
                break;
            case 3:
                shooting = new BulletShooting(getX(),getY()+20,3);
                break;
        }

        if (shootings.size() == 5) {
            return;
        }
        shootings.add(shooting);
        // start shooting
        new Thread(shooting).start();

    }

}
