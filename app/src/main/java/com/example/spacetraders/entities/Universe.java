package com.example.spacetraders.entities;

import java.io.Serializable;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

/**
 * This class represents the game universe
 */
public class Universe implements Serializable {

    private static final String[] PREFIXES =
            {
                    "Pan",
                    "Arc",
                    "Wub",
                    "Chung",
                    "Cri",
                    "Zen",
                    "Da'",
                    "Zur",
                    "Ut",
                    "Chrom",
                    "Zig",
                    "Wub",
                    "Car",
                    "Fig",
                    "Tap",
                    "Sic",
                    "But",
                    "Lok",
                    "Ku",
                    "Crunk",
                    "Bob",
                    "Myrh",
                    "Sen",
                    "Deku",
                    "Tenzum",
                    "Rob",
                    "Altair",
                    "Strat"
            };
    private static final String[] SUFFIXES =
            {
                    "onia",
                    "ardia",
                    "anus",
                    "wei",
                    "rom",
                    "etov",
                    "der",
                    "mus",
                    "ma",
                    "ulus",
                    "on",
                    "ea",
                    "il",
                    "oc",
                    "dacia",
                    " Prime",
                    "'Xi",
                    "os",
                    "ellia",
                    "'kir",
                    "adonia"
            };


    private Random r = new Random();
    /**
     * dimensions of universe
     */
    private static final int MAXX = 600;
    private static final int MAXY = 600;
    private int numSolarSystems = 250;

    private SolarSystem[] solarSystems;

    /**
     * Constructor for Universe
     */
    public Universe() {
        Set<Coordinates> coordSet = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        this.solarSystems = new SolarSystem[numSolarSystems];

        for (int i = 0; i < numSolarSystems; i++) {
            //keep making random names and coordinates until we find one that hasn't been used yet
            //choose coordinates
            int randX = r.nextInt(MAXX);
            int randY = r.nextInt(MAXY);
            Coordinates randCoords = new Coordinates(randX, randY);
            while (coordSet.contains(randCoords)) {
                randX = r.nextInt(MAXX);
                randY = r.nextInt(MAXY);
                randCoords = new Coordinates(randX, randY);
            }
            //choose name
            int randPrefixIndex = r.nextInt(PREFIXES.length);
            int randSuffixIndex = r.nextInt(SUFFIXES.length);
            int randNameNumber = 1 + r.nextInt(100);
            String name = PREFIXES[randPrefixIndex] + SUFFIXES[randSuffixIndex] + "-"
                    + randNameNumber;
            while (nameSet.contains(name)) {
                randPrefixIndex = r.nextInt(PREFIXES.length);
                randSuffixIndex = r.nextInt(SUFFIXES.length);
                randNameNumber = 1 + r.nextInt(100);
                name = PREFIXES[randPrefixIndex] + SUFFIXES[randSuffixIndex] + randNameNumber;
            }
            coordSet.add(randCoords);
            nameSet.add(name);
            this.solarSystems[i] = new SolarSystem(name, randCoords);
        }
    }

    /*
        ONLY NEED IF TRAVEL BETWEEN PLANETS IS NOT INSTANTANEOUS
     */
    public int distanceBetweenPlanets(Planet from, Planet to) {
        double fromCoords = from.getDistanceFromParentStar();
        double toCoords = to.getDistanceFromParentStar();
        int distance = (int)Math.abs(fromCoords - toCoords);
        return distance;
    }

    /**
     * Finds the 2D distance between two solar systems
     *
     * @param from one system
     * @param to the other system
     * @return the distance
     */
    public int distanceBetweenSystems(SolarSystem from, SolarSystem to) {
        Coordinates fromCoords = from.getCoordinates();
        Coordinates toCoords = to.getCoordinates();
        return fromCoords.dist(toCoords);
    }
    /**
     * getter for solar systems
     *
     * @return array of solar systems
     */
    public SolarSystem[] getSolarSystems() {
        return solarSystems;
    }

    /**
     * gets a random solar system
     *
     * @return random solar system
     */
    public SolarSystem getRandomSolarSystem() {
        return solarSystems[r.nextInt(solarSystems.length)];
    }

    /**
     * gets a random content_planet
     *
     * @return random content_planet
     */
    public Planet getRandomPlanet() {
        Planet plan = solarSystems[r.nextInt(solarSystems.length)].getRandomPlanet();
        return plan;
    }

    /**
     * to string for universe
     *
     * @return string of universe info
     */
    @Override
    public String toString() {
        String str = "Universe: " + solarSystems.length + " solar systems\n ";
        /*for (SolarSystem s : solarSystems) {
            str += s.toString();
        }*/
        return str;
    }

}
