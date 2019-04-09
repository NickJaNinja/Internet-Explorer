package com.example.spacetraders;

import android.view.Display;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.ResourcesLevel;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
import com.example.spacetraders.entities.TechLevel;
import com.example.spacetraders.models.Model;

import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

/**
 * Restock test
**/

class RestockTest {

    private Shop shop;
    private TechLevel techLevel;
    private ResourcesLevel resourceLevel;
    private EnumMap<ShopGoods, ShopEntry> shopGoodsStockMap;

    @Test
    public void CRTest() {

    }

    @Test
    public void ERTest() {

    }

    @Test
    public void itemInStockTest() {

    }

    @Test
    public void itemNotInStockTest() {

    }

    public void buildShop(TechLevel tl, ResourcesLevel rl) {
        shop = new Shop(tl, rl);
    }
}

