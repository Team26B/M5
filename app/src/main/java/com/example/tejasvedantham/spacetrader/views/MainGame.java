package com.example.tejasvedantham.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.tejasvedantham.spacetrader.R;

import org.w3c.dom.Text;

public class MainGame extends AppCompatActivity {

    private TextView mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_game);

        mainText = (TextView) findViewById(R.id.mainText);
    }
}
