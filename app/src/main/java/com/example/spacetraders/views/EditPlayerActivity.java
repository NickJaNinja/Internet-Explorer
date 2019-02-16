package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProvider;
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

    public static final int ADD_PLAYER_REQUEST_ID = 1;

    public static final String EXTRA_PLAYER = "com.example.spacetraders.views.EXTRA_PLAYER";

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
    private TextView fighterText;
    private TextView tradeText;
    private TextView engineerText;
    private TextView pilotText;
    private TextView pointsRemaining;

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

        // Connecting button instance variables with xml buttons
        nameField = findViewById(R.id.playerNameInput);
        fightPlus = findViewById(R.id.fighterSkillAdd);
        fightMinus = findViewById(R.id.fighterSkillSubtract);
        tradePlus = findViewById(R.id.traderSkillAdd);
        tradeMinus = findViewById(R.id.traderSkillSubtract);
        engineerPlus = findViewById(R.id.engineerSkillAdd);
        engineerMinus = findViewById(R.id.engineerSkillSubtract);
        pilotPlus = findViewById(R.id.pilotSkillAdd);
        pilotMinus = findViewById(R.id.pilotSkillSubtract);
        gameDifficultySpinner = findViewById(R.id.difficulty_spinner);
        fighterText = findViewById(R.id.fighterSkill);
        tradeText = findViewById(R.id.traderSkill);
        engineerText = findViewById(R.id.engineerSkill);
        pilotText = findViewById(R.id.pilotSkill);
        pointsRemaining = findViewById(R.id.skill_points_value);
        Button button = findViewById(R.id.ok_button);

        // Making game difficulty adapter
        ArrayAdapter<GameDifficulty> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(difficultyAdapter);

        // Skill point buttons
        fightPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fighterText.setText(Integer.parseInt((String) fighterText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), 1));
            }
        });
        fightMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fighterText.setText(Integer.parseInt((String)fighterText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), -1));
            }
        });
        tradePlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tradeText.setText(Integer.parseInt((String)tradeText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), 1));
            }
        });
        tradeMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tradeText.setText(Integer.parseInt((String)tradeText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), -1));
            }
        });
        engineerPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                engineerText.setText(Integer.parseInt((String)engineerText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), 1));
            }
        });
        engineerMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                engineerText.setText(Integer.parseInt((String)engineerText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), -1));
            }
        });
        pilotPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pilotText.setText(Integer.parseInt((String)pilotText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), 1));
            }
        });
        pilotMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pilotText.setText(Integer.parseInt((String)pilotText.getText())
                        + editPlayerViewModel.onSkill(Integer.parseInt(pointsRemaining.toString()), -1));
            }
        });

        p = new Player();
        gameDifficultySpinner.setSelection(g.getGameDifficulty().ordinal());


    }

    /**
     *
     *
     * @param view
     */
    public void onOkPressed(View view) {
        Log.d("Edit", "OK Player Pressed");

        p.setName(nameField.getText().toString());
        p.setEngineerSkill(Integer.parseInt((String)engineerText.getText()));
        p.setFighterSkill(Integer.parseInt((String)fighterText.getText()));
        p.setTraderSkill(Integer.parseInt((String)tradeText.getText()));
        p.setPilotSkill(Integer.parseInt((String)pilotText.getText()));

        GameDifficulty diff = (GameDifficulty) gameDifficultySpinner.getSelectedItem();
        g = new Game(diff, p);
        editPlayerViewModel.onOk(nameField.getText().toString(),
                Integer.parseInt(fighterText.getText().toString()),
                Integer.parseInt(tradeText.getText().toString()),
                Integer.parseInt(engineerText.getText().toString()),
                Integer.parseInt(pilotText.getText().toString()));
    }


    public void onSkillPressed(View view) {
        Log.d("Edit", "Skill Button Pressed");

    }
}
