package me.anselm.spiel.utils;

import me.anselm.spiel.entities.entityMovement.EntityMove;
import me.anselm.spiel.entities.entityMovement.Momentum;
import me.anselm.spiel.entities.player.Player;
import me.anselm.spiel.main.CrumbChaser;

import java.util.ArrayList;

/**
 * Runs every tick to know what Keys are currently Pressed so the Player moves in a certain direction
 */

public class KeyInputHandler {
    private ArrayList<Integer> pressedKeys = new ArrayList<>();
    private CrumbChaser crumbChaser = CrumbChaser.getInstance();
    private EntityMove entityMove = crumbChaser.getEntityMove();
    private Player player = crumbChaser.getWorld().getPlayer();

    public ArrayList<Integer> getPressedKeys() {
        return pressedKeys;
    }

    public void handleKeyInput() {

        /**
         *  87 = W
         *  65 = A
         *  68 = D
         *  83 = S
         */

        if(pressedKeys.size() == 1) {
            if (pressedKeys.contains(87)) {

                //Player love UP
                entityMove.setMomentum(new Momentum(0, -7.3F), player);
            }

            if (pressedKeys.contains(68)) {

                //Player move RIGHT
                entityMove.setMomentum(new Momentum(7.3F, 0), player);
            }

            if (pressedKeys.contains(83)) {

                //Player move DOWN
                entityMove.setMomentum(new Momentum(0, 7.3F), player);
            }

            if(pressedKeys.contains(65)) {

                //Player move LEFT
                entityMove.setMomentum(new Momentum(-7.3F, 0), player);
            }

        }else if(pressedKeys.size() == 2) {

            if (pressedKeys.contains(68) && pressedKeys.contains(87)) {

                //Player move RIGHT-UP
                entityMove.setMomentum(new Momentum(3.65F * 2, -3.65F * 2), player);
            }
            if (pressedKeys.contains(68) && pressedKeys.contains(83)) {

                //Player move RIGHT-DOWN
                entityMove.setMomentum(new Momentum(3.65F * 2, 3.65F * 2), player);
            }
            if (pressedKeys.contains(83) && pressedKeys.contains(65)) {

                //Player move LEFT-DOWN
                entityMove.setMomentum(new Momentum(-3.65F * 2, 3.65F * 2), player);
            }
            if (pressedKeys.contains(65) && pressedKeys.contains(87)) {

                //Player move LEFT-UP
                entityMove.setMomentum(new Momentum(-3.65F * 2, -3.65F * 2), player);
            }
        }
    }
}
