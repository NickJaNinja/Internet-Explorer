package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.models.Model;

public class UniverseViewModel extends AndroidViewModel {
    private Model model;

    public UniverseViewModel(@NonNull Application app) {
        super(app);
        model = Model.getInstance();
    }

    public boolean onTravel(int fuel, int distance) {
        return fuel >= distance;
    }




}
