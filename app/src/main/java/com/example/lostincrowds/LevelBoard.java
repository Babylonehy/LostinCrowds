/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: LevelBoard.java@author: jack@date: 18/05/19 1:46 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lostincrowds.Network.Board;
import com.example.lostincrowds.Network.KvPair;
import com.example.lostincrowds.UI.BoardItem;

import net.frakbot.jumpingbeans.JumpingBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Level board.
 */
public class LevelBoard extends AppCompatActivity {
    /**
     * The User.
     */
    Board user;
    /**
     * The List.
     */
    ArrayList<KvPair> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private HashMap<Integer, KvPair> boards = new HashMap<>();
    private BoardItem boardItem1;
    private BoardItem boardItem2;
    private BoardItem boardItem3;
    private BoardItem boardItem4;
    private BoardItem boardItem5;
    private TextView textView;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        init_windows();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        boardItem1=findViewById(R.id.boardItem1);
        boardItem2=findViewById(R.id.boardItem2);
        boardItem3=findViewById(R.id.boardItem3);
        boardItem4=findViewById(R.id.boardItem4);
        boardItem5=findViewById(R.id.boardItem5);
        boardItem1.update("",0);
        boardItem2.update("",0);
        boardItem3.update("",0);
        boardItem4.update("",0);
        boardItem5.update("",0);
        textView=findViewById(R.id.textView2);
        JumpingBeans jumpingBeans1 = JumpingBeans.with(textView)
                .makeTextJump(0 , textView.getText().length())
                .setIsWave(true)
                .setLoopDuration(5000)
                .build();
        try {
            getBoard();
            Listener(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Glide.with(this).load(R.drawable.levelboard).into((ImageView) findViewById(R.id.bkggif));

    }

    private void  updateBoard(ArrayList<KvPair> list){
        Log.v("UpdateBoard",list.toString());
        if (list.size()==5){
            boardItem1.update(list.get(0).getKey().toString(),Integer.valueOf(list.get(0).getValue().toString()));
            boardItem2.update(list.get(1).getKey().toString(),Integer.valueOf(list.get(1).getValue().toString()));
            boardItem3.update(list.get(2).getKey().toString(),Integer.valueOf(list.get(2).getValue().toString()));
            boardItem4.update(list.get(3).getKey().toString(),Integer.valueOf(list.get(3).getValue().toString()));
            boardItem5.update(list.get(4).getKey().toString(),Integer.valueOf(list.get(4).getValue().toString()));

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
                            if (boards.size()==0)continue;
                            Log.v("Listener/board" , String.valueOf(boards.size()));
                            for (int i = 0; i < boards.size(); i++) {
                                Log.v("update/board" , String.valueOf(i));
                                list.add(boards.get(i));
                            }
                            Message msg = new Message();
                            msg.what= 1;
                            handler.sendMessage(msg);
                            Log.v("Listener/board" , String.valueOf(list.size()));
                        }

                        break;
                    }
                }
            }
        }).start();


    }

    /**
     * Init windows.
     */
    protected void init_windows () {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                updateBoard(list);
            }
        }
    };

}
