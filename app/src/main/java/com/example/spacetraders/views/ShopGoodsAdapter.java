package com.example.spacetraders.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
import com.example.spacetraders.models.Model;

import java.util.ArrayList;
import java.util.List;

public class ShopGoodsAdapter extends RecyclerView.Adapter<ShopGoodsAdapter.ShopGoodsViewHolder> {

    /**
     * a copy of the list of shop goods in the model
     */

    private ShopActivity shopActivity;
    private PlayerCargoAdapter playerCargoAdapter;
    private List<ShopEntry> shopGoodsList;
    private OnClickListener listener;
    private Model model;
    private AlertDialog dialog;
    private boolean dialogConfirmed;

    public ShopGoodsAdapter(List<ShopEntry> shopGoodsList, ShopActivity shopActivity) {
        this.shopGoodsList = shopGoodsList;
        this.model = Model.getInstance();
        this.shopActivity = shopActivity;
    }

    @NonNull
    @Override
    public ShopGoodsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_entry, parent, false);

        return new ShopGoodsViewHolder(itemView);
    }

    public class ShopGoodsViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView stock;


        public ShopGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_text);
            price = itemView.findViewById(R.id.price_text);
            stock = itemView.findViewById(R.id.stock_text);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (position == RecyclerView.NO_POSITION) {
                        CharSequence text = "DO NOT CLICK THAT";
                        Toast toast = Toast.makeText(itemView.getContext(), text, Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        if (listener != null) {
                            listener.onClicked(shopGoodsList.get(position));
                            //view.setBackgroundColor(Color.CYAN);
                        }

                        int cost = Integer.parseInt(price.getText().toString());

                        if (shopGoodsList.get(position).getStock() > 0
                                && model.makeTransaction(shopGoodsList.get(position).getGood(), 1, cost) == 1) {

                            Context context = itemView.getContext();
                            int itemStock = shopGoodsList.get(position).getStock();

                            dialogConfirmed = false;

                            // master layout
                            LinearLayout layout = new LinearLayout(context);
                            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            layout.setOrientation(LinearLayout.VERTICAL);
                            layout.setLayoutParams(params);
                            layout.setGravity(Gravity.CLIP_VERTICAL);
                            layout.setPadding(2, 2, 2, 2);

                            // seek bar for alert dialog to select how much to buy
                            final SeekBar seek = new SeekBar(context);
                            seek.setMax(itemStock - 1);
                            seek.setKeyProgressIncrement(1);

                            // text view for seek bar
                            TextView seekText = new TextView(context);
                            seekText.setText("Value of: ");
                            seekText.setPadding(40, 40, 40, 40);
                            seekText.setGravity(Gravity.CENTER);
                            seekText.setTextSize(20);

                            // text view changes with seek bar position change
                            seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {}

                                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                    seekText.setText("Value of : " + progress + 1);
                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });

                            // adding seek and text view to master layout
                            LinearLayout.LayoutParams seekTextParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            seekTextParams.bottomMargin = 5;
                            layout.addView(seekText, seekTextParams);
                            LinearLayout.LayoutParams seekParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            seekParams.bottomMargin = 5;
                            layout.addView(seek, seekParams);

                            // asking user how much to buy
                            AlertDialog.Builder builder = new AlertDialog.Builder(context);

                            builder.setTitle("chungus.info")
                                    .setView(layout)
                                    .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                                        // when positive button clicked dismiss dialog
                                        @Override
                                        public void onClick(DialogInterface d, int which) {
                                            dialogConfirmed = true;
                                            d.dismiss();
                                        }
                                    })
                                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface d, int which) {
                                            d.dismiss();
                                        }
                                    });

                            dialog = builder.create();

                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    if (dialogConfirmed) {
                                        // updating inventories and display
                                        shopGoodsList = model.getShopEntries();
                                        playerCargoAdapter.setPlayerCargoList(model.getPlayerEntries());
                                        shopActivity.updateDisplay();
                                        notifyDataSetChanged();
                                    } else {
                                        return;
                                    }
                                }
                            });

                            dialog.show();

                            // TODO add 1 to amount of stock player wants to purchase to make it right
                        } else {
                            CharSequence text = "Not enough money or storage";
                            Toast toast = Toast.makeText(itemView.getContext(), text, Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }
            });

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ShopGoodsViewHolder shopGoodsViewHolder, int position) {
        ShopEntry shopEntry = shopGoodsList.get(position);
        shopGoodsViewHolder.price.setText(shopEntry.getPrice() + "");
        shopGoodsViewHolder.name.setText(shopEntry.getGood().getName());
        shopGoodsViewHolder.stock.setText(shopEntry.getStock() + "");
    }


    @Override
    public int getItemCount() {
        return shopGoodsList.size();
    }

    public void setShopGoodsList(List<ShopEntry> shopEntries) {
        shopGoodsList = shopEntries;
        notifyDataSetChanged();
    }

    public interface OnClickListener {
        void onClicked(ShopEntry goods);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public PlayerCargoAdapter getPlayerCargoAdapter() {
        return playerCargoAdapter;
    }

    public void setPlayerCargoAdapter(PlayerCargoAdapter pca) {
        playerCargoAdapter = pca;
    }

    public List<ShopEntry> getShopGoodsList() {
        return shopGoodsList;
    }

    public int getCostOfGood(ShopGoods good) {
        for (ShopEntry entry : shopGoodsList) {
            if (entry.getGood().equals(good)) {
                return entry.getPrice();
            }
        }
        return -1;
    }
}
