package com.example.spacetraders.views;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.spacetraders.R;

public class SolarSystemActivity extends GUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout layout = new FrameLayout(this);
        View.inflate(this, R.layout.planet, layout);
        View.inflate(this, R.layout.menu_bar, layout);
    }
}
