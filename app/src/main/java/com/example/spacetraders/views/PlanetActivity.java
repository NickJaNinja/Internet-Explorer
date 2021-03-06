package com.example.spacetraders.views;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;

//import com.example.space traders.entities.Planet;
import com.example.spacetraders.models.Model;

import java.util.Objects;
import java.util.Random;

/**
 * planet activity class
 */
public class PlanetActivity extends AppCompatActivity {
    private Model model;
    private MediaPlayer mediaPlayer;
    private ProgressBar fuel;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView market;
        TextView shipyard;
        TextView upgrade;
        TextView refuel;
        TextView save;
        TextView load;
        //Planet planet;

        ImageView planetBack;
        ImageView planetFront;
        TextView name;

        model = Model.getInstance();
        setContentView(R.layout.activity_planet);

        // toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        fuel = findViewById(R.id.fuel_bar);
        fuel.setProgress(model.getFuelPercentage());



        //planet = model.getCurrentPlanet();

        name = findViewById(R.id.planet_name_text);
        market = findViewById(R.id.market_button);
        shipyard = findViewById(R.id.shipyard_button);
        upgrade = findViewById(R.id.upgrade_button);
        refuel = findViewById(R.id.refuel_button);
        save = findViewById(R.id.save_button);
        load = findViewById(R.id.load_button);

        // globally
        if (model.getCurrentPlanet() != null) {
            name.setText(model.getCurrentPlanet().getName());
        }

        // music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shopping_spree_planet);
        mediaPlayer.setLooping(true);
        try {
            mediaPlayer.prepare();
        } catch (Exception e) {
            Log.d("debug", "yo");
        }
        mediaPlayer.start();

        // pressing anywhere on layout un dims layout
        //layout.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        layout.getForeground().setAlpha(0);
        //    }
        //});

        // pressing content_market button
        market.setOnClickListener((View v)-> {
                mediaPlayer.stop();
                Intent intent = new Intent(v.getContext(), ShopActivity.class);
                startActivityForResult(intent, 0);
        });

        shipyard.setOnClickListener((View v)-> {
                Intent intent = new Intent(v.getContext(), ShipyardActivity.class);
                startActivityForResult(intent, 0);
        });

        upgrade.setOnClickListener((View v)->
                mediaPlayer.stop()
        );

        refuel.setOnClickListener((View v)-> {
                model.refuelShipMax();
                fuel.setProgress(model.getFuelPercentage());
                Log.d("Debug", "Refuel button clicked");
        });

        save.setOnClickListener((View v)->
                model.saveGame(v.getContext()));

        load.setOnClickListener((View v)-> {
                if (model.loadGame(v.getContext())) {
                    Intent intent = new Intent(v.getContext(), PlanetActivity.class);
                    startActivity(intent);
                } else {
                    CharSequence text = "Load file not found";
                    Toast toast = Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                }
        });


        planetBack = findViewById(R.id.planet_back);
        planetFront = findViewById(R.id.planet_front);

        // set land type
        planetFront.setImageResource(model.getLandType());

        // change colors of planet
        planetBack.setColorFilter(model.getColorBack());
        planetFront.setColorFilter(model.getColorFront());

        // random initial rotation of planet
        Random r = new Random();
        int initialRotationRoll = r.nextInt(360);
        planetFront.setRotation(initialRotationRoll);
        planetBack.setRotation(initialRotationRoll);

        // rotate content_planet animation
        final int duration = 300000;
        final int degree = 360;
        final float pivotValue = 0.5f;
        RotateAnimation rotate = new RotateAnimation(0, degree,
                Animation.RELATIVE_TO_SELF, pivotValue, Animation.RELATIVE_TO_SELF,
                pivotValue);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setDuration(duration);
        rotate.setInterpolator(new LinearInterpolator());
        planetBack.startAnimation(rotate);
        planetFront.startAnimation(rotate);

    }

    @Override
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        // Handle item selection
        switch (Objects.requireNonNull(item).getItemId()) {
            case R.id.universe_map_button:
                Intent intent = new Intent(this, UniverseMapActivity.class);
                startActivityForResult(intent, 0);
                return true;
            case R.id.system_map_button:
                intent = new Intent(this, SolarSystemActivity.class);
                startActivityForResult(intent,0);
                return true;
            case R.id.inventory_button:



                return true;
            case R.id.status_button:



                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    // android back button
    @Override
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}
