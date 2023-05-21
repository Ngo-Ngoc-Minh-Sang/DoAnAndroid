package com.example.doanmonhoc;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.doanmonhoc.sang.Phong_LichSuActivity;

public class FragmentTongQuan extends Fragment {

    Button btnLichSu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tong_quan, container, false);

        btnLichSu = view.findViewById(R.id.btnLichSu);
        btnLichSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext().getApplicationContext(), Phong_LichSuActivity.class));
            }
        });
        return view;
    }

}