package com.example.doanmonhoc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanmonhoc.SQLiteHelper;
import com.example.doanmonhoc.model.NguoiDungModel;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungDAO {
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;
    private Context context;

    public NguoiDungDAO(Context context) {
        this.context = context;
        dbHelper = new SQLiteHelper(context); // Tạo db
        db = dbHelper.getReadableDatabase(); // Cho phép ghi dữ iệu vào db
    }

    public int insertNguoiDung(NguoiDungModel ngDung){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("HoTen", ngDung.getHoTen());
        values.put("SDT", ngDung.getSdt());
        values.put("Avatar", ngDung.getAvatar());
        values.put("NamSinh", ngDung.getNamSinh());
        values.put("SoDu", ngDung.getSoDu());
        values.put("GioiTinh", ngDung.getGioiTinh());
        values.put("Email", ngDung.getEmail());
        values.put("MatKhau", ngDung.getMatKhau());
        long kq = db.insert("NguoiDung", null,values);
        if(kq < 0)
            return -1; // Insert Fail
        return 1; // Insert Success
    }

    public List<String> getALlNguoiDungToString(){
        List<String> ls = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        Cursor c = db.query("NguoiDung", null, null, null, null, null, null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            NguoiDungModel ngDung = new NguoiDungModel();
            ngDung.setMaNguoiDung(c.getInt(0));
            ngDung.setHoTen(c.getString(1));
            ngDung.setSdt(c.getString(2));
            ngDung.setAvatar(c.getString(3));
            ngDung.setNamSinh(c.getInt(4));
            ngDung.setSoDu(c.getInt(5));
            ngDung.setGioiTinh(c.getString(6));
            ngDung.setEmail(c.getString(7));
            ngDung.setMatKhau(c.getString(8));
            String strData = ngDung.getMaNguoiDung() + " - " + ngDung.getHoTen() + " - " + ngDung.getSdt()
                    + " - " + ngDung.getAvatar() + " - " + ngDung.getNamSinh() + " - " + ngDung.getSoDu()
                    + " - " + ngDung.getGioiTinh() + " - " + ngDung.getEmail() + " - " + ngDung.getMatKhau();
            ls.add(strData);
            c.moveToNext();
        }
        c.close();
        return ls;
    }
    // Xóa dữ liệu
    public int deleteNguoiDung(String maNguoiDung){
        int kq = db.delete("NguoiDung", "MaNguoiDung = ?", new String[]{maNguoiDung});
        if(kq <= 0)
            return -1; // Fail
        return 1; // Success
    }

    // Cập nhật
    public int updateNguoiDung(NguoiDungModel ngDung){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("MaNguoiDung", ngDung.getMaNguoiDung());
        values.put("HoTen", ngDung.getHoTen());
        values.put("SDT", ngDung.getSdt());
        values.put("Avatar", ngDung.getAvatar());
        values.put("NamSinh", ngDung.getNamSinh());
        values.put("SoDu", ngDung.getSoDu());
        values.put("GioiTinh", ngDung.getGioiTinh());
        values.put("Email", ngDung.getEmail());
        values.put("MatKhau", ngDung.getMatKhau());
        long kq = db.update("NguoiDung",values,"MaNguoiDung = ?",new String[]{String.valueOf(ngDung.getMaNguoiDung())});
        if(kq < 0)
            return -1; // Fail
        return 1; // Success
    }
}
