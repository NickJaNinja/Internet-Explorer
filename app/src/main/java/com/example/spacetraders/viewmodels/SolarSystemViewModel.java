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
    private Model model;
    private SolarSystem currentSolarSystem;
    private Planet[] planetsInRange;

    /**
     * solar system view model
     *
     * @param app application
     */
    public SolarSystemViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
        currentSolarSystem = model.getCurrentSystem();
        planetsInRange = currentSolarSystem.getPlanets();
    }

    /**
     * set up planets
     */
    public void setUpPlanets() {
        planetsInRange = currentSolarSystem.getPlanets();
    }

    /**
     * get planet in range
     *
     * @return list of planets in range
     */
    public Planet[] getPlanetsInRange() {

        return currentSolarSystem.getPlanets();
    }

    /**
     * get current planets
     *
     * @return planet
     */
    public Planet getCurrentPlanet() {
        return model.getCurrentPlanet();
    }

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
