package com.example.doanmonhoc.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanmonhoc.SQLiteHelper;
import com.example.doanmonhoc.model.DanhMucModel;
import com.example.doanmonhoc.model.ThuChiModel;
import com.example.doanmonhoc.phong.Phong_AdapterData;
import com.example.doanmonhoc.phong.Phong_ItemData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThuChiDAO {
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;
    private Context context;
    ArrayList<Phong_ItemData> arrayList;
    public ThuChiDAO(Context context) {
        this.context = context;
        dbHelper = new SQLiteHelper(context); // Tạo db
        db = dbHelper.getReadableDatabase(); // Cho phép ghi dữ iệu vào db
    }

    // Thêm dữ liệu
    public int insertThuChi(ThuChiModel thuChi){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("MaGiaoDich", thuChi.getMaGiaoDich());
        values.put("PhanLoaiThuChi", thuChi.getPhanLoaiThuChi());
        values.put("TienGiaoDich", thuChi.getTienGiaoDich());
        values.put("NgayGiaoDich", thuChi.getNgayGiaoDich());
        values.put("GhiChu", thuChi.getGhiChu());
        values.put("MaNguoiDung", thuChi.getMaNguoiDung());
        values.put("MaDanhMuc", thuChi.getMaDanhMuc());
        long kq = db.insert("GiaoDich", null,values);
        if(kq < 0)
            return -1; // Insert Fail
        return 1; // Insert Success
    }

    // Lấy hết tất cả dữ liệu show ra dạng chuỗi
    public List<String> getALlGiaoDichToString(){
        List<String> ls = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        Cursor c = db.query("GiaoDich",null, null, null, null, null, null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            ThuChiModel thuChi = new ThuChiModel();
            thuChi.setMaGiaoDich(c.getInt(0));
            thuChi.setPhanLoaiThuChi(c.getInt(1));
            thuChi.setTienGiaoDich(c.getInt(2));
            thuChi.setNgayGiaoDich(c.getString(3));
            thuChi.setGhiChu(c.getString(4));
            thuChi.setMaNguoiDung(c.getInt(5));
            thuChi.setMaDanhMuc(c.getInt(6));


            String strData = thuChi.getMaGiaoDich() + " - " + thuChi.getPhanLoaiThuChi() + " - " + thuChi.getTienGiaoDich()
                    + " - " + thuChi.getNgayGiaoDich() + " - " + thuChi.getGhiChu() + " - " + thuChi.getMaNguoiDung()
                    + " - " + + thuChi.getMaDanhMuc();
            ls.add(strData);
            c.moveToNext();
        }
        c.close();
        return ls;
    }

    public List<String> getSelectDay(int year, int month, int day){
        List<String> ls = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        String dateText = year + "-" + (month + 1) + "-" + day;
        String query = "select PhanLoaiThuChi, TienGiaoDich, GhiChu from GiaoDich where NgayGiaoDich = '" + dateText + "' ";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            ThuChiModel thuChi = new ThuChiModel();
            thuChi.setPhanLoaiThuChi(c.getInt(0));
            thuChi.setTienGiaoDich(c.getInt(1));
            thuChi.setGhiChu(c.getString(2));
            // Ghi chú, Tiền GD,


            String strData = "Loại Giao Dịch: " + thuChi.getPhanLoaiThuChi() + "  Ghi chú: " + thuChi.getGhiChu()
                    + "  Tiền: " + thuChi.getTienGiaoDich()+"VNĐ";

            ls.add(strData);
            c.moveToNext();
        }
        c.close();
        return ls;
    }

    public List<String> getSelectKhoanThu(){
        List<String> ls = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        String query = "select NgayGiaoDich , GhiChu,TienGiaoDich from GiaoDich where PhanLoaiThuChi = 0";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            ThuChiModel thuChi = new ThuChiModel();
            thuChi.setNgayGiaoDich(c.getString(0));
            thuChi.setGhiChu(c.getString(1));
            thuChi.setTienGiaoDich(c.getInt(2));

            // Ghi chú, Tiền GD,


            String strData = "Ngày: " +thuChi.getNgayGiaoDich() + "  Ghi chú: " + thuChi.getGhiChu()+ "  Tiền: " + thuChi.getTienGiaoDich()+" VNĐ";

            ls.add(strData);
            c.moveToNext();
        }
        c.close();
        return ls;
    }

    public List<String> getSelectKhoanChi(){
        List<String> ls = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        String query = "select NgayGiaoDich ,GhiChu, TienGiaoDich from GiaoDich where PhanLoaiThuChi = 1";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            ThuChiModel thuChi = new ThuChiModel();
            thuChi.setNgayGiaoDich(c.getString(0));
            thuChi.setGhiChu(c.getString(1));
            thuChi.setTienGiaoDich(c.getInt(2));

            String strData ="Ngày: "+ thuChi.getNgayGiaoDich()+ "  Ghi chú: " + thuChi.getGhiChu()+ "  Tiền: " + thuChi.getTienGiaoDich()+" VNĐ";

            ls.add(strData);
            c.moveToNext();
        }
        c.close();
        return ls;
    }


    // Xóa dữ liệu
    public int deleteThuChi(String maGiaoDich){
        int kq = db.delete("GiaoDich", "MaGiaoDich = ?", new String[]{maGiaoDich});
        if(kq <= 0)
            return -1; // Fail
        return 1; // Success
    }

    // Cập nhật
    public int updateThuChi(ThuChiModel thuChi){
        ContentValues values = new ContentValues(); // Tạo đối tượng chứa dữ liệu
        // Đưa dữ liệu vào đối tượng chứa
        values.put("MaGiaoDich", thuChi.getMaGiaoDich());
        values.put("PhanLoaiThuChi", thuChi.getPhanLoaiThuChi());
        values.put("TienGiaoDich", thuChi.getTienGiaoDich());
        values.put("NgayGiaoDich", thuChi.getNgayGiaoDich());
        values.put("GhiChu", thuChi.getGhiChu());
        values.put("MaNguoiDung", thuChi.getMaNguoiDung());
        values.put("MaDanhMuc", thuChi.getMaDanhMuc());
        long kq = db.update("GiaoDich",values,"MaGiaoDich = ?",new String[]{String.valueOf(thuChi.getMaGiaoDich())});
        if(kq < 0)
            return -1; // Fail
        return 1; // Success
    }
    public ArrayList<ThuChiModel> getAllGiaoDich(){
        ArrayList<ThuChiModel> data = new ArrayList<>();
        // Tạo con trỏ để đọc dữ liệu
        String query = "select MaGiaoDich, PhanLoaiThuChi, TienGiaoDich, NgayGiaoDich, GhiChu, MaDanhMuc from GiaoDich";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst(); // Đặt con trỏ ở bản ghi đầu tiên trong bảng
        while(!c.isAfterLast()) //Nếu nó không phải dòng cuối cùng thì cứ tiếp tục đọc
        {
            ThuChiModel thuChi = new ThuChiModel();
            thuChi.setMaGiaoDich(c.getInt(0));
            thuChi.setPhanLoaiThuChi(c.getInt(1));
            thuChi.setTienGiaoDich(c.getInt(2));
            thuChi.setNgayGiaoDich(c.getString(3));
            thuChi.setGhiChu(c.getString(4));
            thuChi.setMaDanhMuc(c.getInt(5));


           data.add(thuChi);
            c.moveToNext();
        }
        c.close();
        return data;
    }
    public ArrayList<ThuChiModel> getTransactionsByMonth( int month) {
        ArrayList<ThuChiModel> transactions = new ArrayList<>();


        String monthStr = String.format("%02d", month);


        String query = "SELECT * FROM GiaoDich WHERE  strftime('%m', NgayGiaoDich) = '"+monthStr+"'";

        Cursor c = db.rawQuery(query, null);
        try{
        while (c.moveToNext()) {
            ThuChiModel thuChi = new ThuChiModel();
            thuChi.setMaGiaoDich(c.getInt(0));
            thuChi.setPhanLoaiThuChi(c.getInt(1));
            thuChi.setTienGiaoDich(c.getInt(2));
            thuChi.setNgayGiaoDich(c.getString(3));
            thuChi.setGhiChu(c.getString(4));
            thuChi.setMaDanhMuc(c.getInt(5));

            transactions.add(thuChi);
        }
        }catch (Exception e) {
            // Xử lý ngoại lệ
        } finally {
            if (c != null) {
                c.close();
            }

        }
        return transactions;
    }
    public ArrayList<ThuChiModel> getTransactionsByOption(String startDateString, String endDateString) {
        ArrayList<ThuChiModel> gd = new ArrayList<>();

        String query = "SELECT * FROM GiaoDich WHERE NgayGiaoDich BETWEEN '" + startDateString + "' AND '" + endDateString + "'";

        Cursor c = db.rawQuery(query, null);
        try{
            while (c.moveToNext()) {
                ThuChiModel thuChi = new ThuChiModel();
                thuChi.setMaGiaoDich(c.getInt(0));
                thuChi.setPhanLoaiThuChi(c.getInt(1));
                thuChi.setTienGiaoDich(c.getInt(2));
                thuChi.setNgayGiaoDich(c.getString(3));
                thuChi.setGhiChu(c.getString(4));
                thuChi.setMaDanhMuc(c.getInt(5));


                gd.add(thuChi);
            }
        }catch (Exception e) {
            // Xử lý ngoại lệ
        } finally {
            if (c != null) {
                c.close();
            }

        }
        return gd;
    }

}
