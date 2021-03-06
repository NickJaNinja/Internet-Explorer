package com.example.spacetraders.entities;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import java.util.Random;

/**
 * shop class
 */
public class Shop implements Serializable {
    private final EnumMap<ShopGoods, ShopEntry> shopGoodsStockMap;
    private final TechLevel techLevel;
    private final ResourcesLevel resourcesLevel;
    //private RadicalPriceEvent randomEvent;
    private final int NUM_RESOURCES = ShopGoods.values().length;

    /**
     * Constructor for shop
     *
     * @param techLevel      the tech level
     * @param resourcesLevel the resources level
     */
    public Shop(TechLevel techLevel, ResourcesLevel resourcesLevel) {
        this.techLevel = techLevel;
        this.resourcesLevel = resourcesLevel;
        shopGoodsStockMap = new EnumMap<>(ShopGoods.class);
        restock();
    }

    /**
     * Generates quantity and price for all goods in the shop
     */
    public final void restock() {
        Random rng = new Random();
        double eventChance = rng.nextDouble();
        int event = rng.nextInt(NUM_RESOURCES);  // 0 to (Number of resources)-1

        for (ShopGoods shopGood : ShopGoods.values()) {
            // Calculate price
            final double DIVIDE = 100.0;
            final double PRICE_CONSTANT = 0.8;
            final double EVENT_CHANCE = 0.03;
            final int BOUND = 5601;
            final int STOCK_DIVIDE = 125;

            int itemPrice = (shopGood.getBasePrice() + (shopGood.getIpl()
                    * (techLevel.getLevel() - shopGood.getLevelofMtlp())));
            int var = (int)(rng.nextInt(shopGood.getVar() + 1) / DIVIDE);
            if (rng.nextInt(2) == 0) {
                itemPrice += var;
            } else {
                itemPrice -= var;
            }
            // Interesting events to change shop good price
            if (shopGood.getCr() != null && shopGood.getCr().equals(resourcesLevel)) {
                itemPrice = (int)(itemPrice * PRICE_CONSTANT);
            } else if (shopGood.getEr() != null && shopGood.getEr().equals(resourcesLevel)) {
                itemPrice = (int)(itemPrice / PRICE_CONSTANT);
            }
            if ((event == shopGood.ordinal()) && (eventChance < EVENT_CHANCE)) {
                int temp = itemPrice;
                itemPrice *= 5;
                //randomEvent = shopGood.getIe();
                Log.d("Info", "PRICE EVENT. Prices 5x higher for: " + shopGood.getName()
                        + temp + "," + itemPrice);
            }
            // Stock items
            if (techLevel.getLevel() > shopGood.getLevelofMtlp()) {
                // Item will be in stock
                int itemStock = rng.nextInt(BOUND - shopGood.getBasePrice())/STOCK_DIVIDE;
                if (itemStock <= 0) {
                    itemStock = 1;
                }
                shopGoodsStockMap.put(shopGood, new ShopEntry(shopGood, itemStock, itemPrice));
            } else {
                // Item will not be in stock
                shopGoodsStockMap.put(shopGood, new ShopEntry(shopGood, 0, itemPrice));
            }
        }
    }

    /**
     * Decreases stock of good by amount
     *
     * @param good   the good to decrease stock
     * @param amount the amount to decrease
     * @return 1 if decreased stock
     */
    public int decreaseStock(ShopGoods good, int amount) {
        ShopEntry e = shopGoodsStockMap.get(good);

        int newAmount;
        if (e != null) {
            newAmount = e.getStock() - amount;
            if (newAmount < 0) {
                return 0;
            } else {
                e.setStock(newAmount);
                return 1;
            }
        } else {
            return 0;
        }

        /*
        int newAmount = e.getStock() - amount;

        int newAmount = Objects.requireNonNull(e).getStock() - amount;

        if (newAmount < 0) {
            return 0;
        }
        shopGoodsStockMap.get(good).setStock(newAmount);
        return 1;
        */
    }

    /**
     * Makes a list of the shop entries
     *
     * @return the shop entry list
     */
    public List<ShopEntry> getInventoryAsList() {
        /*for (ShopEntry entry : shopGoodsStockMap.values()) {
            inv.add(entry);
        }*/
        return new ArrayList<>(shopGoodsStockMap.values());
    }

    /**
     * get inventory as list filtered
     *
     * @return list of shop entry
     */
    public List<ShopEntry> getInventoryAsListFiltered() {
        List<ShopEntry> inv = new ArrayList<>();
        for (ShopEntry entry : shopGoodsStockMap.values()) {
            if (entry.getStock() >= 1) {
                inv.add(entry);
            }
        }
        return inv;
    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * get random event
//     *
//     * @return radical price event
//     */
//    public RadicalPriceEvent getRandomEvent() {
//        return randomEvent;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
}
