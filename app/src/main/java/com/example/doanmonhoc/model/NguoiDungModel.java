package com.example.doanmonhoc.model;

public class NguoiDungModel {
    int maNguoiDung, namSinh, soDu;
    String hoTen, sdt, avatar, email, matKhau, gioiTinh;

    public NguoiDungModel(){}

    public NguoiDungModel(int maNguoiDung, int namSinh, int soDu, String hoTen, String sdt, String avatar, String email, String matKhau, String gioiTinh) {
        this.maNguoiDung = maNguoiDung;
        this.namSinh = namSinh;
        this.soDu = soDu;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.avatar = avatar;
        this.email = email;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public int getSoDu() {
        return soDu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public void setSoDu(int soDu) {
        this.soDu = soDu;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
