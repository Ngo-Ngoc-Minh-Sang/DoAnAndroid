package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Locale;

public class LaiNganHang extends AppCompatActivity {

    EditText etPrincipal, etRate;
    Spinner spTerm;
    TextView tvInterest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lai_ngan_hang);

        etPrincipal = findViewById(R.id.et_principal);
        etRate = findViewById(R.id.et_rate);
        spTerm = findViewById(R.id.sp_term);
        tvInterest = findViewById(R.id.tv_interest);

        Button btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double principal = Double.parseDouble(etPrincipal.getText().toString());
                double rate = Double.parseDouble(etRate.getText().toString());
                int term = Integer.parseInt(spTerm.getSelectedItem().toString());

                //principal : số tiền vay
                //rate : lãi suất hàng năm
                //term : số năm kì hạn

                double interest = principal * rate * term / 100;
                DecimalFormat df = new DecimalFormat("#.##");
                tvInterest.setText(df.format(interest));


                tvInterest.setText(String.format(Locale.US, "%.2f", interest));
            }
        });
    }
}