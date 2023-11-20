package DAO;

import Model.MauSac;
import Utils.DBUtils;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MauSacDAO {

    private Connection conn = DBUtils.getConnection();

    public int addMauSac(MauSac ms) {
        String sql = "INSERT INTO MauSac (MauSac) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getTenMau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int suaMauSac(MauSac ms) {
        String sql = "UPDATE MauSac SET MauSac = ? WHERE ID_MS = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getTenMau());
            ps.setInt(2, ms.getID_MauSac());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<MauSac> getListMauSac() {
        List<MauSac> list = new ArrayList<>();
        String sql = "SELECT * FROM MauSac";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setID_MauSac(rs.getInt("ID_MS"));
                ms.setTenMau(rs.getString("TenMauSac"));
                list.add(ms);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public MauSac getMauSacByID(int id_ms) {
        String sql = "SELECT * FROM MauSac WHERE ID_MS = ?";
        MauSac ms = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_ms);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ms = new MauSac();
                ms.setID_MauSac(rs.getInt("ID_MS"));
                ms.setTenMau(rs.getString("TenMauSac"));
                
            }
            return ms;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        
    }
}
