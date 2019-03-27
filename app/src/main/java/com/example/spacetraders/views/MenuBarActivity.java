package com.example.spacetraders.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.example.spacetraders.R;

public class MenuBarActivity extends GUIActivity {
    private ImageView inventory;
    private ImageView status;
    private ProgressBar fuel;
    private ProgressBar health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.menu_bar);
    }

    void createMenuBar() {
        inventory = findViewById(R.id.inventory_button);
        status = findViewById(R.id.status_button);
        fuel = findViewById(R.id.fuel_bar);
        health = findViewById(R.id.health_bar);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.status_bar2, null);
                final PopupWindow popupWindow = new PopupWindow(popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                //popupWindow.showAsDropDown(status, 0, v.getHeight());
                popupWindow.showAsDropDown(status, -20, -400);
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fuel.setMax(100);
        fuel.setProgress(70);
    }
}
