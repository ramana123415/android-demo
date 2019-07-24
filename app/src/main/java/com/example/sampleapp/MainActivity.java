package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "MyActivity";

    int k = 0;

    public static MainActivity Instance;

    //Declaration
    Button btnStart;
    EditText mobile, password;

    //Declared variable
    String myName = "Test Android";


    //Declaration of sharedpreference

    SharedPreferences sharedPreferences;

    // Activity Life Cycle

    String myMobile, myPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TestClass2 testClass2 = TestClass2.getInstance();


        //Initilization of sharedPreferences
       sharedPreferences =  getApplicationContext().getSharedPreferences("RamanaPref", MODE_PRIVATE);
       final SharedPreferences.Editor editor = sharedPreferences.edit();


       //if the user previously loggedin its goes to next screen
       boolean login =(sharedPreferences.getBoolean("is_logedin",false));
       if (login == true){
           Intent intent= new Intent(MainActivity.this,SecondActivity.class);
           startActivity(intent);
       }

        btnStart = (Button) findViewById(R.id.btn_login);
        mobile = (EditText) findViewById(R.id.et_mobile);
        password = (EditText) findViewById(R.id.et_password);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myMobile = mobile.getText().toString();
                myPassword= password.getText().toString();

                //Inserting data in sharedpreference
                editor.putString("key_mobile", myMobile);
                editor.putString("key_password", myPassword);
                editor.putBoolean("is_logedin",true);
               //save entered data
                editor.commit();


                Intent intent= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);




            }
        });
        Log.e(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

        int k;
        k = 50 + 30;

        Log.d("Additon", "  " + k);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }



    public void displayToast() {
        Toast.makeText(this, "Hello Ramana", Toast.LENGTH_LONG).show();
    }


    public void addNumbers() {
        k = 5 + 20;
    }
}
