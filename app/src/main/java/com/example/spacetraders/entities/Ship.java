package com.example.spacetraders.entities;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * This class represents the player's ship
 */

public class Ship {
    /** type of ship*/
    private ShipType type;
    private EnumMap<ShopGoods, ShopEntry> cargo;
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

    public EnumMap<ShopGoods, ShopEntry> getCargo() { return cargo; }

    public void addCargo(ShopGoods good, int amount, int price) {
        if (cargo.get(good) == null) {
            cargo.put(good, new ShopEntry(good, amount, price));
        } else {
            ShopEntry item = cargo.get(good);
            int currAmt = item.getStock();
            int currPrc = item.getPrice();
            int avgPrc = currAmt * currPrc;
            avgPrc += amount * price;
            avgPrc /= (amount + currAmt);
            item.setStock(currAmt + amount);
            item.setPrice(avgPrc);
            cargo.put(good, item);
        }
    }

    public void removeCargo(ShopGoods good, int amount, int price) {
        if (cargo.get(good) == null) {
            return;
        }
        ShopEntry item = cargo.get(good);
        int currAmt = item.getStock();
        int currPrc = item.getPrice();
        int avgPrc = currAmt * currPrc;
        avgPrc -= amount * price;
        avgPrc /= (currAmt - amount);
        item.setStock(currAmt - amount);
        item.setPrice(avgPrc);
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