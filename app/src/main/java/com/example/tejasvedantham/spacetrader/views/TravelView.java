package com.example.tejasvedantham.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tejasvedantham.spacetrader.R;
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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.travel);

        initialize();
        final MainGameViewModel mvm = new MainGameViewModel(getApplication());

        List<String> spinnerList = new ArrayList<>();
        Iterator a = mvm.getGame().getUniverse().getSolarSystems().iterator();
        int fuelLeft = mvm.getGame().getPlayer().getSpaceship().getSpaceShipType().getTravelDistance();

        int currentX = mvm.getGame().getUniverse().getSolarSystems().iterator().next().getLocation().getX();
        int currentY = mvm.getGame().getUniverse().getSolarSystems().iterator().next().getLocation().getY();

        while (a.hasNext()) {

            int x = ((SolarSystem) a.next()).getLocation().getX();
            int y = ((SolarSystem) a.next()).getLocation().getY();

            //System.out.println(((SolarSystem) a.next()).getLocation());

            double distance = Math.sqrt(Math.pow((x - currentX), 2) + Math.pow((y - currentY), 2));

            if (distance <= fuelLeft) {
                spinnerList.add(((SolarSystem) a.next()).getName());
            }

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        travelSpinner.setAdapter(adapter);

    }

    public void travelHere(View view) {

    }

    public void initialize() {
        travelScreenText = (TextView)findViewById(R.id.travelScreenText);
        selectText = (TextView)findViewById(R.id.selectText);
        travelSpinner = (Spinner)findViewById(R.id.travel_spinner);
        travelHereButton = (Button)findViewById(R.id.travelHereButton);
    }

}
