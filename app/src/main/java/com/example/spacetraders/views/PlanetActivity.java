package com.example.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.ShopViewModel;

public class PlanetActivity extends GUIActivity {
    private TextView market;
    private TextView upgrade;
    private TextView refuel;
    private TextView leaveOrbit;
    private Planet planet;
    private ShopViewModel viewModel;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);

        market = findViewById(R.id.market_button);
        upgrade = findViewById(R.id.upgrade_button);
        refuel = findViewById(R.id.refuel_button);
        leaveOrbit = findViewById(R.id.leave_orbit_button);

        // pressing market button
        market.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.setShop(planet.getShop());
                Intent intent = new Intent(v.getContext(), ShopActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }

}
