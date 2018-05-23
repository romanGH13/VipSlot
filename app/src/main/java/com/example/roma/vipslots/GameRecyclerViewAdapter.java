package com.example.roma.vipslots;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import static com.example.roma.vipslots.MainActivity.gameLayout;

/**
 * Created by Roma on 17.05.2018.
 */

public class GameRecyclerViewAdapter extends RecyclerView.Adapter<GameRecyclerViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private int height;

    // data is passed into the constructor
    GameRecyclerViewAdapter(Context context, List<String> data, int height) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.height = height;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.game_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        int resID = holder.itemView.getContext().getResources().getIdentifier(mData.get(position),
                "mipmap", holder.itemView.getContext().getPackageName());

        holder.image1.setImageResource(resID);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image1;

        ViewHolder(View itemView) {
            super(itemView);
            image1 = (ImageView)itemView.findViewById(R.id.image1);
            ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) image1.getLayoutParams();
            params.height = (height / 3) - (height / 8);
            image1.setLayoutParams(params);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public void setData(List<String> data)
    {
        this.mData = data;
    }

    public String getItemByIndex(int index)
    {
        return this.mData.get(index);
    }
}
