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
    private static final int MAX_X = 600;
    private static final int MAX_Y = 600;
    private static final int MAX_SYSTEMS = 250;

    private SolarSystem[] solarSystems;

    /**
     * Constructor for Universe
     */
    public Universe() {
        Set<Coordinates> cordSet = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        this.solarSystems = new SolarSystem[MAX_SYSTEMS];

        for (int i = 0; i < MAX_SYSTEMS; i++) {
            //keep making random names and coordinates until we find one that hasn't been used yet
            //choose coordinates
            int randX = r.nextInt(MAX_X);
            int randY = r.nextInt(MAX_Y);
            Coordinates randCords = new Coordinates(randX, randY);
            while (cordSet.contains(randCords)) {
                randX = r.nextInt(MAX_X);
                randY = r.nextInt(MAX_Y);
                randCords = new Coordinates(randX, randY);
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
            cordSet.add(randCords);
            nameSet.add(name);
            this.solarSystems[i] = new SolarSystem(name, randCords);
        }
    }

    /**
     * Gets the distance between two planets
     *
     * @param from planet 1
     * @param to planet 2
     * @return distance between the planets
     */
    public int distanceBetweenPlanets(Planet from, Planet to) {
        double fromCords = from.getDistanceFromParentStar();
        double toCords = to.getDistanceFromParentStar();
        int distance = (int)Math.abs(fromCords - toCords);
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
        Coordinates fromCords = from.getCoordinates();
        Coordinates toCords = to.getCoordinates();
        return fromCords.dist(toCords);
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
        return "Universe: " + solarSystems.length + " solar systems\n ";
    }

}
