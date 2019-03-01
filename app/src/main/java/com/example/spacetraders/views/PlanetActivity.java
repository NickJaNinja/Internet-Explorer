package com.example.spacetraders.views;

import android.os.Bundle;
import android.widget.TextView;

import com.example.spacetraders.R;

public class PlanetActivity extends GUIActivity {
    private TextView market;
    private TextView upgrade;
    private TextView refuel;
    private TextView leaveOrbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);

        market = findViewById(R.id.market_text);
        upgrade = findViewById(R.id.upgrade_text);
        refuel = findViewById(R.id.refuel_text);
        leaveOrbit = findViewById(R.id.leave_orbit__text);
    }

}
