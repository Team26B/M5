package com.example.tejasvedantham.spacetrader.views;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tejasvedantham.spacetrader.R;
import com.example.tejasvedantham.spacetrader.model.Difficulty;
import com.example.tejasvedantham.spacetrader.model.Game;
import com.example.tejasvedantham.spacetrader.model.Player;
import com.example.tejasvedantham.spacetrader.model.Spaceship;
import com.example.tejasvedantham.spacetrader.model.SpaceshipType;
import com.example.tejasvedantham.spacetrader.viewmodels.ConfigurationViewModel;

public class ConfigurationActivity extends AppCompatActivity {

    private FloatingActionButton startButton;
    private EditText nameField;

    private TextView fighterText;
    private TextView pilotText;
    private TextView traderText;
    private TextView engineerText;

    private SeekBar fighterSeekbar;
    private SeekBar pilotSeekbar;
    private SeekBar traderSeekbar;
    private SeekBar engineerSeekbar;

    private TextView fighterLevel;
    private TextView pilotLevel;
    private TextView traderLevel;
    private TextView engineerLevel;

    private TextView difficultyText;
    private Spinner difficultySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        initialize();

        setFighterSeekbar();
        setPilotSeekbar();
        setTraderSeekbar();
        setEngineerSeekbar();

    }

    public void startButtonPressed(View view) {
        if (fighterSeekbar.getProgress() + pilotSeekbar.getProgress() + traderSeekbar.getProgress() + engineerSeekbar.getProgress() > 16) {
            Snackbar.make(view, "You allocated too many points", Snackbar.LENGTH_LONG).show();
            return;
        }

        if (fighterSeekbar.getProgress() + pilotSeekbar.getProgress() + traderSeekbar.getProgress() + engineerSeekbar.getProgress() < 16) {
            Snackbar.make(view, "You haven't allocated all of the points", Snackbar.LENGTH_LONG).show();
            return;
        }

        if (nameField.getText() == null) {
            Snackbar.make(view, "Please enter a valid name", Snackbar.LENGTH_LONG).show();
            return;
        }

        Player player = new Player(nameField.getText().toString(), pilotSeekbar.getProgress(), fighterSeekbar.getProgress(), traderSeekbar.getProgress(), engineerSeekbar.getProgress(), new Spaceship(SpaceshipType.GNAT));

        ConfigurationViewModel viewModel = new ConfigurationViewModel(getApplication());
        viewModel.updatePlayer(player);
        viewModel.updateGame((Difficulty) difficultySpinner.getSelectedItem());

        System.out.println(player.toString());
    }

    public void setFighterSeekbar() {
        fighterSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                fighterLevel.setText("Level: " + fighterSeekbar.getProgress() + " / " + fighterSeekbar.getMax());
            }
        });
    }

    public void setPilotSeekbar() {
        pilotSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pilotLevel.setText("Level: " + pilotSeekbar.getProgress() + " / " + pilotSeekbar.getMax());
            }
        });
    }

    public void setTraderSeekbar() {
        traderSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                traderLevel.setText("Level: " + traderSeekbar.getProgress() + " / " + traderSeekbar.getMax());
            }
        });
    }

    public void setEngineerSeekbar() {
        engineerSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                engineerLevel.setText("Level: " + engineerSeekbar.getProgress() + " / " + engineerSeekbar.getMax());
            }
        });
    }

    public void initialize() {
        startButton = (FloatingActionButton) findViewById(R.id.startButton);
        nameField = (EditText) findViewById(R.id.nameField);

        fighterText = (TextView) findViewById(R.id.fighterText);
        pilotText = (TextView) findViewById(R.id.pilotText);
        traderText = (TextView) findViewById(R.id.traderText);
        engineerText = (TextView) findViewById(R.id.engineerText);

        fighterSeekbar = (SeekBar) findViewById(R.id.fighterSeekbar);
        pilotSeekbar = (SeekBar) findViewById(R.id.pilotSeekbar);
        traderSeekbar = (SeekBar) findViewById(R.id.traderSeekbar);
        engineerSeekbar = (SeekBar) findViewById(R.id.engineerSeekbar);

        fighterLevel = (TextView) findViewById(R.id.fighterLevel);
        pilotLevel = (TextView) findViewById(R.id.pilotLevel);
        traderLevel = (TextView) findViewById(R.id.traderLevel);
        engineerLevel = (TextView) findViewById(R.id.engineerLevel);

        difficultyText = (TextView) findViewById(R.id.difficulty_text);
        difficultySpinner = (Spinner) findViewById(R.id.difficulty_spinner);
        difficultySpinner.setAdapter(new ArrayAdapter<Difficulty>(this, android.R.layout.simple_list_item_1, Difficulty.values()));

    }
}
