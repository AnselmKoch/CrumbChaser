package me.anselm.spiel.utils;

import me.anselm.spiel.entities.Entity;
import me.anselm.spiel.world.location.Location;

public class AreaDetector {

    /**
     * Returns an Array of Locations that represent the border of the entity,
     * needs to have for corners with all sides beeing the same length;
     * @param xPos the xPos of the entity
     * @param yPos the yPos of the entity
     * @param width the width of the entity
     * @param height the height of the entity
     * @return
     */

    public Location[] getBorder(float xPos, float yPos, int width, int height) {
        int tmp = 0;
        Location[] ergebnis = new Location[width + height + width + height];
        Location startPoint = new Location(xPos, yPos);
        Location pointOtherside = new Location(xPos + width, yPos + height);

        /**
         * By adding the width and the height to either startPoint or pointOtherside I can get every Location
         * on all four sides;
         */

        for(int i = 0; i < width; i++) {
            ergebnis[tmp] = new Location(startPoint.getxCoordinate() + i, startPoint.getyCoordinate());
            tmp++;
        }

        for(int i = 0; i < height; i++) {
            ergebnis[tmp] = new Location(startPoint.getxCoordinate(), startPoint.getyCoordinate() +i);
            tmp++;
        }

        for(int i = 0; i < width; i++) {
            ergebnis[tmp] = new Location(pointOtherside.getxCoordinate() - i, pointOtherside.getyCoordinate());
            tmp++;
        }

        for(int i = 0; i < height; i++) {
            ergebnis[tmp] = new Location(pointOtherside.getxCoordinate(), pointOtherside.getyCoordinate() -i);
            tmp++;
        }

        return ergebnis;
    }
}
