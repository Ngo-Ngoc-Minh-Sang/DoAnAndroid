package com.example.doanmonhoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.doanmonhoc.DAO.NguoiDungDAO;

public class MainActivityThongTin extends AppCompatActivity {
    NguoiDungDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_thong_tin);
        nguoiDungDAO = new NguoiDungDAO(this);
    }
}