package com.example.app_pendataan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {


    ListView lvData;
    Button btnBack;
    ArrayList<String> dataList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        btnBack = findViewById(R.id.btn_back);
        lvData = findViewById(R.id.lv_data);
//
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Intent intent = getIntent();
            String name = intent.getStringExtra("nama");
            String address = intent.getStringExtra("alamat");
            String city = intent.getStringExtra("kota");
            String age = intent.getStringExtra("usia");
            String occupation = intent.getStringExtra("pekerjaan");
            String salary = intent.getStringExtra("gaji");
            String status = intent.getStringExtra("status");

            dataList.add("Name: " + name);
            dataList.add("Address: " + address);
            dataList.add("City: " + city);
            dataList.add("Age: " + age);
            dataList.add("Occupation: " + occupation);
            dataList.add("Salary: " + salary);
            dataList.add("Status: " + status);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.item_text_view, dataList);
        lvData.setAdapter(adapter);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
