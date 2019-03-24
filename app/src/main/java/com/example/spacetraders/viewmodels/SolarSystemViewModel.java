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

    public SolarSystemViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
        currentSolarSystem = model.getCurrentSystem();
    }



    public Planet[] getPlanets() {
        return currentSolarSystem.getPlanets();
    }

    public Planet getCurrentPlanet() {
        return model.getCurrentPlanet();
    }

    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

}
