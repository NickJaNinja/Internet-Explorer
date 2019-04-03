package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.models.Model;

import com.example.spacetraders.entities.SolarSystem;

/**
 * a class that is responsible for preparing and managing the data for universe
 */
public class UniverseViewModel extends AndroidViewModel {
    private Model model;

    /**
     * constructor for universe
     *
     * @param app application app
     */
    public UniverseViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
    }

    /**
     * get the list of solar systems
     *
     * @return list of solar systems
     */
    public SolarSystem[] getSolarSystems() {
        return model.getSolarSystems();
    }

    /**
     * get the current solar system
     *
     * @return current solar system
     */
    public SolarSystem getCurrentSystem() {
        return model.getCurrentSystem();
    }

    /**
     * get the x coordinate of the system
     *
     * @param center solar system in the center
     * @param goal solar system in the goal
     * @return the x coordinate of the system
     */
    public double xCoordOfSystem(SolarSystem center, SolarSystem goal) {
        return 195 + (goal.getCoordinates().getX()-center.getCoordinates().getX())*195.0/Model.getInstance().getMaxRange();
    }

    /**
     * get the x coordinate of the system
     *
     * @param center solar system in the center
     * @param goal solar system in the goal
     * @return the x coordinate of the system
     */
    public double yCoordOfSystem(SolarSystem center, SolarSystem goal) {
        return 30 + 195 - (goal.getCoordinates().getY()-center.getCoordinates().getY())*195.0/Model.getInstance().getMaxRange();
    }

}
