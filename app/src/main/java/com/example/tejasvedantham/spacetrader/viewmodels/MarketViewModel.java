package com.example.tejasvedantham.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.tejasvedantham.spacetrader.model.Game;


public class MarketViewModel extends AndroidViewModel {

    private Game game;

        public MarketViewModel(Application application) {
            super(application);
            game = Game.getInstance();

        }

        public void updateNumCredits(int toSubtract) {
            int current = game.getPlayer().getNumCredits();
            game.getPlayer().setNumCredits(current - toSubtract);
        }
}
