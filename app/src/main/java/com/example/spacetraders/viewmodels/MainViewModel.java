package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.spacetraders.entities.Game;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application app) { super(app); }


    // remove later, only use this for m6
    public void printUniverse(Game g) {
        Log.d("Info", g.getUniverse().toString());
    }

}
