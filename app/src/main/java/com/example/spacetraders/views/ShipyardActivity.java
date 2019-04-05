package com.example.spacetraders.views;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShipType;
import com.example.spacetraders.viewmodels.ShipyardViewModel;
import com.example.spacetraders.viewmodels.ShopViewModel;
import com.example.spacetraders.models.Model;

import com.example.spacetraders.views.ShipAdapter;

/**
 * ship yard activity
 */
public class ShipyardActivity extends GUIActivity {

    private ShipAdapter adapterForShips;
    private ShipyardViewModel viewModel;
    private TextView purchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView recyclerViewShips;

        setContentView(R.layout.shipyard);

        viewModel = ViewModelProviders.of(this).get(ShipyardViewModel.class);

        /*
        Set up our recycler view by grabbing the layout for a single item
        */
        recyclerViewShips = findViewById(R.id.ship_recycler_view);
        recyclerViewShips.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewShips.setHasFixedSize(true);

        // Setup the adapter for this recycler view
        adapterForShips = new ShipAdapter(viewModel.getShipsBasedOnTechLevel());
        recyclerViewShips.setAdapter(adapterForShips);

        // purchase button
        purchaseButton = findViewById(R.id.purchase_button);

        purchaseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ShipType selected = adapterForShips.getSelected();
                if (selected == null) {
                    CharSequence text = "You must select a ship";
                    Toast toast = Toast.makeText(view.getContext(), text,
                            Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Model.getInstance().setShipType(selected);
                }
            }
        });
    }
}
