package com.example.spacetraders.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.R;

public class EditPlayerActivity extends AppCompatActivity {
    private EditText nameField;
    private Button fightPlus;
    private Button fightMinus;
    private Button tradePlus;
    private Button tradeMinus;
    private Button engineerPlus;
    private Button engineerMinus;
    private Button pilotPlus;
    private Button pilotMinus;
    private Spinner gameDifficultySpinner;
    private TextView nameText;
    private TextView fighterText;
    private TextView tradeText;
    private TextView engineerText;
    private TextView pilotText;
    private TextView difficultyText;

    private Player p;

    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_player);

        // I HAVE NO IDEA WHAT THIS DOES
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }

        nameField = findViewById();
        fightPlus = findViewById();
        fightMinus = findViewById();
        tradePlus = findViewById();
        tradeMinus = findViewById();
        engineerPlus = findViewById();
        engineerMinus = findViewById();
        pilotPlus = findViewById();
        pilotMinus = findViewById();
        gameDifficultySpinner = findViewById();
        nameText = findViewById();
        fighterText = findViewById();
        tradeText = findViewById();
        engineerText = findViewById();
        pilotText = findViewById();
        difficultyText = findViewById();
        Button button = findViewById(R.id.ok_button);

        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(difficultyAdapter);

        gameDifficultySpinner.setSelection();
    }
}
