package com.example.lostincrowds.Network;

public class DBmanager {
    private String username;
    private String passwords;
    private String GET_url;
    private int level=0;


    public DBmanager ( String username , String passwords , int level ) {
        this.username = username;
        this.passwords = passwords;
        this.level = level;
        this.GET_url="?name="+username+"&passwords="+passwords+"&level="+level;
    }

    public DBmanager ( String username , String passwords ) {
        this.username = username;
        this.passwords = passwords;
        this.GET_url="?name="+username+"&passwords="+passwords;
    }

    public String getGET_url () {
        return GET_url;
    }
    public String getUsername () {
        return username;
    }

    public String getPasswords () {
        return passwords;
    }

    public int getLevel () {
        return level;
    }


}
