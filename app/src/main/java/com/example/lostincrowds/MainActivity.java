package com.example.lostincrowds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lostincrowds.Network.Login;
import com.example.lostincrowds.Network.Signin;
import com.example.lostincrowds.Network.Update;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        String LoginMessage=intent.getStringExtra("MessageFromLogin");
        String Level=intent.getStringExtra("LevelFromLogin");
        Toast.makeText(this,LoginMessage+" Level:"+Level,Toast.LENGTH_LONG).show();
        Glide.with(this).load(R.drawable.particles);
    }

    private void login() throws JSONException, IOException {
        Login test=new Login("test1","123");
        test.run();
    }
    private void update() throws JSONException, IOException {
        Update test=new Update("test1","123","5");
        test.run();
    }
    private void signin() throws JSONException, IOException {
        Signin test=new Signin("test5","123");
        test.run();
    }
}
