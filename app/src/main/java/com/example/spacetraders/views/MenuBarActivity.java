package com.example.spacetraders.views;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.spacetraders.R;

public class MenuBarActivity extends GUIActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.addView(findViewById(R.id.planet));
        layout.addView(findViewById(R.id.menu_bar));

        setContentView(layout);
    }
}
