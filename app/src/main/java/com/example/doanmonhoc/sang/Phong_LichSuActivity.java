package com.example.doanmonhoc.sang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import com.example.doanmonhoc.DAO.ThuChiDAO;
import com.example.doanmonhoc.R;
import com.example.doanmonhoc.SQLiteHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Phong_LichSuActivity extends AppCompatActivity {
    EditText edtstart,edtend;
    int ngay,thang,nam;
    ImageView imgstart,imgend;
    View view;
    CalendarView calendarView;
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;

    Button btnShow,btnChonLich;
    ThuChiDAO thuChiDAO;
    Context context;
    ListView lv;
    List<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_lich_su);

        btnShow = (Button) findViewById(R.id.btnShow);
        btnChonLich=(Button) findViewById(R.id.btn_lich);
        lv = (ListView) findViewById(R.id.list);
        calendarView = (CalendarView)findViewById(R.id.calendarView);

        context = this;
        thuChiDAO = new ThuChiDAO(context);
        Calendar calendar=Calendar.getInstance();
        calendarView.setDate(System.currentTimeMillis());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                    //SQLiteHelper dbHelper = new SQLiteHelper(context);
                    //db = dbHelper.getReadableDatabase();
                    //Cursor c = db.rawQuery(query, null);
                    list = thuChiDAO.getSelectDay(year,month,day);
                    adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                    lv.setAdapter(adapter);
            }
        });


        btnChonLich.setText(calendar.get(Calendar.DAY_OF_MONTH)+ "/" + (calendar.get(Calendar.MONTH)+ 1)+ "/" + calendar.get(Calendar.YEAR));
        btnChonLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(v.getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                btnChonLich.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        },
                        calendar.get(Calendar.DAY_OF_MONTH),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.YEAR)
                );
                dialog.show();

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list = thuChiDAO.getGiaoDichToString();
                adapter = new ArrayAdapter(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list);
                lv.setAdapter(adapter);
            }
        });
    }

}