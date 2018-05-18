package com.example.roma.vipslots;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by Roma on 18.05.2018.
 */

public class WonDialog{

    public void showDialog(Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.win_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.coins);
        text.setText(msg);

        dialog.show();
    }
}