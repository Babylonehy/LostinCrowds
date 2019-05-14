package com.example.lostincrowds;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lostincrowds.Music.Music;
import com.example.lostincrowds.Network.Login;
import com.example.lostincrowds.Network.Signin;
import com.example.lostincrowds.Network.User;
import com.example.lostincrowds.UI.AutoImageView;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.youth.template.LoginTemplateView;

import net.frakbot.jumpingbeans.JumpingBeans;

import org.json.JSONException;

import java.io.IOException;


public class LoginActivity extends AppCompatActivity {
    static Login user;
    static Signin new_user;
    LoginTemplateView view;
    Music music;
    Display display;
    SoundPool mSoundPool;

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        view = new LoginTemplateView(this);
        AutoImageView imageView = new AutoImageView(this);
        setContentView(view);
        Log.v("Music" , "onCreate: streamID = ");
        mSoundPool = new SoundPool(1 , AudioManager.STREAM_MUSIC , 0);
        int streamID = mSoundPool.load(this , R.raw.party , 1);
        Log.v("Music" , "onCreate: streamID = " + streamID + "" + mSoundPool);
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete ( SoundPool soundPool , int sampleId , int status ) {
                soundPool.play(sampleId , 50 , 50 , 1 , 0 , 1);
            }
        });

        display = getWindowManager().getDefaultDisplay();
//        ImageView imageView=new ImageView(this);
//        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        imageView.setAdjustViewBounds(true);
//        addContentView(imageView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,  LinearLayout.LayoutParams.WRAP_CONTENT));
        Glide.with(this).load(R.drawable.particlesresize).into(imageView);

        //添加文本,this代表当前项目
        TextView textView1 = new TextView(this);
        textView1.setText("Lost In Crowds");
        Typeface typeface = getResources().getFont(R.font.patrickhandregular);
        textView1.setTypeface(typeface);
        textView1.setTextColor(Color.DKGRAY);
        textView1.setTextSize(24);
        textView1.setX((float) (display.getWidth() / 2.8));
        textView1.setY((float) (display.getHeight() / 2.5));

        JumpingBeans jumpingBeans1 = JumpingBeans.with(textView1)
                .makeTextJump(0 , textView1.getText().length())
                .setIsWave(true)
                .setLoopDuration(5000)
                .build();
        view.addView(textView1);

        setting();
        //设置点击事件
        view.setLoginListener(new LoginTemplateView.LoginListener() {
            @Override
            public void login ( View v ) {

                try {
                    userlogin();
                    Listener(user);
                    NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(LoginActivity.this);
                    dialogBuilder
                            .withMessage("Verify username and password......")
                            .withDialogColor("#87CEFA")
                            .show();

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        view.setRegisterListener(new LoginTemplateView.RegisterListener() {
            @Override
            public void register ( View v ) {
                try {
                    registernew();
                    Listener(new_user);
                    NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(LoginActivity.this);
                    dialogBuilder
                            .withMessage("Under registration......")
                            .withDialogColor("#87CEFA")
                            .show();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        setupWindowAnimations();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations () {
        Slide slide = new Slide();
        slide.setDuration(2000);
        getWindow().setExitTransition(slide);
    }


    private void Listener ( final User tempuser ) {

        new Thread(new Runnable() {
            @Override
            public void run () {
                while (true) {
                    System.out.println("listener--");
                    if (!tempuser.getSuccess().equals(ConstantValue.successInitial)) {
                        Log.v("Listener" , tempuser.getSuccess().equals("1") ? "T" : "F");
                        if (tempuser.getSuccess().equals(ConstantValue.successGet)) {
                            Log.v("Listener" , "getsuccess = 1");
                            Intent intent = new Intent();
                            String level = Integer.toString(tempuser.getLevel());
                            //TODO Jump to the corresponding page (Simple switch case)
                            intent.setClass(LoginActivity.this , MainActivity.class);
                            String Message = "MessageFromLogin";
                            String LevelMessage = "LevelFromLogin";
                            intent.putExtra(Message , tempuser.getMessage());
                            intent.putExtra(LevelMessage , level);
                            startActivity(intent);
                            LoginActivity.this.finish();
                        }
                        break;
                    }
                }
                Looper.prepare();
                Toast.makeText(LoginActivity.this , tempuser.getMessage() , Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }).start();


    }

    private void registernew () throws Exception {
        if (!view.getLoginName().equals(""))
            new_user = new Signin(view.getLoginName() , view.getLoginPassword());
        new_user.run();
    }


    @SuppressLint("ResourceType")
    private void setting () {
        view.setForgotButtonText("");
        view.setLoginBackgroundResource(R.drawable.bkg);
        view.setLoginNameHint("UserName");
        view.setLoginNameBackground(R.color.btn_press_color);
        view.setLoginPasswordHint("Passwords");
        view.setLoginPasswordBackground(R.color.btn_press_color);
        view.setLoginButtonText("Login");
        view.setLoginButtonTextColor(Color.DKGRAY);
        view.setLoginButtonBackground(R.drawable.button);
        view.setLoginLogo(R.drawable.simle);

    }

    private void userlogin () throws Exception {
        user = new Login(view.getLoginName() , view.getLoginPassword());
        user.run();
        Log.v("Login" , user.getSuccess());

    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        mSoundPool.release();
        mSoundPool = null;
    }

}
