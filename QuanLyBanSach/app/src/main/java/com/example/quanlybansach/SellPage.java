//package com.example.quanlybansach;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//public class SellPage extends AppCompatActivity {
//
//    DatabaseHelper databasehelper;
//
//    TextView tvSellTotalID, tvCusName, tvTotalPrice;
//    Button btnAddTotal, btnUpdateTotal, btnDeleteTotal, btnSearchingTotal;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.sell_page);
//
//        databasehelper = new DatabaseHelper(this);
//
//        btnAddTotal = findViewById(R.id.btnAddTotal);
//        btnUpdateTotal = findViewById(R.id.btnUpdateTotal);
//        btnDeleteTotal = findViewById(R.id.btnDeleteTotal);
//        btnSearchingTotal = findViewById(R.id.btnSearchTotal);
//
//        tvSellTotalID = findViewById(R.id.edtTotalID);
//        tvCusName = findViewById(R.id.edtCustomerName);
//        tvTotalPrice=findViewById(R.id.edtTotalPrice);
//
//        btnAddTotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                databasehelper.insertTotal(tvSellTotalID.getText().toString(), tvCusName.getText().toString(), tvTotalPrice.getText().toString());
//                clear();
//            }
//        });
//
//        btnDeleteTotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                databasehelper.deleteTotal(tvSellTotalID.getText().toString());
//                clear();
//            }
//        });
//
//        btnUpdateTotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                databasehelper.updateTotal(tvSellTotalID.getText().toString(), tvCusName.getText().toString(), tvTotalPrice.getText().toString());
//                clear();
//            }
//        });
//
//        btnSearchingTotal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvCusName.setText(databasehelper.searchTotal(tvSellTotalID.getText().toString()));
//                tvTotalPrice.setText("");
//            }
//        });
//    }
//
//    void clear(){
//        tvSellTotalID.setText("");
//        tvCusName.setText("");
//        tvTotalPrice.setText("");
//    }
//}