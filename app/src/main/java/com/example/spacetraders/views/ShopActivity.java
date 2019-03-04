package com.example.spacetraders.views;

import android.os.Bundle;
import android.widget.Button;

import com.example.spacetraders.R;

public class ShopActivity extends GUIActivity {
    private Button confirm;
    private Button cancel;
    private Button leaveMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market);
    }

}
