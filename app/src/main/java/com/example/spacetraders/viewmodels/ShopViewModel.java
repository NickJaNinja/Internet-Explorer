package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.models.Model;

import java.util.List;

public class ShopViewModel extends AndroidViewModel {

    private Model model;
    private List<ShopEntry> shopInventoryTemp;
    private List<ShopEntry> playerInventoryTemp;
    private Shop shop;

    public ShopViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
    }

    /**
     * initializes content_market
     */
    public void setUpMarket() {
        shopInventoryTemp = getShopEntries();
        //playerInventoryTemp = getPlayerEntries();
    }

    public void addItemToPlayerInventoryTemp(ShopEntry shopEntry) {
        playerInventoryTemp.add(shopEntry);
    }

    public void addItemToShopInventoryTemp(ShopEntry shopEntry) {
        shopInventoryTemp.add(shopEntry);
    }

    /**
     * Takes in a shop and finds the items in its stock
     *
     * @return a list of shop entries
     */
    public List<ShopEntry> getShopEntries() {
        return model.getShopEntries();
    }

    
    public List<ShopEntry> getPlayerEntries() {
        return model.getPlayerEntries();
    }

    public void setMarketsEntriesToTemp() {

    }
}
