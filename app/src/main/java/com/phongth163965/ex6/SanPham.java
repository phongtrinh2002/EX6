package com.phongth163965.ex6;

public class SanPham {
    private String masp;
    private String tensp;
    private int soLuongSP;

    public SanPham(String masp, String tensp, int soLuongSP) {
        this.masp = masp;
        this.tensp = tensp;
        this.soLuongSP = soLuongSP;
    }

    public SanPham() {}

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }
}
