package com.example.roma.vipslots;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Roma on 16.05.2018.
 */

public class CombinationsRecyclerViewAdapter extends RecyclerView.Adapter<CombinationsRecyclerViewAdapter.ViewHolder> {

    private Map<String, String> mData;
    private LayoutInflater mInflater;
    private boolean isForJackpot;
    private int height;

    // data is passed into the constructor
    CombinationsRecyclerViewAdapter(Context context, Map<String, String> data, boolean isForJackpot, int height) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.isForJackpot = isForJackpot;
        this.height = height;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.combination_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Map.Entry<String, String> entry = getItemFromData(position);
        if(entry == null)
            return;
        int resID = holder.itemView.getContext().getResources().getIdentifier(entry.getValue(),
                "mipmap", holder.itemView.getContext().getPackageName());

        holder.value.setText(entry.getKey());
        holder.image1.setImageResource(resID);
        holder.image2.setImageResource(resID);
        holder.image3.setImageResource(resID);

        if(isForJackpot)
        {
            if(entry.getKey().contentEquals("50"))
            {
                holder.image3.setVisibility(View.INVISIBLE);
            }
            if(entry.getKey().contentEquals("25"))
            {
                holder.image3.setVisibility(View.INVISIBLE);
                holder.image2.setVisibility(View.INVISIBLE);
            }
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image1;
        ImageView image2;
        ImageView image3;
        TextView value;

        ViewHolder(View itemView) {
            super(itemView);
            image1 = (ImageView)itemView.findViewById(R.id.image1);
            image2 =(ImageView) itemView.findViewById(R.id.image2);
            image3 = (ImageView)itemView.findViewById(R.id.image3);
            value =(TextView) itemView.findViewById(R.id.value);

            ViewGroup.LayoutParams params1 = (ViewGroup.LayoutParams) image1.getLayoutParams();
            params1.height = (height / 8);
            image1.setLayoutParams(params1);

            ViewGroup.LayoutParams params2 = (ViewGroup.LayoutParams) image2.getLayoutParams();
            params2.height = (height / 8);
            image2.setLayoutParams(params2);

            ViewGroup.LayoutParams params3 = (ViewGroup.LayoutParams) image3.getLayoutParams();
            params3.height = (height / 8);
            image3.setLayoutParams(params3);
        }

        @Override
        public void onClick(View view) {

        }
    }

    private Map.Entry<String, String> getItemFromData(int id)
    {
        int index = 0;
        for(Map.Entry<String, String> entry : mData.entrySet()) {
            if(index == id) {
                return entry;
            }
            index++;
        }
        return null;
    }
}
