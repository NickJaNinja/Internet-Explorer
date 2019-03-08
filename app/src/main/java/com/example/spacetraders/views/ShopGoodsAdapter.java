package com.example.spacetraders.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import com.example.spacetraders.R;

public class ShopGoodsAdapter extends RecyclerView.Adapter<ShopGoodsAdapter.ShopGoodsViewHolder> {

    @NonNull
    @Override
    public ShopGoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        // hook up to the view for a single student in the system
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_item, parent, false);

        return new ShopGoodsViewHolder(itemView);
    }

    class ShopGoodsViewHolder extends RecyclerView.ViewHolder {
        private TextView Price;
    }
