package com.example.roma.vipslots;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Roma on 17.05.2018.
 */

public class JackpotItemDecoration extends RecyclerView.ItemDecoration
{
    private int space;

    public JackpotItemDecoration(int space)
    {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        int position = parent.getChildAdapterPosition(view);
        if (position == parent.getAdapter().getItemCount() - 1) {
            outRect.bottom = 0;
        }
        else{
            outRect.bottom = space;
        }
    }
}