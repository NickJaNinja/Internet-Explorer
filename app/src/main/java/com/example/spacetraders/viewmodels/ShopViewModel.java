package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.models.Model;

import java.util.List;

/**
 * shop view model
 */
public class ShopViewModel extends AndroidViewModel {

    private final Model model;
    //private List<ShopEntry> shopInventoryTemp;
    // private List<ShopEntry> playerInventoryTemp;
    //private Shop shop;

    /**
     * shop view model
     *
     * @param app application
     */
    public ShopViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
    }

    /*
     * initializes content_market
     */
    /*public void setUpMarket() {
        //shopInventoryTemp = getShopEntries();
        //playerInventoryTemp = getPlayerEntries();
    }*/

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * add item to player inventory temp
//     *
//     * @param shopEntry shop entry
//     */
// --Commented out by Inspection START (4/2/19, 11:03 PM):
////    public void addItemToPlayerInventoryTemp(ShopEntry shopEntry) {
////        playerInventoryTemp.add(shopEntry);
////    }
//// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
//
//    /**
//     * add item to shop inventory temp
//     *
//     * @param shopEntry shop entry
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
//     */
//    public void addItemToShopInventoryTemp(ShopEntry shopEntry) {
//        shopInventoryTemp.add(shopEntry);
//    }

    /**
     * Takes in a shop and finds the items in its stock
     *
     * @return a list of shop entries
     */
    @Nullable
    public List<ShopEntry> getShopEntries() {
        return model.getShopEntries();
    }

    /**
     * get shop entries filtered
     *
     * @return list of shop entries filtered
     */
    @Nullable
    public List<ShopEntry> getShopEntriesFiltered() {
        return model.getShopEntriesFiltered();
    }

    /**
     * get player entries
     *
     * @return list of player entries
     */
    @Nullable
    public List<ShopEntry> getPlayerEntries() {
        return model.getPlayerEntries();
    }

}
