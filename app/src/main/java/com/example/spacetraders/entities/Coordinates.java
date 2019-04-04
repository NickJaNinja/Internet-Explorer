package com.example.spacetraders.entities;
import java.io.Serializable;

/**
 * This class represents the coordinates of a solar system
 */
public class Coordinates implements Serializable {
    private final int x;
    private final int y;

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

    /**
     * getter for x
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * getter for y
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Finds the distance between two 2D coordinates
     *
     * @param c The other coordinates
     * @return the integer distance
     */
    public int dist(Coordinates c) {
        return (int) Math.sqrt(((this.x - c.getX()) * (this.x - c.getX())) + ((this.y - c.getY())
                * (this.y - c.getY())));
    }

    /**
     * hashCode method
     *
     * @return the hashcode
     */
    public int hashCode() {
        int tmp = y + ((x + 1) / 2);
        return x + (tmp * tmp);
    }

    /**
     * isEqual method
     *
     * @param obj some other object
     * @return if they are the same coordinates
     */
    public boolean equals(Object obj) {
        return (obj instanceof Coordinates) && (((Coordinates) obj).getX() == this.x)
                && (((Coordinates) obj).getY() == this.y);
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
