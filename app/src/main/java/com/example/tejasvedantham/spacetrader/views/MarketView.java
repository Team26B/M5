package com.example.tejasvedantham.spacetrader.views;

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
import com.example.tejasvedantham.spacetrader.model.Market;
import com.example.tejasvedantham.spacetrader.model.Planet;
import com.example.tejasvedantham.spacetrader.model.TradeGood;
import com.example.tejasvedantham.spacetrader.viewmodels.MarketViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class MarketView extends AppCompatActivity {

    private TextView marketTextView;
    private TextView cargoSpaceText;
    private TextView numCreditsText;
    private TextView goodsOnShipText;
    private TextView goodsForSaleText;
    private LinearLayout ll;
    private LinearLayout sl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.market);

        initialize();

        final MarketViewModel mvm = new MarketViewModel(getApplication());

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

        final List<TradeGood> forSale = mvm.getGame()
                .getUniverse()
                .getSolarSystems()
                .iterator()
                .next()
                .getMarket()
                .getOnMarket();

        Button[] buyButtons = new Button[forSale.size()];
        final Button[] sellButtons = new Button[forSale.size()];
        TextView[] buytextViews = new TextView[forSale.size()];
        final TextView[] sellTextViews = new TextView[forSale.size()];



        for (int i = 0; i < forSale.size(); i++) {

            ll = (LinearLayout) findViewById(R.id.linearLayout);
            sl = (LinearLayout)findViewById(R.id.shipLayout);


            final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 10, 10, 10);

            buytextViews[i] = new TextView(this);
            buytextViews[i].setText("\n" + forSale.get(i).getTradeGoodType()
                    + "\t$"
                    + forSale.get(i).getTradeGoodType().getBasePrice() +
                    "\n");

            buytextViews[i].setId(i);
            //goodsForSaleText.append(textViews[i].getText());

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

                    mvm.getGame().getPlayer().buy(forSale.get(finalI), mvm.getGame().getUniverse().getSolarSystems().iterator().next().getMarket());
                    mvm.updateNumCredits(forSale.get(finalI).getTradeGoodType().getBasePrice());
                    mvm.updateCargoSpace(1);
                    mvm.updateOwnedGoodsOnBuy(forSale.get(finalI));

                    cargoSpaceText.setText("Cargo Space: " + mvm.getGame().getPlayer().getSpaceship().getCargoNum());
                    numCreditsText.setText("Credits: " + mvm.getGame().getPlayer().getNumCredits());

                    sellTextViews[finalI] = new TextView(getApplicationContext());
                    sellTextViews[finalI].setText("\n" + mvm.getGame().getPlayer().getOwnedGoods().get(mvm.getGame().getPlayer().getOwnedGoods().size() - 1).getTradeGoodType());
                    sellTextViews[finalI].setId(finalI);
                    sl.addView(sellTextViews[finalI], params);

                    sellButtons[finalI] = new Button(getApplicationContext());
                    sellButtons[finalI].setText("SELL");
                    sellButtons[finalI].setLayoutParams(params);

                    sl.addView(sellButtons[finalI]);

                    sellButtons[finalI].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mvm.getGame().getPlayer().sell(forSale.get(finalI), mvm.getGame().getUniverse().getSolarSystems().iterator().next().getMarket());
                            mvm.updateNumCredits(-1 * forSale.get(finalI).getTradeGoodType().getBasePrice());
                            mvm.updateCargoSpace(-1);
                            mvm.updateOwnedGoodsOnSell(forSale.get(finalI));

                            cargoSpaceText.setText("Cargo Space: " + mvm.getGame().getPlayer().getSpaceship().getCargoNum());
                            numCreditsText.setText("Credits: " + mvm.getGame().getPlayer().getNumCredits());

                            ViewGroup layout = (ViewGroup) sellButtons[finalI].getParent();

                            if (layout != null) {
                                layout.removeView(sellTextViews[finalI]);
                                layout.removeView(sellButtons[finalI]);
                            }

                        }
                    });



                    //goodsOnShipText.append("\n" + mvm.getGame().getPlayer().getOwnedGoods().get(mvm.getGame().getPlayer().getOwnedGoods().size() - 1).getTradeGoodType());
                }
            });

            ll.addView(buyButtons[i]);


        }



    }

    private void initialize() {

        marketTextView = (TextView) findViewById(R.id.marketText);
        cargoSpaceText = (TextView) findViewById(R.id.cargoSpaceText);
        numCreditsText = (TextView) findViewById(R.id.numCreditsText);
        goodsForSaleText = (TextView) findViewById(R.id.goodsOnSaleText);
        goodsOnShipText = (TextView) findViewById(R.id.goodsOnShipText);


    }



}
