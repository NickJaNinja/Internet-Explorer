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
     * @param name name of player
     * @param fight fighter points
     * @param trade trader points
     * @param eng engineering points
     * @param pilot pilot points
     * @return true if OK button can move to next screen
     */
    public boolean onOk(String name, int fight, int trade, int eng, int pilot) {
        if (name == null || name.length() < 1) { return false; }
        int sum = fight + trade + eng + pilot;
        if (sum != 16) {
            return false;
        }
        return true;
    }

    /**
     * Returns false if button should not do anything,
     * true if skill point value should change
     *
     * @param pointsRemaining skill points left unspent
     * @param sign +1 if plus button, -1 if minus button
     * @return true if skill point can be updated
     */
    public boolean onSkill(int pointsRemaining, int sign) {
        if (pointsRemaining - sign < 0) {
            return false;
        }
        return true;
    }

}
