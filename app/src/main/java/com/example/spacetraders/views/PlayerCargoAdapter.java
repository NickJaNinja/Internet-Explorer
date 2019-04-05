package com.example.spacetraders.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

import java.util.List;

/**
 * Adapts the list of shop good in player's inventory to be a list of graphical elements in view
 */
public class PlayerCargoAdapter extends RecyclerView.Adapter<PlayerCargoAdapter
        .PlayerCargoViewHolder> {

    /**
     * a copy of the list of shop goods in the model
     */

    final ShopActivity shopActivity;
    ShopGoodsAdapter shopGoodsAdapter;
    List<ShopEntry> playerCargoList;
    OnClickListener listener;
    AlertDialog dialog;
    final Model model;

    /**
     * Constructor
     *
     * @param playerCargoList the player cargo list
     * @param shopActivity the shop activity
     */
    public PlayerCargoAdapter(@Nullable List<ShopEntry> playerCargoList, @Nullable ShopActivity shopActivity) {
        this.playerCargoList = playerCargoList;
        this.model = Model.getInstance();
        this.shopActivity = shopActivity;
    }

    @NonNull
    @Override
    public PlayerCargoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_entry, parent, false);

        return new PlayerCargoViewHolder(itemView);
    }

    public class PlayerCargoViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView price;
        final TextView stock;
        boolean dialogConfirmed;

        /**
         * ViewHolder Constructor
         * @param itemView view
         */
        PlayerCargoViewHolder(@NonNull View itemView) {
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
                        Toast toast = Toast.makeText(itemView.getContext(), text,
                                Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        ShopEntry selectedEntry = playerCargoList.get(position);
                        ShopGoods selectedGood = selectedEntry.getGood();
                        if (listener != null) {
                            listener.onClicked(playerCargoList.get(position));
                        }

                        int cost = shopGoodsAdapter.getCostOfGood(selectedGood);

                        /*
                        if (playerCargoList.get(position).getStock() > 0
                                && model.makeTransaction(selectedGood, -1, cost) == 1) {
                            playerCargoList = model.getPlayerEntries();
                            shopGoodsAdapter.setShopGoodsList(model.getShopEntries());
                            shopActivity.updateDisplay();
                            notifyDataSetChanged();
                        }
                        */

                        if (playerCargoList.get(position).getStock() > 0 ) {

                            Context context = itemView.getContext();
                            int itemStock = playerCargoList.get(position).getStock();
                            int itemPrice = playerCargoList.get(position).getPrice();

                            dialogConfirmed = false;
                            final int PADDING40 = 40;
                            final int SIZE = 20;
                            final int COLOR = 0xFFFFFFFF;


                            // master layout
                            LinearLayout layout = new LinearLayout(context);
                            LinearLayout.LayoutParams params =
                                    new LinearLayout.LayoutParams(
                                            LinearLayout.LayoutParams.MATCH_PARENT,
                                            LinearLayout.LayoutParams.WRAP_CONTENT);
                            layout.setOrientation(LinearLayout.VERTICAL);
                            layout.setLayoutParams(params);
                            layout.setGravity(Gravity.CLIP_VERTICAL);
                            layout.setPadding(2, 2, 2, 2);

                            // seek bar for alert dialog to select how much to buy
                            SeekBar seek = new SeekBar(context);
                            seek.setMax((itemStock - 1));
                            seek.setKeyProgressIncrement(10);

                            // text view for seek bar
                            TextView seekText = new TextView(context);
                            String aah = "AMOUNT TO SELL: 1";
                            seekText.setText(aah);

                            seekText.setTextColor(COLOR);
                            seekText.setPadding(PADDING40, PADDING40, PADDING40, PADDING40);
                            seekText.setGravity(Gravity.CENTER);
                            seekText.setTextSize(SIZE);

                            // text view for price
                            TextView priceText = new TextView(context);
                            String qwo = "TOTAL SALE: ¥" +itemPrice;
                            priceText.setText(qwo);
                            priceText.setTextColor(COLOR);
                            priceText.setPadding(PADDING40, PADDING40, PADDING40, PADDING40);
                            priceText.setGravity(Gravity.CENTER);
                            priceText.setTextSize(SIZE);

                            // text views change with seek bar position change
                            seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                @Override
                                public void onStartTrackingTouch(SeekBar seekBar) {}

                                @Override
                                public void onProgressChanged(SeekBar seekBar,
                                                              int progress, boolean fromUser) {
                                    String as = "AMOUNT TO SELL: " + (progress + 1);
                                    seekText.setText(as);
                                    String aso = "TOTAL SALE: ¥" +(itemPrice *
                                            (progress + 1));
                                    priceText.setText(aso);
                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });

                            // adding seek and text views to master layout
                            LinearLayout.LayoutParams priceTextParams = new LinearLayout
                                    .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT);
                            priceTextParams.bottomMargin = 5;
                            layout.addView(priceText, priceTextParams);
                            LinearLayout.LayoutParams seekTextParams = new LinearLayout
                                    .LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT);
                            seekTextParams.bottomMargin = 5;
                            layout.addView(seekText, seekTextParams);
                            LinearLayout.LayoutParams seekParams =
                                    new LinearLayout.LayoutParams(
                                            LinearLayout.LayoutParams.MATCH_PARENT,
                                            LinearLayout.LayoutParams.WRAP_CONTENT);
                            seekParams.bottomMargin = 5;
                            layout.addView(seek, seekParams);

                            // asking user how much to buy
                            AlertDialog.Builder builder = new AlertDialog.Builder(context,
                                    R.style.AlertDialogTheme);

                            builder.setView(layout)
                                    .setPositiveButton("CONFIRM",
                                            new DialogInterface.OnClickListener() {
                                        // when positive button clicked dismiss dialog
                                        @Override
                                        public void onClick(DialogInterface d, int which) {
                                            dialogConfirmed = true;
                                            d.dismiss();
                                        }
                                    })
                                    .setNegativeButton("CANCEL",
                                            new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface d, int which) {
                                                    d.dismiss();
                                                }
                                            });

                            dialog = builder.create();

                            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    if (dialogConfirmed && (model.makeTransaction(
                                            selectedGood, -seek.getProgress() - 1,
                                            cost) == 1)) {
                                        // updating inventories and display
                                        playerCargoList = model.getPlayerEntries();
                                        shopGoodsAdapter.setShopGoodsList(model.getShopEntries());
                                        shopActivity.updateDisplay();
                                        notifyDataSetChanged();
                                    } else if (dialogConfirmed) {
                                        CharSequence text = "Not enough money or storage";
                                        Toast toast = Toast.makeText(itemView.getContext(), text,
                                                Toast.LENGTH_SHORT);
                                        toast.show();
                                    }
                                }
                            });

                            dialog.show();
                        } else {
                            CharSequence text = "Not enough money or storage";
                            Toast toast = Toast.makeText(itemView.getContext(), text,
                                    Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }
            });
        }
    }

    /**
     * ViewHolder constructor
     * @param playerCargoViewHolder the player cargo viewHolder
     * @param position the position of the shop entry
     */
    @Override
    public void onBindViewHolder(@NonNull PlayerCargoViewHolder playerCargoViewHolder,
                                 int position) {
        ShopEntry shopEntry = playerCargoList.get(position);
        String aoi = "¥" +shopGoodsAdapter.getCostOfGood(shopEntry
                .getGood()) +"(¥" +shopEntry.getPrice() +")";
        playerCargoViewHolder.price.setText(aoi);
        playerCargoViewHolder.name.setText(shopEntry.getGood().getName());
        playerCargoViewHolder.stock.setText(
                String.valueOf(shopEntry.getStock()));

    }

    /**
     * Gets the number of things that will be in the adapter
     * @return number of items
     */
    @Override
    public int getItemCount() {
        return playerCargoList.size();
    }

    /**
     * Sets the player cargo list
     * @param playerCargo player cargo
     */
    public void setPlayerCargoList(@Nullable List<ShopEntry> playerCargo) {
        playerCargoList = playerCargo;
        notifyDataSetChanged();
    }


    interface OnClickListener {

        /**
         * on clicked
         *
         * @param goods shop entry goods
         */
        void onClicked(ShopEntry goods);
    }

    /**
     * set on click listener
     *
     * @param listener on click listener
     *
     */

    public void setOnClickListener(@Nullable OnClickListener listener) {
        this.listener = listener;
    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     * get shop goods adapter
//     *
//     * @return shop goods adapter
//     */
//    public ShopGoodsAdapter getShopGoodsAdapter() {
//        return shopGoodsAdapter;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

    /**
     * set shop goods adapter
     *
     * @param sga shop goods adapter
     */
    public void setShopGoodsAdapter(@Nullable ShopGoodsAdapter sga) {
        shopGoodsAdapter = sga;
    }
}
