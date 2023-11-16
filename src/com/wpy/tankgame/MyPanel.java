package com.wpy.tankgame;
import com.wpy.tankgame.Bomb;
import com.wpy.tankgame.BulletShooting;
import com.wpy.tankgame.EnemyTank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.util.Vector;


@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener,Runnable {
    MyTank tank = null;
    public Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 3;
    Vector<Bomb> bombs = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    // define three pictures to
    Image img1 = null;
    Image img2 = null;
    Image img3 = null;

    public MyPanel(String key)  {
        tank = new MyTank(500, 100, 10);//initialization
        Record.setEnemyTanks(enemyTanks);
        switch (key){
            case "1":
                // initialize enemy tanks
                for(int i = 0; i < enemySize; i++){
                    EnemyTank enemyTank = new EnemyTank((100 * (i +1)),0);
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirection(2);
                    // thread starts
                    new Thread(enemyTank).start();
                    BulletShooting shoot = new BulletShooting(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirection());
                    // add enemy tanks' bullets to eShoots vector
                    enemyTank.eShoots.add(shoot);
                    new Thread(shoot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2":
                nodes = Record.getEnemyRecordNode();
                // initialize enemy tanks
                for(int i = 0; i < nodes.size(); i++){
                    Node node = nodes.get(i);
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    enemyTank.setEnemyTanks(enemyTanks);
                    enemyTank.setDirection(node.getDirection());
                    // thread starts
                    new Thread(enemyTank).start();
                    BulletShooting shoot = new BulletShooting(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirection());
                    // add enemy tanks' bullets to eShoots vector
                    enemyTank.eShoots.add(shoot);
                    new Thread(shoot).start();
                    enemyTanks.add(enemyTank);
                }
                break;
        }


        // initialize object of Image class
        img1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb1.png"));
        img2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb2.png"));
        img3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb3.png"));

    }


    // the method to show the numbers of enemy tanks we destroyed
    public void showInfo(Graphics g){

        // draw the player's total scores
        g.setColor(Color.black);
        Font font = new Font("New Times Roman", Font.BOLD, 16);
        g.setFont(font);

        g.drawString("Total numbers of enemy tanks you have hit:", 1020, 30);
        drawTank(1020,50,g,0,1);
        g.setColor(Color.black);
        g.drawString(Record.getEnemyNums()+"",1080,85);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.fillRect(0,0,1000,750);
        showInfo(g);
        // draw our tanks
        if(tank.isAlive && tank != null){
            drawTank(tank.getX(), tank.getY(), g,tank.getDirection(),0);
        }

        // draw our bullets
        for(int i = 0; i < tank.shootings.size(); i++){
            BulletShooting shooting = tank.shootings.get(i);
            if(shooting != null && shooting.isAlive){
                g.draw3DRect(shooting.x, shooting.y, 2,2,false);
            } else {
                tank.shootings.remove(shooting);
            }
        }

        // if Vector bombs has elements, then draw bomb
        for(int i = 0; i < bombs.size(); i++){
            Bomb bomb = bombs.get(i);
            // according to lifeRemaining to draw bomb
            if(bomb.lifeRemaining > 6){
                g.drawImage(img1, bomb.x, bomb.y, 60,60,this);
            } else if (bomb.lifeRemaining > 3) {
                g.drawImage(img2, bomb.x, bomb.y, 60,60,this);
            }else{
                g.drawImage(img3, bomb.x, bomb.y, 60,60,this);
            }
            bomb.ReduceLife();
            if(bomb.lifeRemaining == 0){
                bombs.remove(bomb);
            }
        }

        // draw enemy tanks
        for(int i = 0; i < enemyTanks.size(); i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.isAlive){
                drawTank(enemyTank.getX(), enemyTank.getY(),g,enemyTank.getDirection(), 1);
            }

            // draw all enemy's bullets only enemy tank still exists
            if(enemyTank.isAlive){
                for(int j = 0; j < enemyTank.eShoots.size(); j++){
                    BulletShooting bullet = enemyTank.eShoots.get(j);
                    if(bullet.isAlive){
                        g.draw3DRect(bullet.x,bullet.y,2,2,false);
                    }else{
                        enemyTank.eShoots.remove(bullet);
                    }
                }
            }

        }
    }

    //paint tank method
    /**
     * @param x x-axis
     * @param y y-axis
     * @param g Brush
     * @param direction direction of the tank
     * @param type type of the tank
     */

    public void drawTank(int x, int y, Graphics g, int direction, int type){

        switch (type){
            case 0: // mytank
                g.setColor(Color.green);
                break;
            case 1: //enemytank
                g.setColor(Color.pink);
                break;
        }

        // according to the direction to draw the tank
        switch (direction){
            case 0: //up
                g.fill3DRect(x, y, 10,60,false);
                g.fill3DRect(x+30, y, 10,60,false);
                g.fill3DRect(x+10, y+10, 20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y,x+20,y+30);
                break;
            case 1: //right
                g.fill3DRect(x, y, 60,10,false);
                g.fill3DRect(x, y +30, 60,10,false);
                g.fill3DRect(x+10, y+10, 40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2: // down
                g.fill3DRect(x, y, 10,60,false);
                g.fill3DRect(x+30, y, 10,60,false);
                g.fill3DRect(x+10, y+10, 20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3: //left
                g.fill3DRect(x, y, 60,10,false);
                g.fill3DRect(x, y +30, 60,10,false);
                g.fill3DRect(x+10, y+10, 40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x,y+20,x+30,y+20);
                break;
        }
    }

    // a method to judge whether our tank shoot enemy tanks
    public void HitETank(){
        for(int i = 0; i < tank.shootings.size(); i++){
            BulletShooting shooting = tank.shootings.get(i);
            // judge if our tank hit enemy tanks
            if (shooting!= null && shooting.isAlive) {
                for (int j = 0; j< enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    HitTank(tank.shooting, enemyTank);
                }
            }
        }
    }

    // a method to judge whether enemy tanks hit my tank
    public void HitMyTank() {
        for(int j = 0; j < enemyTanks.size(); j++){
            EnemyTank enemyTank = enemyTanks.get(j);
            for(int i = 0; i < enemyTank.eShoots.size(); i++){
                BulletShooting shooting = enemyTank.eShoots.get(i);
                // judge if enemy's bullet hit our tanks
                if (shooting != null && shooting.isAlive){
                    HitTank(shooting, tank);
                }
            }
        }
    }
    public void HitTank(BulletShooting b, Tank enemyTank){
        switch (enemyTank.getDirection()){
            case 0:
            case 2:
                if(b.x > enemyTank.getX() && b.x < enemyTank.getX()+40
                   && b.y > enemyTank.getY() && b.y < enemyTank.getY()+60){
                    b.isAlive = false;
                    enemyTank.isAlive = false;
                    enemyTanks.remove(enemyTank);
                    if(enemyTank instanceof EnemyTank){
                        Record.addEnemyNum();
                    }
                    Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;

            case 1:
            case 3:
                if(b.x > enemyTank.getX() && b.x < enemyTank.getX()+60
                  && b.y > enemyTank.getY() && b.y < enemyTank.getY()+40){
                    b.isAlive = false;
                    enemyTank.isAlive = false;
                    enemyTanks.remove(enemyTank);
                    if(enemyTank instanceof EnemyTank){
                        Record.addEnemyNum();
                    }
                    Bomb bomb = new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            tank.setDirection(0);
            if(tank.getY() > 0) {
                tank.moveUp();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            tank.setDirection(1);
            if(tank.getX()+60 < 1000){
                tank.moveRight();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            tank.setDirection(2);
            if(tank.getY()+60 < 750){
                tank.moveDown();
            }
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            tank.setDirection(3);
            if(tank.getX() > 0){
                tank.moveLeft();
            }
        }

        // if the user press 'J', the bullet will start to shoot
        if(e.getKeyCode() == KeyEvent.VK_J){
            tank.shootEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    // repaint bullet every 100 ms
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // judge whether we hit enemy tanks
            HitETank();
            // judge whether enemy hit our tanks
            HitMyTank();
            this.repaint();
        }

    }
}
