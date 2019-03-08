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





        // Connecting button instance variables with planet.xml buttons
        market.findViewById(R.id.market_button);
        upgrade.findViewById(R.id.upgrade_button);
        refuel.findViewById(R.id.refuel_button);
        leaveOrbit.findViewById(R.id.leave_orbit_button);
    }

}
