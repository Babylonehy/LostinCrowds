package com.example.lostincrowds.Network;

import com.loopj.android.http.RequestParams;

import java.io.IOException;

/**
 * The type Login.
 */
public class Login extends User {

    /**
     * The Login.
     */
    final public String LOGIN = "login.php?";

    /**
     * Instantiates a new Login.
     *
     * @param username  the username
     * @param passwords the passwords
     */
    public Login ( String username , String passwords ) {
        System.out.println(username);
        this.paramMap.put("name" , username);
        this.paramMap.put("passwords" , passwords);
        this.params = new RequestParams(paramMap);

    }

    public void run () throws IOException {

        HttpClinet.get(LOGIN , params , jonhttpresponsehandler);

    }

}
