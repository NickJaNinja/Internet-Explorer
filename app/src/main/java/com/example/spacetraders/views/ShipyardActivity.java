package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShipType;
import com.example.spacetraders.viewmodels.ShipyardViewModel;
import com.example.spacetraders.models.Model;

/**
 * ship yard activity
 */
public class ShipyardActivity extends AppCompatActivity implements ShipAdapter.EventHandler {

    private ShipAdapter adapterForShips;
    private TextView purchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shipyard);

        ShipyardViewModel viewModel = ViewModelProviders.of(this).get(ShipyardViewModel.class);

        // toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        /*
        Set up our recycler view by grabbing the layout for a single item
        */
        RecyclerView recyclerViewShips = findViewById(R.id.ship_recycler_view);
        recyclerViewShips.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShips.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapterForShips = new ShipAdapter(viewModel.getShipsBasedOnTechLevel(), this);
        recyclerViewShips.setAdapter(adapterForShips);

        // purchase button
        purchaseButton = findViewById(R.id.purchase_button);
        purchaseButton.setBackgroundColor(Color.parseColor("#D25A64")); // red

        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShipType selected = adapterForShips.getSelected();
                if (selected == null) {
                    CharSequence text = "Select a ship";
                    Toast toast = Toast.makeText(view.getContext(), text,
                            Toast.LENGTH_SHORT);
                    toast.show();
                } else if (Model.getInstance().getCredits() < selected.getCost()) {
                    CharSequence text = "Not enough credits";
                    Toast toast = Toast.makeText(view.getContext(), text,
                            Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Model.getInstance().setShipType(selected);
                    Model.getInstance().setCredits(Model.getInstance().getCredits() -
                            adapterForShips.getSelected().getCost());
                }
            }
        });
    }

    @Override
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



                return true;
            case R.id.status_button:



                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void handle (int position) {
        purchaseButton.setBackgroundColor(Color.parseColor("#5FCA77")); // green
    }
}
