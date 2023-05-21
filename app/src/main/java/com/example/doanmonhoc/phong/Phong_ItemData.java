package com.example.doanmonhoc.phong;

public class Phong_ItemData {
    String date;
    //String img;
    String ghiChu;
    int tienGiaoDich;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public String getImg() {
//        return img;
//    }

//    public void setImg(String img) {
//        this.img = img;
//    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTienGiaoDich() {
        return tienGiaoDich;
    }

    public void setTienGiaoDich(int tienGiaoDich) {
        this.tienGiaoDich = tienGiaoDich;
    }

    public Phong_ItemData(String date, String ghiChu, int tienGiaoDich) {
        this.date = date;
        //this.img = img;
        this.ghiChu = ghiChu;
        this.tienGiaoDich = tienGiaoDich;
    }


}
