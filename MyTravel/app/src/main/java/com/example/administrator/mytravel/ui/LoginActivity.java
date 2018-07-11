package com.example.administrator.mytravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mytravel.R;
import com.example.administrator.mytravel.util.SPUtils;


public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);


        mPasswordView = (EditText) findViewById(R.id.password);


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        Button mEmailRegisterButton = (Button) findViewById(R.id.email_register_button);
        mEmailRegisterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (email.equals(SPUtils.get(this, "email", "111")) && password.equals(SPUtils.get(this, "password", "111"))) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            mEmailView.setText("");
            mPasswordView.setText("");
            Toast.makeText(this, "登入成功，開始你的旅遊計畫吧！", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "登入失敗，請註冊帳號！", Toast.LENGTH_LONG).show();
            mEmailView.setText("");
            mPasswordView.setText("");
        }
    }

    private void attemptRegister() {
       Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}