package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Shop;
import com.example.spacetraders.models.Model;
import com.example.spacetraders.viewmodels.ShopViewModel;

public class ShopActivity extends GUIActivity {
    private TextView cancel;
    private TextView confirm;
    private ListView buyList;
    private ShopGoodsAdapter adapterForShop;
    private PlayerCargoAdapter adapterForPlayer;
    //private Shop shop;
    private ShopViewModel viewModel;
    private RecyclerView recyclerViewShop;
    private RecyclerView recyclerViewPlayer;
    private Model model;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);

        this.model = Model.getInstance();

        viewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        viewModel.setUpMarket();


        /*
        Set up our recycler view by grabbing the layout for a single item
        */
        recyclerViewShop = findViewById(R.id.buy_list);
        recyclerViewShop.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShop.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapterForShop = new ShopGoodsAdapter(viewModel.getShopEntries());
        recyclerViewShop.setAdapter(adapterForShop);


        /*
        Set up our recycler view by grabbing the layout for a single item
        */
        recyclerViewPlayer = findViewById(R.id.sell_list);
        recyclerViewPlayer.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewPlayer.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapterForPlayer = new PlayerCargoAdapter(viewModel.getShopEntries());
        recyclerViewPlayer.setAdapter(adapterForPlayer);

        adapterForPlayer.setShopGoodsAdapter(adapterForShop);
        adapterForShop.setPlayerCargoAdapter(adapterForPlayer);

        // Connecting button instance variables with market.xml buttons
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
}