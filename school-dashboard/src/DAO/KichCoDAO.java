package DAO;

import Model.KichCo;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;


public class KichCoDAO {

    private Connection conn = DBUtils.getConnection();

    public int addKichCo(KichCo kc) {
        String sql = "INSERT INTO KichCo (KichCo) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, kc.getKichCo());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int suaKichCo(KichCo kc) {
        String sql = "UPDATE KichCo SET KichCo = ? WHERE ID_KC = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, kc.getKichCo());
            ps.setInt(2, kc.getID_KichCo());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<KichCo> getListKichCo() {
        List<KichCo> list = new ArrayList<>();
        String sql = "SELECT * FROM KichCo";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KichCo kc = new KichCo();
                kc.setID_KichCo(rs.getInt("ID_KC"));
                kc.setKichCo(rs.getInt("KichCo"));
                list.add(kc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    public KichCo getKichCoByID(int id_kc) {
        
        String sql = "SELECT * FROM KichCo WHERE ID_KC = ?";
        KichCo kc = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_kc);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                kc = new KichCo();
                kc.setID_KichCo(rs.getInt("ID_KC"));
                kc.setKichCo(rs.getInt("KichCo"));
                
            }
            return kc;
        } catch (SQLException ex) {
            ex.printStackTrace();
             return null;
        }
        
    }
}
