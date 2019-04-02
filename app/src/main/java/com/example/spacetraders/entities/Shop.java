package com.example.spacetraders.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

public class Shop implements Serializable {
    private EnumMap<ShopGoods, ShopEntry> shopGoodsStockMap;
    private TechLevel techLevel;
    private ResourcesLevel resourcesLevel;
    private PoliticalSystem politicalSystem;
    private RadicalPriceEvent randomEvent;
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
    public void restock() {
        Random rng = new Random();
        double eventChance = rng.nextDouble();
        int event = rng.nextInt(NUM_RESOURCES);  // 0 to (Number of resources)-1

        for (ShopGoods shopGood : ShopGoods.values()) {
            // Calculate price

            double divide = 100.0;


            int itemPrice = (shopGood.getBasePrice() + shopGood.getIpl()
                    * (techLevel.getLevel() - shopGood.getLevelofMtlp()));
            int var = (int)(rng.nextInt(shopGood.getVar() + 1) / divide);
            if (rng.nextInt(2) == 0) {
                itemPrice += var;
            } else {
                itemPrice -= var;
            }
            // Interesting events
            if (shopGood.getCr().equals(resourcesLevel)) {
                itemPrice = (int)(itemPrice * 0.8);
            } else if (shopGood.getEr().equals(resourcesLevel)) {
                itemPrice = (int)(itemPrice / 0.8);
            }
            if (event == shopGood.ordinal() && eventChance < 0.03) {
                itemPrice *= 5;
                randomEvent = shopGood.getIe();
            }
            // Stock items
            if (techLevel.getLevel() > shopGood.getLevelofMtlp()) {
                // Item will be in stock
                int itemStock = rng.nextInt(5051 - shopGood.getBasePrice())/125;
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
     */
    public int decreaseStock(ShopGoods good, int amount) {
        ShopEntry e = shopGoodsStockMap.get(good);
        int newAmount = e.getStock() - amount;
        if (newAmount < 0) {
            return 0;
        }
        shopGoodsStockMap.get(good).setStock(newAmount);
        return 1;
    }

    /**
     * Makes a list of the shop entries
     *
     * @return the shop entry list
     */
    public List<ShopEntry> getInventoryAsList() {
        List<ShopEntry> inv = new ArrayList<>();
        /*for (ShopEntry entry : shopGoodsStockMap.values()) {
            inv.add(entry);
        }*/
        inv.addAll(shopGoodsStockMap.values());
        return inv;
    }

    public RadicalPriceEvent getRandomEvent() {
        return randomEvent;
    }
}
