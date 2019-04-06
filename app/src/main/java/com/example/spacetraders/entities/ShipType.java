package com.example.spacetraders.entities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * This enum represents the various spaceship types
 */
public enum ShipType {
    FLEA("Flea", 0, 0, 0, 2, 70, 0, 1000),
    GNAT("Gnat", 1, 0, 1, 15, 14, 0, 5000),
    FIREFLY("Firefly", 1, 1, 1, 20, 17, 0, 10000),
    MOSQUITO("Mosquito", 2, 1, 1, 14, 13, 0, 15000), //"strong hull"
    HORNET("Hornet", 3, 2, 1, 20, 16, 2, 20000), //strong hull
    GRASSHOPPER("Grasshopper", 2, 2, 3, 30, 15, 3, 30000),
    TERMITE("Termite", 1, 3, 2, 60, 13, 3, 50000),//strong hull
    WASP("Wasp", 3, 2, 2, 35, 14, 3, 100000);//strong hull

    private final String name;
    private final int numWeapons;
    private final int numShields;
    private final int numGadgets;
    private final int numCargoHolds;
    private final int fuel;
    private final int numCrew;
    private final int cost;

    /**
     * Constructor for the enumeration
     *
     * @param name name of ship type
     */
    ShipType(String name, int numWeapons, int numShields, int numGadgets, int numCargoHolds,
             int fuel, int numCrew, int cost) {
        this.name = name;
        this.numWeapons = numWeapons;
        this.numShields = numShields;
        this.numGadgets = numGadgets;
        this.numCargoHolds = numCargoHolds;
        this.fuel = fuel;
        this.numCrew = numCrew;
        this.cost = cost;
    }

    /**
     * getter for name
     *
     * @return name
     */
    @Nullable
    public String getName() {
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
     * getter for cost
     *
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    public @Nullable List<ShipType> getShipsBasedOnTechLevel(@Nullable TechLevel techLevel) {
        List<ShipType> ships = new LinkedList<>();
        ShipType[] shipTypes = ShipType.values();
        int techLevelNum = 0;
        if (techLevel != null) {
            techLevelNum = techLevel.getLevel();
        }
        for (int i = techLevelNum; i != 0; i--) {
            ships.add(shipTypes[techLevelNum - i]);
        }

        return ships;
    }


    /**
     * @return the display string representation of the ship type
     */
    @Override
    @NonNull
    //remove + numGadgets + numCrew + numShields + numWeapons later
    public String toString() {
        return name + numGadgets + numCrew + numShields + numWeapons;
    }
}
