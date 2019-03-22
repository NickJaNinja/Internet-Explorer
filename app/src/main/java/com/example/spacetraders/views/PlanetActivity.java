package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.ShopViewModel;

public class PlanetActivity extends GUIActivity {
    private TextView market;
    private TextView upgrade;
    private TextView refuel;
    private TextView leaveOrbit;
    private Planet planet;
    private ShopViewModel viewModel;
    private Model model;
    private MediaPlayer mediaPlayer;
    private ImageView planetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planet);

        viewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        model = Model.getInstance();
        planet = model.getCurrentPlanet();
        viewModel.setShop(planet.getShop());

        market = findViewById(R.id.market_button);
        upgrade = findViewById(R.id.upgrade_button);
        refuel = findViewById(R.id.refuel_button);
        leaveOrbit = findViewById(R.id.leave_orbit_button);

        // music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shopping_spree_planet);
        mediaPlayer.setLooping(true);
        try {
            mediaPlayer.prepare();
        } catch (Exception e) {
            System.out.println(e);
        }
        mediaPlayer.start();

        // pressing market button
        market.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mediaPlayer.stop();
                viewModel.setShop(planet.getShop());
                Intent intent = new Intent(v.getContext(), ShopActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        // rotate planet animation
        planetImage = findViewById(R.id.planet_image);
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setDuration(300000);
        rotate.setInterpolator(new LinearInterpolator());
        planetImage.startAnimation(rotate);
    }

}
