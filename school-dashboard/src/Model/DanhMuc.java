package Model;

public class DanhMuc {

    public int ID_DanhMuc;
    public String danhMuc;

    public DanhMuc(int ID_DanhMuc, String danhMuc) {
        this.ID_DanhMuc = ID_DanhMuc;
        this.danhMuc = danhMuc;
    }

    public DanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public DanhMuc() {
    }

    public int getID_DanhMuc() {
        return ID_DanhMuc;
    }

    public void setID_DanhMuc(int ID_DanhMuc) {
        this.ID_DanhMuc = ID_DanhMuc;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public String toString() {
        return this.danhMuc;
    }

}
