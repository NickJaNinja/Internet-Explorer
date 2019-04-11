package com.example.spacetraders;

import com.example.spacetraders.entities.ResourcesLevel;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.TechLevel;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Restock test
**/

public class RestockTest {

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
                Assert.assertNotEquals(entry.getStock(), 0);
        }
        for (ShopEntry entry : inv2) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            Assert.assertNotEquals(entry.getStock(), 0);
        }
        shop1.restock();
        shop2.restock();
        inv1 = shop1.getInventoryAsList();
        inv2 = shop2.getInventoryAsList();
        for (ShopEntry entry : inv1) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            if ("Water".equals(entry.getGood().getName()) || "Furs".equals(entry.getGood().getName()))
                Assert.assertNotEquals(entry.getStock(), 0);
        }
        for (ShopEntry entry : inv2) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            Assert.assertNotEquals(entry.getStock(), 0);
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
            Assert.assertNotEquals(entry.getPrice(), 0);
            if (!"Water".equals(entry.getGood().getName()) && !"Furs".equals(entry.getGood().getName()))
                Assert.assertEquals(entry.getStock(), 0);
        }
        for (ShopEntry entry : inv2) {
            Assert.assertNotEquals(entry.getPrice(), 0);
            Assert.assertNotEquals(entry.getStock(), 0);
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

