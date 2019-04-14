package com.example.tejasvedantham.spacetrader.views;

import android.content.Intent;
//import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tejasvedantham.spacetrader.R;
//import com.example.tejasvedantham.spacetrader.model.DBHelper;
import com.example.tejasvedantham.spacetrader.model.Game;
import com.example.tejasvedantham.spacetrader.viewmodels.MainGameViewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;

public class MainGame extends AppCompatActivity {

    private TextView solarSystemText;
    private TextView planetText;
    private TextView fuelText;
    final MainGameViewModel mvm = new MainGameViewModel(getApplication());
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_game);

        solarSystemText = findViewById(R.id.solarSystemText);
        planetText = findViewById(R.id.planetText);
        Button marketButton = findViewById(R.id.marketButton);
        fuelText = findViewById(R.id.fuelText);

        setText();
    }

    public void goToMarket(View view) {

        Intent intent = new Intent(getApplicationContext(), MarketView.class);
        startActivity(intent);
    }

    public void goToTravel(View view) throws IOException {

        Intent intent = new Intent(getApplicationContext(), TravelView.class);
        startActivity(intent);
    }

    public void saveGame(View view) {
        database.setValue(mvm.getGame());
        database.child("player").child("spaceship").child("spaceShipType").child("fuelLeft")
                .setValue(mvm.getGame().getPlayer().getSpaceship().getSpaceShipType().getTravelDistance());
        database.child("universe").child("currentSS").child("market").child("onShip").setValue(
                mvm.getGame().getUniverse().getCurrentSS().getMarket().getOnShip());

        Toast.makeText(getApplicationContext(), "Game saved successfully", Toast.LENGTH_SHORT);
    }

    public void loadGame(View view) {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Game toLoad = dataSnapshot.getValue(Game.class);
                mvm.setGame(toLoad);

                Log.w("SPACESHIP", "" + mvm.getGame().getPlayer().getSpaceship().getSpaceShipType());
                setText();
                Log.w("HERE", mvm.getGame().getUniverse().getCurrentSS().getName());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to load.");
            }

        });
    }

    public static Game toGame(byte[] bytes) throws IOException, ClassNotFoundException{
        Object obj;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } finally {
            if (bis != null) {
                bis.close();
            }
            if (ois != null) {
                ois.close();
            }
        }
        return (Game) obj;
    }

    public void setText() {
        solarSystemText.setText("Solar System: " + mvm.getGame().getUniverse().getCurrentSS().getName());
        planetText.setText("Planet: " + mvm.getGame().getUniverse().getCurrentSS().getCurrentPlanet().getName());
        fuelText.setText("Fuel Left: " + mvm.getGame().getPlayer().getSpaceship().getFuelLeft());
    }

}
