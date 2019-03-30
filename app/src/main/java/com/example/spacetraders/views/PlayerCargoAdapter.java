package com.example.spacetraders.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
import com.example.spacetraders.models.Model;

import java.util.ArrayList;
import java.util.List;

public class PlayerCargoAdapter extends RecyclerView.Adapter<PlayerCargoAdapter.PlayerCargoViewHolder> {

    /**
     * a copy of the list of shop goods in the model
     */

    private ShopGoodsAdapter shopGoodsAdapter;
    private List<ShopEntry> playerCargoList;
    private OnClickListener listener;
    private Model model;

    public PlayerCargoAdapter(List<ShopEntry> playerCargoList) {
        this.playerCargoList = playerCargoList;
        this.model = Model.getInstance();
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
            price = itemView.findViewById(R.id.price_text);
            stock = itemView.findViewById(R.id.stock_text);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    
                    if (position == RecyclerView.NO_POSITION) {
                        CharSequence text = "DO NOT CLICK THAT";
                        Toast toast = Toast.makeText(itemView.getContext(), text, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        ShopEntry selectedEntry = playerCargoList.get(position);
                        ShopGoods selectedGood = selectedEntry.getGood();
                        if (listener != null) {
                            listener.onClicked(playerCargoList.get(position));
                        }

                        int cost = shopGoodsAdapter.getCostOfGood(selectedGood);

                        if (playerCargoList.get(position).getStock() > 0
                                && model.makeTransaction(selectedGood, -1, cost) == 1) {
                            playerCargoList = model.getPlayerEntries();
                            shopGoodsAdapter.setShopGoodsList(model.getShopEntries());
                            notifyDataSetChanged();
                        /*
                        ShopEntry select = playerCargoList.get(position);
                        //add to shop inventory
                        List<ShopEntry> list = shopGoodsAdapter.getShopGoodsList();
                        if (list.contains(select)) {
                            int selectIndex = list.indexOf(select);
                            int currStock = list.get(selectIndex).getStock();
                            list.get(selectIndex).setStock(currStock + 1);
                        } else {
                            select.setStock(1);
                            select.setPrice(cost);
                            shopGoodsAdapter.getShopGoodsList().add(select);
                        }

                        for (int c = 0; c < list.size(); c++) {
                            if (list.get(c) == select) {
                                list.get(c).setStock(list.get(c).getStock() + 1);

                            } else {
                                select.setStock(1);
                                shopGoodsAdapter.getShopGoodsList().add(select);
                            }
                        }

                        shopGoodsAdapter.notifyItemRangeInserted(
                                shopGoodsAdapter.getShopGoodsList().size() - 1,
                                shopGoodsAdapter.getShopGoodsList().size());

                        //remove from player inventory
                        select = playerCargoList.get(position);
                        select.setStock(select.getStock() - 1);
                        if (select.getStock() == 0) {
                            playerCargoList.remove(select);
                        }

                        // playerCargoList.remove(playerCargoList.get(position));
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, playerCargoList.size());
                        */
                        }
                    }
                }
            });
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

    public List<ShopEntry> getPlayerCargoList() {
        return playerCargoList;
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
    public interface OnClickListener {
        void onClicked(ShopEntry goods);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public ShopGoodsAdapter getShopGoodsAdapter() {
        return shopGoodsAdapter;
    }

    public void setShopGoodsAdapter(ShopGoodsAdapter sga) {
        shopGoodsAdapter = sga;
    }
}
