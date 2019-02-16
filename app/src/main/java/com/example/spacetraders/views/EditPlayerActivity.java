package com.example.spacetraders.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.spacetraders.entities.Game;
import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.R;
import com.example.spacetraders.entities.Player;
import com.example.spacetraders.viewmodels.EditPlayerViewModel;

public class EditPlayerActivity extends AppCompatActivity {
    private EditPlayerViewModel editPlayerViewModel;

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

    private Game g;
    private Player p;

    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);

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

        ArrayAdapter<GameDifficulty> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(difficultyAdapter);

        p = getIntent().getSerializableExtra()
        gameDifficultySpinner.setSelection();
    }

    public void onOkPressed(View view) {
        Log.d("Edit", "OK Player Pressed");

        p.setName(nameField.getText().toString());
        p.setEngineerSkill(Integer.parseInt((String)engineerText.getText()));
        p.setFighterSkill(Integer.parseInt((String)fighterText.getText()));
        p.setTraderSkill(Integer.parseInt((String)tradeText.getText()));
        p.setPilotSkill(Integer.parseInt((String)pilotText.getText()));

        GameDifficulty diff = (GameDifficulty) gameDifficultySpinner.getSelectedItem();

        g = new Game(diff, p);
    }
}
