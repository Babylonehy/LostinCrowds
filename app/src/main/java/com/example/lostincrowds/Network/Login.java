package com.example.lostincrowds.Network;
import org.json.*;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class Login extends HttpClinet {
    private HashMap<String, String> paramMap = new HashMap<String, String>();
    private RequestParams params =null;
    int level =-1;
    String success = null;
    String message = null;

    final public String LOGIN="login.php?";

    public Login ( String username, String passwords) throws IOException {
        System.out.println(username);
        this.paramMap.put("name",username);
        this.paramMap.put("passwords",passwords);
        this.params= new RequestParams(paramMap);
    }


    public void run () throws JSONException{
        HttpClinet.get(LOGIN,params,jonhttpresponsehandler);

    }
    private JsonHttpResponseHandler jonhttpresponsehandler = new JsonHttpResponseHandler(){
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject responses) {
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
    public int getLevel () {
        return level;
    }

    public String getSuccess () {
        return success;
    }

    public String getMessage () {
        return message;
    }


}
