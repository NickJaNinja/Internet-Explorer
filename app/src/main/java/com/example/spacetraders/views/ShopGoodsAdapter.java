package com.example.spacetraders.views;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
import com.example.spacetraders.models.Model;

import java.util.ArrayList;
import java.util.List;

public class ShopGoodsAdapter extends RecyclerView.Adapter<ShopGoodsAdapter.ShopGoodsViewHolder> {

    /**
     * a copy of the list of shop goods in the model
     */

    private PlayerCargoAdapter playerCargoAdapter;
    private List<ShopEntry> shopGoodsList;
    private OnClickListener listener;
    private Model model;

    public ShopGoodsAdapter(List<ShopEntry> shopGoodsList) {
        this.shopGoodsList = shopGoodsList;
        this.model = Model.getInstance();
    }

    @NonNull
    @Override
    public ShopGoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_entry, parent, false);

        return new ShopGoodsViewHolder(itemView);
    }

    public class ShopGoodsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView stock;


        public ShopGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_text);
            price = itemView.findViewById(R.id.price_text);
            stock = itemView.findViewById(R.id.stock_text);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClicked(shopGoodsList.get(position));
                        //view.setBackgroundColor(Color.CYAN);
                    }
                    ShopEntry select = shopGoodsList.get(position);
                    // add to player cargo
                    for (ShopEntry e : playerCargoAdapter.getPlayerCargoList()) {
                        if (e == select) {
                            select.setStock(select.getStock() + 1);
                        } else {
                            select.setStock(1);
                        }
                    }

                    playerCargoAdapter.getPlayerCargoList().add(select);
                    playerCargoAdapter.notifyItemRangeInserted(playerCargoAdapter.getPlayerCargoList().size() - 1, playerCargoAdapter.getPlayerCargoList().size());


                    //remove from market
                   //shopGoodsList.remove(shopGoodsList.get(position));
                   shopGoodsList.get(position).setStock(select.getStock() - 1);

                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, shopGoodsList.size());
                }
            });

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ShopGoodsViewHolder shopGoodsViewHolder, int position) {
        ShopEntry shopEntry = shopGoodsList.get(position);
        shopGoodsViewHolder.price.setText(shopEntry.getPrice() + "");
        shopGoodsViewHolder.name.setText(shopEntry.getGood().getName());
        shopGoodsViewHolder.stock.setText(shopEntry.getStock() + "");

    }


    @Override
    public int getItemCount() {
        return shopGoodsList.size();
    }

    public void setShopGoodsList(List<ShopEntry> shopEntries) {
        shopGoodsList = shopEntries;
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
    public interface OnClickListener {
        void onClicked(ShopEntry goods);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public PlayerCargoAdapter getPlayerCargoAdapter() {
        return playerCargoAdapter;
    }

    public void setPlayerCargoAdapter(PlayerCargoAdapter pca) {
        playerCargoAdapter = pca;
    }

    public List<ShopEntry> getShopGoodsList() {
        return shopGoodsList;
    }
}
