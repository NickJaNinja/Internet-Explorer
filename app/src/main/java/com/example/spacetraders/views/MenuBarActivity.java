package com.example.spacetraders.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        setContentView(R.layout.menu_bar);

        inventory = findViewById(R.id.inventory_button);
        status = findViewById(R.id.status_button);
        fuel = findViewById(R.id.fuel_bar);
        health = findViewById(R.id.health_bar);

        /*
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("info", "test log");
                System.out.println("test");
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fuel.setMax(100);
        fuel.setProgress(70);
        */
    }
}
