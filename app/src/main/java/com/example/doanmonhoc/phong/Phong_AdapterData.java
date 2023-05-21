package com.example.doanmonhoc.phong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.doanmonhoc.R;

import java.util.ArrayList;

public class Phong_AdapterData extends ArrayAdapter {
    Context context;
    ArrayList<Phong_ItemData> arrayList;
    int layout;

    public Phong_AdapterData(@NonNull Context context, int resource, ArrayList<Phong_ItemData> arrayList) {
        super(context, resource, arrayList);
        this.context = context;
        this.arrayList = arrayList;
        this.layout = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Phong_ItemData itemFlag = arrayList.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
        }
        TextView txtDate = (TextView) convertView.findViewById(R.id.txtDate);
        txtDate.setText(itemFlag.getDate());
        //ImageView imgV = (ImageView) convertView.findViewById(R.id.imgV);
        TextView txtGhiChu = (TextView) convertView.findViewById(R.id.txtGhiChu);
        txtGhiChu.setText(itemFlag.getGhiChu());
        TextView txtTienGiaoDich = (TextView) convertView.findViewById(R.id.txtTienGiaoDich);
        //imgV.setImageResource(itemFlag.getImg());
       // txtTienGiaoDich.setText(itemFlag.getTienGiaoDich());


        return convertView;
    }

}
