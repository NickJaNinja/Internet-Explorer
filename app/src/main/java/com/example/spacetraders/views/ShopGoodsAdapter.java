package com.example.spacetraders.views;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.ViewGroup;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.ShopGoods;

import java.util.ArrayList;
import java.util.List;

public class ShopGoodsAdapter extends ListAdapter<ShopGoodsAdapter.ShopGoodsViewHolder> {

    /** a copy of the list of shop goods in the model */
    private List<ShopGoods> shopGoodsList = new ArrayList<>();
    //private

    @NonNull
    public ShopGoodsAdapter.ShopGoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return null;
    }

    class ShopGoodsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView stock;


        public ShopGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    /*
    @NonNull
    @Override
    public ShopGoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        // hook up to the view for a single student in the system
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item, parent, false);

        return new ShopGoodsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopGoodsViewHolder shopGoodsViewHolder, int position) {
        ShopGoods shopGoods = shopGoodsList.get(position);
        int shopGoodsStock =

        shopGoodsViewHolder.price.setText(shopGoods.getBasePrice());
        shopGoodsViewHolder.name.setText(shopGoods.getName());
        shopGoodsViewHolder.stock.setText(shopGoodsStock);

    }

    @Override
    public int getItemCount() {
        return shopGoodsList.size();
    }

    public void setShopGoodsList(List<ShopGoods> shopGoods) {
        shopGoodsList = shopGoods;
        notifyDataSetChanged();
    }

    public void setShopGoodsList() {
    }

    class ShopGoodsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView stock;


        public ShopGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    */

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
}
