package com.example.spacetraders.entities;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * This class represents the player's ship
 */

public class Ship {
    /** type of ship*/
    private ShipType type;
    private EnumMap<ShopGoods, ArrayList<Integer>> cargo;
    private int inventory;

    /**
     * Constructor for the ship
     *
     * @param type   type of ship
     */
    public Ship(ShipType type) {
        this.type = type;
        cargo = null;
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

    public EnumMap<ShopGoods, ArrayList<Integer>> getCargo() { return cargo; }

    public void addCargo(ShopGoods good, int amount, int price) {
        if (cargo.get(good) == null) {
            ArrayList<Integer> item = new ArrayList<>();
            item.add(amount);
            item.add(price);
            cargo.put(good, item);
        } else {
            int currAmt = cargo.get(good).get(0);
            int currPrc = cargo.get(good).get(1);
            int avgPrc = currAmt * currPrc;
            avgPrc += amount * price;
            avgPrc /= (amount + currAmt);
            ArrayList<Integer> item = new ArrayList<>();
            item.add(currAmt + amount);
            item.add(avgPrc);
            cargo.put(good, item);
        }
    }

    public void removeCargo(ShopGoods good, int amount, int price) {
        if (cargo.get(good) == null) {
            return;
        }
        int currAmt = cargo.get(good).get(0);
        int currPrc = cargo.get(good).get(1);
        int avgPrc = currAmt * currPrc;
        avgPrc -= amount * price;
        avgPrc /= (currAmt - amount);
        ArrayList<Integer> item = new ArrayList<>();
        item.add(currAmt - amount);
        item.add(avgPrc);
        cargo.put(good, item);
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