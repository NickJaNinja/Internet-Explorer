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

    // array list with price & stock

    public Shop(TechLevel techLevel, ResourcesLevel resourcesLevel) {
        this.techLevel = techLevel;
        this.resourcesLevel = resourcesLevel;
        shopGoodsStockMap = new EnumMap<ShopGoods, ShopEntry>(ShopGoods.class);
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
     */
    public void decreaseStock(ShopGoods good, int amount) {
        ShopEntry e = shopGoodsStockMap.get(good);
        e.setStock(e.getStock() - amount);
    }


}
