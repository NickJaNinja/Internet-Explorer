package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.SolarSystemViewModel;

import java.text.DecimalFormat;

/**
 * solar system activity
 */
public class SolarSystemActivity extends GUIActivity {
    private Model model;
    private SolarSystemViewModel viewModel;
    private PlanetAdapter adapterForPlanets;
    private Planet selectedPlanet;
    private Button thrusterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView name;
        TextView classification;
        TextView radius;
        TextView mass;
        TextView surfaceTemp;
        TextView luminosity;
        RecyclerView recyclerViewPlanet;
       // ImageView starView;
       // ImageView planetImage;
        SolarSystem solarSystem;

        setContentView(R.layout.solar_system_map);

        model = Model.getInstance();
        viewModel = ViewModelProviders.of(this).get(SolarSystemViewModel.class);

        solarSystem = viewModel.getCurrentSolarSystem();


        recyclerViewPlanet = findViewById(R.id.planet_recycler_view);
        recyclerViewPlanet.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerViewPlanet.setHasFixedSize(true);

        adapterForPlanets = new PlanetAdapter(viewModel.getPlanetsInRange());
        recyclerViewPlanet.setAdapter(adapterForPlanets);


        //starView = findViewById(R.id.star_image);
        name = findViewById(R.id.star_name);
        classification = findViewById(R.id.star_classification);
        radius = findViewById(R.id.star_radius);
        mass = findViewById(R.id.star_mass);
        surfaceTemp = findViewById(R.id.star_surface_temperature);
        luminosity = findViewById(R.id.star_luminosity);
        thrusterButton = findViewById(R.id.thrusters_button);
       // planetImage = findViewById(R.id.planet_image);

        DecimalFormat dfe = new DecimalFormat("#.#E0");
        DecimalFormat df = new DecimalFormat("#.##");

        final double RADIUS_CONSTANT = 1.58125E-5;
        name.setText(solarSystem.getName() + "");
        classification.setText(solarSystem.getStars()[0].getClassification() + " Class Star");
        radius.setText("Radius: " + df.format(solarSystem.getStars()[0].getRadiusInKm()
                * RADIUS_CONSTANT) + " Ly");
        mass.setText("Mass: " + dfe.format(solarSystem.getStars()[0].getMassInKg()) + " kg");
        surfaceTemp.setText("Temp: " + dfe.format(solarSystem.getStars()[0].getTemperature())
                + " K");
        luminosity.setText("Luminosity: " + dfe.format(
                solarSystem.getStars()[0].getLuminosityInWatts()) + " W");

        //initialize button color to red
        thrusterButton.setBackgroundColor(Color.parseColor("#D25A64"));


        thrusterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedPlanet == null) {
                    Toast toast = Toast.makeText(v.getContext(),"No Planet Selected" ,
                            Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast1 = Toast.makeText(v.getContext(), selectedPlanet.getName(),
                            Toast.LENGTH_SHORT);
                    toast1.show();
                    if (model.travelToPlanet(selectedPlanet) == 1) {
                        Intent newIntent = new Intent(SolarSystemActivity.this,
                                PlanetActivity.class);
                        startActivity(newIntent);

                    }
                }
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        adapterForPlanets.setPlanetsList(viewModel.getPlanetsInRange());
        adapterForPlanets.setOnClickListener(new PlanetAdapter.OnClickListener() {
            @Override
            public void onClicked(Planet planet) {
                setSelectedPlanet(planet);
                if (selectedPlanet == null) {
                    thrusterButton.setBackgroundColor(Color.parseColor("#D25A64"));
                } else {
                    //change button color to green after clicking on a planet
                    thrusterButton.setBackgroundColor(Color.parseColor("#5FCA77"));
               /*     planetImage = findViewById(R.id.planet_image);
                    RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setRepeatCount(Animation.INFINITE);
                    rotate.setDuration(3);
                    rotate.setInterpolator(new LinearInterpolator());
                    planetImage.startAnimation(rotate);*/
                }
            }
        });


    }

    /**
     * set planet selected
     * @param p the selected destination planet
     */
    public void setSelectedPlanet(Planet p) {
        this.selectedPlanet = p;
    }

}
