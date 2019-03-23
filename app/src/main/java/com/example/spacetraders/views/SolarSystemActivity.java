package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.SolarSystemViewModel;

public class SolarSystemActivity extends GUIActivity {
    private TextView name;
    private TextView distance;
    private TextView coordinates;
    private RecyclerView recyclerViewPlanet;
    private Model model;
    private SolarSystemViewModel viewModel;
    private PlanetAdapter adapterForPlanets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FrameLayout layout = new FrameLayout(this);
        View.inflate(this, R.layout.planet, layout);
        View.inflate(this, R.layout.menu_bar, layout);

        setContentView(R.layout.solar_system_map);

        this.model = Model.getInstance();
        viewModel = ViewModelProviders.of(this).get(SolarSystemViewModel.class);

        recyclerViewPlanet = findViewById(R.id.planet_recycler_view);
        recyclerViewPlanet.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPlanet.setHasFixedSize(true);

        adapterForPlanets = new PlanetAdapter(viewModel.getPlanets());
        recyclerViewPlanet.setAdapter(adapterForPlanets);










    }
}
