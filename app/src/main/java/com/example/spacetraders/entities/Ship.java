package com.example.spacetraders.entities;

import java.util.EnumMap;

/**
 * This class represents the player's ship
 */

public class Ship {
    /** type of ship*/
    private ShipType type;
    private EnumMap<ShopGoods, Integer> cargo;
    private int inventory;

    /**
     * Constructor for the ship
     *
     * @param type   type of ship
     */
    public Ship(ShipType type) {
        this.type = type;
        inventory = 0;
    }

    /**
     * getter for ship type
     *
     * @return  type of ship
     */
    public ShipType getShipType() {
        return type;
    }

    public int getInventory() { return inventory; }

    public EnumMap<ShopGoods, Integer> getCargo() { return cargo; }

    public void addCargo(ShopGoods good, int amount) {
        int remaining = type.getNumCargoHolds() - inventory;
        if (cargo.get(good) == null) {
            if (amount <= remaining) {
                cargo.put(good, amount);
            }
        } else {
            int curr = cargo.get(good);
            curr += amount;
            cargo.put(good, curr);
        }
    }

    /**
     * to string for ship
     *
     * @return string of ship
     */
    @Override
    public String toString() {
        return "Ship{" +
                "type=" + type +
                '}';
    }
}