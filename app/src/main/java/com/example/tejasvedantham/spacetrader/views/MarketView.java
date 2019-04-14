package com.example.tejasvedantham.spacetrader.views;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tejasvedantham.spacetrader.R;
import com.example.tejasvedantham.spacetrader.model.DBHelper;
import com.example.tejasvedantham.spacetrader.model.Market;
import com.example.tejasvedantham.spacetrader.model.Planet;
import com.example.tejasvedantham.spacetrader.model.TradeGood;
import com.example.tejasvedantham.spacetrader.viewmodels.MarketViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class MarketView extends AppCompatActivity {

    private TextView cargoSpaceText;
    private TextView numCreditsText;
    private TextView goodsOnShipText;
    private LinearLayout sl;
    MarketViewModel mvm = new MarketViewModel(getApplication());
    List<TradeGood> forSale = mvm.getGame()
            .getUniverse()
            .getCurrentSS()
            .getMarket()
            .getOnMarket();

    Button[] buyButtons = new Button[forSale.size()];
    Button[] sellButtons = new Button[forSale.size()];
    TextView[] buytextViews = new TextView[forSale.size()];
    TextView[] sellTextViews = new TextView[forSale.size()];

    //DBHelper db = new DBHelper(this);
    //Cursor cursor = db.getGameFromDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.market);

        initialize();



        cargoSpaceText.append("" + mvm.getGame()
                .getPlayer()
                .getSpaceship()
                .getCargoNum());


        numCreditsText.append("" + mvm.getGame()
                .getPlayer()
                .getNumCredits());

        goodsOnShipText.append("" + mvm.getGame()
                .getPlayer()
                .getOwnedGoods());


        for (int i = 0; i < forSale.size(); i++) {

            LinearLayout ll = findViewById(R.id.linearLayout);
            sl = findViewById(R.id.shipLayout);


            final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 10, 10, 10);

            buytextViews[i] = new TextView(this);
            buytextViews[i].setText("\n" + forSale.get(i).getTradeGoodType()
                    + "\t$"
                    + forSale.get(i).getMarketPrice() +
                    "\n");

            ll.addView(buytextViews[i], params);

            buyButtons[i] = new Button(getApplicationContext());
            buyButtons[i].setText("BUY");


            buyButtons[i].setLayoutParams(params);

            final int finalI = i;

            buyButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mvm.getGame().getPlayer().getSpaceship().getCargoNum() == 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "You do not have enough cargo space to buy this item.", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }

                    if (forSale.get(finalI).getTradeGoodType().getBasePrice() > mvm.getGame().getPlayer().getNumCredits()) {
                        Toast toast = Toast.makeText(getApplicationContext(), "You cannot afford this.", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }

                    mvm.getGame().getPlayer().buy(forSale.get(finalI), mvm.getGame().getUniverse().getCurrentSS().getMarket());
                    mvm.updateNumCredits(forSale.get(finalI).getMarketPrice());
                    mvm.updateCargoSpace(1);
                    mvm.updateOwnedGoodsOnBuy(forSale.get(finalI));

                    cargoSpaceText.setText("Cargo Space: " + mvm.getGame().getPlayer().getSpaceship().getCargoNum());
                    numCreditsText.setText("Credits: " + mvm.getGame().getPlayer().getNumCredits());

                    sellFunction(finalI);

                    //goodsOnShipText.append("\n" + mvm.getGame().getPlayer().getOwnedGoods().get(mvm.getGame().getPlayer().getOwnedGoods().size() - 1).getTradeGoodType());
                }
            });

            ll.addView(buyButtons[i]);


        }



    }

    public void sellFunction(final int index) {

        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 10, 10);

        sellTextViews[index] = new TextView(getApplicationContext());
        sellTextViews[index].setText("\n" + mvm.getGame().getPlayer().getOwnedGoods().get(mvm.getGame().getPlayer().getOwnedGoods().size() - 1).getTradeGoodType());
        //sellTextViews[finalI].setId(finalI);
        sl.addView(sellTextViews[index], params);

        sellButtons[index] = new Button(getApplicationContext());
        sellButtons[index].setText("SELL");
        sellButtons[index].setLayoutParams(params);
        //sellButtons[finalI].setId(finalI);

        sl.addView(sellButtons[index]);

        sellButtons[index].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvm.getGame().getPlayer().sell(forSale.get(index), mvm.getGame().getUniverse().getCurrentSS().getMarket());
                mvm.updateNumCredits(-1 * forSale.get(index).getMarketPrice());
                mvm.updateCargoSpace(-1);
                mvm.updateOwnedGoodsOnSell(forSale.get(index));

                cargoSpaceText.setText("Cargo Space: " + mvm.getGame().getPlayer().getSpaceship().getCargoNum());
                numCreditsText.setText("Credits: " + mvm.getGame().getPlayer().getNumCredits());


                ViewGroup layout1 = (ViewGroup) sellTextViews[index].getParent();
                ViewGroup layout2 = (ViewGroup) v.getParent();


                layout1.removeView(sellTextViews[index]);

                layout2.removeView(v);

            }
        });
    }

    private void initialize() {

        TextView marketTextView = findViewById(R.id.marketText);
        cargoSpaceText = findViewById(R.id.cargoSpaceText);
        numCreditsText = findViewById(R.id.numCreditsText);
        TextView goodsForSaleText = findViewById(R.id.goodsOnSaleText);
        goodsOnShipText = findViewById(R.id.goodsOnShipText);


    }



}
