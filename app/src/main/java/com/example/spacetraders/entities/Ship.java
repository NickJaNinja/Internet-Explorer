package com.example.spacetraders.entities;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * This class represents the player's ship
 */

public class Ship {
    private ShipType type;
    private EnumMap<ShopGoods, ShopEntry> cargo;
    private int inventory;

    /**
     * Constructor for the ship
     *
     * @param type type of ship
     */
    public Ship(ShipType type) {
        this.type = type;
        cargo = new EnumMap<ShopGoods, ShopEntry>(ShopGoods.class);
        inventory = 0;
    }

    /**
     * getter for ship type
     *
     * @return type of ship
     */
    public ShipType getShipType() {
        return type;
    }

    public int getInventory() {
        return inventory;
    }

    public EnumMap<ShopGoods, ShopEntry> getCargo() {
        return cargo;
    }

    /**
     * Add good of a certain amount to cargo, where each good is at a certain price
     * Amount * Price = Total $ of the transaction
     * This method also does nothing and returns 0 if the transaction does not occur
     *
     * @param good   the good to be transacted
     * @param amount amount of the good
     * @param price  price of each good
     * @return 1 if occurred, 0 if failed
     */
    public int addCargo(ShopGoods good, int amount, int price) {
        //if (cargo.get(good) == null) { return 0; }
        if (inventory + amount > type.getNumCargoHolds()) {
            return 0;
        }
        if (cargo.get(good) == null) {
            cargo.put(good, new ShopEntry(good, amount, price));
        } else {
            ShopEntry item = cargo.get(good);
            int currAmt = item.getStock();
            if (currAmt + amount <= 0) {
                cargo.remove(good);
                inventory += amount;
                return 1;
            }
            int currPrc = item.getPrice();
            int avgPrc = currAmt * currPrc;
            avgPrc += amount * price;
            avgPrc /= (amount + currAmt);
            item.setStock(currAmt + amount);
            item.setPrice(avgPrc);
            inventory += amount;
            cargo.put(good, item);
        }
        return 1;
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

    /**
     * Makes a list of the shop entries in player's cargo
     *
     * @return the shop entry list in player's cargo
     */
    public List<ShopEntry> getInventoryCargo() {
        List<ShopEntry> inv = new ArrayList<>();
        for (ShopEntry entry : cargo.values()) {
            inv.add(entry);
        }
        return inv;
    }
}