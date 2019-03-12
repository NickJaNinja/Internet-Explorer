package com.example.spacetraders.views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;

public class PlanetActivity extends GUIActivity {
    private TextView market;
    private TextView upgrade;
    private TextView refuel;
    private TextView leaveOrbit;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);

        market = findViewById(R.id.market_button);
        upgrade = findViewById(R.id.upgrade_button);
        refuel = findViewById(R.id.refuel_button);
        leaveOrbit = findViewById(R.id.leave_orbit_button);

    }

}
