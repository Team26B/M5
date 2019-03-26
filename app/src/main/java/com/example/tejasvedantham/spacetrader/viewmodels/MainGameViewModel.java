package com.example.tejasvedantham.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.tejasvedantham.spacetrader.model.Game;
import com.example.tejasvedantham.spacetrader.model.Market;
import com.example.tejasvedantham.spacetrader.model.Planet;
import com.example.tejasvedantham.spacetrader.model.SolarSystem;

public class MainGameViewModel extends AndroidViewModel {

    private Game game;

    public MainGameViewModel(Application application) {
        super(application);
        game = Game.getInstance();
    }

    public void updateSolarSystem(SolarSystem ss) {
        game.getUniverse().setCurrentSS(ss);
    }
    public void updatePlanet() {
        game.getUniverse().getCurrentSS().setCurrentPlanet(game.getUniverse().getCurrentSS().getPlanets().get(0));
    }

    public void updateMarket(Market nMarket) {
    }

    public void updateTravelDistanceLeft(int td) {
        game.getPlayer().getSpaceship().getSpaceShipType().setTravelDistance(td);
    }

    public Game getGame() {
        return this.game;
    }

}
