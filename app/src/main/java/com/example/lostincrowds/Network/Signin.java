package com.example.lostincrowds.Network;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class Signin {

    private HashMap<String, String> paramMap = new HashMap<String, String>();
    final public String SIGNIN="signin.php?";
    private RequestParams params =null;
    String success = null;
    String message = null;

    public Signin ( String username,String passwords) {
        this.paramMap.put("name",username);
        this.paramMap.put("passwords",passwords);
        this.params= new RequestParams(paramMap);
    }

    public void run() throws JSONException {
        HttpClinet.get(SIGNIN,params,jonhttpresponsehandler);
    }
    private JsonHttpResponseHandler jonhttpresponsehandler = new JsonHttpResponseHandler(){
        @Override
        public void onSuccess( int statusCode, Header[] headers, JSONObject responses) {
            // If the response is JSONObject instead of expected JSONArray
            Log.v("Josn","Signin----");
            try {
                success = responses.getString("success");
                message=responses.getString("message");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Do something with the response
            Log.v("Josn",success);

        }

    };
}
