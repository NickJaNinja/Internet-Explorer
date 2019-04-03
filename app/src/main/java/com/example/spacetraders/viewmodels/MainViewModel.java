package com.example.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

public class MainViewModel extends AndroidViewModel {

    public MainViewModel(@NonNull Application app) {
        super(app);
    }


    // remove later, only use this for m6
    /*public void printUniverse(Game g) {
        largeLog("Info", Model.getInstance().getGame().getUniverse().toString());
    }*/

    public static void largeLog(String tag, String content) {
        if (content.length() > 4000) {
            Log.d(tag, content.substring(0, 4000));
            largeLog(tag, content.substring(4000));
        } else {
            Log.d(tag, content);
        }
    }

}
