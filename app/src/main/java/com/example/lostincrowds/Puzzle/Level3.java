/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Level3.java@author: jack@date: 18/05/19 4:47 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;
import com.example.lostincrowds.UI.DrawLine;
import com.example.lostincrowds.UI.MyImageView;
import com.example.lostincrowds.UI.Stickline;

import java.util.ArrayList;

import static com.example.lostincrowds.ConstantValue.HEIGHT;
import static com.example.lostincrowds.ConstantValue.WIDTH;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: Xiaorong Ma
 * @Date: $date$ $time$
 */
public class Level3 extends BasicActivity {
    public ArrayList<MyImageView[]> unconnectivepair = new ArrayList<>();
    public ArrayList<MyImageView> ListForImageView = new ArrayList<>();

    public DrawLine drawLine;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.init_windows();
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(HEIGHT ,
                WIDTH);
        display = getWindowManager().getDefaultDisplay();
        MyImageView init1 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , display.getWidth()/7*3 , 20 , 100 , "1");
        MyImageView init2 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*2, display.getHeight()/7 , 0 , "2");
        MyImageView init3 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*4  , display.getHeight()/7 , 0 , "3");
        MyImageView init4 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*2+20 , display.getHeight()/7*2 , 0 , "4");
        MyImageView init5 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*4+20 , display.getHeight()/7*2 , 0 , "5");
        MyImageView init6 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*3+20 , display.getHeight()/7*3 , 0 , "6");

        addContentView(init1,params);
        addContentView(init2,params);
        addContentView(init3,params);
        addContentView(init4,params);
        addContentView(init5,params);
        addContentView(init6,params);

        MyImageView init7 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7 , display.getHeight()/7*3 , 0 , "7");
        MyImageView init8 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 20 , display.getHeight()/7*4 , 0 , "8");
        MyImageView init9 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*2 , display.getHeight()/7*4 , 0 , "9");
        MyImageView init10 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , 20+20 , display.getHeight()/7*5 , 0 , "10");
        MyImageView init11 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*2+20, display.getHeight()/7*5 , 0 , "11");
        MyImageView init12 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7+20, display.getHeight()/7*6 , 0 , "12");

        MyImageView[] data={init7,init8};
        MyImageView[] data1={init7,init9};
        MyImageView[] data2={init7,init10};
        MyImageView[] data3={init7,init11};
        MyImageView[] data4={init7,init12};
        MyImageView[] data5={init8,init9};
        MyImageView[] data6={init8,init10};
        MyImageView[] data7={init8,init11};
        MyImageView[] data8={init8,init12};
        MyImageView[] data9={init9,init10};
        MyImageView[] data10={init9,init11};
        MyImageView[] data11={init9,init12};
        MyImageView[] data12={init10,init11};
        MyImageView[] data13={init10,init12};
        MyImageView[] data14={init11,init12};

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


        addContentView(init7,params);
        addContentView(init8,params);
        addContentView(init9,params);
        addContentView(init10,params);
        addContentView(init11,params);
        addContentView(init12,params);

        MyImageView init13 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*5 , display.getHeight()/7*3 , 0 , "13");
        MyImageView init14 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*4 , display.getHeight()/7*4 , 0 , "14");
        MyImageView init15 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*6 , display.getHeight()/7*4 , 0 , "15");
        MyImageView init16 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*4+20 , display.getHeight()/7*5 , 0 , "16");
        MyImageView init17 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*6+20 , display.getHeight()/7*5 , 0 , "17");
        MyImageView init18 = new MyImageView(this , R.drawable.gray , R.drawable.eyesclose , display.getWidth()/7*5+20 , display.getHeight()/7*6 , 0 , "18");

        MyImageView[] data15={init13,init14};
        MyImageView[] data16={init13,init15};
        MyImageView[] data17={init13,init16};
        MyImageView[] data18={init13,init17};
        MyImageView[] data19={init13,init18};
        MyImageView[] data20={init14,init15};
        MyImageView[] data21={init14,init16};
        MyImageView[] data22={init14,init17};
        MyImageView[] data23={init14,init18};
        MyImageView[] data24={init15,init16};
        MyImageView[] data25={init15,init17};
        MyImageView[] data26={init15,init18};
        MyImageView[] data27={init16,init17};
        MyImageView[] data28={init16,init18};
        MyImageView[] data29={init17,init18};

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

        addContentView(init13,params);
        addContentView(init14,params);
        addContentView(init15,params);
        addContentView(init16,params);
        addContentView(init17,params);
        addContentView(init18,params);

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

        drawLine=findViewById(R.id.DrawLine);
        getDrawLine().setImageView(ListForImageView);
        getStickline().setUncuttable_pair(unconnectivepair);


    }


}
