package com.example.lostincrowds.Network;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class Update {
    private HashMap<String, String> paramMap = new HashMap<String, String>();
    final public String LOGIN="update.php?";
    private RequestParams params =null;
    int level =-1;
    String success = null;
    String message = null;

    public Update ( String username,String passwords, String level) {
        this.paramMap.put("name",username);
        this.paramMap.put("passwords",passwords);
        this.paramMap.put("level",level);
        this.params= new RequestParams(paramMap);
    }

    public void run() throws JSONException {

        HttpClinet.get(LOGIN,params,jonhttpresponsehandler);

    }
    private JsonHttpResponseHandler jonhttpresponsehandler = new JsonHttpResponseHandler(){
        @Override
        public void onSuccess( int statusCode, Header[] headers, JSONObject responses) {
            // If the response is JSONObject instead of expected JSONArray
            Log.v("Josn","Start----");
            try {
                success = responses.getString("success");
                message=responses.getString("message");
                level=responses.getInt("level");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            // Do something with the response
            Log.v("Josn",success);

        }

    };
}
