package com.example.lostincrowds.Network;
import com.loopj.android.http.*;

public class HttpClinet {

    private static final String BASE_URL = "http://52.163.84.2/api/lostincrowds/";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String action,RequestParams params, AsyncHttpResponseHandler responseHandler) {
        System.out.println(BASE_URL+action+params);
        client.get(BASE_URL+action, params, responseHandler);
    }


}
