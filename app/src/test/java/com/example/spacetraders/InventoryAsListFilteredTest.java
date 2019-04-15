package com.example.spacetraders;

import org.junit.Assert;
import org.junit.Test;

import com.example.spacetraders.entities.ResourcesLevel;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.TechLevel;

import java.util.List;

public class InventoryAsListFilteredTest {

    /**
     * no entries with zero stock in filtered list
     */
    @Test
    public void noZeroStockInFilteredListTest() {
        Shop shop = new Shop(TechLevel.PRE_AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);

        List<ShopEntry> listFiltered = shop.getInventoryAsListFiltered();

        for (int i = 0; i < listFiltered.size(); i++) {
            Assert.assertNotEquals(0, listFiltered.get(i).getStock());
        }
    }

    /**
     * all entries in unfiltered list have zero stock
     */
    @Test
    public void allZeroStockTest() {
        Shop shop = new Shop(TechLevel.PRE_AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);

        List<ShopEntry> listUnfiltered = shop.getInventoryAsList();

        for (int i = 0; i < listUnfiltered.size(); i++) {
            if (listUnfiltered.get(i).getStock() != 0) {
                listUnfiltered.get(i).setStock(0);
            }
        }

        List<ShopEntry> listFiltered = shop.getInventoryAsListFiltered();

        for (int i = 0; i < listUnfiltered.size(); i++) {
            for (int j = 0; j < listFiltered.size(); j++) {
                if (listUnfiltered.get(i).getGood() == listFiltered.get(i).getGood() &&
                        listUnfiltered.get(i).getStock() != 0) {
                    Assert.assertEquals(listUnfiltered.get(i).getStock(), listFiltered.get(i).getStock());
                    Assert.assertEquals(listUnfiltered.get(i).getPrice(), listFiltered.get(i).getPrice());
                }
            }
        }
    }

    /**
     * no entries in unfiltered list have zero stock
     */
    @Test
    public void noZeroStockTest() {
        Shop shop = new Shop(TechLevel.PRE_AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);

        List<ShopEntry> listUnfiltered = shop.getInventoryAsList();

        for (int i = 0; i < listUnfiltered.size(); i++) {
            if (listUnfiltered.get(i).getStock() == 0) {
                listUnfiltered.get(i).setStock(1);
            }
        }

        List<ShopEntry> listFiltered = shop.getInventoryAsListFiltered();

        for (int i = 0; i < listUnfiltered.size(); i++) {
            for (int j = 0; j < listFiltered.size(); j++) {
                if (listUnfiltered.get(i).getGood() == listFiltered.get(i).getGood() &&
                        listUnfiltered.get(i).getStock() != 0) {
                    Assert.assertEquals(listUnfiltered.get(i).getStock(), listFiltered.get(i).getStock());
                    Assert.assertEquals(listUnfiltered.get(i).getPrice(), listFiltered.get(i).getPrice());
                }
            }
        }
    }
}
