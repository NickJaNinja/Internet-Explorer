package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.models.Model;

/**
 * ViewModel for player configuration
 */
public class EditPlayerViewModel extends AndroidViewModel {

    /**
     *  VM constructor
     * @param app the app
     */
    public EditPlayerViewModel(@NonNull Application app) {
        super(app);
    }

    private String toastText;

    /**
     * Checks to see if player is configured correctly
     *
     * @param name  name of player
     * @param fight fighter points
     * @param trade trader points
     * @param eng   engineering points
     * @param pilot pilot points
     * @param diff game difficulty
     * @return true if OK button can move to next screen
     */
    public boolean onOk(String name, int fight, int trade, int eng, int pilot,
                        GameDifficulty diff) {
        Model model = Model.getInstance();
        if (name == null || name.length() < 1) {
            toastText = "Please enter your pilot's name";
            return false;
        }
        int sum = fight + trade + eng + pilot;
        if (sum != 16) {
            toastText = "Please use all of your skill points";
            return false;
        }

        model.createGame(diff, name, pilot, fight, trade, eng);
        return true;
    }

    /**
     * returns value of String toastText
     *
     * @return value of toastText
     */
    public String getToastText() {
        return toastText;
    }

    /**
     * Returns false if button should not do anything,
     * true if skill point value should change
     *
     * @param curr current number of skill points in this skill
     * @param pointsRemaining skill points left unspent
     * @param sign            +1 if plus button, -1 if minus button
     * @return amount to change skill point value by
     */
    public int onSkill(int curr, int pointsRemaining, int sign) {
        if (pointsRemaining - sign < 0 || (curr == 0 && sign < 0)) {
            return 0;
        } else if (sign < 0) {
            return -1;
        }
        return 1;
    }

    /**
     * returns green color hex if currSkillRem is 0, else returns orange color hex
     *
     * @param currSkillRem current amount of skill points remaining
     * @return the color to use
     */
    public int onAnyButton(int currSkillRem) {
        if (currSkillRem == 0) return Color.parseColor("#FF5FCA77");
        else return Color.parseColor("#FFA500");
    }

}
