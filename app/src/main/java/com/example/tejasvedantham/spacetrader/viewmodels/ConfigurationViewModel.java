package com.example.tejasvedantham.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.tejasvedantham.spacetrader.model.Difficulty;
import com.example.tejasvedantham.spacetrader.model.Game;
import com.example.tejasvedantham.spacetrader.model.Player;

public class ConfigurationViewModel extends AndroidViewModel{
    private Game game;

    public ConfigurationViewModel(Application application) {
        super(application);
        game = Game.getInstance();

    }

    public void updatePlayer(Player player) {
        game.setPlayer(player);
    }

    public void updateGame(Difficulty difficulty) {
        game.setDifficulty(difficulty);
    }

}