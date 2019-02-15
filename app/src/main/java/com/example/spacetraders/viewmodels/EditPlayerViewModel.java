package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.spacetraders.models.PlayerInteractor;

public class EditPlayerViewModel {
    private PlayerInteractor interactor;

    public EditPlayerViewModel(@NonNull Application app) {
        super(app);
    }


}
