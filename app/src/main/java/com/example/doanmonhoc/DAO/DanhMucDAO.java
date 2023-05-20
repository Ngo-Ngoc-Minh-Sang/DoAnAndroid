package com.example.doanmonhoc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanmonhoc.SQLiteHelper;
import com.example.doanmonhoc.model.DanhMucModel;

import java.util.ArrayList;
import java.util.List;

public class DanhMucDAO {
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;
    private Context context;
    public DanhMucDAO(Context context) {
        this.context = context;
        dbHelper = new SQLiteHelper(context); // Tạo db
        db = dbHelper.getReadableDatabase(); // Cho phép ghi dữ iệu vào db
    }
    public int insertDanhMuc(DanhMucModel danhMuc){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("TenDanhMuc", danhMuc.getTenDanhMuc());
        values.put("Icon", danhMuc.getIcon());

        long kq = db.insert("DanhMuc", null,values);
        if(kq < 0)
            return -1; // Insert Fail
        return 1; // Insert Success
    }

    public List<String> getALlDanhMucToString(){
        List<String> ls = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        Cursor c = db.query("DanhMuc", null, null, null, null, null, null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            DanhMucModel danhMuc = new DanhMucModel();
            danhMuc.setMaDanhMuc(c.getInt(0));
            danhMuc.setTenDanhMuc(c.getString(1));
            danhMuc.setIcon(c.getString(2));

            String strData = danhMuc.getMaDanhMuc() + " - " + danhMuc.getTenDanhMuc() + " - " + danhMuc.getIcon();
            ls.add(strData);
            c.moveToNext();
        }
        c.close();
        return ls;
    }

    // Xóa dữ liệu
    public int deleteDanhMuc(String maDanhMuc){
        int kq = db.delete("DanhMuc", "MaDanhMuc = ?", new String[]{maDanhMuc});
        if(kq <= 0)
            return -1; // Fail
        return 1; // Success
    }

    // Cập nhật
    public int updateDanhMuc(DanhMucModel danhMuc){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("MaDanhMuc", danhMuc.getMaDanhMuc());
        values.put("TenDanhMuc", danhMuc.getTenDanhMuc());
        values.put("Icon", danhMuc.getIcon());
        long kq = db.update("DanhMuc",values,"MaDanhMuc = ?",new String[]{String.valueOf(danhMuc.getMaDanhMuc())});
        if(kq < 0)
            return -1; // Fail
        return 1; // Success
    }
}
