package com.example.spacetraders.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.entities.GameDifficulty;
import com.example.spacetraders.R;
import com.example.spacetraders.viewmodels.EditPlayerViewModel;

/**
 * .
 */
public class EditPlayerActivity extends AppCompatActivity {
    private EditPlayerViewModel editPlayerViewModel;

    private EditText nameField;
    private Spinner gameDifficultySpinner;
    private TextView fighterText;
    private TextView tradeText;
    private TextView engineerText;
    private TextView pilotText;
    private TextView pointsRemaining;

    /**
     * .
     * @param savedInstanceState .
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button fightPlus;
        Button fightMinus;
        Button tradePlus;
        Button tradeMinus;
        Button engineerPlus;
        Button engineerMinus;
        Button pilotPlus;
        Button pilotMinus;
        Button reset;
        Button exit;
        setContentView(R.layout.config);
        editPlayerViewModel = ViewModelProviders.of(this).get(EditPlayerViewModel.class);


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
        reset = findViewById(R.id.reset_button);
        exit = findViewById(R.id.cancel_button);

        // Making game difficulty adapter
        ArrayAdapter<GameDifficulty> difficultyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, GameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(difficultyAdapter);

        // Skill point buttons
        fightPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(
                        fighterText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                fighterText.setText(String.format("%d", Integer.parseInt(
                        (String) fighterText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(
                        pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });
        fightMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(
                        Integer.parseInt(fighterText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                fighterText.setText(String.format("%d",
                        Integer.parseInt((String) fighterText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d",
                        Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });
        tradePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(
                        Integer.parseInt(tradeText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                tradeText.setText(String.format("%d",
                        Integer.parseInt((String) tradeText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d",
                        Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });
        tradeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(
                        Integer.parseInt(tradeText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                tradeText.setText(String.format("%d",
                        Integer.parseInt((String) tradeText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d",
                        Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });
        engineerPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(
                        Integer.parseInt(engineerText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                engineerText.setText(String.format("%d",
                        Integer.parseInt((String) engineerText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d",
                        Integer.parseInt(pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });
        engineerMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(
                        Integer.parseInt(engineerText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                engineerText.setText(String.format("%d", Integer.parseInt(
                        (String) engineerText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(
                        pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });
        pilotPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(
                        pilotText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), 1);
                pilotText.setText(String.format("%d", Integer.parseInt(
                        pilotText.getText().toString()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(
                        pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });
        pilotMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skillChange = editPlayerViewModel.onSkill(Integer.parseInt(
                        pilotText.getText().toString()),
                        Integer.parseInt(pointsRemaining.getText().toString()), -1);
                pilotText.setText(String.format("%d", Integer.parseInt(
                        (String) pilotText.getText()) + skillChange));
                pointsRemaining.setText(String.format("%d", Integer.parseInt(
                        pointsRemaining.getText().toString()) - skillChange));
                onAnyButtonPressed();
            }
        });

        // Resets player configuration screen
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameField.setText(null);
                gameDifficultySpinner.setSelection(0);
                pilotText.setText(String.format("%d", 4));
                fighterText.setText(String.format("%d", 4));
                tradeText.setText(String.format("%d", 4));
                engineerText.setText(String.format("%d", 4));
                pointsRemaining.setText(String.format("%d", 0));
                onAnyButtonPressed();
            }
        });

        // Exits the app
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * Compiles player data and creates a new player if data is all correct.
     * Also creates a new game with the data.
     *
     * @param view the view
     */
    public void onOkPressed(@Nullable View view) {
        String name = nameField.getText().toString();
        name = name.replace("\n", " ");
        int engineer = Integer.parseInt(engineerText.getText().toString());
        int fighter = Integer.parseInt(fighterText.getText().toString());
        int trader = Integer.parseInt(tradeText.getText().toString());
        int pilot = Integer.parseInt(pilotText.getText().toString());
        GameDifficulty diff = (GameDifficulty) gameDifficultySpinner.getSelectedItem();
        if (editPlayerViewModel.onOk(name, fighter, trader, engineer, pilot, diff)) {
            Intent intent = new Intent(EditPlayerActivity.this, PlanetActivity.class);
            startActivity(intent);
        } else {
            CharSequence text = editPlayerViewModel.getToastText();

            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * whenever a plus or minus button is pressed, changes the currSkillRem Text View background
     * color to green if it is 0, otherwise keeps it orange
     *
     */
    private void onAnyButtonPressed() {
        int currSkillRem = Integer.valueOf(pointsRemaining.getText().toString());
        pointsRemaining.setBackgroundColor(editPlayerViewModel.onAnyButton(currSkillRem));
    }

    // CAN USE THIS INSTEAD OF 8 LISTENERS IN onCreate()
    // ISSUE: Linking the skill buttons to their respective text views
    /*
    public void onPlusPressed(View view) {
        Log.d("Edit", "Skill Plus Button Pressed");

    }

    public void onMinusPressed(View view) {
        Log.d("Edit", "Skill Minus Button Pressed");

    }
    */

    // . ..█ (͡°  ͜ʖ ͡°)
    // ███۞███████ ]▄▄▄▄▄▄▄▄▄▄▄▄▃
    // ▂▄▅█████████▅▄▃▂
    // I███████████████████].
    // ◥⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲⊙◤...
}
