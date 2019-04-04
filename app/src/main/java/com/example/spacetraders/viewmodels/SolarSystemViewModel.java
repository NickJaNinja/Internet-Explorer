package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;

/**
 * solar system view model
 */
public class SolarSystemViewModel extends AndroidViewModel {
    private final Model model;
    private final SolarSystem currentSolarSystem;
    // --Commented out by Inspection (4/2/19, 11:04 PM):private Planet[] planetsInRange;

    /**
     * solar system view model
     *
     * @param app application
     */
    public SolarSystemViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
        currentSolarSystem = model.getCurrentSystem();
// --Commented out by Inspection START (4/2/19, 11:04 PM):
//        planetsInRange = currentSolarSystem.getPlanets();
//    }
//
//    /**
//     * set up planets
//     */
//    public void setUpPlanets() {
//        planetsInRange = currentSolarSystem.getPlanets();
// --Commented out by Inspection STOP (4/2/19, 11:04 PM)
    }

    /**
     * get planet in range
     *
     * @return list of planets in range
     */
    public Planet[] getPlanetsInRange() {

        return currentSolarSystem.getPlanets();
    }

// --Commented out by Inspection START (4/2/19, 11:04 PM):
//    /**
//     * get current planets
//     *
//     * @return planet
//     */
//    public Planet getCurrentPlanet() {
//        return model.getCurrentPlanet();
//    }
// --Commented out by Inspection START (4/2/19, 11:04 PM):
//// --Commented out by Inspection STOP (4/2/19, 11:04 PM)
//
    /**
     * get current solar system
     *
     * @return solar system
     */
    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    /**
     * set planet
     *
     * @param p planet
     */
    public void setPlanet(Planet p) {
        model.setCurrentPlanet(p);
    }

}
