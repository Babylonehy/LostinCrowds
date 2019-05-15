package com.example.lostincrowds.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.lostincrowds.R;

import mehdi.sakout.fancybuttons.FancyButton;

public class PlayButton extends android.support.v7.widget.AppCompatButton {
    private FancyButton fancyButton;
    public PlayButton(Context context) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.supertextview , null);
        fancyButton=view.findViewById(R.id.btn_play);
    }

    public PlayButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.supertextview , null);
        fancyButton=view.findViewById(R.id.btn_play);
    }

    public FancyButton getFancyButton() {
        return fancyButton;
    }
}
