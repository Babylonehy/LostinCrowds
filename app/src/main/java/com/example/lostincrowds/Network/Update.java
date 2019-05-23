package com.example.lostincrowds.Network;

import android.util.Log;

import com.loopj.android.http.RequestParams;

import java.io.IOException;

/**
 * The type Update.
 */
public class Update extends User {

    /**
     * The Update.
     */
    final public String UPDATE = "update.php?";

    /**
     * Instantiates a new Update.
     *
     * @param username  the username
     * @param passwords the passwords
     * @param level     the level
     */
    public Update ( String username , String passwords , String level ) {
        this.paramMap.put("name" , username);
        this.paramMap.put("passwords" , passwords);
        this.paramMap.put("level" , level);
        this.params = new RequestParams(paramMap);
    }

    public void run () throws IOException {

        HttpClinet.get(UPDATE , params , jonhttpresponsehandler);
        Log.v("UpdateLEVEL", "1");


    }


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
