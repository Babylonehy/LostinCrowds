/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: Board.java@author: jack@date: 17/05/19 11:52 PM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds.Network;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import cz.msebera.android.httpclient.Header;

import static com.example.lostincrowds.ConstantValue.successGet;

/**
 * The type Board.
 *
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: Xiang Li
 * @Date: $date$ $time$
 */
public class Board extends User{
    /**
     * The Login.
     */
    final public String LOGIN = "board.php?";



    private HashMap<Integer,KvPair> boards=new HashMap<>();

    /**
     * Instantiates a new Board.
     */
    public Board () {
        this.paramMap.put("board" , "");
        this.params = new RequestParams(paramMap);
    }

    public void run () throws IOException {
        HttpClinet.get(LOGIN , params , jonhttpresponsehandler);
    }


    /**
     * The Jonhttpresponsehandler.
     */
    JsonHttpResponseHandler jonhttpresponsehandler = new JsonHttpResponseHandler() {
        @Override
        public void onSuccess ( int statusCode , Header[] headers , JSONObject responses ) {
            // If the response is JSONObject instead of expected JSONArray
            Log.v("Json" , "Board----");
            try {
                JSONArray jsonArray=new JSONArray();
                success = responses.getString("success");
                if (success.equals(successGet)) {
                    int count=0;
                    for (Iterator<String> it = responses.getJSONObject("board").keys(); it.hasNext(); ) {
                        String key = it.next();
                        boards.put(count,new KvPair<>(key,responses.getJSONObject("board").getString(key)));
                        count+=1;
                    }
                    Log.v("Board", boards.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    };

    /**
     * Gets boards.
     *
     * @return the boards
     */
    public HashMap<Integer, KvPair> getBoards () {
        Log.v("Boards/board" , String.valueOf(boards.size()));
        return boards;
    }
}
