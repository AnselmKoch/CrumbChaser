package me.anselm.spiel.frame;

import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.utils.KeyBoardListener;

import javax.swing.*;

/**
 * The Main Window in which the game is running
 */

public class MainFrame extends JFrame {

    private MainPanel mainPanel = CrumbChaser.getInstance().getMainPanel();

    public MainFrame() {
        setSize(CrumbChaser.screenSize);
        setVisible(true);
        setResizable(true);
    }

   public void setJPanel() {
        setContentPane(mainPanel);
        mainPanel.paintComponent(getGraphics());
        addKeyListener(new KeyBoardListener());
    }
}
