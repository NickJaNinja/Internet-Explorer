package com.example.spacetraders.entities

import java.util.LinkedList

/**
 * This enum represents the various spaceship types
 */
enum class ShipType
/**
 * Constructor for the enumeration
 *
 * @param name name of ship type
 */
private constructor(//strong hull

        /**
         * getter for name
         *
         * @return name
         */
        val name: String,
        /**
         * getter for numWeapons
         *
         * @return numWeapons
         */
        val numWeapons: Int,
        /**
         * getter for numShields
         *
         * @return numShields
         */
        val numShields: Int,
        /**
         * getter for numGadgets
         *
         * @return numGadgets
         */

        val numGadgets: Int,
        /**
         * getter for numCargoHolds
         *
         * @return numCargoHolds
         */

        val numCargoHolds: Int,
        /**
         * getter for fuel
         *
         * @return fuel
         */
        val fuel: Int,
        /**
         * getter for numCrew
         *
         * @return numCrew
         */
        val numCrew: Int,
        /**
         * getter for cost
         *
         * @return cost
         */
        val cost: Int) {
    FLEA("Flea", 0, 0, 0, 2, 70, 0, 1000),
    GNAT("Gnat", 1, 0, 1, 15, 14, 0, 5000),
    FIREFLY("Firefly", 1, 1, 1, 20, 17, 0, 10000),
    MOSQUITO("Mosquito", 2, 1, 1, 14, 13, 0, 15000), //"strong hull"
    HORNET("Hornet", 3, 2, 1, 20, 16, 2, 20000), //strong hull
    GRASSHOPPER("Grasshopper", 2, 2, 3, 30, 15, 3, 30000),
    TERMITE("Termite", 1, 3, 2, 60, 13, 3, 50000), //strong hull
    WASP("Wasp", 3, 2, 2, 35, 14, 3, 100000);

    /**
     *
     * @param techLevel tech level
     * @return lists of ships based on tech level
     */
    fun getShipsBasedOnTechLevel(techLevel: TechLevel?): List<ShipType> {
        val ships = LinkedList<ShipType>()
        val shipTypes = ShipType.values()
        var techLevelNum = 0
        if (techLevel != null) {
            techLevelNum = techLevel.level
        }
        for (i in techLevelNum downTo 1) {
            ships.add(shipTypes[techLevelNum - i])
        }

        return ships
    }


    /**
     * @return the display string representation of the ship type
     */
    override//remove + numGadgets + numCrew + numShields + numWeapons later
    fun toString(): String {
        return name + numGadgets + numCrew + numShields + numWeapons
    }
}
