package com.example.spacetraders.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;


import java.util.Arrays;
import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private List<Planet> planetsList;
    private OnClickListener listener;
    private Model model;

    public PlanetAdapter(Planet[] planets) {
        this.planetsList = Arrays.asList(planets);
        this.model = Model.getInstance();
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.solar_system_map, parent, false);

        return new PlanetViewHolder(itemView);
    }


    public class PlanetViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView distance;
        private TextView coordinates;


        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            distance = itemView.findViewById(R.id.distance_text);
            coordinates = itemView.findViewById(R.id.coordinates_text);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClicked(planetsList.get(position));
                    }
                  /*  name.setText(planetsList.get(getAdapterPosition()).getName());
                    distance.setText(""+ planetsList.get(getAdapterPosition()).getDistanceFromParentStar());
                    notifyDataSetChanged();*/
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int position) {
        Planet planet = planetsList.get(position);
        SolarSystem system = model.getCurrentSystem();
        planetViewHolder.name.setText(planet.getName() + "");
        planetViewHolder.distance.setText("" + planet.getDistanceFromParentStar());
        planetViewHolder.coordinates.setText(system.getCoordinates().toString());
    }


    @Override
    public int getItemCount() {
        return planetsList.size();
    }

    public void setPlanetsList(Planet[] p) {
        planetsList = Arrays.asList(p);
        notifyDataSetChanged();
    }



    public interface OnClickListener {
        void onClicked(Planet planet);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }


}
