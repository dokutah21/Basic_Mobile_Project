package com.example.quanlybansach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SeedPage extends AppCompatActivity {
    DatabaseHelper databasehelper;

    TextView tvSeedID, tvSeedName;
    Button btnAddSeed, btnUpdateSeed, btnDeleteSeed, btnSearchingSeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_page);

        databasehelper = new DatabaseHelper(this);

        btnAddSeed = findViewById(R.id.btnAddSeed);
        btnUpdateSeed = findViewById(R.id.btnUpdateSeed);
        btnDeleteSeed = findViewById(R.id.btnDeleteSeed);
        btnSearchingSeed = findViewById(R.id.btnSearchSeed);

        tvSeedID = findViewById(R.id.edtSeedID);
        tvSeedName = findViewById(R.id.edtSeedName);

        btnAddSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper.insertSeed(tvSeedID.getText().toString(), tvSeedName.getText().toString());
                clear();
            }
        });

        btnDeleteSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper.deleteSeed(tvSeedID.getText().toString());
                clear();
            }
        });

        btnUpdateSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper.updateSeed(tvSeedID.getText().toString(), tvSeedName.getText().toString());
                clear();
            }
        });

        btnSearchingSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSeedName.setText(databasehelper.searchSeed(tvSeedID.getText().toString()));
            }
        });
    }

    void clear(){
        tvSeedID.setText("");
        tvSeedName.setText("");
    }
}