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
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShipType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ship adapter class
 */
public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.ShipViewHolder> {
///DO NOT MAKE nested private->will create n synthetic Accessor warning
    final NestedClass nested = new NestedClass();
    /*
    private final List<ShipType> ships;
    private ShipType selected;
    private final EventHandler handler;
    private final ArrayList<View> viewHolderList;
*/

    /**
     * constructor
     * @param ships ships
     */
    public ShipAdapter(@Nullable List<ShipType> ships, @Nullable EventHandler handler) {
        nested.setShips(ships);
        nested.setHandler(handler);
        nested.setViewHolderList( new ArrayList<>());
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
        final TextView name;
        final TextView weapon;
        final TextView shields;
        final TextView gadgets;
        final TextView cargo;
        final TextView maxFuel;
        final TextView crew;
        final TextView cost;

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

            nested.getViewHolderList().add(itemView);

           /*
            itemView.setOnClickListener((View view) ->{
                    selected = ships.get(getAdapterPosition());

                    // give all views "unselected background"
                    for(int i = 0; i < viewHolderList.size(); i++) {
                        viewHolderList.get(i).setBackgroundColor(
                                Color.parseColor("#00000000"));
                    }

                    // give "selected" background
                    view.setBackgroundColor(Color.parseColor("#664B4B4C"));

                    handler.handle(); // make purchase button green
            });
        }
        */

            itemView.setOnClickListener((View view) ->{
                nested.setSelected(nested.getShips().get(getAdapterPosition()));

                // give all views "unselected background"
                for(int i = 0; i < nested.getViewHolderList().size(); i++) {
                    nested.getViewHolderList().get(i).setBackgroundColor(
                            Color.parseColor("#00000000"));
                }

                // give "selected" background
                view.setBackgroundColor(Color.parseColor("#664B4B4C"));

                nested.getHandler().handle(); // make purchase button green
            });
        }

    }

    @Override
    public int getItemCount() {
        return Objects.requireNonNull(nested.getShips()).size();
    }

    @Override
    public void onBindViewHolder(@NonNull ShipAdapter.ShipViewHolder shipViewHolder, int position) {
        ShipType ship = Objects.requireNonNull(nested.getShips()).get(position);

        shipViewHolder.name.setText(ship.getName());
        shipViewHolder.weapon.setText(String.valueOf(ship.getNumWeapons()));
        shipViewHolder.shields.setText(String.valueOf(ship.getNumShields()));
        shipViewHolder.gadgets.setText(String.valueOf(ship.getNumGadgets()));
        shipViewHolder.cargo.setText(String.valueOf(ship.getNumCargoHolds()));
        shipViewHolder.maxFuel.setText(String.valueOf(ship.getFuel()));
        shipViewHolder.crew.setText(String.valueOf(ship.getNumCrew()));
        String psh = "¥" +ship.getCost();
        shipViewHolder.cost.setText(psh);
    }

    /**
     * gets selected ship
     *
     * @return selected
     */
    @Nullable
    public ShipType getSelected() {
        return nested.getSelected();
    }

    public interface EventHandler {
        void handle(); // if u need know position. If no, just create method without params
    }


    final class NestedClass {
        private List<ShipType> ships;
        private ShipType selected;
        private EventHandler handler;
        private ArrayList<View> viewHolderList;

        EventHandler getHandler() {
            return handler;
        }

        void setViewHolderList(ArrayList<View> viewHolderList) {
            this.viewHolderList = viewHolderList;
        }

        ArrayList<View> getViewHolderList() {
            return viewHolderList;
        }

        List<ShipType> getShips() {
            return ships;
        }

        void setHandler(EventHandler handler) {
            this.handler = handler;
        }

         ShipType getSelected() {
            return selected;
        }

        void setSelected(ShipType selected) {
            this.selected = selected;
        }

         void setShips(List<ShipType> ships) {
            this.ships = ships;
        }

    }
}
