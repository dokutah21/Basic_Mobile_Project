package com.example.quanlybansach;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CafePage extends AppCompatActivity {

    DatabaseHelper databasehelper;

    TextView tvCafeID, tvCafeName;
    Button btnAdd, btnUpdate, btnDelete, btnSearching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_page);

        databasehelper = new DatabaseHelper(this);

        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnSearching = findViewById(R.id.btnSearch);

        tvCafeID = findViewById(R.id.edtCafeID);
        tvCafeName = findViewById(R.id.edtCafeName);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper.insert(tvCafeID.getText().toString(), tvCafeName.getText().toString());
                clear();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper.delete(tvCafeID.getText().toString());
                clear();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper.update(tvCafeID.getText().toString(), tvCafeName.getText().toString());
                clear();
            }
        });

        btnSearching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvCafeName.setText(databasehelper.search(tvCafeID.getText().toString()));
            }
        });
    }

    void clear(){
        tvCafeID.setText("");
        tvCafeName.setText("");
    }
}