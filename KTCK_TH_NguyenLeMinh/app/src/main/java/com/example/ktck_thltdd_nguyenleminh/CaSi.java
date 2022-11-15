package com.example.ktck_thltdd_nguyenleminh;

public class CaSi {
    private String ten;
    private String ngheDanh;
    private String quocGia;
    private int soSao;
    private int image;

    public CaSi() {}


    public CaSi(String ten, String ngheDanh, String quocGia, int soSao, int image) {
        this.ten = ten;
        this.ngheDanh = ngheDanh;
        this.quocGia = quocGia;
        this.soSao = soSao;
        this.image = image;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgheDanh() {
        return ngheDanh;
    }

    public void setNgheDanh(String ngheDanh) {
        this.ngheDanh = ngheDanh;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public int getSoSao() {
        return soSao;
    }

    public void setSoSao(int soSao) {
        this.soSao = soSao;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
