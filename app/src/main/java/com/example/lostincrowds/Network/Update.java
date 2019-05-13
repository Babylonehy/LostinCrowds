package com.example.lostincrowds.Network;

import com.loopj.android.http.RequestParams;

import java.io.IOException;

public class Update extends User {

    final public String UPDATE = "update.php?";

    public Update ( String username , String passwords , String level ) {
        this.paramMap.put("name" , username);
        this.paramMap.put("passwords" , passwords);
        this.paramMap.put("level" , level);
        this.params = new RequestParams(paramMap);
    }

    public void run () throws IOException {

        HttpClinet.get(UPDATE , params , jonhttpresponsehandler);


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
