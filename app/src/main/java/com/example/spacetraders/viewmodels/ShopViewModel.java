package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class ShopViewModel extends AndroidViewModel {



    public ShopViewModel(@NonNull Application app) { super(app); }

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

}
