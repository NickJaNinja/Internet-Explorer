package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
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
    private SolarSystem solarSystem;
    private Planet selectedPlanet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


      //  FrameLayout layout = new FrameLayout(this);
      //  View.inflate(this, R.layout.planet, layout);
      //  View.inflate(this, R.layout.menu_bar, layout);

        setContentView(R.layout.solar_system_map);

        model = Model.getInstance();
        viewModel = ViewModelProviders.of(this).get(SolarSystemViewModel.class);

        solarSystem = viewModel.getCurrentSolarSystem();

      //  viewModel.setUpPlanets();



      //  name.setText("Planet:" + currPlanet.getName());
    //    distance.setText("" + currPlanet.getDistanceFromParentStar());


        recyclerViewPlanet = findViewById(R.id.planet_recycler_view);
        recyclerViewPlanet.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerViewPlanet.setHasFixedSize(true);

        adapterForPlanets = new PlanetAdapter(viewModel.getPlanetsInRange());
        recyclerViewPlanet.setAdapter(adapterForPlanets);

        coordinates = findViewById(R.id.coordinates_text);
        name = findViewById(R.id.name_text);
        distance = findViewById(R.id.distance_text);
       coordinates.setText(solarSystem.getCoordinates().toString());
       //  name.setText("Planet:" + currPlanet.getName());
        //    distance.setText("" + currPlanet.getDistanceFromParentStar());

    }
    @Override
    protected void onResume() {
        super.onResume();
        adapterForPlanets.setPlanetsList(viewModel.getPlanetsInRange());


    }

}
