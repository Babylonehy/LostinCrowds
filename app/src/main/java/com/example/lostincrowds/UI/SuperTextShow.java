package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lostincrowds.R;

import org.w3c.dom.Text;

public class SuperTextShow extends View {
    @SuppressLint("ResourceType")
    public SuperTextShow ( Context context ) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.supertextview , null);

    }

    public SuperTextShow ( Context context , AttributeSet attrs ) {
        super(context , attrs);

    }
}
