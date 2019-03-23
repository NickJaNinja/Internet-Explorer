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

import android.graphics.Color;

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

        FrameLayout layout = new FrameLayout(this);
        View.inflate(this, R.layout.planet, layout);
        View.inflate(this, R.layout.menu_bar, layout);

        setContentView(layout);

        nameOfPlanet = findViewById(R.id.name_text);
        distance = findViewById(R.id.distance_text);
        coordinates = findViewById(R.id.coordinates_text);
        engageWarpDrive = findViewById(R.id.warp_button);
        universeViewModel = ViewModelProviders.of(this).get(UniverseViewModel.class);
        theCircle = findViewById(R.id.local_universe);

        for (int i = 0; i < universeViewModel.getSolarSystems().length; i++) {
            if (universeViewModel.getSolarSystems()[i].dist(universeViewModel.getCurrentSystem()) < 20) {
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
                imageView.setBackgroundColor(universeViewModel.getSolarSystems()[i].getStars()[0].getColor());
                relativeLayout.addView(imageView, layoutParams);
            }
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
