package com.example.tejasvedantham.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.tejasvedantham.spacetrader.model.Game;
import com.example.tejasvedantham.spacetrader.model.Market;
import com.example.tejasvedantham.spacetrader.model.SolarSystem;

public class MainGameViewModel extends AndroidViewModel {

    private Game game;

    public MainGameViewModel(Application application) {
        super(application);
        game = Game.getInstance();
    }

    public void updateSolarSystem(SolarSystem ss) {
        //update Solar System here
    }

    public void updateMarket(Market nMarket) {
        //update market here
    }

    public Game getGame() {
        return this.game;
    }

}
