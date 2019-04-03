package com.example.spacetraders.entities;

/**
 * sorry I don't know how to do junits lads.
 */
public class Test {

    /**
     * main method
     *
     * @param args string array
     */
    public static void main(String args[]) {
        int inhabitedPlanetsNum = 0;
        /*
        SolarSystem testSystem = new SolarSystem("Alpha Centauri",new Coordinates(0, 0));
        System.out.println(testSystem.getName());
        System.out.println("\tSystem Overview");
        System.out.println("\t--------------------------------");
        for (Star star: testSystem.getStars()) {
            System.out.println("\t" + star.getName());
            for (Planet content_planet: testSystem.getPlanets()) {
                if (content_planet.getParentStar().equals(star)) System.out.println("\t\t" + content_planet.getName());
            }
        }
        System.out.println();
        System.out.println("\tStar Details");
        System.out.println("\t--------------------------------");
        DecimalFormat dfe = new DecimalFormat("#.##E0");
        DecimalFormat df = new DecimalFormat("#.##");
        for (Star star: testSystem.getStars()) {
            System.out.println("\t" + star.getName());
            System.out.println("\t\tType:\t\t\t\t\t\t" + star.getClassification() + " Class Star");
            System.out.println("\t\tRadius:\t\t\t\t\t\t" + df.format(star.getRadiusInKm()*1.58125E-5) + " ly");
            System.out.println("\t\tMass:\t\t\t\t\t\t" + dfe.format(star.getMassInKg()) + " kg");
            System.out.println("\t\tSurface Temperature:\t\t" + dfe.format(star.getTemperature()) + " K");
            System.out.println("\t\tLuminosity:\t\t\t\t\t" + dfe.format(star.getLuminosityInWatts()) + " W");
            System.out.println("\t\tInner Habitable Radius:\t\t" + df.format(star.getInnerHZRadius()*8.3167) + " lm");
            System.out.println("\t\tOuter Habitable Radius:\t\t" + df.format(star.getOuterHZRadius()*8.3167) + " lm");
        }
        System.out.println();
        System.out.println("\tPlanet Details");
        System.out.println("\t--------------------------------");
        for (Planet content_planet: testSystem.getPlanets()) {
            System.out.println("\t" + content_planet.getName());
            System.out.println("\t\tDistance from Star:\t" + df.format(content_planet.getDistanceFromParentStar()*8.3167) + " lm");
            if (content_planet.getInHabitableZone()) {
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
        */

        /*Universe universe = new Universe();
        for (int i = 0; i < universe.getSolarSystems().length; i++) {
            System.out.println(universe.getSolarSystems()[i].getName());
            System.out.println("\tSystem Overview");
            System.out.println("\t--------------------------------");
            for (Star star: universe.getSolarSystems()[i].getStars()) {
                System.out.println("\t" + star.getName());
                for (Planet planet: universe.getSolarSystems()[i].getPlanets()) {
                    if (planet.getParentStar().equals(star)) System.out.println("\t\t" + planet.getName());
                }
            }
            System.out.println();
            System.out.println("\tStar Details");
            System.out.println("\t--------------------------------");
            DecimalFormat dfe = new DecimalFormat("#.##E0");
            DecimalFormat df = new DecimalFormat("#.##");
            for (Star star: universe.getSolarSystems()[i].getStars()) {
                System.out.println("\t" + star.getName());
                System.out.println("\t\tType:\t\t\t\t\t\t" + star.getClassification() + " Class Star");
                System.out.println("\t\tRadius:\t\t\t\t\t\t" + df.format(star.getRadiusInKm()*1.58125E-5) + " ly");
                System.out.println("\t\tMass:\t\t\t\t\t\t" + dfe.format(star.getMassInKg()) + " kg");
                System.out.println("\t\tSurface Temperature:\t\t" + dfe.format(star.getTemperature()) + " K");
                System.out.println("\t\tLuminosity:\t\t\t\t\t" + dfe.format(star.getLuminosityInWatts()) + " W");
                System.out.println("\t\tInner Habitable Radius:\t\t" + df.format(star.getInnerHZRadius()*8.3167) + " lm");
                System.out.println("\t\tOuter Habitable Radius:\t\t" + df.format(star.getOuterHZRadius()*8.3167) + " lm");
            }
            System.out.println();
            System.out.println("\tPlanet Details");
            System.out.println("\t--------------------------------");
            for (Planet planet: universe.getSolarSystems()[i].getPlanets()) {
                System.out.println("\t" + planet.getName());
                System.out.println("\t\tDistance from Star:\t" + df.format(planet.getDistanceFromParentStar() * 8.3167) + " lm");
                if (planet.getInHabitableZone()) {
                    System.out.println("\t\tStatus:\t\t\t\t\t\tinhabited");
                    System.out.println("\t\tPopulation:\t\t\t\t\t[NOT IMPLEMENTED]");
                    System.out.println("\t\tPolitical System:\t\t\t[NOT IMPLEMENTED]");
                    System.out.println("\t\tTech Level:\t\t\t\t\t[NOT IMPLEMENTED]");
                    System.out.println("\t\tResource Level:\t\t\t\t[NOT IMPLEMENTED]");
                    inhabitedPlanetsNum++;
                } else {
                    System.out.println("\t\tStatus:\t\t\t\t\t\tuninhabited");
                }
            }
        }
        System.out.println();
        System.out.println("Total number of inhabited planets: " + inhabitedPlanetsNum);*/
    }
}

