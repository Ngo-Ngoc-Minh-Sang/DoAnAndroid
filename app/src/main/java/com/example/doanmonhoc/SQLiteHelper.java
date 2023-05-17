package com.example.doanmonhoc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    // Lệnh tạo bảng Ví Tiền
    public static final String CREATE_TABLE_ViTien = "CREATE TABLE ViTien(" +
            "MaViTien INT PRIMARY KEY," +
            "SoDu INT)";
    // Lệnh tạo bảng Người Dùng
    public static final String CREATE_TABLE_NguoiDung = "CREATE TABLE NguoiDung(" +
            "  MaNguoiDung INT PRIMARY KEY," +
            "  HoTen TEXT," +
            "  SDT TEXT," +
            "  Avatar TEXT," +
            "  DiaChi TEXT," +
            "  NamSinh INTEGER," +
            "  GioiTinh INTEGER," +
            "  Email TEXT," +
            "  MatKhau TEXT," +
            "  MaViTien INTEGER," +
            "  FOREIGN KEY (MaViTien) REFERENCES ViTien(MaViTien)" +
            ")";
    // Lệnh tạo bảng Danh Mục
    public static final String CREATE_TABLE_DanhMuc = "CREATE TABLE DanhMuc(" +
            "  MaDanhMuc INT PRIMARY KEY," +
            "  TenDanhMuc TEXT," +
            "  Icon TEXT" +
            ")";
    // Lệnh tạo bảng Giao Dịch
    public static final String CREATE_TABLE_GiaoDich = "CREATE TABLE GiaoDich(" +
            "  MaGiaoDich INT PRIMARY KEY," +
            "  PhanLoaiThuChi INTEGER," +
            "  TienGiaoDich INTEGER," +
            "  NgayGiaoDich DATE," +
            "  GhiChu TEXT," +
            "  MaNguoiDung INT," +
            "  MaDanhMuc INT," +
            "  FOREIGN KEY (MaNguoiDung) REFERENCES NguoiDung(MaNguoiDung)," +
            "  FOREIGN KEY (MaDanhMuc) REFERENCES DanhMuc(MaDanhMuc)" +
            ")";
    // Hàm tạo CSDL
    public SQLiteHelper(Context context){
        super(context, "QuanLyThuChi", null, 1); // Thực thi tạo CSDL
    }
    // Tạo bảng
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ViTien);
        sqLiteDatabase.execSQL(CREATE_TABLE_NguoiDung);
        sqLiteDatabase.execSQL(CREATE_TABLE_DanhMuc);
        sqLiteDatabase.execSQL(CREATE_TABLE_GiaoDich);
    }
    // Xóa bảng dữ liêu cũ tạo bảng dữ liệu mới
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ViTien");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS NguoiDung");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS DanhMuc");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS GiaoDich");
    }
}
