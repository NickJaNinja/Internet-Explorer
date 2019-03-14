package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
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

    /***
     * check if the player have enough money and cargo hold for buying the good
     * @param price, the price of a good
     * @param creditRemaining, the player's remaining money
     * @param cargoHoldRemaining, the remaining cargoHolds in the ship
     * @return true if purchase is allowed
     */
    public boolean onBuy(int price, int creditRemaining, int cargoHoldRemaining) {
        if (price > creditRemaining) {
            return false;
        }

        if (cargoHoldRemaining <= 0) {
            return false;
        }

        return true;
    }

    /**
     * check if the selected good to sell is in play's cargo
     * @param good, the good to be sold
     * @param goodsInCargo list of all goods in play's cargo
     * @return true if cargo contains the good to be sold, transaction is allowed
     */
    public boolean onSell(ShopGoods good, List<ShopGoods> goodsInCargo) {
        for (int i = 0; i < goodsInCargo.size(); i++) {
            if (good == goodsInCargo.get(i)) {
                return true;
            }
        }
        return false;
    }

    public void setUpShop() {
        shopInventoryTemp = getShopEntries();
    }

    public void addItemToPlayerInventoryTemp(ShopEntry shopEntry) {
        playerInventoryTemp.add(shopEntry);
    }

    public void addItemToShopInventoryTemp(ShopEntry shopEntry) {
        shopInventoryTemp.add(shopEntry);
    }

    /**
     *  Takes in a shop and finds the items in its stock
     * @param shop the shop to get the inventory of
     * @return a list of shop entries
     */
    public List<ShopEntry> getShopEntries() {
        return model.getShopEntries(shop);
    }

    public void setShopEntriesToTemp() {

    }

    public void setShop(Shop s) {
        shop = s;
    }

    public Shop getShop() {
        return shop;
    }
}
