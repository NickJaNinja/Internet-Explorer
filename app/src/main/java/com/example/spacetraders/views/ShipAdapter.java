package com.example.spacetraders.views;

//import android.support.v7.widget.RecyclerView;
//import android.widget.TextView;
//
//import com.example.space traders.entities.Planet;
//import com.example.space traders.models.Model;
//
//import java.util.List;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShipType;
import com.example.spacetraders.models.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * ship adapter class
 */
public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.ShipViewHolder> {

    private final List<ShipType> ships;
    //private ShipAdapter.OnClickListener listener;
    private Model model;
    private ShipType selected;
    private final EventHandler handler;
    private final ArrayList<View> viewHolderList;


    /**
     * constructor
     * @param ships ships
     */
    public ShipAdapter(List<ShipType> ships, EventHandler handler) {
        this.ships = ships;
        this.handler = handler;
        viewHolderList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ShipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ship_item, parent, false);

        return new ShipViewHolder(itemView);
    }

    /**
     * This is a holder for the widgets associated with a single entry in the list of ships
     */
    public class ShipViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView weapon;
        private final TextView shields;
        private final TextView gadgets;
        private final TextView cargo;
        private final TextView maxFuel;
        private final TextView crew;
        private final TextView cost;

        /**
         * ship view holder
         *
         * @param itemView view
         */
        ShipViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ship_name_display);
            weapon = itemView.findViewById(R.id.ship_weapons_display);
            shields = itemView.findViewById(R.id.ship_shields_display);
            gadgets = itemView.findViewById(R.id.ship_gadgets_display);
            cargo = itemView.findViewById(R.id.ship_cargo_holds_display);
            maxFuel = itemView.findViewById(R.id.ship_max_fuel_display);
            crew = itemView.findViewById(R.id.ship_crew_display);
            cost = itemView.findViewById(R.id.ship_cost_display);

            viewHolderList.add(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected = ships.get(getAdapterPosition());

                    // give all views "unselected background"
                    for(int i = 0; i < viewHolderList.size(); i++) {
                        viewHolderList.get(i).setBackgroundColor(
                                Color.parseColor("#00000000"));
                    }

                    // give "selected" background
                    view.setBackgroundColor(Color.parseColor("#664B4B4C"));

                    handler.handle(getAdapterPosition()); // make purchase button green
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return ships.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ShipAdapter.ShipViewHolder shipViewHolder, int position) {
        ShipType ship = ships.get(position);

        shipViewHolder.name.setText(ship.getName());
        shipViewHolder.weapon.setText(String.valueOf(ship.getNumWeapons()));
        shipViewHolder.shields.setText(String.valueOf(ship.getNumShields()));
        shipViewHolder.gadgets.setText(String.valueOf(ship.getNumGadgets()));
        shipViewHolder.cargo.setText(String.valueOf(ship.getNumCargoHolds()));
        shipViewHolder.maxFuel.setText(String.valueOf(ship.getFuel()));
        shipViewHolder.crew.setText(String.valueOf(ship.getNumCrew()));
        String pshet = "¥" +ship.getCost();
        shipViewHolder.cost.setText(pshet);
    }

    /**
     * gets selected ship
     *
     * @return selected
     */
    public ShipType getSelected() {
        return selected;
    }

    public interface EventHandler {
        void handle(int position); // if u need know position. If no, just create method without params
    }
}
