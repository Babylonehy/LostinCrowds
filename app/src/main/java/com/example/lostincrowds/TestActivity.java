package com.example.lostincrowds;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lostincrowds.UI.AutoImageView;
import com.example.lostincrowds.UI.MyImageButton;

public class TestActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
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
//        Glide.with(this).load(R.drawable.particles).into((ImageView) findViewById(R.id.imageView));
        final MyImageButton myImageButton = findViewById(R.id.ImageButton2);

        myImageButton.getImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("IMgae","clickdown");
            }
        });
        setupWindowAnimations();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations () {
        Fade slide = new Fade();
        slide.setDuration(2000);
        getWindow().setEnterTransition(slide);
    }

}
