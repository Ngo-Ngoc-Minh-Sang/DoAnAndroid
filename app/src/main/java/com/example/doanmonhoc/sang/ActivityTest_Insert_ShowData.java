package com.example.doanmonhoc.sang;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmonhoc.R;

import java.util.List;

public class ActivityTest_Insert_ShowData extends AppCompatActivity {

    Button buttonInsert, buttonShow;
    ThuChiDAO thuChiDAO;
    Context context;
    List<String> list;
    ListView lv;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_insert_show_data);

        buttonInsert = (Button) findViewById(R.id.button4);
        buttonShow = (Button) findViewById(R.id.button5);
        lv = (ListView) findViewById(R.id.lvData);
        context = this;
        thuChiDAO = new ThuChiDAO(context);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThuChiModel thuChi = new ThuChiModel(1, 2, 2000, 3, 4, 5, "2023-05-19", "Mua sữa chua" );
                int kq = thuChiDAO.insertThu(thuChi);
                if(kq == 1)
                    Toast.makeText(ActivityTest_Insert_ShowData.this, "Thành công", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(ActivityTest_Insert_ShowData.this, "Thất bại", Toast.LENGTH_LONG).show();
            }
        });
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list = thuChiDAO.getALlGiaoDichToString();
                adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                lv.setAdapter(adapter);
            }
        });
    }
}