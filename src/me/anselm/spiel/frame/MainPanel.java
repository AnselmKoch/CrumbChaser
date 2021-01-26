package me.anselm.spiel.frame;

import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.main.CrumbChaser;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.world.World;
import me.anselm.spiel.world.location.Location;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * The Display attached to MainFrame, this class is responsible for rendering whats going on
 */
public class MainPanel extends JPanel {

    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private Player player;

    /**
     * Images for Player and Enemy, will be given an extra class soon
     */
    private String urlString = "images/waitScreen.png";
    private String enemyPngUrl = "images/enemyPNG.png";
    private String playerPngUrl = "images/playerPNG.png";

    private Image playerImage = ImageIO.read(new File(playerPngUrl));
    private Image enemyImage = ImageIO.read(new File(enemyPngUrl));
    private Image waitScreen = ImageIO.read(new File(urlString));


    public MainPanel() throws IOException {
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        World world = crumbChaser.getWorld();
        setBounds(0,0, world.getWidth(), world.getHeight());
        player = world.getPlayer();
        drawStartGUI(graphics);
        drawEntities(graphics);
    }


    public void drawEntities(Graphics graphics) {
        World world = crumbChaser.getWorld();
        int xPos = CrumbChaser.WIDTH / 2;
        int yPos = CrumbChaser.HEIGHT / 2;

        /**
         * Draws the Player in the middle of the Screen
         * Everything else will be rendered relative to the Players actual location so it looks like the Player is moving along the Map
         *
         * so for example if an entity is 10LE away on the X-Axis and 20LE away from the X-Axis of the Player
         * it will render the entity (10,20) LE away from the y and xPos variable, not the actual position of the Player
         * (Same goes for the Lines)
         */
        graphics.drawImage(playerImage, xPos, yPos, this);
            float playerYPos = world.relativePlayerYPos;
            float playerXPos = world.relativePlayerXPos;

            for (int i = 0; i < world.getHeight(); i++) {
                if (i % 100 == 0) {
                    graphics.drawLine(0 - (int) playerXPos, i - (int) playerYPos, world.getWidth() - (int) playerXPos, i - (int) playerYPos);
                }
            }
            for (int i = 0; i < world.getWidth(); i++) {
                if (i % 100 == 0) {
                    graphics.drawLine(i - (int) playerXPos, 0 - (int) playerYPos, i - (int) playerXPos, world.getHeight() - (int) playerYPos);
                }
            }

            for (Entity entity : world.getAliveEntities()) {
                Location playerLocation = player.getLocation();
                Location relativeLocation = playerLocation.getRelativeLocationTo(entity.getLocation());
                if (!(entity instanceof Player)) {

                    graphics.setColor(entity.getColor());
                    graphics.drawImage(enemyImage, xPos + (int) relativeLocation.getxCoordinate(), yPos + (int) relativeLocation.getyCoordinate(), this);

            }
        }
    }

    private void drawStartGUI(Graphics graphics) {
        if (player == null) {
            graphics.drawImage(waitScreen, 500, 500, this);
        }
    }


    public void draw(Graphics graphics) {
    }
}
