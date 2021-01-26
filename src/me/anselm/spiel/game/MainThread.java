package me.anselm.spiel.game;

import java.io.IOException;



public class MainThread extends Thread{

    public synchronized void run() {
        try {
            GameTick gameTick = new GameTick();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
