package com.example.spacetraders.models;

import android.content.Context;
import android.util.Log;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.Player;
import com.example.spacetraders.entities.Ship;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
import com.example.spacetraders.entities.SolarSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Model {
    private Game game;
    private final String filename = "SAVE_FILE.ser";

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
    public void createGame(GameDifficulty gd, String name, int pilot, int fight, int trade, int eng) {
        Player p = new Player(name, pilot, fight, trade, eng);
        game = new Game(gd, p);
    }

    public boolean loadGame(Context context) {
        game = null;
        try {
            File loadFile = new File(context.getFilesDir(), filename);
            FileInputStream fileIn =
                    new FileInputStream(loadFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            game = (Game) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Game class not found.");
            c.printStackTrace();
        }
        return game != null;
    }

    public void saveGame(Context context) {
        try {
            File saveFile = new File(context.getFilesDir(), filename);
            saveFile.createNewFile();
            saveFile.setWritable(true);
            FileOutputStream fileOut =
                    new FileOutputStream(saveFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
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
        if (amount == 0) { return 0; }
        return game.makeTransaction(sg, amount, price);
    }

    public int getCredits() {
        return game.getCredits();
    }

    public int getCargoSpace() {
        return game.getCargoSpace();
    }

    public int travelToPlanet(Planet p) { return game.travelToPlanet(p); }

    public int travelToSystem(SolarSystem to) {
        return game.travelToSystem(to);
    }

    public void refuelShipMax() {
        game.refuelShipMax();
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
     * getter for current content_planet
     *
     * @return current content_planet
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

    /**
     * gets current fuel level
     *
     * @return
     */
    public int getFuelPercentage() { return game.getFuelPercentage(); }

    public int getRange() { return game.getRange(); }

    public double getMaxRange() { return game.getMaxRange();}

    public SolarSystem[] getSolarSystems() {
        return game.getSolarSystems();
    }

    public SolarSystem getCurrentSystem() {
        return game.getCurrentSystem();
    }

    public boolean isOnWarpGatePlanet() { return game.isOnWarpGatePlanet(); }
}
