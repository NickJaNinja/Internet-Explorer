package com.example.spacetraders.entities;

/**
 * This class represents the various spaceships
 */
public enum ShipType {
    FLEA("Flea"), GNAT("Gnat"), FIREFLY("Firefly"), MOSQUITO("Mosquito"), BUMBLEBEE("Bumblebee"),
    BEETLE("Beetle"), HORNET("Hornet"), GRASSHOPPER("Grasshopper"), TERMITE("Termite"), WASP("Wasp");

    private String name;
    /*
    private int numWeapons;
    private int numShields;
    private int numGadgets;
    private int numCargoHolds;
    private int maxRange;
    */

    /**
     * Constructor for the enumeration
     *
     * @param name   name of ship
     */
    Spaceship(String name) {
        this.name = name;
        /*this.numWeapons = numWeapons;
        this.numShields = numShields;
        this.numGadgets = numGadgets;
        this.numCargoHolds = numCargoHolds;
        this.maxRange = maxRange;*/
    }

    /**
     *
     * @return the display string representation of the course
     */
    public String toString() { return name; }
}
