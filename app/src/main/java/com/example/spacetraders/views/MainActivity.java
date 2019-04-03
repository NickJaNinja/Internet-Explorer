package com.example.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.spacetraders.R;
import com.example.spacetraders.models.Model;

/**
 * main activity
 */
public class MainActivity extends GUIActivity {
    private Model model;

    /**
     * on create
     *
     * @param savedInstanceState bundle of saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button newButton;
        Button loadButton;

        setContentView(R.layout.activity_main);

        newButton = findViewById(R.id.new_button);
        loadButton = findViewById(R.id.load_button);
        model = Model.getInstance();

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditPlayerActivity.class);
                startActivity(intent);
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.loadGame(v.getContext());
                Intent intent;
                if (model.getGame() == null) {
                    intent = new Intent(v.getContext(), EditPlayerActivity.class);
                } else {
                    intent = new Intent(v.getContext(), PlanetActivity.class);
                }
                startActivity(intent);
            }

        });


        // Should prob delete this later, seems like the view has too much access to data
      //  mainViewModel.printUniverse(Model.getInstance().getGame());
    }

    /**
     * on create options menu
     *
     * @param menu menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
