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


public class RegisterActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView,mUserName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Set up the login form.
        mUserName = (EditText) findViewById(R.id.username);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);


        Button mEmailRegisterButton = (Button) findViewById(R.id.email_register_button);
        mEmailRegisterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

    }



    private void attemptRegister() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        if (!email.isEmpty() && !password.isEmpty()) {

            SPUtils.put(this, "username", mUserName.getText().toString().trim());
            SPUtils.put(this, "email", email.trim());
            SPUtils.put(this, "password", password.trim());
            Toast.makeText(this, "註冊成功，請登入", Toast.LENGTH_LONG).show();
            mEmailView.setText("");
            mPasswordView.setText("");
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "帳號密碼不能為空白！", Toast.LENGTH_LONG).show();
        }

    }
}