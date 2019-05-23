/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Level3.java@author: jack@date: 18/05/19 4:47 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lostincrowds.Crowds;
import com.example.lostincrowds.R;
import com.example.lostincrowds.UI.DrawLine;
import com.example.lostincrowds.UI.MyImageButton;
import com.example.lostincrowds.UI.MyImageView;
import com.hanks.htextview.line.LineTextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import static com.example.lostincrowds.ConstantValue.HEIGHT;
import static com.example.lostincrowds.ConstantValue.WIDTH;

/**
 * The type Level 3.
 *
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: Xiaorong Ma
 * @Date: $date$ $time$
 */
public class Level3 extends BasicActivity {
    /**
     * The Unconnectivepair.
     */
    public ArrayList<MyImageView[]> unconnectivepair = new ArrayList<>();
    /**
     * The List for image view.
     */
    public ArrayList<MyImageView> ListForImageView = new ArrayList<>();

    /**
     * The Draw line.
     */
    public DrawLine drawLine;
    private MyImageButton simulation;
    private MyImageButton restart;
    private Boolean flag = true;
    private Crowds crowds;
    private Context mcontext;
    private MyImageButton myImageButton;
    private String id = "3";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.init_windows();
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT,
                WIDTH);
        mcontext = getApplicationContext();
        try {
            Level3.super.update(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,Sandbox.class);

                finish();
                startActivity(intent);
            }
        });


        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.bkg);
        this.getWindow().setBackgroundDrawable(drawable);
        LineTextView lineTextView=getLineTextView();
        lineTextView.animateText("Draw connections within and between groups to spread wisdom to the whole world.");
        lineTextView.setX(10);
        lineTextView.setY(10);
        display = getWindowManager().getDefaultDisplay();
        MyImageView init1 = new MyImageView(this, R.drawable.peepsblue, R.drawable.simle, display.getWidth() / 7 * 3, 20, 0, "0");
        MyImageView init2 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 2, display.getHeight() / 7, 0, "1");
        MyImageView init3 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 4, display.getHeight() / 7, 0, "2");
        MyImageView init4 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 2 + 20, display.getHeight() / 7 * 2, 0, "3");
        MyImageView init5 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 4 + 20, display.getHeight() / 7 * 2, 0, "4");
        MyImageView init6 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 3 + 20, display.getHeight() / 7 * 3, 0, "5");
        crowds.addInfector(init1.getViewId());
        crowds.addPerson(init2.getViewId());
        crowds.addPerson(init3.getViewId());
        crowds.addPerson(init4.getViewId());
        crowds.addPerson(init5.getViewId());
        crowds.addPerson(init6.getViewId());
        addContentView(init1, params);
        addContentView(init2, params);
        addContentView(init3, params);
        addContentView(init4, params);
        addContentView(init5, params);
        addContentView(init6, params);

        MyImageView init7 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7, display.getHeight() / 7 * 3, 0, "6");
        MyImageView init8 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 20, display.getHeight() / 7 * 4, 0, "7");
        MyImageView init9 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 2, display.getHeight() / 7 * 4, 0, "8");
        MyImageView init10 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, 20 + 20, display.getHeight() / 7 * 5, 0, "9");
        MyImageView init11 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 2 + 20, display.getHeight() / 7 * 5, 0, "10");
        MyImageView init12 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 + 20, display.getHeight() / 7 * 6, 0, "11");
        crowds.addPerson(init7.getViewId());
        crowds.addPerson(init8.getViewId());
        crowds.addPerson(init9.getViewId());
        crowds.addPerson(init10.getViewId());
        crowds.addPerson(init11.getViewId());
        crowds.addPerson(init12.getViewId());

        MyImageView[] data = {init7, init8};
        MyImageView[] data1 = {init7, init9};
        MyImageView[] data2 = {init7, init10};
        MyImageView[] data3 = {init7, init11};
        MyImageView[] data4 = {init7, init12};
        MyImageView[] data5 = {init8, init9};
        MyImageView[] data6 = {init8, init10};
        MyImageView[] data7 = {init8, init11};
        MyImageView[] data8 = {init8, init12};
        MyImageView[] data9 = {init9, init10};
        MyImageView[] data10 = {init9, init11};
        MyImageView[] data11 = {init9, init12};
        MyImageView[] data12 = {init10, init11};
        MyImageView[] data13 = {init10, init12};
        MyImageView[] data14 = {init11, init12};

        crowds.connect(init7.getViewId(), init8.getViewId());
        crowds.connect(init7.getViewId(), init9.getViewId());
        crowds.connect(init7.getViewId(), init10.getViewId());
        crowds.connect(init7.getViewId(), init11.getViewId());
        crowds.connect(init7.getViewId(), init12.getViewId());
        crowds.connect(init8.getViewId(), init9.getViewId());
        crowds.connect(init8.getViewId(), init10.getViewId());
        crowds.connect(init8.getViewId(), init11.getViewId());
        crowds.connect(init8.getViewId(), init12.getViewId());
        crowds.connect(init9.getViewId(), init10.getViewId());
        crowds.connect(init9.getViewId(), init11.getViewId());
        crowds.connect(init9.getViewId(), init12.getViewId());
        crowds.connect(init10.getViewId(), init11.getViewId());
        crowds.connect(init10.getViewId(), init12.getViewId());
        crowds.connect(init11.getViewId(), init12.getViewId());


        unconnectivepair.add(data);
        unconnectivepair.add(data1);
        unconnectivepair.add(data2);
        unconnectivepair.add(data3);
        unconnectivepair.add(data4);
        unconnectivepair.add(data5);
        unconnectivepair.add(data6);
        unconnectivepair.add(data7);
        unconnectivepair.add(data8);
        unconnectivepair.add(data9);
        unconnectivepair.add(data10);
        unconnectivepair.add(data11);
        unconnectivepair.add(data12);
        unconnectivepair.add(data13);
        unconnectivepair.add(data14);


        addContentView(init7, params);
        addContentView(init8, params);
        addContentView(init9, params);
        addContentView(init10, params);
        addContentView(init11, params);
        addContentView(init12, params);

        MyImageView init13 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 5, display.getHeight() / 7 * 3, 0, "12");
        MyImageView init14 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 4, display.getHeight() / 7 * 4, 0, "13");
        MyImageView init15 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 6, display.getHeight() / 7 * 4, 0, "14");
        MyImageView init16 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 4 + 20, display.getHeight() / 7 * 5, 0, "15");
        MyImageView init17 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 6 + 20, display.getHeight() / 7 * 5, 0, "16");
        MyImageView init18 = new MyImageView(this, R.drawable.gray, R.drawable.eyesclose, display.getWidth() / 7 * 5 + 20, display.getHeight() / 7 * 6, 0, "17");
        crowds.addPerson(init13.getViewId());
        crowds.addPerson(init14.getViewId());
        crowds.addPerson(init15.getViewId());
        crowds.addPerson(init16.getViewId());
        crowds.addPerson(init17.getViewId());
        crowds.addPerson(init18.getViewId());

        MyImageView[] data15 = {init13, init14};
        MyImageView[] data16 = {init13, init15};
        MyImageView[] data17 = {init13, init16};
        MyImageView[] data18 = {init13, init17};
        MyImageView[] data19 = {init13, init18};
        MyImageView[] data20 = {init14, init15};
        MyImageView[] data21 = {init14, init16};
        MyImageView[] data22 = {init14, init17};
        MyImageView[] data23 = {init14, init18};
        MyImageView[] data24 = {init15, init16};
        MyImageView[] data25 = {init15, init17};
        MyImageView[] data26 = {init15, init18};
        MyImageView[] data27 = {init16, init17};
        MyImageView[] data28 = {init16, init18};
        MyImageView[] data29 = {init17, init18};

        crowds.connect(init13.getViewId(), init14.getViewId());
        crowds.connect(init13.getViewId(), init15.getViewId());
        crowds.connect(init13.getViewId(), init16.getViewId());
        crowds.connect(init13.getViewId(), init17.getViewId());
        crowds.connect(init13.getViewId(), init18.getViewId());
        crowds.connect(init14.getViewId(), init15.getViewId());
        crowds.connect(init14.getViewId(), init16.getViewId());
        crowds.connect(init14.getViewId(), init17.getViewId());
        crowds.connect(init14.getViewId(), init18.getViewId());
        crowds.connect(init15.getViewId(), init16.getViewId());
        crowds.connect(init15.getViewId(), init17.getViewId());
        crowds.connect(init15.getViewId(), init18.getViewId());
        crowds.connect(init16.getViewId(), init17.getViewId());
        crowds.connect(init16.getViewId(), init18.getViewId());
        crowds.connect(init17.getViewId(), init18.getViewId());

        unconnectivepair.add(data15);
        unconnectivepair.add(data16);
        unconnectivepair.add(data17);
        unconnectivepair.add(data18);
        unconnectivepair.add(data19);
        unconnectivepair.add(data20);
        unconnectivepair.add(data21);
        unconnectivepair.add(data22);
        unconnectivepair.add(data23);
        unconnectivepair.add(data24);
        unconnectivepair.add(data25);
        unconnectivepair.add(data26);
        unconnectivepair.add(data27);
        unconnectivepair.add(data28);
        unconnectivepair.add(data29);

        addContentView(init13, params);
        addContentView(init14, params);
        addContentView(init15, params);
        addContentView(init16, params);
        addContentView(init17, params);
        addContentView(init18, params);

        ListForImageView.add(init1);
        ListForImageView.add(init2);
        ListForImageView.add(init3);
        ListForImageView.add(init4);
        ListForImageView.add(init5);
        ListForImageView.add(init6);
        ListForImageView.add(init7);
        ListForImageView.add(init8);
        ListForImageView.add(init9);
        ListForImageView.add(init10);
        ListForImageView.add(init11);
        ListForImageView.add(init12);
        ListForImageView.add(init13);
        ListForImageView.add(init14);
        ListForImageView.add(init15);
        ListForImageView.add(init16);
        ListForImageView.add(init17);
        ListForImageView.add(init18);

        drawLine = findViewById(R.id.DrawLine);
        getDrawLine().setImageView(ListForImageView);
        getStickline().setUncuttable_pair(unconnectivepair);
        initView();
        restart.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 1; i < ListForImageView.size(); i++) {
                    ListForImageView.get(i).getImage().updatefrontImageView(R.drawable.eyesclose);
                    ListForImageView.get(i).getImage().updatebackImageView(R.drawable.gray);
                    ListForImageView.get(i).setPercentage(0);

                }

                Intent intent = new Intent(mcontext, Level3.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void initView() {
        simulation = getStart();
        restart = getReset();
        //TODO look
        simulation.setPosition(200, 200);
        restart.setX(simulation.getX());
        restart.setY(simulation.getY() + 50);
        simulation.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("buttonstart", "in");
                HashMap<String, String> map = crowds.simulation();
                while (map.size() != 0) {
                    flag = true;
                    Log.v("buttonstart", "whileloop" + map.size());
                    Collection<String> list = map.values();
                    for (MyImageView my : ListForImageView) {
                        for (String s : list) {
                            if (my.getViewId().equals(s)) {
                                my.getImage().updatebackImageView(R.drawable.peepsblue);
                                my.getImage().updatefrontImageView(R.drawable.simle);
                            }
                        }
                    }
                    map = Crowds.simulation();
                }
                for (MyImageView my : ListForImageView) {
                    if (my.getImage().getBack() == R.drawable.gray) {
                        Log.v("Finished", flag.toString());
                        flag = false;
                        break;
                    }
                }

                Log.v("Finished1", flag.toString());
                if (flag) {
                    Log.v("Finished2", flag.toString());
                    Toast.makeText(mcontext, "well done", Toast.LENGTH_LONG).show();
                } else {
                    Log.v("Finished2", flag.toString());
                    Toast.makeText(mcontext, "Keep working!", Toast.LENGTH_LONG).show();
                }


            }
        });
    }


}
