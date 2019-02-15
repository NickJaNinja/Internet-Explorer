package com.example.spacetraders.entities;

/**
 * This class represents the various spaceships
 */
public enum ShipType {
    FLEA("Flea", 0, 0, 0, 2, 20, 0),
    GNAT("Gnat", 1, 0, 1, 15, 14, 0),
    FIREFLY("Firefly", 1, 1, 1, 20, 17, 0),
    MOSQUITO("Mosquito", 2, 1, 1, 14, 13, 0), //"strong hull"
    BUMBLEBEE("Bumblebee", 1, 2, 2, 20, 15, 1),//"same hull as firefly"
    BEETLE("Beetle", 0, 1, 1, 50, 14, 3),//weak hull
    HORNET("Hornet", 3, 2, 1, 20, 16, 2), //strong hull
    GRASSHOPPER("Grasshopper", 2, 2, 3, 30, 15, 3),
    TERMITE("Termite", 1, 3, 2, 60, 13, 3),//strong hull
    WASP("Wasp", 3, 2, 2, 35, 14, 3);//strong hull

    private final String name;
    private final int numWeapons;
    private final int numShields;
    private final int numGadgets;
    private final int numCargoHolds;
    private final int fuel;
    private final int numCrew;

    /**
     * Constructor for the enumeration
     *
     * @param name   name of ship type
     */
    ShipType(String name, int numWeapons, int numShields, int numGadgets, int numCargoHolds, int fuel, int numCrew) {
        this.name = name;
        this.numWeapons = numWeapons;
        this.numShields = numShields;
        this.numGadgets = numGadgets;
        this.numCargoHolds = numCargoHolds;
        this.fuel = fuel;
        this.numCrew = numCrew;
    }

    /**
     * getter for name
     *
     * @return name
     */
    public int getName() {
        return name;
    }

    /**
     * getter for numWeapons
     *
     * @return numWeapons
     */
    public int getNumWeapons() {
        return numWeapons;
    }

    /**
     * getter for numShields
     *
     * @return numShields
     */
    public int getNumShields() {
        return numShields;
    }

    /**
     * getter for numGadgets
     *
     * @return numGadgets
     */
    public int getNumGadgets() {
        return numGadgets;
    }

    /**
     * getter for numCargoHolds
     *
     * @return numCargoHolds
     */
    public int getNumCargoHolds() {
        return numCargoHolds;
    }

    /**
     * getter for fuel
     *
     * @return fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * getter for numCrew
     *
     * @return numCrew
     */
    public int getNumCrew() {
        return numCrew;
    }


    /**
     *
     * @return the display string representation of the shiptype
     */
    public String toString() { return name; }
}
