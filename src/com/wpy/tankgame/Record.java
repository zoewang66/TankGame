package com.wpy.tankgame;
import javax.swing.*;
import java.io.*;
import java.util.Vector;
@SuppressWarnings({"all"})
public class Record {

    private static int enemyNums = 0;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "record.txt";
    private static Vector<EnemyTank> enemyTanks = null;

    private static Vector<Node> nodes = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks){
        Record.enemyTanks = enemyTanks;
    }
    public static int getEnemyNums() {
        return enemyNums;
    }

    public static void setEnemyNums(int enemyNums) {
        Record.enemyNums = enemyNums;
    }

    public static void addEnemyNum(){
        Record.enemyNums++;
    }

    public static Vector<Node> getEnemyRecordNode(){
        try{
            br = new BufferedReader(new FileReader(recordFile));
            enemyNums = Integer.parseInt(br.readLine());
            String line = "";
            while((line = br.readLine()) != null){
                String[] positions = line.split(" ");
                Node node = new Node(Integer.parseInt(positions[0]),
                        Integer.parseInt(positions[1]),
                        Integer.parseInt(positions[2]));
                nodes.add(node);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(br != null){
                    br.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        return nodes;
    }

    // save record
    public static void saveFile(){
        try{
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(""+enemyNums);
            bw.newLine();
            // iterate enemyTanks vectors
            for(int i = 0; i < enemyTanks.size(); i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isAlive){
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                    bw.write(record);
                    bw.newLine();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(bw != null){
                    bw.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
