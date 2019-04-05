package com.example.spacetraders.models;

import android.content.Context;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.Player;
import com.example.spacetraders.entities.ShipType;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
import com.example.spacetraders.entities.SolarSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * model class
 */
public class Model {
    private Game game;
    private final String filename = "SAVE_FILE.ser";

    /**
     * Singleton Pattern Code
     * this allows us to get access to this class
     * anywhere, which will allow our View models to access
     * the "back end"  more easily
     */
    private static final Model instance = new Model();

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
     * @param name  player name
     * @param pilot pilot level
     * @param fight fight level
     * @param trade trade level
     * @param eng eng level
     */
    public void createGame(GameDifficulty gd, String name, int pilot, int fight, int trade,
                           int eng) {
        Player p = new Player(name, pilot, fight, trade, eng);
        game = new Game(gd, p);
    }

    /**
     * lead game
     *
     * @param context context
     * @return game != null
     */
    public boolean loadGame(Context context) {
        game = new Game();
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
            c.printStackTrace();
        }
        return game != null;
    }

    /**
     * save game
     *
     * @param context context
     */
    public void saveGame(Context context) {
        try {
            File saveFile = new File(context.getFilesDir(), filename);
            if (!saveFile.createNewFile() || !saveFile.setWritable(true)) {
                // SHOULD RETURN -1 ON FAIL OR SOMETHING
                return;
            }
            FileOutputStream fileOut =
                    new FileOutputStream(saveFile);
            ObjectOutput out_ = new ObjectOutputStream(fileOut);
            out_.writeObject(game);
            out_.close();
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

    /**
     * get credits
     *
     * @return player's credit
     */
    public int getCredits() {
        return game.getCredits();
    }

    /**
     * get credits
     *
     * @return available cargo space in ship
     */
    public int getCargoSpace() {
        return game.getCargoSpace();
    }

    /**
     * travel between planets
     *
     * @param p destination planet
     * @return 1 if travel succeed or 0 if fail
     */
    public int travelToPlanet(Planet p) { return game.travelToPlanet(p); }

    /**
     * travel between solar system
     *
     * @param to destination solar system
     * @return 1 if travel succeed or 0 if fail
     */
    public int travelToSystem(SolarSystem to) {
        return game.travelToSystem(to);
    }

    /**
     * refuel ship max
     */
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
     * get shop entries filtered
     *
     * @return list of shop entries filtered
     */
    public List<ShopEntry> getShopEntriesFiltered() { return game.getShopEntriesFiltered(); }

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

//    /**
//     * setter for current content_planet
//     *
//     * @param newCurr planet new curr
//     */
//    public void setCurrentPlanet(Planet newCurr) {
//        this.game.setCurrentPlanet(newCurr);
//    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * getter for shop
//     *
//     * @return shop
//     */
//    public Shop getShop() {
//        return game.getCurrentShop();
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

    /**
     * gets current fuel level
     *
     * @return fuel percentage
     */
    public int getFuelPercentage() { return game.getFuelPercentage(); }

    /**
     * get range
     *
     * @return range
     */
    public int getRange() { return game.getRange(); }

    /**
     * get max range
     *
     * @return range
     */
    public double getMaxRange() { return game.getMaxRange();}

    /**
     * get list of solar system
     *
     * @return list of solar system
     */
    public SolarSystem[] getSolarSystems() {
        return game.getSolarSystems();
    }

    /**
     * get current system
     *
     * @return current solarSystem
     */
    public SolarSystem getCurrentSystem() {
        return game.getCurrentSystem();
    }

    /**
     * is on warp gate planet
     *
     * @return if player is on warp gate planet
     */
    public boolean isOnWarpGatePlanet() { return !game.isOnWarpGatePlanet(); }

    public List getShipsBasedOnTechLevel() {
        return game.getShipsBasedOnTechLevel();
    }

    public void setShipType(ShipType shipType) {
        game.setShipType(shipType);
    }

    public void setCredits(int credits) {
        game.setCredits(credits);
    }
}
