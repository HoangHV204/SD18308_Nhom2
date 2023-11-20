package DAO;

import Model.Hang;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HangDAO {

    private Connection conn = DBUtils.getConnection();

    public int addHang(Hang h) {
        String sql = "INSERT INTO Hang (TenHang) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, h.getHang());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int suaHang(Hang h) {
        String sql = "UPDATE Hang SET TenHang = ? WHERE ID_Hang = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, h.getHang());
            ps.setInt(2, h.getID_Hang());
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Hang> getListHang() {
        List<Hang> list = new ArrayList<>();
        String sql = "SELECT * FROM Hang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hang h = new Hang();
                h.setID_Hang(rs.getInt("ID_Hang"));
                h.setHang(rs.getString("TenHang"));
                list.add(h);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public Hang getHangByID(int id_hang) {
        
        String sql = "SELECT * FROM Hang WHERE ID_Hang = ?";
        Hang h = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_hang);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                h = new Hang();
                h.setID_Hang(rs.getInt("ID_Hang"));
                h.setHang(rs.getString("TenHang"));
                
            }
            return h;
        } catch (SQLException ex) {
            ex.printStackTrace();
             return null;
        }
        
    }
}
