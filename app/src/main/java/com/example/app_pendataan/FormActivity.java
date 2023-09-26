package com.example.app_pendataan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    EditText inpName, inpAddress, inpCity, inpAge, inpOccupation, inpSalary;
    RadioGroup rbStatus;
    RadioButton rbMarried, rbSingle;
    Button btnView, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        setContentView(R.layout.activity_form);
        inpName = findViewById(R.id.inp_name);
        inpAddress = findViewById(R.id.inp_address);
        inpCity = findViewById(R.id.inp_city);
        inpAge = findViewById(R.id.inp_age);
        inpOccupation = findViewById(R.id.inp_occupation);
        inpSalary = findViewById(R.id.inp_salary);
        rbStatus = findViewById(R.id.rb_status);
        rbMarried = findViewById(R.id.rb_married);
        rbSingle = findViewById(R.id.rb_single);
        btnView = findViewById(R.id.btn_view);
        btnClear = findViewById(R.id.btn_clear);


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inpName.getText().toString();
                String address = inpAddress.getText().toString();
                String city = inpCity.getText().toString();
                String age = inpAge.getText().toString();
                String occupation = inpOccupation.getText().toString();
                String salary = inpSalary.getText().toString();
                String status = rbMarried.isChecked() ? "Married" : "Single";

                if(name.isEmpty() || address.isEmpty() || city.isEmpty() || age.isEmpty() || occupation.isEmpty() || salary.isEmpty() || status.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Data must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(FormActivity.this, ViewActivity.class);
                intent.putExtra("nama", name);
                intent.putExtra("alamat", address);
                intent.putExtra("kota", city);
                intent.putExtra("usia", age);
                intent.putExtra("pekerjaan", occupation);
                intent.putExtra("gaji", salary);
                intent.putExtra("status", status);
                startActivity(intent);

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inpName.setText("");
                inpAddress.setText("");
                inpCity.setText("");
                inpAge.setText("");
                inpOccupation.setText("");
                inpSalary.setText("");
                rbStatus.clearCheck();
            }
        });
    }
}
