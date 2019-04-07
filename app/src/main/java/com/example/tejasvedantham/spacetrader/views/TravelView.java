package com.example.tejasvedantham.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tejasvedantham.spacetrader.R;
import com.example.tejasvedantham.spacetrader.model.Planet;
import com.example.tejasvedantham.spacetrader.model.SolarSystem;
import com.example.tejasvedantham.spacetrader.viewmodels.MainGameViewModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TravelView extends AppCompatActivity {

    private TextView travelScreenText;
    private TextView selectText;
    private Spinner travelSpinner;
    private Button travelHereButton;
    final MainGameViewModel mvm = new MainGameViewModel(getApplication());
    int fuelLeft;
    double distance;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.travel);

        initialize();

        List<SolarSystem> spinnerList = new ArrayList<>();
        Iterator iter = mvm.getGame().getUniverse().getSolarSystems().iterator();
        fuelLeft = mvm.getGame().getPlayer().getSpaceship().getSpaceShipType().getTravelDistance();

        int currentX = mvm.getGame().getUniverse().getSolarSystems().iterator().next().getLocation().getX();
        int currentY = mvm.getGame().getUniverse().getSolarSystems().iterator().next().getLocation().getY();

        while (iter.hasNext()) {

            SolarSystem ss = ((SolarSystem) iter.next());

            int x = ss.getLocation().getX();
            int y = ss.getLocation().getY();

            //System.out.println(((SolarSystem) a.next()).getLocation());

            distance = Math.sqrt(Math.pow((x - currentX), 2) + Math.pow((y - currentY), 2));

            if (distance <= (fuelLeft)) {
                spinnerList.add(ss);
            }

        }

        ArrayAdapter<SolarSystem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        travelSpinner.setAdapter(adapter);

    }

    public void travelHere(View view) {

        if (((SolarSystem) travelSpinner.getSelectedItem()).equals(mvm.getGame().getUniverse().getCurrentSS())) {
            Toast.makeText(getApplicationContext(), "You are currently on this location", Toast.LENGTH_SHORT).show();
            return;
        }

        if ((fuelLeft) - (int) distance <= 0) {
            Toast.makeText(getApplicationContext(), "You don't have enough fuel!", Toast.LENGTH_SHORT).show();
            return;
        }

        mvm.updateSolarSystem((SolarSystem) travelSpinner.getSelectedItem());
        mvm.updatePlanet();
        mvm.updateTravelDistanceLeft((fuelLeft) - (int) distance);

        Toast.makeText(getApplicationContext(), "Traveled successfully!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MainGame.class);
        startActivity(intent);
    }

    public void initialize() {
        travelScreenText = (TextView)findViewById(R.id.travelScreenText);
        selectText = (TextView)findViewById(R.id.selectText);
        travelSpinner = (Spinner)findViewById(R.id.travel_spinner);
        travelHereButton = (Button)findViewById(R.id.travelHereButton);
    }

}
