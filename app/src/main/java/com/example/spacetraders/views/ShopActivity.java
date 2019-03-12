package com.example.spacetraders.views;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.Shop;

public class ShopActivity extends GUIActivity {
    private Button confirm;
    private Button cancel;
    private Button leaveMarket;
    private ListView buyList;
    private ShopGoodsAdapter adapter;
    private Shop shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);

        //buyList = findViewById(R.id.buy_list);
        for (int c = 0; c < adapter.getItemCount(); c++) {
            //buyList.addView(adapter.getLayout(c, this));
        }


        /*
        // adding items to market.xml layout
        for (int c = 0; c < adapter.getItemCount(); c++) {
            // creating a View with a horizontal white line
            View line = new View(this);
            line.setMinimumHeight(1);
            line.setBackgroundColor(Color.parseColor("#ffffff"));

            // creating a LinearLayout containing the item and info about it in TextViews
            LinearLayout item_layout = new LinearLayout(this);
            item_layout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams item_layout_params1 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                    0.5f);
            LinearLayout.LayoutParams item_layout_params2 = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                    0.25f);

            // adding text views for each item in item_layout
            TextView item_name = new TextView(this);
            item_name.setWidth(0);
            item_name.setText();
            item_name.setLayoutParams(item_layout_params1);
            TextView item_price = new TextView(this);
            item_price.setWidth(0);
            item_price.setLayoutParams(item_layout_params2);
            TextView item_stock = new TextView(this);
            item_stock.setWidth(0);
            item_stock.setLayoutParams(item_layout_params2);

            item_layout.addView(item_name);
            item_layout.addView(item_price);
            item_layout.addView(item_stock);

            // adding Views to buyLayout
            buyLayout = findViewById(R.id.buy_layout);
            buyLayout.addView(line);
            buyLayout.addView(item_layout);
        }
        */

        // Connecting button instance variables with market.xml buttons
        confirm.findViewById(R.id.confirm_button);
        cancel.findViewById(R.id.cancel_button);
        leaveMarket.findViewById(R.id.leave_market_button);

        //confirm transaction
        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        //cancel transaction
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        //leave market place
        leaveMarket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        adapter.setShopGoodsList();
        adapter.onCreateViewHolder();

    }

}
