package com.example.sampleapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{
    SharedPreferences sharedPreferences;
    TextView mobile, passsword;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mobile= (TextView)findViewById(R.id.tv_mobile);
        passsword=(TextView)findViewById(R.id.tv_password);

        //Installation Method
        sharedPreferences =  getApplicationContext().getSharedPreferences("RamanaPref", MODE_PRIVATE);

        mobile.setText(sharedPreferences.getString("key_mobile",null));
        passsword.setText(sharedPreferences.getString("key_password",null));






    }
}
