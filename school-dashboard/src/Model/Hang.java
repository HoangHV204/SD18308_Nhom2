package Model;

public class Hang {

    public int ID_Hang;
    public String hang;

    public Hang(int ID_Hang, String hang) {
        this.ID_Hang = ID_Hang;
        this.hang = hang;
    }

    public Hang(String hang) {
        this.hang = hang;
    }

    public Hang() {
    }

    public int getID_Hang() {
        return ID_Hang;
    }

    public void setID_Hang(int ID_Hang) {
        this.ID_Hang = ID_Hang;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    @Override
    public String toString() {
        return this.hang;
    }
    
}
