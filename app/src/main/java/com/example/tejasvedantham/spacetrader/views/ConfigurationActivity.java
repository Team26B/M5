package com.example.tejasvedantham.spacetrader.views;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
//import android.widget.Toast;

import com.example.tejasvedantham.spacetrader.R;
import com.example.tejasvedantham.spacetrader.model.Difficulty;
//import com.example.tejasvedantham.spacetrader.model.Game;
import com.example.tejasvedantham.spacetrader.model.Player;
import com.example.tejasvedantham.spacetrader.model.Spaceship;
import com.example.tejasvedantham.spacetrader.model.SpaceshipType;
import com.example.tejasvedantham.spacetrader.model.TradeGood;
import com.example.tejasvedantham.spacetrader.model.Universe;
import com.example.tejasvedantham.spacetrader.viewmodels.ConfigurationViewModel;
import com.example.tejasvedantham.spacetrader.viewmodels.MainGameViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ConfigurationActivity extends AppCompatActivity {

    private EditText nameField;

    private SeekBar fighterSeekbar;
    private SeekBar pilotSeekbar;
    private SeekBar traderSeekbar;
    private SeekBar engineerSeekbar;

    private TextView fighterLevel;
    private TextView pilotLevel;
    private TextView traderLevel;
    private TextView engineerLevel;

    private Spinner difficultySpinner;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    final MainGameViewModel mvm = new MainGameViewModel(getApplication());

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

        Player player = new Player(nameField.getText().toString(),
                pilotSeekbar.getProgress(),
                fighterSeekbar.getProgress(),
                traderSeekbar.getProgress(),
                engineerSeekbar.getProgress(),
                new Spaceship(SpaceshipType.GNAT),
                new ArrayList<TradeGood>());

        ConfigurationViewModel viewModel = new ConfigurationViewModel(getApplication());
        viewModel.updatePlayer(player);
        viewModel.updateGame((Difficulty) difficultySpinner.getSelectedItem());

        System.out.println(player.toString());

        Universe universe = new Universe();
        viewModel.updateUniverse(universe);

        System.out.println(universe.toString());

        Intent intent = new Intent(getApplicationContext(), MainGame.class);
        startActivity(intent);
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
        FloatingActionButton startButton = (FloatingActionButton) findViewById(R.id.startButton);
        nameField = (EditText) findViewById(R.id.nameField);

        TextView fighterText = (TextView) findViewById(R.id.fighterText);
        TextView pilotText = (TextView) findViewById(R.id.pilotText);
        TextView traderText = (TextView) findViewById(R.id.traderText);
        TextView engineerText = (TextView) findViewById(R.id.engineerText);

        fighterSeekbar = (SeekBar) findViewById(R.id.fighterSeekbar);
        pilotSeekbar = (SeekBar) findViewById(R.id.pilotSeekbar);
        traderSeekbar = (SeekBar) findViewById(R.id.traderSeekbar);
        engineerSeekbar = (SeekBar) findViewById(R.id.engineerSeekbar);

        fighterLevel = (TextView) findViewById(R.id.fighterLevel);
        pilotLevel = (TextView) findViewById(R.id.pilotLevel);
        traderLevel = (TextView) findViewById(R.id.traderLevel);
        engineerLevel = (TextView) findViewById(R.id.engineerLevel);

        TextView difficultyText = (TextView) findViewById(R.id.difficulty_text);
        difficultySpinner = (Spinner) findViewById(R.id.difficulty_spinner);
        difficultySpinner.setAdapter(new ArrayAdapter<Difficulty>(this, android.R.layout.simple_list_item_1, Difficulty.values()));

    }

}
