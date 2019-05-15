package com.example.lostincrowds.Network;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class RemeberUser extends Activity {
    private String username;
    private String passwords;
    private String level;

    public RemeberUser ( Context context , String username , String passwords ) {
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo" , context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("account" , username);
        editor.putString("password" , passwords);
        editor.commit();
    }
}
