package com.example.spacetraders;

import com.example.spacetraders.entities.ResourcesLevel;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.TechLevel;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Restock test
**/

public class RestockTest {
    Random rn = new Random();

    @Test
    public void priceVarianceTest() {
        System.out.println("---- Price Variance Test -----");
        rn.setSeed(0);
        Shop shop = new Shop(TechLevel.AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);
        List<Integer> price = new ArrayList<>();
        List<Integer> price2 = new ArrayList<>();
        for (ShopEntry entry : shop.getInventoryAsList()) {
            price.add(entry.getPrice());
        }
        rn.setSeed(1);
        shop.restock();
        for (ShopEntry entry : shop.getInventoryAsList()) {
            price2.add(entry.getPrice());
        }
        for (int i = 0; i < price.size(); i++) {
            System.out.println("Price 1: " + price.get(i) + "\t  Price 2: " + price2.get(i));
            Assert.assertTrue(price.get(i) >= price2.get(i));
        }
    }

    @Test
    public void itemInStockTest() {
        System.out.println("----- Item in Stock Test -----");
        // Test if stock > 0 for items
        Shop shop1 = new Shop(TechLevel.AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);
        Shop shop2 = new Shop(TechLevel.HI_TECH,     ResourcesLevel.LIFELESS);
        List<ShopEntry> inv1 = shop1.getInventoryAsList();
        List<ShopEntry> inv2 = shop2.getInventoryAsList();
        for (ShopEntry entry : inv1) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            if ("Water".equals(entry.getGood().getName()) || "Furs".equals(entry.getGood().getName()))
                Assert.assertTrue(entry.getStock() > 0);
            else {
                Assert.assertTrue(entry.getStock() == 0);
            }
        }
        for (ShopEntry entry : inv2) {
            Assert.assertTrue(entry.getPrice() > 0);
            Assert.assertTrue(entry.getStock() > 0);
        }
        shop1.restock();
        shop2.restock();
        inv1 = shop1.getInventoryAsList();
        inv2 = shop2.getInventoryAsList();
        for (ShopEntry entry : inv1) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            if ("Water".equals(entry.getGood().getName()) || "Furs".equals(entry.getGood().getName()))
                Assert.assertTrue(entry.getStock() > 0);
            else {
                Assert.assertTrue(entry.getStock() == 0);
            }
        }
        for (ShopEntry entry : inv2) {
            Assert.assertTrue(entry.getPrice() > 0);
            Assert.assertTrue(entry.getStock() > 0);
        }
    }

    @Test
    public void itemNotInStockTest() {
        System.out.println("--- Item not in Stock Test ---");
        // Test if stock > 0 for items
        Shop shop1 = new Shop(TechLevel.AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);
        Shop shop2 = new Shop(TechLevel.HI_TECH,     ResourcesLevel.LIFELESS);
        List<ShopEntry> inv1 = shop1.getInventoryAsList();
        List<ShopEntry> inv2 = shop2.getInventoryAsList();
        for (ShopEntry entry : inv1) {
            Assert.assertTrue(entry.getPrice() > 0);
            if (!"Water".equals(entry.getGood().getName()) && !"Furs".equals(entry.getGood().getName()))
                Assert.assertEquals(entry.getStock(), 0);
        }
        for (ShopEntry entry : inv2) {
            Assert.assertTrue(entry.getPrice() > 0);
            Assert.assertTrue(entry.getStock() > 0);
        }
        inv1 = shop1.getInventoryAsList();
        inv2 = shop2.getInventoryAsList();
        for (ShopEntry entry : inv1) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            if (!"Water".equals(entry.getGood().getName()) && !"Furs".equals(entry.getGood().getName()))
                Assert.assertEquals(entry.getStock(), 0);
        }
        for (ShopEntry entry : inv2) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            Assert.assertNotEquals(entry.getStock(), 0);
        }
    }
}

