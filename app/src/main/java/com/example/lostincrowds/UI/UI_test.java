package com.example.lostincrowds.UI;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.lostincrowds.R;

import java.util.ArrayList;

public class UI_test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去除状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.activity_ui_test);
        addContentView(new DrawLine(this , null) , new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT , LinearLayout.LayoutParams.FILL_PARENT));

        @SuppressLint("ResourceType")
        BasicImageView basicImageView2 = new BasicImageView(this , R.drawable.gray , R.drawable.eyesclose , 700 , 900 , 1);
        basicImageView2.setBasicImageView(R.drawable.peepsblue , R.drawable.eyesclose);
        addContentView(basicImageView2.setBasicImageView(R.drawable.peepsred , R.drawable.eyesclose) , basicImageView2.getLayoutParams());

//        ArrayList<BasicImageView> imagesList=new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            imagesList.add(new BasicImageView(this,R.drawable.gray , R.drawable.eyesclose,i*100,i*100,i));
//        }
//        for (int i = 0; i < imagesList.size(); i++) {
//            addContentView(imagesList.get(i).getImageView(),imagesList.get(i).getLayoutParams());
//            Log.v("BasicImage:",imagesList.get(i).getXpos()+" "+imagesList.get(i).getYpos());
//        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        MyImageView testview = new MyImageView(this , R.drawable.peepsgreen , R.drawable.eyesclose , 0 , 50 , 50);
        addContentView(testview , new LinearLayout.LayoutParams(150 , 150));
    }

}
