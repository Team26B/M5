package com.example.tejasvedantham.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tejasvedantham.spacetrader.R;
import com.example.tejasvedantham.spacetrader.viewmodels.MainGameViewModel;

import java.util.Collection;
import java.util.Iterator;

public class MainGame extends AppCompatActivity {

    private TextView solarSystemText;
    private TextView planetText;
    private Button marketButton;
    private TextView fuelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_game);

        solarSystemText = (TextView) findViewById(R.id.solarSystemText);
        planetText = (TextView) findViewById(R.id.planetText);
        marketButton = (Button) findViewById(R.id.marketButton);
        fuelText = (TextView) findViewById(R.id.fuelText);

        final MainGameViewModel mvm = new MainGameViewModel(getApplication());
        solarSystemText.append("" + mvm.getGame().getUniverse().getCurrentSS().getName());
        planetText.append("" + mvm.getGame().getUniverse().getCurrentSS().getCurrentPlanet().getName());
        fuelText.append("" + mvm.getGame().getPlayer().getSpaceship().getSpaceShipType().getTravelDistance());


    }

    public void goToMarket(View view) {
        Intent intent = new Intent(getApplicationContext(), MarketView.class);
        startActivity(intent);
    }

    public void goToTravel(View view) {
        Intent intent = new Intent(getApplicationContext(), TravelView.class);
        startActivity(intent);
    }

    public Object getLastElement(final Collection c) {
        final Iterator iter = c.iterator();
        Object lastElement = iter.next();
        while (iter.hasNext()) {
            lastElement = iter.next();
        }

        return lastElement;
    }
}
