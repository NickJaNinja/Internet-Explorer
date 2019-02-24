package com.example.spacetraders.entities;

import java.util.Random;

/**This class represents a solar system*/
public class SolarSystem {

    private String name;
    private Coordinates coordinates;
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
    }

    /**
     * Generates the number of stars
     *
     * @return int number of stars
     */
    private int generateNumStars () {
        int roll = r.nextInt(10) + 1;
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
        this.stars = new Star[numStars];
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
        return r.nextInt(13) + 1; // random int from 1 to 13
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
     * getter for stars
     *
     * @return  array of stars
     */
    public Star[] getStars() {
        return stars;
    }

    /**
     * gets a random star
     * 
     * @return random star
     */
    public Star getRandomStar() {
        return stars[r.nextInt(stars.length)];
    }

}
