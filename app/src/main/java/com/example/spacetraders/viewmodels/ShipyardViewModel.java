package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.entities.ShipType;
import com.example.spacetraders.entities.TechLevel;
import com.example.spacetraders.models.Model;

import java.util.List;

public class ShipyardViewModel extends AndroidViewModel {

    private final Model model;

    public ShipyardViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
    }

    public List getShipsBasedOnTechLevel() {
        return Model.getInstance().getShipsBasedOnTechLevel();
    }
}
