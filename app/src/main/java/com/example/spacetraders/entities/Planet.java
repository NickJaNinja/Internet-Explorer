package com.example.spacetraders.entities;

import android.support.annotation.NonNull;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 * This class represents a content_planet
 */
public class Planet implements Serializable {

    private String name;
    private final Star parentStar;
    private final TechLevel techLevel;
    private final ResourcesLevel resourcesLevel;
    private final PoliticalSystem politicalSystem;
    private double distanceFromParentStar; // in AUs
    private boolean inHabitableZone;
    // --Commented out by Inspection (4/2/19, 11:03 PM):private int population;
    private final Shop shop;
    private boolean isWarpGate;

    /**
     * Constructor for Planet, randomizes levels
     *
     * @param name       name
     * @param parentStar the parent star
     */
    public Planet(String name, Star parentStar) {
        this.name = name;
        this.parentStar = parentStar;
        Random r = new Random();

        this.inHabitableZone = ((distanceFromParentStar > parentStar.getInnerHZRadius())
                && (distanceFromParentStar < parentStar.getOuterHZRadius()));

        int techPick = r.nextInt(TechLevel.values().length);
        this.techLevel = TechLevel.values()[techPick];

        int resourcesPick = r.nextInt(ResourcesLevel.values().length);
        this.resourcesLevel = ResourcesLevel.values()[resourcesPick];

        int politicalPick = r.nextInt(PoliticalSystem.values().length);
        this.politicalSystem = PoliticalSystem.values()[politicalPick];

        shop = new Shop(techLevel, resourcesLevel);

        this.isWarpGate = false;
    }

    /**
     * sets distance from parent star.
     *
     * @param distanceFromParentStar double distance from the parent star
     */
    public void setDistanceFromParentStar(double distanceFromParentStar) {
        this.distanceFromParentStar = distanceFromParentStar;
    }

    /**
     * sets inHabitableZone
     *
     * @param inHabitableZone inHabitableZone
     */
    public void setInHabitableZone(boolean inHabitableZone) {
        this.inHabitableZone = inHabitableZone;
    }

    /**
     * gets name of content_planet.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * Gets whether or not the content_planet is in the habitable zone
//     *
//     * @return boolean in habitable zone
//     */
//    public boolean getInHabitableZone() {
//        return inHabitableZone;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

    /**
     * Gets distance from parent star
     *
     * @return double distance from parent star
     */
    public double getDistanceFromParentStar() {
        return distanceFromParentStar;
    }

    /**
     * Gets parent star.
     *
     * @return Star parent star
     */
    public Star getParentStar() {
        return parentStar;
    }

    /**
     * Gets tech level
     *
     * @return tech level
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * Gets resources level
     *
     * @return the resources level
     */
    public ResourcesLevel getResourcesLevel() {
        return resourcesLevel;
    }

    /**
     * Gets political system
     *
     * @return political system
     */
    public PoliticalSystem getPoliticalSystem() {
        return politicalSystem;
    }
//
//    /**
//     * Gets if in habitable zone
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
//     *
//     * @return if in habitable zone
//     */
//    public boolean isInHabitableZone() {
//        return inHabitableZone;
//    }

    /**
     * make transaction
     *
     * @param sg shop goods
     * @param amount amount
     * @return decrease stock
     */
    public int makeTransaction(ShopGoods sg, int amount) {
        return shop.decreaseStock(sg, amount);
    }

//    /**
//     * Gets shop
//     *
//     * @return shop
//     */
//    public Shop getShop() {
//        return shop;
//    }

    /**
     * get shop entries
     *
     * @return list of shop entries
     */
    public List<ShopEntry> getShopEntries() { return shop.getInventoryAsList(); }

    /**
     * get shop entries filtered
     *
     * @return list of shop entries filtered
     */
    public List<ShopEntry> getShopEntriesFiltered() { return shop.getInventoryAsListFiltered(); }

    /**
     * get is warp gate
     *
     * @return boolean
     */
    public boolean getIsWarpGate() {
        return this.isWarpGate;
    }

    /**
     * set is warp gate
     *
     * @param b boolean b
     */
    public void setIsWarpGate(boolean b) {
        this.isWarpGate = b;
        this.name += " [WARP GATE]";
    }

    /**
     * restock shop
     */
    public void restockShop() {
        shop.restock();
    }

    /**
     * to string for content_planet
     *
     * @return string of content_planet info
     */
    @Override
    @NonNull
    public String toString() {
        return name + " (" + techLevel + ", " + resourcesLevel + inHabitableZone +")";
    }
}
