package com.example.doanmonhoc.sang;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmonhoc.DAO.ThuChiDAO;
import com.example.doanmonhoc.R;
import com.example.doanmonhoc.SQLiteHelper;
import com.example.doanmonhoc.model.DanhMucModel;
import com.example.doanmonhoc.model.ThuChiModel;

import java.util.Calendar;
import java.util.List;

public class Phong_LichSuActivity extends AppCompatActivity {
    int ngay,thang,nam;
    View view;
    CalendarView calendarView;
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;

    Button btnChonLich,btnKhoanThu,btnKhoanChi;
    EditText tongThu,tongChi;
    ThuChiDAO thuChiDAO;
    Context context;
    ListView lv;
    List<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_lich_su);
        tongChi = (EditText)findViewById(R.id.edtTongChi);
        tongThu = (EditText)findViewById(R.id.edtTongThu);
        btnKhoanThu = (Button)findViewById(R.id.btnXemThu);
        btnKhoanChi = (Button)findViewById(R.id.btnXemChi);
        btnChonLich=(Button) findViewById(R.id.btn_lich);
        lv = (ListView) findViewById(R.id.list);
        calendarView = (CalendarView)findViewById(R.id.calendarView);

        context = this;
        thuChiDAO = new ThuChiDAO(context);
        Calendar calendar=Calendar.getInstance();
        calendarView.setDate(System.currentTimeMillis());
        btnChonLich.setText(calendar.get(Calendar.DAY_OF_MONTH)+ "/" + (calendar.get(Calendar.MONTH)+ 1)+ "/" + calendar.get(Calendar.YEAR));


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                    //SQLiteHelper dbHelper = new SQLiteHelper(context);
                    //db = dbHelper.getReadableDatabase();
                    //Cursor c = db.rawQuery(query, null);
                    String getDate = year + "-" + (month + 1) + "-" + day;
                    btnChonLich.setText(getDate);
                    list = thuChiDAO.getSelectDay(year,month,day);
                    adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                    lv.setAdapter(adapter);


                    //Tinh Tong Thu Theo Ngay
                    String queryThu = " select sum(TienGiaoDich) from GiaoDich where PhanLoaiThuChi = 0 and NgayGiaoDich = '"+getDate+"'";
                    dbHelper = new SQLiteHelper(context); // Tạo db
                    db = dbHelper.getReadableDatabase();
                    Cursor c2 = db.rawQuery(queryThu,null);
                    int sumThu = 0;
                    c2.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
                    while(!c2.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
                    {
                        sumThu = c2.getInt(0);
                        tongThu.setText(String.valueOf(sumThu));
                        c2.moveToNext();
                    }
                    c2.close();
                    //Tinh Tong Chi Theo Ngay
                    String queryChi = " select sum(TienGiaoDich) from GiaoDich where PhanLoaiThuChi = 1 and NgayGiaoDich = '"+getDate+"'";
                    dbHelper = new SQLiteHelper(context); // Tạo db
                    db = dbHelper.getReadableDatabase();
                    Cursor c1 = db.rawQuery(queryChi,null);
                    int sumChi = 0;
                    c1.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
                    while(!c1.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
                    {
                        sumChi = c1.getInt(0);
                        tongChi.setText(String.valueOf(sumChi));
                        c1.moveToNext();
                    }
                    c1.close();

            }
        });


        btnKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list = thuChiDAO.getSelectKhoanThu();
                adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                lv.setAdapter(adapter);
                //Tinh Tong Thu
                getTongThu();

            }
        });
        btnKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list = thuChiDAO.getSelectKhoanChi();
                adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                lv.setAdapter(adapter);
                //Tinh tong chi
                getTongChi();
            }
        });
    }

    public void getTongChi(){
        String query = " select sum(TienGiaoDich) from GiaoDich where PhanLoaiThuChi = 1";
        dbHelper = new SQLiteHelper(context); // Tạo db
        db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        int sum = 0;
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            sum = c.getInt(0);
            tongChi.setText(String.valueOf(sum));
            c.moveToNext();
        }
        c.close();
    }

    public void getTongThu(){
        String query = " select sum(TienGiaoDich) from GiaoDich where PhanLoaiThuChi = 0";
        dbHelper = new SQLiteHelper(context); // Tạo db
        db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        int sum = 0;
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            sum = c.getInt(0);
            tongThu.setText(String.valueOf(sum));
            c.moveToNext();
        }
        c.close();
    }

}