package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class EditPlayerViewModel extends AndroidViewModel {
    public EditPlayerViewModel(@NonNull Application app) { super(app); }

    /**
     *
     *
     * @param name
     * @param fight
     * @param trade
     * @param eng
     * @param pilot
     * @return
     */
    public boolean onOk(String name, int fight, int trade, int eng, int pilot) {
        if (name == null || name.length() < 1) { return false; }
        int sum = fight + trade + eng + pilot;
        if (sum != 16) {
            return false;
        }
        return true;
    }
}
