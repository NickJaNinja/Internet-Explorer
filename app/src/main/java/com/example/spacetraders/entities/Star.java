package com.example.spacetraders.entities;

import java.io.Serializable;
import java.util.Random;
import android.graphics.Color;

/**
 * This class represents a star
 */
public class Star implements Serializable {

    private final String name;
    private final char classification;
    private int temperature; // in Kelvin (K)
    private double mass; // in solar masses (M☉)
    private double radius; // in solar radii (R☉)
    private double luminosity; // in solar luminosity (L☉)
    private double innerHZRadius; // in AUs
    private double outerHZRadius; // in AUs


    private final Random r = new Random();

    /**
     * Constructor for Star.
     *
     * @param name name
     */
    public Star(String name) {
        this.name = name;
        classification = generateClassification();
        generateTemperatureAndRadius(classification);
        calculateLuminosityAndMass(temperature, radius);
        calculateHabitableZone(luminosity);
    }

    /**
     * Generates a classification for the star. Chances based on Harvard's spectral classification
     * model
     * (https://en.wikipedia.org/wiki/Stellar_classification), but altered slightly to increase
     * coolness factor.
     *
     * @return char classification of star
     */
    private char generateClassification() {
        float roll = r.nextFloat() * 100;
        if (roll > 60) {
            return 'M'; // 40% chance
        } else if (roll <= 60 && roll > 35) {
            return 'K';// 25% chance
        } else if (roll <= 35 && roll > 24) {
            return 'G';// 11% chance
        } else if (roll <= 24 && roll > 10) {
            return 'F';// 14% chance
        } else if (roll <= 10 && roll > 2.7f) {
            return 'A';// 7.3% chance
        } else if (roll <= 2.7f && roll > 0.4f) {
            return 'B';// 2.3% chance
        } else {
            return 'O';// 0.4% chance
        }
    }

    /**
     * get color
     *
     * @return color
     */
    public int getColor() {
        switch (this.classification) {
            case 'M':
                return Color.parseColor("#FF0000");
            case 'K':
                return Color.parseColor("#FF9833");
            case 'G':
                return Color.parseColor("#FFFF00");
            case 'F':
                return Color.parseColor("#FFFFED");
            case 'A':
                return Color.parseColor("#FBF8FF");
            case 'B':
                return Color.parseColor("#BBCCFF");
            default: // 'O'
                return Color.parseColor("#9BB0FF");
        }
    }

    /**
     * Sets temperature and radius for star based on classification at a random
     * value between the min and max as defined in Harvard's spectral classification model
     * (https://en.wikipedia.org/wiki/Stellar_classification).
     *
     * @param classification the classification of the star
     */
    private void generateTemperatureAndRadius(char classification) {
        if (classification == 'M') {
            temperature = r.nextInt(3701) + 2400; // 2,400–3,700 K
            radius = r.nextDouble() * (.71 - .12) + .12; // ≤ 0.7 R☉ (capped at 0.12 R☉)
        }
        if (classification == 'K') {
            temperature = r.nextInt(5201) + 3700; // 3,700–5,200 K
            radius = r.nextDouble() * (.97 - .7) + .7; // 0.7–0.96 R☉
        }
        if (classification == 'G') {
            temperature = r.nextInt(6001) + 5200; // 5,200–6,000 K
            radius = r.nextDouble() * (1.16 - .96) + .96; // 0.96–1.15 R☉
        }
        if (classification == 'F') {
            temperature = r.nextInt(7501) + 6000;  // 6,000–7,500 K
            radius = r.nextDouble() * (1.41 - 1.15) + 1.15; // 1.15–1.4 R☉
        }
        if (classification == 'A') {
            temperature = r.nextInt(10001) + 7500; // 7,500–10,000 K
            radius = r.nextDouble() * (1.81 - 1.4) + 1.4; // 1.4–1.8 R☉
        }
        if (classification == 'B') {
            temperature = r.nextInt(30001) + 10000; // 10,000–30,000 K
            radius = r.nextDouble() * (6.61 - 1.8) + 1.8; // 1.8–6.6 R☉
        } else { // 'O'
            temperature = r.nextInt(100000) + 30000; // ≥ 30,000 K (capped at 99,999 K)
            radius = r.nextDouble() * (100 - 6.6) + 6.6; // ≥ 6.6 R☉ (capped at 99.99 R☉)
        }
    }

    /**
     * Calculates luminosity and mass of star based on temperature and radius.
     *
     * @param temperature temperature of star in Kelvin
     * @param radius      solar radius of star
     */
    private void calculateLuminosityAndMass(int temperature, double radius) {
        // by definition of solar temperature: T☉ = T (in K) / T of Earth (in K)   where T of Earth
        // is 5,778 K
        double solarTemp = temperature / 5778.0;

        // by Stefan-Boltzman Law: L☉ = R☉^2 * T☉^4
        luminosity = ((radius * radius) * (solarTemp * solarTemp * solarTemp * solarTemp));

        // by Mass-Luminosity Relation: M☉ = L☉^(1/a)   where a = 3.5 for most main seq stars
        mass = Math.pow(solarTemp, 1.0 / 3.5);
    }

    /**
     * Calculates the inner and outer habitable zone radius of the star.
     *
     * @param luminosity the solar luminosity of the star
     */
    private void calculateHabitableZone(double luminosity) {
        // source: http://www.planetarybiology.com/calculating_habitable_zone.html
        innerHZRadius = Math.pow(luminosity / 1.1, .5); // inner radius = (L☉/1.1)^(1/2)
        outerHZRadius = Math.pow(luminosity / 0.53, .5); // outer radius = (L☉/0.53)^(1/2)
    }

    /**
     * gets name of star.
     *
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * gets classification of star.
     *
     * @return char classification
     */
    public char getClassification() {
        return classification;
    }

    /**
     * gets temperature of star in Kelvin.
     *
     * @return int temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * gets solar mass of star.
     *
     * @return double mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * gets mass of star in kilograms.
     *
     * @return double mass
     */
    public double getMassInKg() {
        return mass * 1.989e30;
    }

    /**
     * gets solar radius of star.
     *
     * @return double radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * gets radius of star in kilometers.
     *
     * @return double radius
     */
    public double getRadiusInKm() {
        return radius * 695500;
    }

    /**
     * gets solar luminosity of star.
     *
     * @return double luminosity.
     */
    public double getLuminosity() {
        return luminosity;
    }

    /**
     * gets luminosity of star in Watts.
     *
     * @return double luminosity.
     */
    public double getLuminosityInWatts() {
        return luminosity * 3.828e26;
    }

    /**
     * gets inner habitable zone radius of the star in AUs
     *
     * @return double inner habitable zone radius
     */
    public double getInnerHZRadius() {
        return innerHZRadius;
    }

    /**
     * gets outer habitable zone radius of the star in AUs
     *
     * @return double outer habitable zone radius
     */
    public double getOuterHZRadius() {
        return outerHZRadius;
    }

    /**
     * to string for star
     *
     * @return string of star info
     */
    @Override
    public String toString() {
        return name;
    }

}
