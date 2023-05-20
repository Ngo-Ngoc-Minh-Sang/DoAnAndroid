package com.example.doanmonhoc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanmonhoc.SQLiteHelper;
import com.example.doanmonhoc.model.HinhAnhGhiChuModel;

import java.util.ArrayList;
import java.util.List;

public class HinhAnhGhiChuDAO {
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;
    private Context context;
    public HinhAnhGhiChuDAO(Context context) {
        this.context = context;
        dbHelper = new SQLiteHelper(context); // Tạo db
        db = dbHelper.getReadableDatabase(); // Cho phép ghi dữ iệu vào db
    }
    public int insertHinhAnhNote(HinhAnhGhiChuModel anh){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("IMG", anh.getImg());
        values.put("MaGiaoDich", anh.getMaGiaoDich());

        long kq = db.insert("HinhAnhGhiChu", null,values);
        if(kq < 0)
            return -1; // Insert Fail
        return 1; // Insert Success
    }

    public List<String> getALlHinhAnhNoteToString(){
        List<String> ls = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        Cursor c = db.query("HinhAnhGhiChu", null, null, null, null, null, null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            HinhAnhGhiChuModel anh = new HinhAnhGhiChuModel();
            anh.setMaAnh(c.getInt(0));
            anh.setImg(c.getString(1));
            anh.setMaGiaoDich(c.getInt(2));

            String strData = anh.getMaAnh() + " - " + anh.getImg() + " - " + anh.getMaGiaoDich();
            ls.add(strData);
            c.moveToNext();
        }
        c.close();
        return ls;
    }
    // Xóa dữ liệu
    public int deleteHinhAnhNote(String maAnh){
        int kq = db.delete("HinhAnhGhiChu", "MaAnh = ?", new String[]{maAnh});
        if(kq <= 0)
            return -1; // Fail
        return 1; // Success
    }

    // Cập nhật
    public int updateHinhAnhNote(HinhAnhGhiChuModel anhNote){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("MaAnh", anhNote.getMaAnh());
        values.put("IMG", anhNote.getImg());
        values.put("MaGiaoDich", anhNote.getMaGiaoDich());
        long kq = db.update("HinhAnhGhiChu",values,"MaAnh = ?",new String[]{String.valueOf(anhNote.getMaAnh())});
        if(kq < 0)
            return -1; // Fail
        return 1; // Success
    }
}
