package com.example.spacetraders.entities;

/**
 * This class represents the player's ship
 */

public class Ship {
    /** type of ship*/
    private ShipType type;

    /**
     * Constructor for the ship
     *
     * @param type   type of ship
     */
    public Ship(ShipType type) {
        this.type = type;
    }

    /**
     * getter for ship type
     *
     * @return  type of ship
     */
    public ShipType getShipType() {
        return type;
    }

}