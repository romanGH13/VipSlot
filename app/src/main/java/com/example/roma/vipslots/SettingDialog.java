package com.example.roma.vipslots;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Roma on 18.05.2018.
 */

public class SettingDialog {

    public void showDialog(final Activity activity){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.settings_dialog);

        final CheckBox cb1 = (CheckBox) dialog.findViewById(R.id.cb1);
        CheckBox cb2 = (CheckBox) dialog.findViewById(R.id.cb2);
        CheckBox cb3 = (CheckBox) dialog.findViewById(R.id.cb3);

        if(!((MainActivity)activity).user.isFirstLine())
            cb1.setChecked(false);
        if(!((MainActivity)activity).user.isSecondLine())
            cb2.setChecked(false);
        if(!((MainActivity)activity).user.isThirdLine())
            cb3.setChecked(false);


        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked())
                {
                    ((MainActivity)activity).user.setFirstLine(true);
                    ((MainActivity)activity).changeFirstLine(true);
                }
                else
                {
                    ((MainActivity)activity).user.setFirstLine(false);
                    ((MainActivity)activity).changeFirstLine(false);
                }
            }
        });

        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked())
                {
                    ((MainActivity)activity).user.setSecondLine(true);
                    ((MainActivity)activity).changeSecondLine(true);
                }
                else
                {
                    ((MainActivity)activity).user.setSecondLine(false);
                    ((MainActivity)activity).changeSecondLine(false);
                }
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CheckBox)view).isChecked())
                {
                    ((MainActivity)activity).user.setThirdLine(true);
                    ((MainActivity)activity).changeThirdLine(true);
                }
                else
                {
                    ((MainActivity)activity).user.setThirdLine(false);
                    ((MainActivity)activity).changeThirdLine(false);
                }
            }
        });

        Button btn = (Button) dialog.findViewById(R.id.button_take_coins);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)activity).user.addCoints(1000);
                ((MainActivity)activity).updateCoins();
            }
        });

        dialog.show();
    }
}