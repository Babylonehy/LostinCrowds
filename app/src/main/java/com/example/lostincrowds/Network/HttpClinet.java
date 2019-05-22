package com.example.lostincrowds.Network;

import com.example.lostincrowds.ConstantValue;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.IOException;

/**
 * The type Http clinet.
 */
public class HttpClinet {

    private static final String BASE_URL = ConstantValue.BASE_URL;
    private static AsyncHttpClient client = new AsyncHttpClient();

    /**
     * Get.
     *
     * @param action          the action
     * @param params          the params
     * @param responseHandler the response handler
     * @throws IOException the io exception
     */
    public static void get ( String action , RequestParams params , AsyncHttpResponseHandler responseHandler ) throws IOException {
        System.out.println(BASE_URL + action + params);
        client.get(BASE_URL + action , params , responseHandler);

    }

}
