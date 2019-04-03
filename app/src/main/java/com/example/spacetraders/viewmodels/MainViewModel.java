package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * main view model
 */
public class MainViewModel extends AndroidViewModel {

    /**
     * main view model
     *
     * @param app application app
     */
    public MainViewModel(@NonNull Application app) {
        super(app);
    }


    // remove later, only use this for m6
    /*public void printUniverse(Game g) {
        largeLog("Info", Model.getInstance().getGame().getUniverse().toString());
    }*/

    /**
     * large log
     *
     * @param tag string tag
     * @param content string contect
     */
    public static void largeLog(String tag, String content) {
        if (content.length() > 4000) {
            Log.d(tag, content.substring(0, 4000));
            largeLog(tag, content.substring(4000));
        } else {
            Log.d(tag, content);
        }
    }

}
