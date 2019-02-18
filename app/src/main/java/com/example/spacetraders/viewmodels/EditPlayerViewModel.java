package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.graphics.Color;
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
     * @return amount to change skill point value by
     */
    public int onSkill(int curr, int pointsRemaining, int sign) {
        if (pointsRemaining - sign < 0 || (curr == 0 && sign < 0)) {
            return 0;
        }
        else if (sign < 0) {
            return -1;
        }
        return 1;
    }

    /**
     * returns green color hex if currSkillRem is 0, else returns orange color hex
     *
     * @param currSkillRem current amount of skill points remaining
     * @return
     */
    public int onAnyButton(int currSkillRem) {
        if (currSkillRem == 0) return Color.parseColor("#FF5FCA77");
        else return Color.parseColor("#FFA500");
    }

}
