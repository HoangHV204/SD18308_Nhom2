package Model;

public class MauSac {
    
    public int ID_MauSac;
    public String tenMau;

    public MauSac(int ID_MauSac, String tenMau) {
        this.ID_MauSac = ID_MauSac;
        this.tenMau = tenMau;
    }

    public MauSac(String tenMau) {
        this.tenMau = tenMau;
    }

    public MauSac() {
    }

    public int getID_MauSac() {
        return ID_MauSac;
    }

    public void setID_MauSac(int ID_MauSac) {
        this.ID_MauSac = ID_MauSac;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return this.tenMau;
    }
}
