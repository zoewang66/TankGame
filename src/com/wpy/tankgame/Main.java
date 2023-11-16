package com.wpy.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Main extends JFrame {

    MyPanel mp = null;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Main game = new Main();
    }

    public Main(){
        System.out.print("Please enter your choice: 1 - new game, 2 - load the previous game: ");
        String key = scanner.next();
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1500, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Record.saveFile();
                System.exit(0);
            }
        });
    }
}
