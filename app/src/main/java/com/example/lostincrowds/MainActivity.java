package com.example.lostincrowds;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lostincrowds.UI.AutoImageView;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String LoginMessage = intent.getStringExtra("MessageFromLogin");
        String Level = intent.getStringExtra("LevelFromLogin");
        Toast.makeText(this , LoginMessage + " Level:" + Level , Toast.LENGTH_LONG).show();
        ImageView bkg = new AutoImageView(this);
        Glide.with(this).load(R.drawable.particles).into((ImageView) findViewById(R.id.imageView));

        setupWindowAnimations();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations () {
        Fade slide = new Fade();
        slide.setDuration(2000);
        getWindow().setEnterTransition(slide);
    }

}
