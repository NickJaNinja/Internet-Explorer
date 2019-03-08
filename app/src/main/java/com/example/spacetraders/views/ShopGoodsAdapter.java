package com.example.spacetraders.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Planet;
import com.example.spacetraders.entities.ShopGoods;

import java.util.ArrayList;
import java.util.List;

public class ShopGoodsAdapter extends RecyclerView.Adapter<ShopGoodsAdapter.ShopGoodsViewHolder> {

    /** a copy of the list of shop goods in the model */
    private List<ShopGoods> shopGoodsList = new ArrayList<>();

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

        /**
         *
         *
         * @param itemView
         */
        public ShopGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
