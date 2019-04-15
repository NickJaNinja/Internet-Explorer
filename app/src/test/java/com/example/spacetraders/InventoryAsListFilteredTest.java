package com.example.spacetraders;

import org.junit.Assert;
import org.junit.Test;

import com.example.spacetraders.entities.ResourcesLevel;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.TechLevel;

import java.util.List;

import static org.junit.Assert.*;

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
     * stock and price of unfiltered list matches filtered list
     */
    @Test
    public void unfilteredListSameAsFilteredListTest() {
        Shop shop = new Shop(TechLevel.PRE_AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);

        List<ShopEntry> listFiltered = shop.getInventoryAsListFiltered();
        List<ShopEntry> listUnfiltered = shop.getInventoryAsList();

        for (int i = 0; i < listUnfiltered.size(); i++) {
            if (listUnfiltered.get(i).getStock() != 0) {
                Assert.assertEquals(listUnfiltered.get(i).getStock(), listFiltered.get(i).getStock());
                Assert.assertEquals(listUnfiltered.get(i).getPrice(), listFiltered.get(i).getPrice());
            }
        }
    }

    /**
     * ensures no change when filtering a list without zero stock items
     */
    @Test
    public void noChangeFilteredList() {
        Shop shop = new Shop(TechLevel.PRE_AGRICULTURE, ResourcesLevel.NO_SPECIAL_RESOURCES);

        List<ShopEntry> listUnfiltered = shop.getInventoryAsList();

        for (int i = 0; i < listUnfiltered.size(); i++) {
            if (listUnfiltered.get(i).getStock() != 0) {
                listUnfiltered.get(i).setStock(1);
            }
        }

        List<ShopEntry> listFiltered = shop.getInventoryAsListFiltered();

        for (int i = 0; i < listUnfiltered.size(); i++) {
            if (listUnfiltered.get(i).getStock() != 0) {
                Assert.assertEquals(listUnfiltered.get(i).getStock(), listFiltered.get(i).getStock());
                Assert.assertEquals(listUnfiltered.get(i).getPrice(), listFiltered.get(i).getPrice());
            }
        }
    }

}
