package com.example.spacetraders.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.models.Model;

public class MenuBarActivity extends GUIActivity {
    private ImageView inventory;
    private ImageView status;
    private ProgressBar fuel;
    private ProgressBar health;

    private TextView map;

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
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                // dimming screen
                findViewById(R.id.linear_layout).getForeground().setAlpha(140);

                // menubar popping up
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.status_bar2, null);
                final PopupWindow popupWindow = new PopupWindow(popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setOutsideTouchable(true);

                //popupWindow.showAsDropDown(status, 0, v.getHeight());
                popupWindow.showAsDropDown(status, -105, -470);

                map = popupWindow.getContentView().findViewById(R.id.map_button);

                map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), UniverseMapActivity.class);
                        startActivityForResult(intent, 0);
                    }
                });
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        fuel.setMax(100);
        updateFuelBar();
    }

    void updateFuelBar() {
        fuel.setProgress(Model.getInstance().getFuelPercentage());
    }
}
