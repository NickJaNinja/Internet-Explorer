package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.SolarSystemViewModel;

import java.text.DecimalFormat;

public class SolarSystemActivity extends GUIActivity {
    private TextView name;
    private TextView classification;
    private TextView radius;
    private TextView mass;
    private TextView surfaceTemp;
    private TextView luminosity;
    private RecyclerView recyclerViewPlanet;
    private ImageView starView;
    private Model model;
    private SolarSystemViewModel viewModel;
    private PlanetAdapter adapterForPlanets;
    private SolarSystem solarSystem;
    private Planet selectedPlanet;
    private Button thrusterButton;

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

        starView = findViewById(R.id.star_image);
        name = findViewById(R.id.star_name);
        classification = findViewById(R.id.star_classification);
        radius = findViewById(R.id.star_radius);
        mass = findViewById(R.id.star_mass);
        surfaceTemp = findViewById(R.id.star_surface_temperature);
        luminosity = findViewById(R.id.star_luminosity);
        thrusterButton = findViewById(R.id.thrusters_button);

        DecimalFormat dfe = new DecimalFormat("#.#E0");
        DecimalFormat df = new DecimalFormat("#.##");

        name.setText(solarSystem.getName() + "");
        classification.setText(solarSystem.getStars()[0].getClassification() + " Class Star");
        radius.setText("Radius: " + df.format(solarSystem.getStars()[0].getRadiusInKm()*1.58125E-5) + " Ly");
        mass.setText("Mass: " + dfe.format(solarSystem.getStars()[0].getMassInKg()) + " kg");
        surfaceTemp.setText("Temp: " + dfe.format(solarSystem.getStars()[0].getTemperature()) + " K");
        luminosity.setText("Luminosity: " + dfe.format(solarSystem.getStars()[0].getLuminosityInWatts()) + " W");

        thrusterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPlanet = adapterForPlanets.getSelectedPlanet();
                Toast toast = Toast.makeText(v.getContext(), selectedPlanet.getName().toString(), Toast.LENGTH_SHORT);
                toast.show();
                if (model.travelToPlanet(selectedPlanet) == 1) {
                    Intent newIntent = new Intent(SolarSystemActivity.this, PlanetActivity.class);
                    startActivity(newIntent);

                }
            }
        });



    }
    @Override
    protected void onResume() {
        super.onResume();
        adapterForPlanets.setPlanetsList(viewModel.getPlanetsInRange());


    }

    public void setSelectedPlanet(Planet p) {
        this.selectedPlanet = p;
    }

}
