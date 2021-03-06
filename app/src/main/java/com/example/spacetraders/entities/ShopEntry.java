package com.example.spacetraders.entities;

import android.support.annotation.Nullable;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;

/**
 * shop entry class
 */
public class ShopEntry implements Serializable {
    private final ShopGoods good;
    private int stock;
    private int price;

    /**
     * Constructor for shop entry
     *
     * @param g the good
     * @param s the stock
     * @param p the price
     */
    public ShopEntry(@Nullable ShopGoods g, int s, int p) {
        this.good = g;
        this.stock = s;
        this.price = p;
    }

    /**
     * getter for good
     *
     * @return good
     */
    @Nullable
    public ShopGoods getGood() {
        return good;
    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * setter for good
//     *
//     * @param good the new good
//     */
//    public void setGood(ShopGoods good) {
//        this.good = good;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

    /**
     * getter for price
     *
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * setter for price
     *
     * @param price the new price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * getter for stock
     *
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * setter for stock
     *
     * @param amount the new stock
     */
    public void setStock(int amount) {
        this.stock = amount;
    }

//    /**
//     * Makes this object into a list of Strings
//     * -name
//     * -stock
//     * -price
//     *
//     * @return The list of strings of instance data
//     */
//    public List<String> toStringList() {
//        List<String> list = new ArrayList<>();
//        list.add(good.getName());
//        list.add((stock == 0) ? " - " : Integer.toString(stock));
//        list.add(Integer.toString(price));
//        return list;
//    }


}