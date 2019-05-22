package com.example.lostincrowds.Network;


import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

import static com.example.lostincrowds.ConstantValue.MessageInitial;
import static com.example.lostincrowds.ConstantValue.levelInitial;
import static com.example.lostincrowds.ConstantValue.successInitial;

/**
 * The type User.
 */
public abstract class User {
    /**
     * The Param map.
     */
    HashMap<String, String> paramMap = new HashMap<String, String>();
    /**
     * The Params.
     */
    RequestParams params = null;
    /**
     * The Level.
     */
    int level = levelInitial;
    /**
     * The Success.
     */
    String success = successInitial;
    /**
     * The Message.
     */
    String message = MessageInitial;
    /**
     * The Jonhttpresponsehandler.
     */
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

    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel () {
        return level;
    }

    /**
     * Gets success.
     *
     * @return the success
     */
    public String getSuccess () {
        return success;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage () {
        return message;
    }

    /**
     * Run.
     *
     * @throws IOException the io exception
     */
    public void run () throws IOException {

    }
}
