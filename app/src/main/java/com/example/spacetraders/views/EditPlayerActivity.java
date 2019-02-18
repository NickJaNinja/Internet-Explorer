package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
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
    private TextView fighterText;
    private TextView tradeText;
    private TextView engineerText;
    private TextView pilotText;
    private TextView pointsRemaining;

    private Game g;
    private Player p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        editPlayerViewModel = ViewModelProviders.of(this).get(EditPlayerViewModel.class);

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

        // Making game difficulty adapter
        ArrayAdapter<GameDifficulty> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(difficultyAdapter);

        // Skill point buttons
        fightPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(fighterText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                fighterText.setText(String.format("%d", Integer.parseInt((String) fighterText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
        fightMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(fighterText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                fighterText.setText(String.format("%d", Integer.parseInt((String)fighterText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
        tradePlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(tradeText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                tradeText.setText(String.format("%d", Integer.parseInt((String)tradeText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
        tradeMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(tradeText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                tradeText.setText(String.format("%d", Integer.parseInt((String)tradeText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
        engineerPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(engineerText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                engineerText.setText(String.format("%d", Integer.parseInt((String)engineerText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
        engineerMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(engineerText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                engineerText.setText(String.format("%d", Integer.parseInt((String)engineerText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
        pilotPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(pilotText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                pilotText.setText(String.format("%d", Integer.parseInt(pilotText.getText().toString()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
        pilotMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(pilotText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                pilotText.setText(String.format("%d", Integer.parseInt((String)pilotText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
            }
        });
    }

    /**
     *
     *
     * @param view the view
     */
    public void onOkPressed(View view) {
        Log.d("Edit", "OK Player Pressed");
        String name = nameField.getText().toString();
        int engineer = Integer.parseInt(engineerText.getText().toString());
        int fighter = Integer.parseInt(fighterText.getText().toString());
        int trader = Integer.parseInt(tradeText.getText().toString());
        int pilot = Integer.parseInt(pilotText.getText().toString());
        if (editPlayerViewModel.onOk(name, fighter, trader, engineer, pilot)) {
            p = new Player();
            p.setName(name);
            p.setEngineerSkill(engineer);
            p.setFighterSkill(fighter);
            p.setTraderSkill(trader);
            p.setPilotSkill(pilot);
            GameDifficulty diff = (GameDifficulty) gameDifficultySpinner.getSelectedItem();
            g = new Game(diff, p);
        }
    }

    // CAN USE THIS INSTEAD OF 8 LISTENERS IN onCreate()
    // ISSUE: Linking the skill buttons to their respective textviews
    /*
    public void onPlusPressed(View view) {
        Log.d("Edit", "Skill Plus Button Pressed");

    }

    public void onMinusPressed(View view) {
        Log.d("Edit", "Skill Minus Button Pressed");

    }
    */

    // . ..█ (͡° ͜ʖ ͡°)
    // ███۞███████ ]▄▄▄▄▄▄▄▄▄▄▄▄▃
    // ▂▄▅█████████▅▄▃▂
    // I███████████████████].
    // ◥⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲⊙◤...
}
