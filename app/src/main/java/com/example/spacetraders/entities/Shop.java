package com.example.spacetraders.entities;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

public class Shop {
    private EnumMap<ShopGoods, ArrayList<Integer>> shopGoodsStockMap;
    private TechLevel techLevel;
    private ResourcesLevel resourcesLevel;
    private PoliticalSystem politicalSystem;

    // array list with price & stock

    public Shop(TechLevel techLevel, ResourcesLevel resourcesLevel) {
        this.techLevel = techLevel;
        this.resourcesLevel = resourcesLevel;
        for (ShopGoods shopGood: ShopGoods.values()) {
            if (techLevel.getLevel() > shopGood.getMtlp().getLevel()) {
                ArrayList<Integer> priceNStock = new ArrayList<>();
                int finalPriceOfDaniel = shopGood.getBasePrice() + shopGood.getIpl() * (techLevel.getLevel() - shopGood.getMtlp().getLevel()) + shopGood.getBasePrice() * (new Random()).nextInt(shopGood.getVar() + 1);
                int stock = 50;
                priceNStock.add(finalPriceOfDaniel);
                priceNStock.add(stock);
                shopGoodsStockMap.put(shopGood, priceNStock);
            }

        }
    }



}
