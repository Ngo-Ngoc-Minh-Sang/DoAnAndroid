package com.example.doanmonhoc.model;

public class HinhAnhGhiChuModel {
    int maAnh, maGiaoDich;
    String img;

    public HinhAnhGhiChuModel(){}

    public HinhAnhGhiChuModel(int maAnh, int maGiaoDich, String img) {
        this.maAnh = maAnh;
        this.maGiaoDich = maGiaoDich;
        this.img = img;
    }

    public int getMaAnh() {
        return maAnh;
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public String getImg() {
        return img;
    }

    public void setMaAnh(int maAnh) {
        this.maAnh = maAnh;
    }

    public void setMaGiaoDich(int maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
