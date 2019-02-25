package com.example.spacetraders.entities;

/**This class represents the coordinates of a solar system*/
public class Coordinates {
    private int x;
    private int y;

    /**
     * Constructor coordinates
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /** getter for x*/
    public int getX() { return x;}
    /** getter for y*/
    public int getY() { return y;}

    /** hashCode method
     * @return the hashcode
     */
    public int hashCode() {
        //copied this from stackoverflow
        int tmp = y + (x + 1) / 2;
        return x + tmp * tmp;
    }

    /** isEqual method
     * @param obj some other object
     * @return if they are the same coordinates
     */
    public boolean isEqual(Object obj) {
        if(obj instanceof Coordinates && ((Coordinates) obj).getX() == this.x && ((Coordinates) obj).getY() == this.y) {
            return true;
        }
        return false;
    }

    /**
     * to string for coordinates
     *
     * @return string of coordinates info
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
