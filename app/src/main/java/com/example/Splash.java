package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.login.activity.LoginActivity;
import com.example.form.ListActivity;
import com.example.R;

public class Splash extends AppCompatActivity {

    private int waktu_loading=3000;

    //3000=3 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home=new Intent(Splash.this, LoginActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}