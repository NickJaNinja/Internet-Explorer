package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.spacetraders.entities.Player;
import com.example.spacetraders.models.PlayerInteractor;

public class EditPlayerViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;

    public EditPlayerViewModel(@NonNull Application app) { super(app); }

    public void setPlayer(Player p) { interactor.setPlayer(p); }
}
