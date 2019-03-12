package com.example.tejasvedantham.spacetrader.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.example.tejasvedantham.spacetrader.model.Game;
import com.example.tejasvedantham.spacetrader.model.TradeGood;


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

        public void updateCargoSpace(int toSubtract) {
            int current = game.getPlayer().getSpaceship().getCargoNum();
            game.getPlayer().getSpaceship().setCargoNum(current - toSubtract);
        }

        public void updateOwnedGoodsOnBuy(TradeGood toAdd) {
            game.getPlayer().getOwnedGoods().add(toAdd);
        }

        public void updateOwnedGoodsOnSell(TradeGood toRemove) {
            game.getPlayer().getOwnedGoods().remove(toRemove);
        }


        public Game getGame() {
            return this.game;
        }
}
