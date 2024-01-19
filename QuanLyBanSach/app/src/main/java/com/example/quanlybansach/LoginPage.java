package com.example.quanlybansach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    TextView tvLog;
    EditText edtUsername, edtPassword;
    Button btnLogin;
    DatabaseHelper databasehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        tvLog= findViewById(R.id.tvSignup);

        tvLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginPage.this, SignupPage.class);
                startActivity(intent);
            }
        });

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        databasehelper = new DatabaseHelper(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLoggedID = databasehelper.checkUser(edtUsername.getText().toString(), edtPassword.getText().toString());
                if (isLoggedID){
                    Intent intent = new Intent(LoginPage.this, MainPage.class);
                    startActivity(intent);
                } else
                    Toast.makeText(LoginPage.this, "Đăng nhập thất bại!", Toast.LENGTH_LONG).show();
            }
        });
    }
}