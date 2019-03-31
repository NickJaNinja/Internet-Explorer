package com.example.spacetraders.views;

import android.app.AlertDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.ShopViewModel;

public class ShopActivity extends MenuBarActivity {
    private TextView cancel;
    private TextView confirm;
    private TextView creditDisplay;
    private TextView cargoDisplay;
    private ListView buyList;
    private ShopGoodsAdapter adapterForShop;
    private PlayerCargoAdapter adapterForPlayer;
    //private Shop shop;
    private ShopViewModel viewModel;
    private RecyclerView recyclerViewShop;
    private RecyclerView recyclerViewPlayer;
    private Model model;
    private MediaPlayer mediaPlayer;
    private ProgressBar fuel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        fuel = findViewById(R.id.fuel_bar);
        fuel.setProgress(Model.getInstance().getFuelPercentage());

        this.model = Model.getInstance();

        viewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        viewModel.setUpMarket();

        creditDisplay = findViewById(R.id.credit_text_display);
        cargoDisplay  = findViewById(R.id.cargo_text_display);

        /*
        Set up our recycler view by grabbing the layout for a single item
        */
        recyclerViewShop = findViewById(R.id.buy_list);
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShop.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapterForShop = new ShopGoodsAdapter(viewModel.getShopEntries(), this);
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
            public void onClick(View v) {
                viewModel.setMarketsEntriesToTemp();
                viewModel.setUpMarket();
            }
        });

        //cancel transaction
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewModel.setUpMarket();
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

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

                // TODO inventory

                return true;
            case R.id.status_button:

                // TODO status

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // android back button
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            // stop music
            mediaPlayer.stop();

            Intent intent = new Intent(this, PlanetActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    public void updateDisplay() {
        creditDisplay.setText(Integer.toString(model.getCredits()));
        cargoDisplay.setText(Integer.toString(model.getCargoSpace()));
    }
}