package com.example.lostincrowds;

import android.content.Intent;
import android.graphics.Color;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lostincrowds.Network.ConstantValue;
import com.example.lostincrowds.Network.Login;
import com.example.lostincrowds.Network.Signin;
import com.example.lostincrowds.Network.User;
import com.youth.template.LoginTemplateView;

import org.json.JSONException;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    LoginTemplateView view;
    static Login user;
    static Signin new_user;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        view=new LoginTemplateView(this);
        setContentView(view);
        setting();
        //设置点击事件
        view.setLoginListener(new LoginTemplateView.LoginListener() {
            @Override
            public void login( View v) {

                try {
                    userlogin();
                    Listener(user);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
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
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        });


    }

    private void Listener( final User tempuser ){

        new Thread(new Runnable(){
            @Override
            public void run () {
                while (true) {
                    System.out.println("listener--");
                    if (!tempuser.getSuccess().equals(ConstantValue.successInitial)){
                        Log.v("Listener",tempuser.getSuccess().equals("1") ? "T" : "F");
                        if (tempuser.getSuccess().equals(ConstantValue.successGet)){
                            Log.v("Listener","getsuccess = 1");
                            Intent intent = new Intent();
                            String level=Integer.toString(tempuser.getLevel());
                            intent.setClass(LoginActivity.this, MainActivity.class);
                            String Message="MessageFromLogin";
                            String LevelMessage="LevelFromLogin";
                            intent.putExtra(Message,tempuser.getMessage());
                            intent.putExtra(LevelMessage,level);
                            startActivity(intent);
                            LoginActivity.this.finish();
                        }
                        break;
                    }
                }
                Looper.prepare();
                Toast.makeText(LoginActivity.this,tempuser.getMessage(),Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }).start();


    }
    private void registernew() throws IOException, JSONException {
        new_user=new Signin(view.getLoginName(),view.getLoginPassword());
        new_user.run();

    }


    private void setting(){
        view.setForgotButtonText("");
        view.setLoginButtonBackground(R.drawable.button);
        view.setLoginNameHint("UserName");
        view.setLoginPasswordHint("Passwords");
        view.setLoginButtonText("Login");
        view.setLoginButtonTextColor(Color.parseColor("#26A69A"));
        view.setLoginLogo(R.drawable.simle);
        view.setBackgroundResource(R.drawable.loginbck);
    }

    private void userlogin() throws JSONException, IOException, InterruptedException {
        user=new Login(view.getLoginName(),view.getLoginPassword());
        user.run();
        Log.v("Login",user.getSuccess());

    }

}
