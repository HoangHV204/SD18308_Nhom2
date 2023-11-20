package Model;

public class SanPhamCT {

    public int ID_SPCT;
    public int ID_SP;
    public String maSP;
    public String tenSP;
    public int ID_Hang;
    public int ID_KC;
    public int ID_MS;
    public int ID_DM;
    public double donGia;
    public int soLuong;
    public String trangThai;

    public SanPhamCT(int ID_SPCT, int ID_SP, String maSP, String tenSP, int ID_Hang, int ID_KC, int ID_MS, int ID_DM, double donGia, int soLuong, String trangThai) {
        this.ID_SPCT = ID_SPCT;
        this.ID_SP = ID_SP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.ID_Hang = ID_Hang;
        this.ID_KC = ID_KC;
        this.ID_MS = ID_MS;
        this.ID_DM = ID_DM;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }

    public SanPhamCT() {
    }

    public int getID_SPCT() {
        return ID_SPCT;
    }

    public void setID_SPCT(int ID_SPCT) {
        this.ID_SPCT = ID_SPCT;
    }

    public int getID_SP() {
        return ID_SP;
    }

    public void setID_SP(int ID_SP) {
        this.ID_SP = ID_SP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getID_Hang() {
        return ID_Hang;
    }

    public void setID_Hang(int ID_Hang) {
        this.ID_Hang = ID_Hang;
    }

    public int getID_KC() {
        return ID_KC;
    }

    public void setID_KC(int ID_KC) {
        this.ID_KC = ID_KC;
    }

    public int getID_MS() {
        return ID_MS;
    }

    public void setID_MS(int ID_MS) {
        this.ID_MS = ID_MS;
    }

    public int getID_DM() {
        return ID_DM;
    }

    public void setID_DM(int ID_DM) {
        this.ID_DM = ID_DM;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
}
