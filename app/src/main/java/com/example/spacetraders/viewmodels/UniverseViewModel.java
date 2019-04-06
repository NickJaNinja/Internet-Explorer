package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.spacetraders.models.Model;

import com.example.spacetraders.entities.SolarSystem;

import java.util.Objects;

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
        if (Objects.requireNonNull(goal).getCoordinates() != null && Model.getInstance() != null) {
            return COORDINATE + (((Objects.requireNonNull(goal).getCoordinates().getX() - Objects.requireNonNull(center).getCoordinates()
                    .getX()) * COORDINATE) / Model.getInstance().getMaxRange());
        }
        return 0;
    }

    /**
     * get the x coordinate of the system
     *
     * @param center solar system in the center
     * @param goal solar system in the goal
     * @return the x coordinate of the system
     */
    public double yCoordinatorOfSystem(@Nullable SolarSystem center, @Nullable SolarSystem goal) {
        final int CONSTANT = 30;
        if (Objects.requireNonNull(goal).getCoordinates() != null && Model.getInstance() != null) {
            return (CONSTANT + COORDINATE) - (((Objects.requireNonNull(goal).getCoordinates().getY() - Objects.requireNonNull(center)
                    .getCoordinates().getY()) * COORDINATE) / Model.getInstance().getMaxRange());
        }
        return 0;
    }
}
