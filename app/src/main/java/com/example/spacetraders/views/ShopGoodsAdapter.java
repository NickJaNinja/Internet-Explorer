package com.example.spacetraders.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetraders.R;
import com.example.spacetraders.entities.ShopEntry;
import com.example.spacetraders.entities.ShopGoods;
import com.example.spacetraders.models.Model;

import java.util.List;
/**
 * Adapts the list of shop goods in market to be a list of graphical elements in view
 */
public class ShopGoodsAdapter extends RecyclerView.Adapter<ShopGoodsAdapter.ShopGoodsViewHolder> {

    /**
     * a copy of the list of shop goods in the model
     */

    private final ShopActivity shopActivity;
    private PlayerCargoAdapter playerCargoAdapter;
    private List<ShopEntry> shopGoodsList;
    private OnClickListener listener;
    private final Model model;
    private AlertDialog dialog;
    private boolean dialogConfirmed;

    /**
     * constructor
     *
     * @param shopGoodsList list of shop goods list
     * @param shopActivity shop activity
     */
    public ShopGoodsAdapter(List<ShopEntry> shopGoodsList, ShopActivity shopActivity) {
        for (ShopEntry entry : shopGoodsList) {
            if (entry.getStock() == 0) {
                shopGoodsList.remove(entry);
            }
        }
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
        private final TextView name;
        private final TextView price;
        private final TextView stock;

        /**
         * shop goods view holder
         *
         * @param itemView view
         */
        ShopGoodsViewHolder(@NonNull View itemView) {
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
                        if (listener != null) {
                            listener.onClicked(shopGoodsList.get(position));
                            //view.setBackgroundColor(Color.CYAN);
                        }

                        int cost = Integer.parseInt(price.getText().toString().substring(1));

                        if (shopGoodsList.get(position).getStock() > 0 ) {

                            Context context = itemView.getContext();
                            int itemStock = shopGoodsList.get(position).getStock();
                            int itemPrice = shopGoodsList.get(position).getPrice();

                            dialogConfirmed = false;

                            //magic number
                            final int PADDING2 = 2;
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
                            layout.setPadding(PADDING2, PADDING2, PADDING2, PADDING2);

                            // seek bar for alert dialog to select how much to buy
                            SeekBar seek = new SeekBar(context);
                            seek.setMax((itemStock - 1));
                            seek.setKeyProgressIncrement(10);

                            // text view for seek bar
                            TextView seekText = new TextView(context);
                            seekText.setText("AMOUNT TO PURCHASE: 1");
                            seekText.setTextColor(COLOR);
                            seekText.setPadding(PADDING40, PADDING40, PADDING40, PADDING40);
                            seekText.setGravity(Gravity.CENTER);
                            seekText.setTextSize(SIZE);

                            // text view for price
                            TextView priceText = new TextView(context);
                            priceText.setText("TOTAL PRICE: ¥" +itemPrice);
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
                                    seekText.setText("AMOUNT TO PURCHASE: " + (progress + 1));
                                    priceText.setText("TOTAL PRICE: ¥" +
                                            (itemPrice * (progress + 1)));
                                }

                                @Override
                                public void onStopTrackingTouch(SeekBar seekBar) {

                                }
                            });

                            // adding seek and text views to master layout
                            LinearLayout.LayoutParams priceTextParams = new LinearLayout.
                                    LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT);
                            priceTextParams.bottomMargin = 5;
                            layout.addView(priceText, priceTextParams);
                            LinearLayout.LayoutParams seekTextParams = new LinearLayout.
                                    LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
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
                                            shopGoodsList.get(position).getGood(),
                                            seek.getProgress() + 1, cost) == 1)) {
                                        // updating inventories and display
                                        shopGoodsList = model.getShopEntries();
                                        playerCargoAdapter.setPlayerCargoList(
                                                model.getPlayerEntries());
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

    @Override
    public void onBindViewHolder(@NonNull ShopGoodsViewHolder shopGoodsViewHolder, int position) {
        ShopEntry shopEntry = shopGoodsList.get(position);
        shopGoodsViewHolder.price.setText("¥" +shopEntry.getPrice());
        shopGoodsViewHolder.name.setText(shopEntry.getGood().getName());
        shopGoodsViewHolder.stock.setText(shopEntry.getStock() + "");
    }


    @Override
    public int getItemCount() {
        return shopGoodsList.size();
    }

    /**
     * set shop goods list
     *
     * @param shopEntries list of shop entries
     */
    public void setShopGoodsList(List<ShopEntry> shopEntries) {
        shopGoodsList = shopEntries;
        notifyDataSetChanged();
    }

    interface OnClickListener {

        /**
         * on click
         *
         * @param goods shop entry
         */
        void onClicked(ShopEntry goods);
    }
//
//    /**
//     * set on click listener
//     *
//     * @param listener on lick listener
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)
//     */
//    public void setOnClickListener(OnClickListener listener) {
//        this.listener = listener;
//    }

// --Commented out by Inspection START (4/2/19, 11:03 PM):
//    /**
//     *
//     * @return a list of shop goods in players inventory
//     */
//    public PlayerCargoAdapter getPlayerCargoAdapter() {
//        return playerCargoAdapter;
//    }
// --Commented out by Inspection STOP (4/2/19, 11:03 PM)

    /**
     * set player cargo adapter
     *
     * @param pca player cargo adapter
     */
    public void setPlayerCargoAdapter(PlayerCargoAdapter pca) {
        playerCargoAdapter = pca;
    }

//    /**
//     *
//     * @return a list of shop goods in market
//     */
//    public List<ShopEntry> getShopGoodsList() {
//        return shopGoodsList;
//    }

    /**
     *
     * @param good  a shop good
     * @return the shop good price OR -1 if fail
     */
    public int getCostOfGood(ShopGoods good) {
        for (ShopEntry entry : shopGoodsList) {
            if (entry.getGood().equals(good)) {
                return entry.getPrice();
            }
        }
        return -1;
    }
}
