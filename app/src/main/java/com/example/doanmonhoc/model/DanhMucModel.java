package com.example.doanmonhoc.model;

public class DanhMucModel {
    int maDanhMuc;
    String tenDanhMuc, icon;

    public DanhMucModel(){}

    public DanhMucModel(int maDanhMuc, String tenDanhMuc, String icon) {
        this.maDanhMuc = maDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
        this.icon = icon;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public String getIcon() {
        return icon;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
