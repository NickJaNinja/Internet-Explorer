package com.example.spacetraders.entities;

import java.util.ArrayList;
import java.util.List;

public class ShopEntry {
    private ShopGoods good;
    private int stock;
    private int price;

    public ShopEntry(ShopGoods g, int s, int p) {
        this.good = g;
        this.stock = s;
        this.price = p;
    }

    public ShopGoods getGood() { return good; }

    public void setGood(ShopGoods good) { this.good = good; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public int getStock() { return stock; }

    public void setStock(int amount) { this.stock = amount; }

    /**
     * Makes this object into a list of Strings
     * -name
     * -stock
     * -price
     *
     * @return The list of strings of instance data
     */
    public List<String> toStringList() {
        List<String> list = new ArrayList<>();
        list.add(good.getName());
        list.add(Integer.toString(stock));
        list.add(Integer.toString(price));
        return list;
    }


}