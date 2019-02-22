package com.example.spacetraders.entities;

/**
 * sorry I don't know how to do junits lads.
 */
public class Test {
    public static void main(String args[]) {
        SolarSystem testSystem = new SolarSystem("Alpha Centauri",new Coordinates(0, 0));
        System.out.println(testSystem.getName());
        System.out.println("\tSystem Overview");
        System.out.println("\t--------------------------------");
        for (Star star: testSystem.getStars()) {
            System.out.println("\t" + star.getName());
            for (Planet planet: testSystem.getPlanets()) {
                if (planet.getParentStar().equals(star)) System.out.println("\t\t" + planet.getName());
            }
        }
        System.out.println();
        System.out.println("\tStar Details");
        System.out.println("\t--------------------------------");
        for (Star star: testSystem.getStars()) {
            System.out.println("\t" + star.getName());
            System.out.println("\t\tRadius:\t\t\t\t\t\t" + star.getRadiusInKm() + " km");
            System.out.println("\t\tMass:\t\t\t\t\t\t" + star.getMassInKg() + " kg");
            System.out.println("\t\tSurface Temperature:\t\t" + star.getTemperature() + " K");
            System.out.println("\t\tLuminosity:\t\t\t\t\t" + star.getLuminosityInWatts() + " W");
        }
        System.out.println();
        System.out.println("\tPlanet Details");
        System.out.println("\t--------------------------------");
        for (Planet planet: testSystem.getPlanets()) {
            System.out.println("\t" + planet.getName());
            System.out.println("\t\tDistance from Star:\t" + planet.getDistanceFromParentStar() + " km");
            if (planet.getInHabitableZone()) {
                System.out.println("\t\tStatus:\t\t\t\t\t\tinhabited");
            }
            else {
                System.out.println("\t\tStatus:\t\t\t\t\t\tuninhabited");
            }
            System.out.println("\t\tPopulation:\t\t\t\t\t[NOT IMPLEMENTED]");
            System.out.println("\t\tPolitical System:\t\t\t[NOT IMPLEMENTED]");
            System.out.println("\t\tTech Level:\t\t\t\t\t[NOT IMPLEMENTED]");
            System.out.println("\t\tResource Level:\t\t\t\t[NOT IMPLEMENTED]");
        }
    }
}

