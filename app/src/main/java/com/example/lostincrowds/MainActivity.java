package com.example.lostincrowds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lostincrowds.Network.Login;
import com.example.lostincrowds.Network.Update;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            login();
            update();
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }
    }

    private void login() throws JSONException, IOException {
        Login test=new Login("test1","123");
        test.run();
    }
    private void update() throws JSONException, IOException {
        Update test=new Update("test1","123","5");
        test.run();
    }
}
