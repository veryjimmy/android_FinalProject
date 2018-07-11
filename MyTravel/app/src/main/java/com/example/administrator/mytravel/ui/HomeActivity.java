package com.example.administrator.mytravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mytravel.R;


public class HomeActivity extends AppCompatActivity {
    private static int Splash_times_out=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent Mainintent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(Mainintent);
                finish();
            }
        },Splash_times_out);
    }
}
