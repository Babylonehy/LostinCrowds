/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Level1.java@author: jack@date: 18/05/19 1:45 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.LinearLayout;

import com.example.lostincrowds.Crowds;
import com.example.lostincrowds.R;
import com.example.lostincrowds.UI.MyImageView;

import java.util.ArrayList;

import static com.example.lostincrowds.ConstantValue.HEIGHT;
import static com.example.lostincrowds.ConstantValue.WIDTH;

public class Level1 extends BasicActivity {
    public ArrayList<MyImageView> ListForImageView = new ArrayList<>();
    private Crowds crowds;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.init_windows();
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT ,
                WIDTH);
        display = getWindowManager().getDefaultDisplay();
        MyImageView init1 = new MyImageView(this , R.drawable.peepsyellow , R.drawable.eyesopen , display.getWidth()/14*6 , display.getHeight()/16, 100 , "0");
        MyImageView init2 = new MyImageView(this , R.drawable.peepsyellow , R.drawable.eyesopen, display.getWidth()/14*4, display.getHeight()/16*3 , 100 , "1");
        MyImageView init3 = new MyImageView(this , R.drawable.peepsyellow , R.drawable.eyesopen, display.getWidth()/14*8  , display.getHeight()/16*3 , 100 , "2");
        MyImageView init4 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/14*3 , display.getHeight()/16*6 , 0 , "3");
        MyImageView init5 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/14*9 , display.getHeight()/16*6 , 0 , "4");
        MyImageView init6 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/14*7/2 , display.getHeight()/16*9 , 0 , "5");
        MyImageView init7 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/14*17/2 , display.getHeight()/16*9 , 0 , "6");
        MyImageView init8 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/14*5 , display.getHeight()/16*11 , 0 , "7");
        MyImageView init9 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/14*7 , display.getHeight()/16*11 , 0 , "8");

        crowds.addInfector(init1.getViewId());
        crowds.addInfector(init2.getViewId());
        crowds.addInfector(init3.getViewId());
        crowds.addPerson(init4.getViewId());
        crowds.addPerson(init5.getViewId());
        crowds.addPerson(init6.getViewId());
        crowds.addPerson(init7.getViewId());
        crowds.addPerson(init8.getViewId());
        crowds.addPerson(init9.getViewId());

        addContentView(init1,params);
        addContentView(init2,params);
        addContentView(init3,params);
        addContentView(init4,params);
        addContentView(init5,params);
        addContentView(init6,params);
        addContentView(init7,params);
        addContentView(init8,params);
        addContentView(init9,params);

        ListForImageView.add(init1);
        ListForImageView.add(init2);
        ListForImageView.add(init3);
        ListForImageView.add(init4);
        ListForImageView.add(init5);
        ListForImageView.add(init6);
        ListForImageView.add(init7);
        ListForImageView.add(init8);
        ListForImageView.add(init9);

        getDrawLine().setImageView(ListForImageView);


    }
}
