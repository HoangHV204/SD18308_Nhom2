package Model;

public class KichCo {

    public int kichCo;
    public int ID_KichCo;

    public KichCo(int kichCo, int ID_KichCo) {
        this.kichCo = kichCo;
        this.ID_KichCo = ID_KichCo;
    }

    public KichCo(int kichCo) {
        this.kichCo = kichCo;
    }

    public KichCo() {
    }

    public int getKichCo() {
        return kichCo;
    }

    public void setKichCo(int kichCo) {
        this.kichCo = kichCo;
    }

    public int getID_KichCo() {
        return ID_KichCo;
    }

    public void setID_KichCo(int ID_KichCo) {
        this.ID_KichCo = ID_KichCo;
    }

    @Override
    public String toString() {
        return this.kichCo + "";
    }

}
