package com.example.spacetraders.entities;

import java.util.Random;

/**This class represents a solar system*/
public class SolarSystem {

    private String name;
    private Coordinates coordinates;
    private Planet[] planets;
    private Star[] stars;

    private Random r = new Random();

    /**Constructor for Solar System. Randomizes all stats.
     * @param name name of solar system
     * @param coordinates the coordinates of the solar system
     */
    public SolarSystem(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;

        createStars(generateNumStars());
        createPlanets(generateNumPlanets());
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
     * Generates the number of stars
     *
     * @return int number of stars
     */
    private int generateNumStars () {
        int roll = r.nextInt(11) + 1;
        if (roll < 5) return 2; // 4 in 10 chance for binary star system
        else if (roll > 8) return 3; // 2 in 10 chance for trinary star system
        else return 1; // 6 in 10 chance for unary star system
    }

    /**
     * If unary star system, names stars in format of "name of solar system"
     * eg Kepler
     *
     * If multi-star system, names stars in format "name of solar system + SPACE + uppercase letter"
     * in alphabetic order.
     * eg Kepler A, Kepler B, ...
     *
     * @param numStars int number of stars
     */
    private void createStars (int numStars) {
        stars = new Star[numStars];
        if (numStars < 2) { // if unary star system
            stars[0] = new Star(name);
        } else { // if multi-star system
            char alphabet = 'A';
            for (int i = 0; i < numStars; i++) {
                stars[i] = new Star(name + " " + alphabet);
                alphabet++;
            }
        }
    }

    /**
     * Generates the number of planets
     *
     * @return int number of planets
     */
    private int generateNumPlanets () {
        return r.nextInt(8) + 1; // random int from 1 to 7
    }

    /**
     * If unary star system, names planets in format "name of parent star + SPACE + number" in order
     * of smallest distance from parent star.
     * eg Kepler 1, Kepler 2, ...
     *
     * If multi-star system, names planets in format of "name of parent star + number" in order of
     * smallest distance from parent star.
     * eg Kepler B1, Kepler A2, ...
     *
     * Also randomly decides parent star of planet.
     *
     * @param numPlanets int number of planets
     */
    private void createPlanets (int numPlanets) {
        planets = new Planet[numPlanets];
        for (int i = 0; i < numPlanets; i++) {
            if (stars.length > 1) { // if multi-star system
                int roll = r.nextInt(stars.length);
                planets[i] = new Planet(stars[roll].getName() + (i + 1), stars[roll]);
                generateDistanceFromParentStar(planets[i], i);

            } else { // if unary star system
                planets[i] = new Planet(stars[0].getName() + " " + (i + 1), stars[0]);
                generateDistanceFromParentStar(planets[i], i);
            }
        }
    }

    private double generateDistanceFromParentStar(Planet planet, int planetNumber) {
        if (planets[0].equals(planet)) { // first planet
            return r.nextDouble() * (2 - .15) + .15 + stars[0].getRadius(); // TODO think of better way to generate distance from first planet to parent star
        } else { // planets' after first
            // by Titius-Bode Law
            return planets[planetNumber - 1].getDistanceFromParentStar() * 2.0 ; // TODO add slight random variation so this is less exact
        }
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

    /**
     * getter for stars
     *
     * @return  array of stars
     */
    public Star[] getStars() {
        return stars;
    }

}
