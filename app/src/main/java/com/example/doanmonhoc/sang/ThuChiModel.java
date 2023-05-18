package com.example.doanmonhoc.sang;

public class ThuChiModel {
    int maGiaoDich, phanLoaiThuChi, tienGiaoDich, maNguoiDung, maDanhMuc, maViTien;
    String ngayGiaoDich, ghiChu;

    public ThuChiModel(){}

    public ThuChiModel(int maGiaoDich, int phanLoaiThuChi, int tienGiaoDich, int maNguoiDung, int maDanhMuc, int maViTien, String ngayGiaoDich, String ghiChu) {
        this.maGiaoDich = maGiaoDich;
        this.phanLoaiThuChi = phanLoaiThuChi;
        this.tienGiaoDich = tienGiaoDich;
        this.maNguoiDung = maNguoiDung;
        this.maDanhMuc = maDanhMuc;
        this.maViTien = maViTien;
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

    public int getMaViTien() {
        return maViTien;
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

    public void setMaViTien(int maViTien) {
        this.maViTien = maViTien;
    }

    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
