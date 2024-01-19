package com.example.quanlybansach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    TextView tvCaf, tvSed, tvEmpl, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        tvCaf= findViewById(R.id.tvCafe);
        tvSed=findViewById(R.id.tvSeed);
        tvEmpl=findViewById(R.id.tvEmployee);

        tvCaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainPage.this, CafePage.class);
                startActivity(intent);
            }
        });

        tvSed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainPage.this, SeedPage.class);
                startActivity(intent);
            }
        });

        tvEmpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainPage.this, EmployPage.class);
                startActivity(intent);
            }
        });

//        tvTotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(MainPage.this, SellPage.class);
//                startActivity(intent);
//            }
//        });
    }
}