package com.example.lostincrowds.Network;

import com.loopj.android.http.RequestParams;

import java.io.IOException;

/**
 * The type Signin.
 */
public class Signin extends User {


    /**
     * The Signin.
     */
    final public String SIGNIN = "signin.php?";


    /**
     * Instantiates a new Signin.
     *
     * @param username  the username
     * @param passwords the passwords
     */
    public Signin ( String username , String passwords ) {
        this.paramMap.put("name" , username);
        this.paramMap.put("passwords" , passwords);
        this.params = new RequestParams(paramMap);
    }

    public void run () throws IOException {
        HttpClinet.get(SIGNIN , params , jonhttpresponsehandler);
    }


    public String getSuccess () {
        return success;
    }

    public String getMessage () {
        return message;
    }
}
