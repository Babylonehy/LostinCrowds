/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Level1.java@author: jack@date: 18/05/19 1:45 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Puzzle;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

public class Level1 extends BasicActivity {
    //Todo puzzle 1
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.init_windows();
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void fabsetting () {

    }
}
