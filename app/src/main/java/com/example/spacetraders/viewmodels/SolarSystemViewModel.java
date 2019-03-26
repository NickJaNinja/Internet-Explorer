package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;

public class SolarSystemViewModel extends AndroidViewModel {
    private Model model;
    private SolarSystem currentSolarSystem;
    private Planet[] planetsInRange;

    public SolarSystemViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
        currentSolarSystem = model.getCurrentSystem();
        planetsInRange = currentSolarSystem.getPlanets();
    }

    public void setUpPlanets() {
      planetsInRange = currentSolarSystem.getPlanets();
    }


    public Planet[] getPlanetsInRange() {
        Planet[] planetsInRange;
        for (int i = 0; i < currentSolarSystem.getPlanets().length; i++) {
            System.out.println((currentSolarSystem.getPlanets())[i].getDistanceFromParentStar());
        }
        return currentSolarSystem.getPlanets();
    }

    public Planet getCurrentPlanet() {
        return model.getCurrentPlanet();
    }

    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

}
