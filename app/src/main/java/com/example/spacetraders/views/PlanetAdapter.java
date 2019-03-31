package com.example.spacetraders.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.SolarSystem;
import com.example.spacetraders.models.Model;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private List<Planet> planetsList;
    private OnClickListener listener;
    private Model model;
    private Planet selectedPlanet;

    public PlanetAdapter(Planet[] planets) {
        this.planetsList = Arrays.asList(planets);
        this.model = Model.getInstance();
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_item, parent, false);

        return new PlanetViewHolder(itemView);

    }


    public class PlanetViewHolder extends RecyclerView.ViewHolder {
        private TextView pname;
        private TextView economy;
        private TextView distance;
        private TextView techLevel;
        private TextView politicalSystem;
        private ImageView planetView;

        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            pname = itemView.findViewById(R.id.planet_name);
            economy = itemView.findViewById(R.id.planet_economy);
            distance = itemView.findViewById(R.id.planet_distance_from_star);
            techLevel = itemView.findViewById(R.id.planet_tech_level);
            politicalSystem = itemView.findViewById(R.id.planet_political_system);

            planetView = itemView.findViewById(R.id.planet_image);


            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClicked(planetsList.get(position));
                    }


                    // select content_planet
                    planetView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            System.out.println("flag");
                            Log.d("Debug", "Planet clicked");

                        }
                    });
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int position) {
        Planet planet = planetsList.get(position);
       // selectedPlanet = planet;
        SolarSystem system = model.getCurrentSystem();
        planetViewHolder.pname.setText(planet.getName() + "");
        DecimalFormat df = new DecimalFormat("#.##");
        planetViewHolder.distance.setText(df.format(planet.getDistanceFromParentStar() * 8.3167) + " Lm");
        planetViewHolder.economy.setText(planet.getResourcesLevel().getName() + "");
        planetViewHolder.techLevel.setText(planet.getTechLevel().getName() + "");
        planetViewHolder.politicalSystem.setText(planet.getPoliticalSystem().getName() + "");
     //  planetViewHolder.planetView.setImageResource(R.drawable.placeholder_planet);



       // planetViewHolder.distance.setText("" + content_planet.getDistanceFromParentStar());
//        planetViewHolder.coordinates.setText(system.getCoordinates().toString());
//        notifyDataSetChanged();



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
