package Model;

public class SanPham {

    public int ID_SP;
    public String maSP;
    public String tenSP;

    public SanPham(int ID_SP, String maSP, String tenSP) {
        this.ID_SP = ID_SP;
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public SanPham() {
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

    @Override
    public String toString() {
        return this.tenSP;
    }
}
