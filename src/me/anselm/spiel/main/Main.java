package me.anselm.spiel.main;

import java.io.IOException;

public class Main {


    /**
     * Spiel wird gestartet
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        CrumbChaser crumbChaser = new CrumbChaser();
        crumbChaser.start();
    }
}
