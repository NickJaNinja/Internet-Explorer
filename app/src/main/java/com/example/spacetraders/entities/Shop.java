package com.example.spacetraders.entities;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

public class Shop {
    private EnumMap<ShopGoods, ShopEntry> shopGoodsStockMap;
    private TechLevel techLevel;
    private ResourcesLevel resourcesLevel;
    private PoliticalSystem politicalSystem;
    private List<ShopEntry> inventory;

    // array list with price & stock

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
        for (ShopGoods shopGood: ShopGoods.values()) {
            if (techLevel.getLevel() > shopGood.getMtlp().getLevel()) {
                int itemPrice = shopGood.getBasePrice() + shopGood.getIpl()
                        * (techLevel.getLevel() - shopGood.getMtlp().getLevel())
                        + shopGood.getBasePrice()
                        * (new Random()).nextInt(shopGood.getVar() + 1);
                int itemStock = new Random().nextInt(5051 - shopGood.getBasePrice()) + 10;
                shopGoodsStockMap.put(shopGood, new ShopEntry(shopGood, itemStock, itemPrice));
            }
        }
    }

    /**
     * Decreases stock of good by amount
     *
     * @param good the good to decrease stock
     * @param amount the amount to decrease
     */
    public void decreaseStock(ShopGoods good, int amount) {
        ShopEntry e = shopGoodsStockMap.get(good);
        e.setStock(e.getStock() - amount);
    }

    /**
     * Makes a list of the shop entries
     *
     * @return the shop entry list
     */
    public List<ShopEntry> getInventoryAsList() {
        List<ShopEntry> inv = new ArrayList<>();
        for (ShopEntry entry : shopGoodsStockMap.values()) {
            inv.add(entry);
        }
        return inv;
    }
}
