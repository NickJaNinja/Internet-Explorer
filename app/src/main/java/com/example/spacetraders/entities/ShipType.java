package com.example.spacetraders.entities;

import java.io.Serializable;

/**
 * This enum represents the various spaceship types
 */
public enum ShipType {
    // --Commented out by Inspection (4/2/19, 11:03 PM):FLEA("Flea", 0, 0, 0, 2, 20, 0),
// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    GNAT("Gnat", 1, 0, 1, 15, 14, 0),
//    // --Commented out by Inspection (4/2/19, 11:03 PM):FIREFLY("Firefly", 1, 1, 1, 20, 17, 0),
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
    MOSQUITO("Mosquito", 2, 1, 1, 14, 13, 0), //"strong hull"
// --Commente// --Commented out by Inspection (4/2/19, 11:03 PM):d out// --Commented out by Inspection (4/2/19, 11:03 PM): by Inspection START (4/2/19, 11:03 PM):
//// --Commented out by Inspection START (4/2/19, 11:03 PM):
////    // --Commented out by Inspection (4/2/19, 11:03 PM):BUMBLEBEE("Bumblebee", 1, 2, 2, 20, 15, 1),//"same hull as firefly"
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
//    // --Commented out by Inspection (4/2/19, 11:03 PM):BEETLE("Beetle", 0, 1, 1, 50, 14, 3),//weak hull
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
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
     * @param name name of ship type
     */
    ShipType(String name, int numWeapons, int numShields, int numGadgets, int numCargoHolds,
             int fuel, int numCrew) {
        this.name = name;
// --Commented out by Inspection START (4/2/19, 11:03 PM):
//        this.numWeapons = numWeapons;
//        this.numShields = numShields;
// --Commented out by Inspection START (4/2/19, 11:03 PM):
////        this.numGadgets = numGadgets;
////        this.numCargoHolds = numCargoHolds;
//// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
// --Commented out by Inspection START (4/2/19, 11:03 PM):
//        this.fuel = fuel;
//        this.numCrew = numCrew;
//    }
//
//    /**
//     * getter for name
//     *
//     * @return name
//     */
//// --Commented out by Inspection START (4/2/19, 11:03 PM):
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * getter for numWeapons
//     *
//     * @return numWeapons
//     */
//    public int getNumWeapons() {
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
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
// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    public int getNumGadgets() {
//        return numGadgets;
//    }
//
//    /**
//     * getter for numCargoHolds
//     *
//     * @return numCargoHolds
//     */
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
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
     * @return the display string representation of the ship type
     */
    public String toString() {
        return name;
    }
}
