package com.example.spacetraders.entities;

import java.util.Random;

/**This class represents a solar system*/
public class SolarSystem {

    private String name;
    private Coordinates coordinates;
    private Planet[] planets;

    /**Constructor for Solar System. Randomizes all stats.
     * @param name name of solar system
     * @param coordinates the coordinates of the solar system
     */
    public SolarSystem(String name, Coordinates coordinates) {
        Random r = new Random();
        int numPlanets = r.nextInt(5) + 1; // random int from 1 to 5
        Planet[] planets = new Planet[numPlanets];
        for (int i = 0; i < numPlanets; i++) {
            planets[i] = new Planet(name + " " + (i + 1));
        }

        this.name = name;
        this.coordinates = coordinates;
        this.planets = planets;
    }

    /**Constructor for Solar System
     * @param name name of solar system
     * @param coordinates the coordinates of the solar system
     * @param planets   array of planets
     */
    public SolarSystem(String name, Coordinates coordinates, Planet[] planets) {
        this.name = name;
        this.coordinates = coordinates;
        this.planets = planets;
    }

    /**
     * getter for name
     *
     * @return  name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for coordinates
     *
     * @return  coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * getter for planets
     *
     * @return  array of planets
     */
    public Planet[] getPlanets() {
        return planets;
    }

}
