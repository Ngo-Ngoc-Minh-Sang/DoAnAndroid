package com.example.doanmonhoc.sang;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmonhoc.DAO.DanhMucDAO;
import com.example.doanmonhoc.DAO.ThuChiDAO;
import com.example.doanmonhoc.R;
import com.example.doanmonhoc.model.DanhMucModel;
import com.example.doanmonhoc.model.ThuChiModel;

import java.util.List;

public class ActivityTest_Insert_ShowData extends AppCompatActivity {

    Button buttonInsert, buttonShow, buttonDelete, buttonUpdate;
    ThuChiDAO thuChiDAO;
//    NguoiDungDAO ngDungDAO;
//    HinhAnhGhiChuDAO anhNoteDAO;
    //DanhMucDAO danhMucDAO;
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
        buttonDelete = (Button) findViewById(R.id.button6);
        buttonUpdate = (Button) findViewById(R.id.button7);
        lv = (ListView) findViewById(R.id.lvData);
        context = this;
       thuChiDAO = new ThuChiDAO(context);
//        ngDungDAO = new NguoiDungDAO(context);
//        anhNoteDAO = new HinhAnhGhiChuDAO(context);
  //      danhMucDAO = new DanhMucDAO(context);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ThuChiModel thuChi = new ThuChiModel(2, 1, 3000, 3, 4, "2023-05-21", "Lương" );
//                NguoiDungModel ngDung = new NguoiDungModel(1, 2002, 200000, "Ngô Ngọc Minh Sang", "0946885098", "avatar.png", "ngos810@gmail.com", "sang123", "Nữ");
//                HinhAnhGhiChuModel anhNote = new HinhAnhGhiChuModel(1, 1, "anhNote.png");
//                DanhMucModel danhMuc = new DanhMucModel(1, "Ăn uống", "icon.png");

               int kq = thuChiDAO.insertThuChi(thuChi);
//                int kq = ngDungDAO.insertNguoiDung(ngDung);
//                int kq = anhNoteDAO.insertHinhAnhNote(anhNote);
  //              int kq = danhMucDAO.insertDanhMuc(danhMuc);
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
//                list = ngDungDAO.getALlNguoiDungToString();
//                list = anhNoteDAO.getALlHinhAnhNoteToString();
    //            list = danhMucDAO.getALlDanhMucToString();
                adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                lv.setAdapter(adapter);
            }
        });
    }
}