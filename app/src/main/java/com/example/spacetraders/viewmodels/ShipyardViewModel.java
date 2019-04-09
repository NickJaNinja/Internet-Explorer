package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.spacetraders.entities.ShipType;
import com.example.spacetraders.models.Model;

import java.util.List;

/**
 * ship yard view model
 */
public class ShipyardViewModel extends AndroidViewModel {

    private final Model model;

    /**
     * ship yard view model
     * @param app application
     */
    public ShipyardViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
    }

    /**
     *
     * @return list of ships based on  tech level
     */
    @Nullable
    public List<ShipType> getShipsBasedOnTechLevel() {
        return model.getShipsBasedOnTechLevel();
    }
}
