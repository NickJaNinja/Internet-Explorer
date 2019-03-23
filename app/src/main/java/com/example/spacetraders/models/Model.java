package com.example.spacetraders.models;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.Player;
import com.example.spacetraders.entities.Ship;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;

import java.util.List;

public class Model {
    private Game game;
    
    /**
     * Singleton Pattern Code
     * this allows us to get access to this class
     * anywhere, which will allow our View models to access
     * the "back end"  more easily
     */
    private static Model instance = new Model();

    /**
     * getter for instance
     *
     * @return instance
     */
    public static Model getInstance() {
        return instance;
    }

    /**
     * Creates a new game
     *
     * @param gd game difficulty
     * @param p  player
     */
    public void createGame(GameDifficulty gd, Player p) {
        game = new Game(gd, p);
    }

    /**
     * Passes a good, an amount, and a price all the way down to player
     * and ship to be able to carry out a transaction if valid
     *
     * @param sg     the type of the good associated with this transaction
     * @param amount the total amount of the good to buy
     * @param price  the price of each good
     * @return 1 if transaction occurred, 0 otherwise
     */
    public int makeTransaction(ShopGoods sg, int amount, int price) {
        return game.makeTransaction(sg, amount, price);
    }

    /**
     * getter for shop entries
     *
     * @return shop entries
     */
    public List<ShopEntry> getShopEntries() {
        return game.getShopEntries();
    }

    /**
     * getter for player entities
     *
     * @return player entities
     */
    public List<ShopEntry> getPlayerEntries() {
        return game.getPlayerEntries();
    }

    /**
     * getter for game
     *
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     * getter for current planet
     *
     * @return current planet
     */
    public Planet getCurrentPlanet() {
        return game.getCurrentPlanet();
    }

    /**
     * getter for shop
     *
     * @return shop
     */
    public Shop getShop() {
        return game.getCurrentShop();
    }

}
