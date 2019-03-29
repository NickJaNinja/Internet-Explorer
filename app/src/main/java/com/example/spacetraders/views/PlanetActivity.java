package com.example.spacetraders.views;

import android.annotation.TargetApi;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.ShopViewModel;

public class PlanetActivity extends MenuBarActivity {
    private TextView market;
    private TextView upgrade;
    private TextView refuel;
    private TextView leaveOrbit;
    private Planet planet;
    private ShopViewModel viewModel;
    private Model model;
    private MediaPlayer mediaPlayer;
    private ImageView planetImage;
    private TextView name;
    private LinearLayout layout;

    private TextView map;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        layout = findViewById(R.id.linear_layout);
        //layout.getForeground().setAlpha(0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        //createMenuBar();

        viewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        model = Model.getInstance();
        planet = model.getCurrentPlanet();
        name = (TextView)findViewById(R.id.planet_name_text);

        market = findViewById(R.id.market_button);
        upgrade = findViewById(R.id.upgrade_button);
        refuel = findViewById(R.id.refuel_button);
        leaveOrbit = findViewById(R.id.leave_orbit_button);

        // globally

        name.setText(planet.getName());

        // music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shopping_spree_planet);
        mediaPlayer.setLooping(true);
        try {
            mediaPlayer.prepare();
        } catch (Exception e) {
            System.out.println(e);
        }
        mediaPlayer.start();

        // pressing anywhere on layout undims layout
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.getForeground().setAlpha(0);
            }
        });

        // pressing market button
        market.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.stop();
                Intent intent = new Intent(v.getContext(), ShopActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        upgrade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

        leaveOrbit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SolarSystemActivity.class);
                startActivityForResult(intent,0);
            }
        });

        refuel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                model.refuelShipMax();
                //updateFuelBar();
                Log.d("Debug", "Refuel button clicked");
            }
        });


        // rotate content_planet animation
        planetImage = findViewById(R.id.planet_image);
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setDuration(300000);
        rotate.setInterpolator(new LinearInterpolator());
        planetImage.startAnimation(rotate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    // android back button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
