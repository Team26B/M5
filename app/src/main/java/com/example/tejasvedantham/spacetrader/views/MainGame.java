package com.example.tejasvedantham.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tejasvedantham.spacetrader.R;
import com.example.tejasvedantham.spacetrader.viewmodels.MainGameViewModel;

public class MainGame extends AppCompatActivity {

    private TextView solarSystemText;
    private TextView planetText;
    private Button marketButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_game);

        solarSystemText = (TextView) findViewById(R.id.solarSystemText);
        planetText = (TextView) findViewById(R.id.planetText);
        marketButton = (Button) findViewById(R.id.marketButton);

        final MainGameViewModel mvm = new MainGameViewModel(getApplication());
        solarSystemText.append("" + mvm.getGame().getUniverse().getSolarSystems().iterator().next().getName());
        planetText.append("" + mvm.getGame().getUniverse().getSolarSystems().iterator().next().getPlanets().iterator().next().getName());


    }

    public void goToMarket(View view) {
        Intent intent = new Intent(getApplicationContext(), MarketView.class);
        startActivity(intent);
    }
}
