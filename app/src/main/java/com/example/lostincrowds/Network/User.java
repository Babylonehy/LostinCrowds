package com.example.lostincrowds.Network;


import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

import static com.example.lostincrowds.Network.ConstantValue.MessageInitial;
import static com.example.lostincrowds.Network.ConstantValue.levelInitial;
import static com.example.lostincrowds.Network.ConstantValue.successInitial;

public abstract class User {
    HashMap<String, String> paramMap = new HashMap<String, String>();
    RequestParams params = null;
    int level = levelInitial;
    String success = successInitial;
    String message = MessageInitial;
    JsonHttpResponseHandler jonhttpresponsehandler = new JsonHttpResponseHandler() {
        @Override
        public void onSuccess ( int statusCode , Header[] headers , JSONObject responses ) {
            // If the response is JSONObject instead of expected JSONArray
            Log.v("Json" , "Update----");
            try {
                success = responses.getString("success");
                message = responses.getString("message");
                if (success.equals("1")) {
                    level = responses.getInt("level");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Do something with the response
            Log.v("Json" , success);

        }

    };

    public int getLevel () {
        return level;
    }

    public String getSuccess () {
        return success;
    }

    public String getMessage () {
        return message;
    }

    public void run () throws JSONException, IOException {

    }
}
