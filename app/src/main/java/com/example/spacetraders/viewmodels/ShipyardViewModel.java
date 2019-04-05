package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.models.Model;

import java.util.List;

public class ShipyardViewModel extends AndroidViewModel {

    public ShipyardViewModel(@NonNull Application app) {
        super(app);
        Model model = Model.getInstance();
    }

    public List getShipsBasedOnTechLevel() {
        Model model;
        return model.getShipsBasedOnTechLevel();
    }
}
