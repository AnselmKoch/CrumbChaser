package me.anselm.spiel.utils;

import me.anselm.spiel.entities.entityMovement.EntityMove;
import me.anselm.spiel.entities.entityMovement.Momentum;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.entities.player.Player;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class KeyBoardListener implements KeyListener {

    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private JFrame mainJFrame = crumbChaser.getMainFrame();
    private JPanel mainJPanel = crumbChaser.getMainPanel();
    private JLabel jLabel;
    private Player player;
    private GameReload gameReload = new GameReload();
    private EntityMove entityMove = crumbChaser.getEntityMove();
    private KeyInputHandler keyInputHandler = crumbChaser.getKeyInputHandler();

    public KeyBoardListener() {
        super();
        jLabel = new JLabel();
        mainJPanel.add(jLabel);
        mainJFrame.add(jLabel);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'r':
                try {
                    gameReload.restartGame();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
        }
    }


    //W=87, D=68, S=83, A=65
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        player = crumbChaser.getPlayer();
        if (!keyInputHandler.getPressedKeys().contains(e.getKeyCode())) {
            keyInputHandler.getPressedKeys().add(e.getKeyCode());
        }
    }


    @Override
    public synchronized void keyReleased(KeyEvent e) {
        for(int i = 0; i < keyInputHandler.getPressedKeys().size(); i++) {
            if (keyInputHandler.getPressedKeys().get(i) == e.getKeyCode()) {
                keyInputHandler.getPressedKeys().remove(i);
            }
        }

        if(keyInputHandler.getPressedKeys().size() == 0) {
            entityMove.setMomentum(new Momentum(0,0), player);
        }
     }
}
