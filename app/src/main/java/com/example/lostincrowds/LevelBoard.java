/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: LevelBoard.java@author: jack@date: 18/05/19 1:46 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.lostincrowds.Network.Board;
import com.example.lostincrowds.Network.KvPair;
import com.example.lostincrowds.UI.MyAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LevelBoard extends AppCompatActivity {
    Board user;
    ArrayList<KvPair> list = new ArrayList<>();
    private ListView listView;
    private HashMap<Integer, KvPair> boards = new HashMap<>();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        listView = findViewById(R.id.listboard);
        listView.setAdapter(new MyAdapter(LevelBoard.this , View.NO_ID , list));

        try {
            getBoard();
            Listener(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getBoard () throws IOException {
        user = new Board();
        user.run();
    }

    private void Listener ( final Board tempuser ) {

        new Thread(new Runnable() {
            @Override
            public void run () {
                while (true) {

                    System.out.println("listener--");
                    if (!tempuser.getSuccess().equals(ConstantValue.successInitial)) {
                        Log.v("Listener" , tempuser.getSuccess().equals("1") ? "T" : "F");
                        if (tempuser.getSuccess().equals(ConstantValue.successGet)) {
                            Log.v("Listener/board" , "getsuccess = 1");
                            boards = tempuser.getBoards();
                            for (int i = 0; i < boards.size(); i++) {
                                list.add(boards.get(i));
                            }
                            Log.v("Listener/board" , String.valueOf(list.size()));
                        }
                        break;
                    }
                }
            }
        }).start();


    }
}
