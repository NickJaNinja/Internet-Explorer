package com.example.spacetraders.views;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;





import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Adapts the list of planets in the model to be a list of graphical elements in view
 */
public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {

    private final NestedClass nested = new NestedClass();
  //  private List<Planet> planetsList;
    // private OnClickListener listener;



    private final ArrayList<View> viewHolderList;

    // --Commented out by Inspection (4/2/19, 11:03 PM):private Planet selectedPlanet;

    /**
     * constructor
     * @param planets list of planets
     */

    public PlanetAdapter(Planet[] planets) {
         //nested = new NestedClass();
         nested.setPlanetsList(Arrays.asList(planets));
        //this.planetsList = Arrays.asList(planets);

        viewHolderList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.planet_item, parent, false);

        return new PlanetViewHolder(itemView);

    }

    /**
     * This is a holder for the widgets associated with a single entry in the list of planets
     */
    public class PlanetViewHolder extends RecyclerView.ViewHolder {
        final TextView planetName;
        final TextView economy;
        final TextView distance;
        final TextView techLevel;
        final TextView politicalSystem;
        //planet image on the left
        final ImageView planetView;

        /**
         * planet view holder
         *
         * @param itemView view
         */
        PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            planetName = itemView.findViewById(R.id.planet_name);
            economy = itemView.findViewById(R.id.planet_economy);
            distance = itemView.findViewById(R.id.planet_distance_from_star);
            techLevel = itemView.findViewById(R.id.planet_tech_level);
            politicalSystem = itemView.findViewById(R.id.planet_political_system);
            planetView = itemView.findViewById(R.id.planet_image);

            viewHolderList.add(itemView);
            //planetView.setImageDrawable(viewHolderList.get(getAdapterPosition()).getBackground());

            itemView.setOnClickListener((View view)-> {
                    int position = getAdapterPosition();

                    if ((nested.getListener() != null) && (position != RecyclerView.NO_POSITION)) {
                        nested.getListener().onClicked(nested.getPlanetsList().get(position));
                    }

                    // give all views "unselected background"
                    for(int i = 0; i < viewHolderList.size(); i++) {
                        viewHolderList.get(i).setBackgroundColor(
                                Color.parseColor("#00000000"));
                    }

                    // give "selected" background
                    view.setBackgroundColor(Color.parseColor("#22FFFFFF"));

                    notifyDataSetChanged();
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int position) {
        final double MULTIPLE = 8.3167;
        //bind the planet data for one planet
        Planet planet = nested.getPlanetsList().get(position);

        //rSolarSystem system = model.getCurrentSystem();
        planetViewHolder.planetName.setText(planet.getName());
        DecimalFormat df = new DecimalFormat("#.##");
        String stupidStrings = df.format(planet.getDistanceFromParentStar()
                * MULTIPLE) + " Lm";
        planetViewHolder.distance.setText(stupidStrings);
        if (planet.getTechLevel() != null && planet.getResourcesLevel() != null && planet.getPoliticalSystem() != null) {
            planetViewHolder.economy.setText(planet.getResourcesLevel().getName());
            planetViewHolder.techLevel.setText(planet.getTechLevel().getName());
            planetViewHolder.politicalSystem.setText(planet.getPoliticalSystem().getName());
        }
        planetViewHolder.planetView.setImageResource(R.drawable.input);

    }




    @Override
    public int getItemCount() {
        return nested.getPlanetsList().size();
    }

    /**
     * set planet list
     *
     * @param p list of planet
     */

    public void setPlanetsList(@NonNull Planet[] p) {
        nested.setPlanetsList(Arrays.asList(p));



        notifyDataSetChanged();
    }

    /**
     * interface on click listener
     */
    public interface OnClickListener {

        /**
         * on clicked
         * @param planet planet
         */
        void onClicked(@Nullable Planet planet);
    }

    /**
     * set on click listener
     *
     * @param listener listener
     */

    public void setOnClickListener(@ NonNull OnClickListener listener) {
        nested.setListener(listener);
    }

////////////////////////////////////////////////////
      final class NestedClass {
        private List<Planet> planetsList;
        private OnClickListener listener;
      //  private final NestedClass instance = new NestedClass();

        List<Planet> getPlanetsList() {
            return planetsList;
        }
        OnClickListener getListener() {
            return listener;
        }
         void setListener(OnClickListener onClick) {
            listener = onClick;
        }
         void setPlanetsList(List<Planet> planets) {
            planetsList = planets;
        }
      /*  NestedClass getNestClass() {
            return instance;
        }*/
    }
}
