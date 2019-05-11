package com.example.lostincrowds.Network;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DBconnect {
    final public String URI_path="http://52.163.84.2/api/lostincrowds/";
    final public String LOGIN="login.php";
    private DBmanager conn;

      public DBconnect (String username,String password) {
        this.conn=new DBmanager(username,password);
    }

    public DBconnect (String username,String password,int level) {
        this.conn=new DBmanager(username,password,level);
    }

    public  String loginByGet(){
        //get的方式提交就是url拼接的方式
        String path = URI_path+LOGIN+conn.getGET_url();
        System.out.println(path);
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            //获得结果码
            int responseCode = connection.getResponseCode();
            if(responseCode ==200){
                //请求成功 获得返回的流
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String rtn=reader.readLine();
                System.out.println(rtn);
                return rtn;
            }else {
                //请求失败
                Log.v("DB","Fail 404.");
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HashMap<String,String> jsonParse ( String reader ) throws JSONException {

        JSONObject jsonObject = null;
//        jsonObject = JSONObject.quote(reader);

        HashMap json=new HashMap<>();
        if (jsonObject.has("level")){
            json.put("level",jsonObject.getInt("level"));
        }
        if (jsonObject.has("success")){
            json.put("success",jsonObject.getInt("success"));
        }
        return json;

    }
    public static void main ( String[] args ) throws JSONException {
          String test="test1";
          String pass="123";
          DBconnect con=new DBconnect(test,pass);
          HashMap json=jsonParse(con.loginByGet());
          System.out.println(json);
    }

}
