package me.anselm.spiel.game;

import me.anselm.spiel.entities.entityMovement.EntityMove;
import me.anselm.spiel.frame.MainPanel;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.utils.CollitionDetector;
import me.anselm.spiel.utils.math.DirectionHelper;
import me.anselm.spiel.world.World;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Starts the GameTime with an 1ms delay
 */

public class GameTick{


    private CrumbChaser crumbChaser = CrumbChaser.getInstance();

    private GameTime gameTime = new GameTime(1, new ActionListener() {
        @Override
        public synchronized void actionPerformed(ActionEvent e) {
            try {
                gameTime.doGameTick();
                CrumbChaser.getInstance().getMainFrame().setTitle(CrumbChaser.gameName + " | FPS: " + gameTime.getFpsLastSecond());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    });

    public GameTick() throws IOException {
    }

    public void doTick() throws IOException {
    }

}
