package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.viewmodels.UniverseViewModel;

public class UniverseMapActivity extends GUIActivity{

    private TextView nameOfPlanet;
    private TextView distance;
    private TextView coordinates;
    private Button engageWarpDrive;
    private UniverseViewModel universeViewModel;
    private ImageView theCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universe_map);

        nameOfPlanet = findViewById(R.id.name_text);
        distance = findViewById(R.id.distance_text);
        coordinates = findViewById(R.id.coordinates_text);
        engageWarpDrive = findViewById(R.id.warp_button);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        theCircle = findViewById(R.id.local_universe);

        for (int i = 0; i < universeViewModel.getSolarSystems().length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.solarsystemsquare);

            FrameLayout relativeLayout = (FrameLayout) findViewById(R.id.mapframe);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
            );

            relativeLayout.addView(imageView, layoutParams);
        }

        theCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });


        engageWarpDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
