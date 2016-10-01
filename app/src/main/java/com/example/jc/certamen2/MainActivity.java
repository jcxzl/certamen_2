package com.example.jc.certamen2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usuario1 = (EditText) findViewById(R.id.usuario);
    }

    public void searchUser(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        // get EditText by id
        EditText usuario1 = (EditText) findViewById(R.id.usuario);
        String usuario = usuario1.toString();
        String url1 = "https://api.github.com/users/" + usuario + "/repos";
        url1 = MakeConnection(url1);

        List<repo> lista_repo = new ArrayList<>();
        JSONObject object = new JSONObject(json);
        JSONArray json_array = object.optJSONArray();

        if (json_array.getString("message") == "User is not found"){
            Toast toast = Toast.makeText(savedInstanceState, "No existe el usuario ingresado", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            for (int i = 0; i < json_array.length(); i++) {
                lista_repo.add(new repo(json_array.getJSONObject(i)));
            }
            setContentView(R.layout.git_display);

        }
    }

    public String MakeConnection (String url1){
        URL url = null;
        try {
            url = new URL(url1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setDoInput(true);

        try {
            conn.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            int response = conn.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = conn.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String contentAsString = null;
        try {
            contentAsString = readIt(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentAsString;
    }
    public String readIt(InputStream stream) throws IOException, UnsupportedEncodingException{
        Reader reader = null;
        StringBuilder inputStringBuilder = new StringBuilder();
        reader = new InputStreamReader(stream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while(line != null){
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        return
                inputStringBuilder.toString();
    }
}