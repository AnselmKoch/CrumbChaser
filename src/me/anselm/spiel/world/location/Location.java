package me.anselm.spiel.world.location;

public class Location {
    private float xCoordinate, yCoordinate;

    public Location(float xCoordinate, float yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void setXCoordinate(float newX) {
        this.xCoordinate = newX;
    }
    public void setYCoordinate(float newY) {
        this.yCoordinate = newY;
    }
    public float getxCoordinate() {
        return xCoordinate;
    }
    public float getyCoordinate() {
        return yCoordinate;
    }

    /**
     * Returns the X- and Y- Difference between two Locations
     * @param location the location of which you want the difference relative to the called one
     * @return an Location that represents the position of the param Location relative to the called one
     */
    public Location getRelativeLocationTo(Location location) {
        Location returnLocation = new Location(0,0);
        int x = 0, y = 0;
        float sourceX = this.getxCoordinate();
        float targetX = location.getxCoordinate();

        if(sourceX < targetX) {
            for(int i = (int)sourceX; i < targetX; i++) {
                x++;
            }
        }else{
            for(int i = (int)sourceX; i > targetX; i--) {
                x--;
            }
        }

        float sourceY = this.getyCoordinate();
        float destY = location.getyCoordinate();

        if (sourceY < destY) {
            for (int i = (int) sourceY; i < destY; i++) {
                y++;
            }
        }else{
            for(int i = (int) sourceY; i > destY; i--) {
                y--;
            }
        }
        returnLocation.setXCoordinate((float)x);
        returnLocation.setYCoordinate((float)y);

        return returnLocation;
    }

    public String toString() {
        return "X:" + xCoordinate + "| Y:" + yCoordinate;
    }

}
