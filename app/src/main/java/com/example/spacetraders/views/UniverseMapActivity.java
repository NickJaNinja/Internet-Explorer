package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.entities.Universe;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.UniverseViewModel;

import android.graphics.Color;
import android.widget.Toast;

import java.util.List;

public class UniverseMapActivity extends GUIActivity{

    private TextView nameOfPlanet;
    private TextView distance;
    private TextView coordinates;
    private TextView range;
    private Button engageWarpDrive;
    private UniverseViewModel universeViewModel;
    private ImageView theCircle;
    private SolarSystem currentSolarSystem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.universe_map);

        nameOfPlanet = findViewById(R.id.name_text);
        distance = findViewById(R.id.distance_text);
        coordinates = findViewById(R.id.coordinates_text);
        range = findViewById(R.id.range_text);
        engageWarpDrive = findViewById(R.id.warp_button);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        theCircle = findViewById(R.id.local_universe);

        currentSolarSystem = universeViewModel.getCurrentSystem();
        nameOfPlanet.setText("" + currentSolarSystem.getName());
        distance.setText("0 Ly");
        coordinates.setText("" + currentSolarSystem.getCoordinates().toString());
        range.setText(Model.getInstance().getRange() + " Ly");

        for (int i = 0; i < universeViewModel.getSolarSystems().length; i++) {
            if (universeViewModel.getSolarSystems()[i].dist(universeViewModel.getCurrentSystem()) < Model.getInstance().getMaxRange()) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.solarsystemsquare);

                FrameLayout relativeLayout = (FrameLayout) findViewById(R.id.mapframe);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
                );
                //factor is for converting dp to px
                float factor = relativeLayout.getContext().getResources().getDisplayMetrics().density;
                layoutParams.leftMargin = (int) (universeViewModel.xCoordOfSystem(universeViewModel.getCurrentSystem(), universeViewModel.getSolarSystems()[i]) * factor); //Your X coordinate
                layoutParams.topMargin = (int) (universeViewModel.yCoordOfSystem(universeViewModel.getCurrentSystem(), universeViewModel.getSolarSystems()[i]) * factor); //Your Y coordinate
                //color
                imageView.setBackgroundColor(universeViewModel.getSolarSystems()[i].getStars()[0].getColor());

                relativeLayout.addView(imageView, layoutParams);

                int j = i;

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        currentSolarSystem = universeViewModel.getSolarSystems()[j];
                        nameOfPlanet.setText("" + universeViewModel.getSolarSystems()[j].getName());
                        distance.setText(universeViewModel.getSolarSystems()[j].dist(universeViewModel.getCurrentSystem()) + " Ly");
                        coordinates.setText("" + currentSolarSystem.getCoordinates().toString());
                    }
                });
            }
        }




        engageWarpDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSolarSystem == null) {
                    CharSequence text = "No System Selected";
                    Toast toast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                //Log.d("Debug", "current Solar System>>>>>>>>>>>>>" + currentSolarSystem);
                //Log.d("Debug", "universeViewModel.getCurrentSystem()>>>>>>>>>>>>>>>>>>" + universeViewModel.getCurrentSystem());
                if (Model.getInstance().travelToSystem(currentSolarSystem) == 0) {
                    CharSequence text = "Not Enough Fuel";
                    Toast toast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                //Log.d("Debug", "current Solar System>>>>>>>>>>>>>" + currentSolarSystem);
                //Log.d("Debug", "universeViewModel.getCurrentSystem()>>>>>>>>>>>>>>>>>>" + universeViewModel.getCurrentSystem());
                Intent newIntent = new Intent(UniverseMapActivity.this, PlanetActivity.class);
                //Log.d("Debug", "current Solar System>>>>>>>>>>>>>" + currentSolarSystem);
                //Log.d("Debug", "universeViewModel.getCurrentSystem()>>>>>>>>>>>>>>>>>>" + universeViewModel.getCurrentSystem());
                startActivity(newIntent);
                //Log.d("Debug", "current Solar System>>>>>>>>>>>>>" + currentSolarSystem);
                //Log.d("Debug", "universeViewModel.getCurrentSystem()>>>>>>>>>>>>>>>>>>" + universeViewModel.getCurrentSystem());
            }
        });


    }
}
