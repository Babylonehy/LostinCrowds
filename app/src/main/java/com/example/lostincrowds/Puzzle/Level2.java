/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Level2.java@author: jack@date: 22/05/19 3:59 PM@version: 1.0
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
 * The type Level 2.
 */
public class Level2 extends BasicActivity {
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
    private String id = "2";
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
//        super.init_windows();
        super.onCreate(savedInstanceState);
        try {
            Level2.super.update(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,Level3.class);

                finish();
                startActivity(intent);
            }
        });
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT ,
                WIDTH);

        LineTextView lineTextView = getLineTextView();
        lineTextView.animateText("Draw connections within and between groups to spread wisdom to the whole world.");
        lineTextView.setX(10);
        lineTextView.setY(10);
        mcontext=getApplicationContext();
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.bkg);
        this.getWindow().setBackgroundDrawable(drawable);
        display = getWindowManager().getDefaultDisplay();
        MyImageView init1 = new MyImageView(this , R.drawable.peepsred , R.drawable.eyessmile , display.getWidth() / 14 , display.getHeight() / 16 , 0 , "0");
        MyImageView init2 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/ 14 * 3 , display.getHeight() / 16 * 3 , 0 , "1");
        crowds.addInfector(init1.getViewId());
        crowds.addPerson(init2.getViewId());
        addContentView(init1,params);
        addContentView(init2,params);

        MyImageView[] data={init1,init2};
        unconnectivepair.add(data);
        crowds.connect(init1.getViewId(),init2.getViewId());



        MyImageView init3 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 2 , display.getHeight() / 16 * 9 , 0 , "2");
        MyImageView init4 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 4 , display.getHeight() / 16 * 7 , 0 , "3");
        MyImageView init5 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 4 , display.getHeight() / 16 * 11 , 0 , "4");
        crowds.addPerson(init3.getViewId());
        crowds.addPerson(init4.getViewId());
        crowds.addPerson(init5.getViewId());
        addContentView(init3, params);
        addContentView(init4, params);
        addContentView(init5, params);

        MyImageView[] data1={init3, init4};
        MyImageView[] data2={init3, init5};
        MyImageView[] data3={init4, init5};

        unconnectivepair.add(data1);
        unconnectivepair.add(data2);
        unconnectivepair.add(data3);

        crowds.connect(init3.getViewId(), init4.getViewId());
        crowds.connect(init3.getViewId(), init5.getViewId());
        crowds.connect(init4.getViewId(), init5.getViewId());



        MyImageView init6 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 7 , display.getHeight() / 14 * 2 , 0 , "5");
        MyImageView init7 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 5 , display.getHeight() / 14 * 4 , 0 , "6");
        MyImageView init8 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 9 , display.getHeight() / 14 * 4 , 0 , "7");
        MyImageView init9 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 6 , display.getHeight() / 14 * 6 , 0 , "8");
        MyImageView init10 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 8 , display.getHeight() / 14 * 6 , 0 , "9");
        crowds.addPerson(init6.getViewId());
        crowds.addPerson(init7.getViewId());
        crowds.addPerson(init8.getViewId());
        crowds.addPerson(init9.getViewId());
        crowds.addPerson(init10.getViewId());
        addContentView(init6, params);
        addContentView(init7, params);
        addContentView(init8, params);
        addContentView(init9, params);
        addContentView(init10, params);

        MyImageView[] data4={init6, init7};
        MyImageView[] data5={init6, init8};
        MyImageView[] data6={init6, init9};
        MyImageView[] data7={init6, init10};
        MyImageView[] data8={init7, init8};
        MyImageView[] data9={init7, init9};
        MyImageView[] data10={init7, init10};
        MyImageView[] data11={init8, init9};
        MyImageView[] data12={init8, init10};
        MyImageView[] data13={init9, init10};


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


        crowds.connect(init6.getViewId(), init7.getViewId());
        crowds.connect(init6.getViewId(), init8.getViewId());
        crowds.connect(init6.getViewId(), init9.getViewId());
        crowds.connect(init6.getViewId(), init10.getViewId());
        crowds.connect(init7.getViewId(), init8.getViewId());
        crowds.connect(init7.getViewId(), init9.getViewId());
        crowds.connect(init7.getViewId(), init10.getViewId());
        crowds.connect(init8.getViewId(), init9.getViewId());
        crowds.connect(init8.getViewId(), init10.getViewId());
        crowds.connect(init9.getViewId(), init10.getViewId());


        MyImageView init11 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 10 , display.getHeight() / 7 * 3 , 0 , "10");
        MyImageView init12 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 8 , display.getHeight() / 7 * 4 , 0 , "11");
        MyImageView init13 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 12 , display.getHeight() / 7 * 4 , 0 , "12");
        MyImageView init14 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 9 , display.getHeight() / 7 * 5 , 0 , "13");
        MyImageView init15 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth() / 14 * 11 , display.getHeight() / 7 * 5 , 0 , "14");
        crowds.addPerson(init11.getViewId());
        crowds.addPerson(init12.getViewId());
        crowds.addPerson(init13.getViewId());
        crowds.addPerson(init14.getViewId());
        crowds.addPerson(init15.getViewId());
        addContentView(init11, params);
        addContentView(init12, params);
        addContentView(init13, params);
        addContentView(init14, params);
        addContentView(init15, params);

        MyImageView[] data14={init11, init12};
        MyImageView[] data15={init11, init13};
        MyImageView[] data16={init11, init14};
        MyImageView[] data17={init11, init15};
        MyImageView[] data18={init12, init13};
        MyImageView[] data19={init12, init14};
        MyImageView[] data20={init12, init15};
        MyImageView[] data21={init13, init14};
        MyImageView[] data22={init13, init15};
        MyImageView[] data23={init14, init15};


        unconnectivepair.add(data14);
        unconnectivepair.add(data15);
        unconnectivepair.add(data16);
        unconnectivepair.add(data17);
        unconnectivepair.add(data18);
        unconnectivepair.add(data19);
        unconnectivepair.add(data20);
        unconnectivepair.add(data21);
        unconnectivepair.add(data22);
        unconnectivepair.add(data23);


        crowds.connect(init11.getViewId(), init12.getViewId());
        crowds.connect(init11.getViewId(), init13.getViewId());
        crowds.connect(init11.getViewId(), init14.getViewId());
        crowds.connect(init11.getViewId(), init15.getViewId());
        crowds.connect(init12.getViewId(), init13.getViewId());
        crowds.connect(init12.getViewId(), init14.getViewId());
        crowds.connect(init12.getViewId(), init15.getViewId());
        crowds.connect(init13.getViewId(), init14.getViewId());
        crowds.connect(init13.getViewId(), init15.getViewId());
        crowds.connect(init14.getViewId(), init15.getViewId());



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

        drawLine=findViewById(R.id.DrawLine);
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

                Intent intent = new Intent(mcontext, Level2.class);
                finish();
                startActivity(intent);
            }
        });
    }

    private void initView() {
        simulation = getStart();
        restart = getReset();
        simulation.setPosition(50, 50);
        restart.setX(simulation.getX());
        restart.setY(simulation.getY() + 100);

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
                                my.getImage().updatebackImageView(R.drawable.peepsred);
                                my.getImage().updatefrontImageView(R.drawable.eyessmile);
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

