package com.example.quanlybansach;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmployPage extends AppCompatActivity {

    DatabaseHelper databaseHelper;

    TextView tvEmplID, tvEmplName;
    Button btnAddEmpl, btnUpdateEmpl, btnDeleteEmpl, btnSearchingEmpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employ_page);

        databaseHelper = new DatabaseHelper(this);

        btnAddEmpl = findViewById(R.id.btnAddEmpl);
        btnUpdateEmpl = findViewById(R.id.btnUpdateEmpl);
        btnDeleteEmpl = findViewById(R.id.btnDeleteEmpl);
        btnSearchingEmpl = findViewById(R.id.btnSearchEmpl);

        tvEmplID = findViewById(R.id.edtEmplID);
        tvEmplName = findViewById(R.id.edtEmplName);

        btnAddEmpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.insertEmpl(tvEmplID.getText().toString(), tvEmplName.getText().toString());
                clear();

                showAlertDialogueUpdateEmpl();
            }
        });

        btnDeleteEmpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteEmpl(tvEmplID.getText().toString());
                clear();
            }
        });

        btnUpdateEmpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.updateEmpl(tvEmplID.getText().toString(), tvEmplName.getText().toString());
                clear();
            }
        });

        btnSearchingEmpl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvEmplName.setText(databaseHelper.searchEmpl(tvEmplID.getText().toString()));
            }
        });
    }

    void clear(){
        tvEmplID.setText("");
        tvEmplName.setText("");
    }

    private void showAlertDialogueUpdateEmpl(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Bạn muốn sửa sản phẩm này?");

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EmployPage.this, "Đã sửa", Toast.LENGTH_SHORT);
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(EmployPage.this, "Thoát", Toast.LENGTH_SHORT);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}