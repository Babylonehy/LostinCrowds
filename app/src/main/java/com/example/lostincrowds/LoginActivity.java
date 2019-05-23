package com.example.lostincrowds;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lostincrowds.Network.Login;
import com.example.lostincrowds.Network.Signin;
import com.example.lostincrowds.Network.User;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.youth.template.LoginTemplateView;

import net.frakbot.jumpingbeans.JumpingBeans;

import org.json.JSONException;

import java.io.IOException;

import static com.example.lostincrowds.ConstantValue.Passwords;
import static com.example.lostincrowds.ConstantValue.Username;


/**
 * The type Login activity.
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * The User.
     */
    static Login user;
    /**
     * The New user.
     */
    static Signin new_user;
    /**
     * The View.
     */
    LoginTemplateView view;
    /**
     * The Display.
     */
    Display display;
    /**
     * The User info.
     */
    SharedPreferences userInfo;
    /**
     * The Mp.
     */
    MediaPlayer mp;
    private  int level;
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        userInfo = getSharedPreferences("userInfo" , Context.MODE_PRIVATE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        view = new LoginTemplateView(this);
        setContentView(view);
        Log.v("Music" , "onCreate: streamID = ");


        //add text
        display = getWindowManager().getDefaultDisplay();
        TextView textView1 = new TextView(this);
        textView1.setText("Lost In Crowds");
        Typeface typeface = getResources().getFont(R.font.patrickhandregular);
        textView1.setTypeface(typeface);
        textView1.setTextColor(Color.DKGRAY);
        textView1.setTextSize(24);
        textView1.setX((float) (display.getWidth() / 3.0));
        textView1.setY((float) (display.getHeight() / 4.0));

        JumpingBeans jumpingBeans1 = JumpingBeans.with(textView1)
                .makeTextJump(0 , textView1.getText().length())
                .setIsWave(true)
                .setLoopDuration(5000)
                .build();
        view.addView(textView1);

        setting();
        //setting onclick
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
        view.setForgotListener(new LoginTemplateView.ForgotListener() {
            @Override
            public void forgot ( View v ) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this , MenuActivity.class);
                mp.release();
                intent.putExtra("Level",level);
                startActivity(intent);

            }
        });

        //music
        mp = MediaPlayer.create(this , R.raw.bg_music);
        mp.setLooping(true);
        mp.start();
        Once();
    }

    private void Once () {
        //  Declare a new thread to do a preference check
        Thread t = new Thread(new Runnable() {
            @Override
            public void run () {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart" , true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    final Intent i = new Intent(LoginActivity.this , MenuActivity.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run () {
                            startActivity(i);
                        }
                    });

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart" , false);

                    //  Apply changes
                    e.apply();
                }
            }
        });

        // Start the thread
        t.start();
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
                            Username = view.getLoginName();
                            Passwords = view.getLoginPassword();
                            int level = (int) (tempuser.getLevel());
                            //TODO Jump to the corresponding page (Simple switch case)
                            intent.setClass(LoginActivity.this , MenuActivity.class);
                            String Message = "MessageFromLogin";
                            String LevelMessage = "LevelFromLogin";
                            intent.putExtra(Message , tempuser.getMessage());
                            intent.putExtra(LevelMessage , level);
                            mp.release();

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
        String UserName = userInfo.getString("account" , "UserName");
        view.setLoginBackgroundResource(R.drawable.bkg);
        view.setLoginNameHint(UserName);
        view.setLoginNameBackground(R.color.btn_press_color);
        view.setLoginPasswordHint("Passwords");
        view.setForgotButtonText("Skip Registration");
        view.setLoginPasswordBackground(R.color.btn_press_color);
        view.setRegisterButtonText("Regist");
        view.setLoginButtonText("Login");
        view.setLoginButtonTextColor(Color.DKGRAY);
        view.setLoginButtonBackground(R.drawable.button);
        view.setLoginLogo(R.drawable.simle);

    }

    private void userlogin () throws Exception {

        user = new Login(view.getLoginName() , view.getLoginPassword());
        user.run();
        RemeberUser(view.getLoginName() , view.getLoginPassword());
        Log.v("Login" , user.getSuccess());

    }

    private void RemeberUser ( String username , String passwords ) {
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("account" , username);
        editor.putString("password" , passwords);
        editor.commit();
    }
    private boolean mIsExit;

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mIsExit) {
                this.finish();

            } else {
                Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
                mIsExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
