package com.example.spacetraders.entities;

import java.io.Serializable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Objects;
import java.util.Random;

/**
 * This class represents a star
 */
public class Star implements Serializable {

    private final String name;
    private StarClass starClass;
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
    public Star(@Nullable String name) {
        this.name = name;
        generateClassification();
        generateTemperatureAndRadius();
        calculateLuminosityAndMass(temperature, radius);
        calculateHabitableZone(luminosity);
    }

    /**
     * Generates a classification for the star. Chances based on Harvard's spectral classification
     * model
     * (https://en.wikipedia.org/wiki/Stellar_classification), but altered slightly to increase
     * coolness factor.
     */
    private void generateClassification() {
        float roll = r.nextFloat();
        StarClass[] values = StarClass.values();
        float classes[] = StarClass.getChancesAsArray();
        for (int i = 0; i < Objects.requireNonNull(classes).length; i++) {
            if (roll <= classes[i]) {
                this.starClass = values[i];
                return;
            }
        }
        this.starClass = values[values.length-1];
    }

    /**
     * get color
     *
     * @return color
     */
    public int getColor() {
        return starClass.getColor();
    }

    /**
     * Sets temperature and radius for star based on classification at a random
     * value between the min and max as defined in Harvard's spectral classification model
     * (https://en.wikipedia.org/wiki/Stellar_classification).
     */
    private void generateTemperatureAndRadius() {
        int tempMin = starClass.getTempLower();
        int tempMax = starClass.getTempUpper();
        double radMin = starClass.getRadiusLower();
        double radMax = starClass.getRadiusUpper();
        this.temperature = r.nextInt(tempMax-tempMin) + tempMin;
        this.radius = r.nextDouble()*(radMax - radMin) + radMin;
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
        final double SOLAR_TEMP_CONVERSION = 5778;
        final double MASS_POWER = 3.5;
        double solarTemp = temperature / SOLAR_TEMP_CONVERSION;

        // by Stefan-B o l t z m a n Law: L☉ = R☉^2 * T☉^4
        luminosity = ((radius * radius) * (solarTemp * solarTemp * solarTemp * solarTemp));

        // by Mass-Luminosity Relation: M☉ = L☉^(1/a)   where a = 3.5 for most main seq stars
        mass = Math.pow(solarTemp, 1.0 / MASS_POWER);
    }

    /**
     * Calculates the inner and outer habitable zone radius of the star.
     *
     * @param luminosity the solar luminosity of the star
     */
    private void calculateHabitableZone(double luminosity) {
        // source: http://www.planetarybiology.com/calculating_habitable_zone.html
        final double INNER_DENOMINATOR = 1.1;
        final double HALF = 0.5;
        final double OUTER_DENOMINATOR = 0.53;
        innerHZRadius = Math.pow(luminosity / INNER_DENOMINATOR, HALF); // inner radius = (L☉/1.1)^(1/2)
        outerHZRadius = Math.pow(luminosity / OUTER_DENOMINATOR, HALF); // outer radius = (L☉/0.53)^(1/2)
    }

    /**
     * gets name of star.
     *
     * @return String name
     */
    @Nullable
    public String getName() {
        return name;
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
     *
     * @return classification
     */
    public char getClassification() {
        return starClass.getClassification();
    }

// --Commented out by Inspection START (4/2/19, 11:04 PM):
//    /**
//     * gets solar mass of star.
//     *
//     * @return double mass
//     */
//    public double getMass() {
//        return mass;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:04 PM)

    /**
     * gets mass of star in kilograms.
     *
     * @return double mass
     */
    public double getMassInKg() {
        final double MASS_CONVERSION = 1.989e30;
        return mass * MASS_CONVERSION;
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
        final double RADIUS_CONVERSION = 695500;
        return radius * RADIUS_CONVERSION;
    }

// --Commented out by Inspection START (4/2/19, 11:04 PM):
//    /**
//     * gets solar luminosity of star.
//     *
//     * @return double luminosity.
//     */
//    public double getLuminosity() {
//        return luminosity;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:04 PM)

    /**
     * gets luminosity of star in Watts.
     *
     * @return double luminosity.
     */
    public double getLuminosityInWatts() {
        final double LUMINOSITY_CONVERSION = 3.828e26;
        return luminosity * LUMINOSITY_CONVERSION;
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
    @NonNull
    public String toString() {
        return name;
    }

}
