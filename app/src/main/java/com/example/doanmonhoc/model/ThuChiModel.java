package com.example.doanmonhoc.model;

public class ThuChiModel {
    int maGiaoDich, phanLoaiThuChi, tienGiaoDich, maNguoiDung, maDanhMuc;
    String ngayGiaoDich, ghiChu;

    public ThuChiModel(){}

    public ThuChiModel(int maGiaoDich, int phanLoaiThuChi, int tienGiaoDich, int maNguoiDung, int maDanhMuc, String ngayGiaoDich, String ghiChu) {
        this.maGiaoDich = maGiaoDich;
        this.phanLoaiThuChi = phanLoaiThuChi;
        this.tienGiaoDich = tienGiaoDich;
        this.maDanhMuc = maDanhMuc;
        this.ngayGiaoDich = ngayGiaoDich;
        this.ghiChu = ghiChu;
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public int getPhanLoaiThuChi() {
        return phanLoaiThuChi;
    }

    public int getTienGiaoDich() {
        return tienGiaoDich;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public void setPhanLoaiThuChi(int phanLoaiThuChi) {
        this.phanLoaiThuChi = phanLoaiThuChi;
    }

    public void setTienGiaoDich(int tienGiaoDich) {
        this.tienGiaoDich = tienGiaoDich;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
