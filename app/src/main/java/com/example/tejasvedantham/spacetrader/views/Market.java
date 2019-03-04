package com.example.tejasvedantham.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tejasvedantham.spacetrader.R;
import com.example.tejasvedantham.spacetrader.model.Planet;

public class Market extends AppCompatActivity {

    private TextView marketTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.market);

        initialize();
    }

    private void initialize() {
        marketTextView = (TextView) findViewById(R.id.marketText);
    }

    public void createTradeGoodsMatrix(Planet planet) {

    }

}
