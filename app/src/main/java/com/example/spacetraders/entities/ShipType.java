package com.example.spacetraders.entities;

/**
 * This class represents the various spaceships
 */
public enum ShipType {
    FLEA("Flea"), GNAT("Gnat"), FIREFLY("Firefly"), MOSQUITO("Mosquito"), BUMBLEBEE("Bumblebee"),
    BEETLE("Beetle"), HORNET("Hornet"), GRASSHOPPER("Grasshopper"), TERMITE("Termite"), WASP("Wasp");

    private final String name;
    private final int numWeapons;
    private final int numShields;
    private final int numGadgets;
    private final int numCargoHolds;
    private final int maxRange;

    /**
     * Constructor for the enumeration
     *
     * @param name   name of ship type
     */
    ShipType(String name) {
        this.name = name;
        /*this.numWeapons = numWeapons;
        this.numShields = numShields;
        this.numGadgets = numGadgets;
        this.numCargoHolds = numCargoHolds;
        this.maxRange = maxRange;*/
    }

    /**
     *
     * @return the display string representation of the shiptype
     */
    public String toString() { return name; }
}
