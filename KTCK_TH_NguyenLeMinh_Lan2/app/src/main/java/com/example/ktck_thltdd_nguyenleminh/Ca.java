package com.example.ktck_thltdd_nguyenleminh;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Ca implements Serializable {
    private int id;
    private String tenKhoaHoc;
    private String tenThuongGoi;
    private String dacTinh;
    private String mauSac;
    private int hinhAnh;

    private Ca () {}

    public Ca(int id, String tenKhoaHoc, String tenThuongGoi, String dacTinh, String mauSac, int hinhAnh) {
        this.id = id;
        this.tenKhoaHoc = tenKhoaHoc;
        this.tenThuongGoi = tenThuongGoi;
        this.dacTinh = dacTinh;
        this.mauSac = mauSac;
        this.hinhAnh = hinhAnh;
    }
    public Ca(String tenKhoaHoc, String tenThuongGoi, String dacTinh, String mauSac, int hinhAnh) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.tenThuongGoi = tenThuongGoi;
        this.dacTinh = dacTinh;
        this.mauSac = mauSac;
        this.hinhAnh = hinhAnh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getTenThuongGoi() {
        return tenThuongGoi;
    }

    public void setTenThuongGoi(String tenThuongGoi) {
        this.tenThuongGoi = tenThuongGoi;
    }

    public String getDacTinh() {
        return dacTinh;
    }

    public void setDacTinh(String dacTinh) {
        this.dacTinh = dacTinh;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Map<String,Object> toMap() {
        HashMap<String,Object> result = new HashMap<>();
        result.put("tenKhoaHoc", tenKhoaHoc);
        return result;
    }
}
