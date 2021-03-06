package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.UniverseViewModel;

import java.util.Objects;

/**
 * universe map activity class
 */
public class UniverseMapActivity extends AppCompatActivity {

    private TextView nameOfPlanet;
    private TextView distance;
    private TextView coordinates;
    private Button engageWarpDrive;
    private UniverseViewModel universeViewModel;
    private SolarSystem currentSolarSystem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.universe_map);

        nameOfPlanet = findViewById(R.id.name_text);
        distance = findViewById(R.id.distance_text);
        coordinates = findViewById(R.id.coordinates_text);
        TextView range = findViewById(R.id.range_text);
        engageWarpDrive = findViewById(R.id.warp_button);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
       // ImageView theCircle = findViewById(R.id.local_universe);

        if (universeViewModel.getCurrentSystem() != null && universeViewModel.getCurrentSystem().getCoordinates() != null && Model.getInstance() != null && universeViewModel != null) {
            nameOfPlanet.setText(universeViewModel.getCurrentSystem().getName());
            String joi = "0 Ly";
            distance.setText(joi);
            coordinates.setText(universeViewModel.getCurrentSystem().getCoordinates().toString());
            String yox = Model.getInstance().getRange() + " Ly";
            range.setText(yox);
            engageWarpDrive.setBackgroundColor(Color.parseColor("#D25A64"));

            if (universeViewModel != null && universeViewModel.getCurrentSystem() != null && universeViewModel.getSolarSystems() != null) {
                for (int i = 0; i < universeViewModel.getSolarSystems().length; i++) {
                    if ((universeViewModel.getSolarSystems()[i].dist(universeViewModel.getCurrentSystem())
                            < Model.getInstance().getMaxRange())
                            && !universeViewModel.getSolarSystems()[i].equals(
                            universeViewModel.getCurrentSystem())) {
                        ImageView imageView = new ImageView(this);
                        imageView.setImageResource(R.drawable.solarsystemsquare);

                        FrameLayout relativeLayout = findViewById(R.id.mapFrame);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                                FrameLayout.LayoutParams.WRAP_CONTENT,
                                FrameLayout.LayoutParams.WRAP_CONTENT
                        );
                        //factor is for converting dp to px
                        float factor = relativeLayout.getContext().getResources().getDisplayMetrics()
                                .density;
                        layoutParams.leftMargin = (int) (universeViewModel.xCoordinatorOfSystem(
                                universeViewModel.getCurrentSystem(),
                                universeViewModel.getSolarSystems()[i]) * factor); //Your X coordinate
                        layoutParams.topMargin = (int) (universeViewModel.yCoordinatorOfSystem(
                                universeViewModel.getCurrentSystem(),
                                universeViewModel.getSolarSystems()[i]) * factor); //Your Y coordinate
                        //color
                        if (universeViewModel.getSolarSystems()[i] != null && universeViewModel.getSolarSystems()[i].getStars() != null)
                        imageView.setBackgroundColor(Objects.requireNonNull(Objects.requireNonNull(universeViewModel.getSolarSystems())[i]
                                .getStars())[0].getColor());

                        relativeLayout.addView(imageView, layoutParams);

                        int j = i;

                        imageView.setOnClickListener((View v) -> {
                            currentSolarSystem = universeViewModel.getSolarSystems()[j];
                            nameOfPlanet.setText(currentSolarSystem.getName());
                            String slk = currentSolarSystem.dist(
                                    universeViewModel.getCurrentSystem()) + " Ly";
                            distance.setText(slk);
                            if (currentSolarSystem.getCoordinates() != null) {
                                coordinates.setText(currentSolarSystem.getCoordinates().toString());
                            }

                            // TODO draw a line between ship and star when star is selected

                            // make travel button red if system out of range, green if in range
                            if (Model.getInstance().getRange() < currentSolarSystem.dist(
                                    universeViewModel.getCurrentSystem())) {
                                engageWarpDrive.setBackgroundColor(Color.parseColor(
                                        "#D25A64")); // red
                            } else {
                                engageWarpDrive.setBackgroundColor(Color.parseColor(
                                        "#5FCA77")); // green
                            }
                        });
                    }
                }
            }
        }



        engageWarpDrive.setOnClickListener((View v)-> {
                if (Model.getInstance().isOnWarpGatePlanet()) {
                    CharSequence text = "Not on planet with Warp Gate";
                    Toast toast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (currentSolarSystem == null) {
                    CharSequence text = "No System Selected";
                    Toast toast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (Model.getInstance().travelToSystem(currentSolarSystem) == 0) {
                    CharSequence text = "Not Enough Fuel";
                    Toast toast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                Intent newIntent = new Intent(UniverseMapActivity.this,
                        PlanetActivity.class);
                startActivity(newIntent);
        });


    }
}
