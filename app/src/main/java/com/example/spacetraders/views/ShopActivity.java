package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.ShopViewModel;

/**
 * Shop activity class
 */
public class ShopActivity extends AppCompatActivity {
    private TextView creditDisplay;
    private TextView cargoDisplay;
    // --Commented out by Inspection (4/2/19, 11:03 PM):private ListView buyList;
    private ShopGoodsAdapter adapterForShop;
    private PlayerCargoAdapter adapterForPlayer;
    //private Shop shop;
    private ShopViewModel viewModel;
    private Model model;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProgressBar fuel;
        RecyclerView recyclerViewShop;
        RecyclerView recyclerViewPlayer;
        TextView cancel;
        TextView confirm;

        setContentView(R.layout.activity_market);

        // toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        this.model = Model.getInstance();

        fuel = findViewById(R.id.fuel_bar);
        fuel.setProgress(model.getFuelPercentage());

        viewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
     //   viewModel.setUpMarket();

        creditDisplay = findViewById(R.id.credit_text_display);
        cargoDisplay  = findViewById(R.id.cargo_text_display);

        /*
        Set up our recycler view by grabbing the layout for a single item
        */
        recyclerViewShop = findViewById(R.id.buy_list);
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShop.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapterForShop = new ShopGoodsAdapter(viewModel.getShopEntriesFiltered(), this);
        recyclerViewShop.setAdapter(adapterForShop);


        /*
        Set up our recycler view by grabbing the layout for a single item
        */
        recyclerViewPlayer = findViewById(R.id.sell_list);
        recyclerViewPlayer.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPlayer.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapterForPlayer = new PlayerCargoAdapter(viewModel.getShopEntries(), this);
        recyclerViewPlayer.setAdapter(adapterForPlayer);

        adapterForPlayer.setShopGoodsAdapter(adapterForShop);
        adapterForShop.setPlayerCargoAdapter(adapterForPlayer);

        // Connecting button instance variables with content_market.xml buttons
        confirm = findViewById(R.id.confirm_button);
        cancel = findViewById(R.id.cancel_button);

        //confirm transaction

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implements later setMarketsEntriesToTemp();
                   //viewModel.setMarketsEntriesToTemp();
                //viewModel.setUpMarket();
            }
        });

        //cancel transaction
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //viewModel.setUpMarket();
            }
        });

        // music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shopping_spree_market);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapterForShop.setShopGoodsList(viewModel.getShopEntries());
        adapterForPlayer.setPlayerCargoList(viewModel.getPlayerEntries());
        updateDisplay();
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
        switch (item.getItemId()) {
            case R.id.universe_map_button:
                Intent intent = new Intent(this, UniverseMapActivity.class);
                startActivityForResult(intent, 0);
                return true;
            case R.id.system_map_button:
                intent = new Intent(this, SolarSystemActivity.class);
                startActivityForResult(intent,0);
                return true;
            case R.id.inventory_button:

                // TO-DO inventory

                return true;
            case R.id.status_button:

                // TO-DO status

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // android back button
    @Override
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            // stop music
            mediaPlayer.stop();

            Intent intent = new Intent(this, PlanetActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * After a transaction,
     * update player's credit and cargo space in ship displayed in market
     */
    public void updateDisplay() {
        String asz = Integer.toString(model.getCredits());
        creditDisplay.setText(asz);
        String aop = Integer.toString(model.getCargoSpace());
        cargoDisplay.setText(aop);
    }
}