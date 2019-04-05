package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.spacetraders.models.Model;

import com.example.spacetraders.entities.SolarSystem;

/**
 * a class that is responsible for preparing and managing the data for universe
 */
public class UniverseViewModel extends AndroidViewModel {
    private final Model model;
    private final double COORDINATE = 195.0;

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
    @Nullable
    public SolarSystem[] getSolarSystems() {
        return model.getSolarSystems();
    }

    /**
     * get the current solar system
     *
     * @return current solar system
     */
    @Nullable
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

    public double xCoordinatorOfSystem(@Nullable SolarSystem center, @Nullable SolarSystem goal) {
        return COORDINATE + (((goal.getCoordinates().getX() - center.getCoordinates()
                .getX()) * COORDINATE) / Model.getInstance().getMaxRange());

    }

    /**
     * get the x coordinate of the system
     *
     * @param center solar system in the center
     * @param goal solar system in the goal
     * @return the x coordinate of the system
     */
    public double yCoordinatorOfSystem(@Nullable SolarSystem center, @Nullable SolarSystem goal) {
        final int  CONSTANT = 30;
        return (CONSTANT + COORDINATE) - (((goal.getCoordinates().getY() - center
                .getCoordinates().getY()) * COORDINATE) / Model.getInstance().getMaxRange());
    }

}
