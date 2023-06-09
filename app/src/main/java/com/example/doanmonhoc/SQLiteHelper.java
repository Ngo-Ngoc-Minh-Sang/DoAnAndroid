package com.example.doanmonhoc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    // Lệnh tạo bảng Người Dùng
    public static final String CREATE_TABLE_NguoiDung = "CREATE TABLE NguoiDung(" +
            "MaNguoiDung INTEGER PRIMARY KEY AUTOINCREMENT," +
            "HoTen TEXT," +
            "SDT TEXT," +
            "Avatar TEXT," +
            "NamSinh INT," +
            "SoDu INTEGER," +
            "GioiTinh TEXT," +
            "Email TEXT," +
            "MatKhau TEXT)";
    // Lệnh tạo bảng Danh Mục
    public static final String CREATE_TABLE_DanhMuc = "CREATE TABLE DanhMuc(" +
            "MaDanhMuc INTEGER PRIMARY KEY AUTOINCREMENT," +
            "TenDanhMuc TEXT," +
            "Icon TEXT)";
    // Lệnh tạo bảng Giao Dịch
    public static final String CREATE_TABLE_GiaoDich = "CREATE TABLE GiaoDich(" +
            "MaGiaoDich INTEGER PRIMARY KEY AUTOINCREMENT," +
            "PhanLoaiThuChi INT," +
            "TienGiaoDich INTEGER," +
            "NgayGiaoDich DATE," +
            "GhiChu TEXT," +
            "MaNguoiDung INTEGER," +
            "MaDanhMuc INTEGER," +
            "FOREIGN KEY (MaNguoiDung) REFERENCES NguoiDung(MaNguoiDung)," +
            "FOREIGN KEY (MaDanhMuc) REFERENCES DanhMuc(MaDanhMuc))";
    public static final String CREATE_TABLE_HinhAnhGhiChu = "CREATE TABLE HinhAnhGhiChu(" +
            "MaAnh INTEGER PRIMARY KEY AUTOINCREMENT," +
            "IMG TEXT," +
            "MaGiaoDich INTEGER," +
            "FOREIGN KEY (MaGiaoDich) REFERENCES GiaoDich (MaGiaoDich))";
    // Hàm tạo CSDL
    public SQLiteHelper(Context context){
        super(context, "QuanLyThuChi", null, 1); // Thực thi tạo CSDL
    }
    // Tạo bảng
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_NguoiDung);
        sqLiteDatabase.execSQL(CREATE_TABLE_DanhMuc);
        sqLiteDatabase.execSQL(CREATE_TABLE_GiaoDich);
        sqLiteDatabase.execSQL(CREATE_TABLE_HinhAnhGhiChu);
    }
    // Xóa bảng dữ liêu cũ tạo bảng dữ liệu mới
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NguoiDung");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DanhMuc");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS GiaoDich");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS HinhAnhGhiChu");
    }
}
