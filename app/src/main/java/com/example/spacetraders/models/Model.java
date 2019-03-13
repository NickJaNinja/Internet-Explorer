package com.example.spacetraders.models;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Player;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;

import java.util.List;

public class Model {
    private Game game;

    /** Singleton Pattern Code
     *  this allows us to get access to this class
     *  anywhere, which will allow our View models to access
     *  the "back end"  more easily
     */
    private static  Model instance = new Model();

    public static Model getInstance() { return instance; }

    /**
     * Creates a new game
     *
     * @param gd game difficulty
     * @param p player
     */
    public void createGame(GameDifficulty gd, Player p) {
        game = new Game(gd, p);
    }

    /**
     * Passes a good, an amount, and a price all the way down to player
     * and ship to be able to carry out a transaction if valid
     *
     * @param sg
     * @param amount
     * @param price
     * @return 1 if transaction occured, 0 otherwise
     */
    public int makeTransaction(ShopGoods sg, int amount, int price) {
        return game.makeTransaction(sg, amount, price);
    }

    public List<ShopEntry> getShopEntries(Shop shop) {
        
    }

    public Game getGame() { return game; }
}
