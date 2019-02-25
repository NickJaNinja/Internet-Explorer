package com.example.spacetraders.entities;

import java.util.Random;

/**This class represents a solar system*/
public class SolarSystem {

    private String name;
    private Coordinates coordinates;
    private Star[] stars;
    private Planet[] planets;

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

            } else { // if unary star system
                planets[i] = new Planet(stars[0].getName() + " " + (i + 1), stars[0]);
            }
            planets[i].setDistanceFromParentStar(generateDistanceFromParentStar(planets[i], i));

            if (planets[i].getDistanceFromParentStar() > planets[i].getParentStar().getInnerHZRadius()
                    && planets[i].getDistanceFromParentStar() < planets[i].getParentStar().getOuterHZRadius()) {
                planets[i].setInHabitableZone(true);
            } else {
                planets[i].setInHabitableZone(false);
            }
        }
    }
    private double generateDistanceFromParentStar(Planet planet, int planetNumber) {
        if (planets[0].equals(planet)) { // first planet
            return r.nextDouble() * (20.0 - .15) + .15 + stars[0].getRadius(); // TODO think of better way to generate distance from first planet to parent star
        } else { // planets' after first
            // by Titius-Bode Law
            return planets[planetNumber - 1].getDistanceFromParentStar() * 2.0 ; // TODO add slight random variation so this is less exact
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
     * getter for planets
     *
     * @return  array of planets
     */
    public Planet[] getPlanets() {
        return planets;
    }

    /**
     * gets a random star
     * 
     * @return random star
     */
    public Star getRandomStar() {
        return stars[r.nextInt(stars.length)];
    }

    /**
     * gets a random planet
     * 
     * @return random planet
     */
    public Planet getRandomPlanet() {
        return planets[r.nextInt(planets.length)];
    }
    
    /**
     * to string for solar system
     *
     * @return string of solar system info
     */
    @Override
    public String toString() {
        String str = "Solar System: " + name + " at " + coordinates + "\nSuns: ";
        for (Star s : stars) {
            str += s + ", ";
        }
        str += "Planets: ";
        for (Planet p : planets) {
            str += p + ", ";
        }
        return str + "\n";
    }

}
