package com.example.quanlybansach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupPage extends AppCompatActivity {
    TextView tvSign;
    EditText edtUsername, edtPassword, edtRepass;
    Button btnSignup;

    DatabaseHelper databasehelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        tvSign= findViewById(R.id.tvLogin);

        tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SignupPage.this, LoginPage.class);
                startActivity(intent);
            }
        });

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtRepass = findViewById(R.id.edtRepass);
        btnSignup = findViewById(R.id.btnSignup);
        databasehelper = new DatabaseHelper(this);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username, Password, Repass;
                Username = edtUsername.getText().toString();
                Password = edtPassword.getText().toString();
                Repass = edtRepass.getText().toString();
                if (Username.equals("") || Password.equals("") || Repass.equals("")){
                    Toast.makeText(SignupPage.this, "Hãy điền đầy đủ thông tin!", Toast.LENGTH_LONG).show();
                }
                else {
                    if (Password.equals(Repass)){
                        if (databasehelper.checkUsername(Username))
                        {
                            Toast.makeText(SignupPage.this, "Người dùng đã tồn tại!", Toast.LENGTH_LONG).show();
                            return;
                        }
                        boolean signupSuccess = databasehelper.insertDataAccount(Username, Password);
                        if (signupSuccess)
                            Toast.makeText(SignupPage.this, "Đăng ký tài khoản thành công!", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SignupPage.this, "Đăng ký tài khoản không thành công!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(SignupPage.this, "Mật khẩu không trùng khớp!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


}