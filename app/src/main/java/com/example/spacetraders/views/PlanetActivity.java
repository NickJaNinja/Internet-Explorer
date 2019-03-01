package com.example.spacetraders.views;

import android.os.Bundle;
import android.widget.Button;

import com.example.spacetraders.R;

public class PlanetActivity extends GUIActivity {
    private Button market;
    private Button upgrade;
    private Button refuel;
    private Button leaveOrbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);
    }

}
