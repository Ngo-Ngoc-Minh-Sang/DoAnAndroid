package com.example.doanmonhoc;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Other extends AppCompatActivity {

    TextView txtName;
    Button btn_sua, dmk, logout;
    Toolbar toolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_other);

        linkView();
        actionBar();
        String name = this.getIntent().getStringExtra("name");
        txtName.setText(name);
        eventButton();
    }

    private void eventButton() {
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Other.this, Profile.class);
                startActivity(intent);
            }
        });
        dmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Other.this, DoiMatKhau.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(Other.this)
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn đăng xuất ?")
                        .setPositiveButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // add login ui to intent change to MainActivity
                                Intent intent = new Intent(Other.this, MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });
    }

    private void actionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void linkView() {
        btn_sua = (Button) findViewById(R.id.btn_sua);
        txtName = (TextView) findViewById(R.id.txt_name);
        dmk = (Button) findViewById(R.id.doimk);
        toolbar = (Toolbar) findViewById(R.id.toolBarOther);
        logout = (Button) findViewById(R.id.logout);
    }
}