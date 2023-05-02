package com.example.doanmonhoc;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentBaoCao extends Fragment {

    Button btnPTThuNhap, btnPTChiTieu,btnTaiChinh,btnPTTaiChinh;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bao_cao, container, false);

        btnPTThuNhap = view.findViewById(R.id.btnPTThuNhap);
        btnPTTaiChinh = view.findViewById(R.id.btnPTTaiChinh);
        btnPTChiTieu = view.findViewById(R.id.btnPTChiTieu);

        btnPTThuNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext().getApplicationContext(), ThuNhapActivity.class));
            }
        });

        btnPTTaiChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext().getApplicationContext(),PTTaiChinhActivity.class));
            }
        });

        btnPTChiTieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext().getApplicationContext(),PTChiTieuActivity.class));
            }
        });

        return view;
    }
}