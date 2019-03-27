package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.models.Model;

import com.example.spacetraders.entities.SolarSystem;

public class UniverseViewModel extends AndroidViewModel {
    private Model model;

    public UniverseViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
    }

    public SolarSystem[] getSolarSystems() {
        return model.getSolarSystems();
    }

    public SolarSystem getCurrentSystem() {
        return model.getCurrentSystem();
    }

    public double xCoordOfSystem(SolarSystem center, SolarSystem goal) {
        return 195 + (goal.getCoordinates().getX()-center.getCoordinates().getX())*195.0/80;
    }

    public double yCoordOfSystem(SolarSystem center, SolarSystem goal) {
        return 30 + 195 - (goal.getCoordinates().getY()-center.getCoordinates().getY())*195.0/80;
    }

}
