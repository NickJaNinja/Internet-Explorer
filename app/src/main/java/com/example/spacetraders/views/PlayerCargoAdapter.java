package com.example.spacetraders.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShopEntry;

import java.util.ArrayList;
import java.util.List;

public class PlayerCargoAdapter extends RecyclerView.Adapter<PlayerCargoAdapter.PlayerCargoViewHolder> {

    /** a copy of the list of shop goods in the model */
    //enum, int stock, int price
    private List<ShopEntry> playerCargoList;

    public PlayerCargoAdapter(List<ShopEntry> playerCargoList) {
        this.playerCargoList = playerCargoList;
    }

    @NonNull
    @Override
    public PlayerCargoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_entry, parent, false);

        return new PlayerCargoViewHolder(itemView);
    }

    public class PlayerCargoViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView stock;


        public PlayerCargoViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_text);
            price = itemView.findViewById(R.id.stock_text);
            stock = itemView.findViewById(R.id.price_text);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull PlayerCargoViewHolder playerCargoViewHolder, int position) {
        ShopEntry shopEntry = playerCargoList.get(position);


        playerCargoViewHolder.price.setText(shopEntry.getPrice() + "");
        playerCargoViewHolder.name.setText(shopEntry.getGood().getName());
        playerCargoViewHolder.stock.setText(shopEntry.getStock() + "");

    }


    @Override
    public int getItemCount() {
        return playerCargoList.size();
    }

    public void setShopGoodsList(List<ShopEntry> shopEntries) {
        playerCargoList = shopEntries;
        notifyDataSetChanged();
    }

    public void setPlayerCargoList(List<ShopEntry> playerCargo) {
        playerCargoList = playerCargo;
        notifyDataSetChanged();
    }

/*
    public LinearLayout getLayout(int index, Context context) {
        // layout containing line and the item layout
        LinearLayout master_layout = new LinearLayout(context);
        master_layout.setOrientation(LinearLayout.HORIZONTAL);

        // creating a LinearLayout containing the item and info about it in TextViews
        LinearLayout item_layout = new LinearLayout(master_layout.getContext());
        item_layout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams item_layout_params1 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                0.5f);
        LinearLayout.LayoutParams item_layout_params2 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                0.25f);

        // adding text views for each item in item_layout
        TextView item_name = new TextView(master_layout.getContext());
        item_name.setWidth(0);
        item_name.setText(shopGoodsLis);
        item_name.setLayoutParams(item_layout_params1);
        TextView item_price = new TextView(master_layout.getContext());
        item_price.setWidth(0);
        item_price.setLayoutParams(item_layout_params2);
        TextView item_stock = new TextView(master_layout.getContext());
        item_stock.setWidth(0);
        item_stock.setLayoutParams(item_layout_params2);

        item_layout.addView(item_name);
        item_layout.addView(item_price);
        item_layout.addView(item_stock);

        // creating a View with a horizontal white line
        View line = new View(master_layout.getContext());
        line.setMinimumHeight(1);
        line.setBackgroundColor(Color.parseColor("#ffffff"));

        // adding line and item_layout to master_layout
        master_layout.addView(line);
        master_layout.addView(item_layout);

        return master_layout;
    }
    */
}
