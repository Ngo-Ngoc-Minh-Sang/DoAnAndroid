package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivityDat extends AppCompatActivity {
    Button btnbar,btndoitien, btntienlai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dat);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnbar=(Button)findViewById(R.id.btnbar);
        btndoitien=(Button)findViewById(R.id.btndoitien);
        btntienlai=(Button)findViewById(R.id.btntienlai);

        btnbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),bardemo.class));
            }
        });

        btndoitien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DoiTien.class));
            }
        });

        btntienlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LaiNganHang.class));
            }
        });
    }
}