/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Level3.java@author: jack@date: 18/05/19 4:47 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.example.lostincrowds.R;
import com.example.lostincrowds.UI.MyImageView;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: Xiang Li
 * @Date: $date$ $time$
 */
public class Level3 extends BasicActivity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.init_windows();
        super.onCreate(savedInstanceState);
        MyImageView init1 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init2 = new MyImageView(this , R.drawable.gray , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init3 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init4 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init5 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init6 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init7 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init8 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init9 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init10 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init11 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init12 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init13 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init14 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init15 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init16 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init17 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");
        MyImageView init18 = new MyImageView(this , R.drawable.peepsblue , R.drawable.simle , 500 , 20 , 100 , "1");

    }
}
