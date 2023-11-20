package DAO;

import Model.DanhMuc;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DanhMucDAO  {

    private Connection conn = DBUtils.getConnection();

    public int addDanhMuc(DanhMuc dm) {
        String sql = "INSERT INTO DanhMuc (TenDanhMuc) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dm.getDanhMuc());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int suaDanhMuc(DanhMuc dm) {
        String sql = "UPDATE DanhMuc SET TenDanhMuc = ? WHERE ID_DM = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dm.getDanhMuc());
            ps.setInt(2, dm.getID_DanhMuc());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<DanhMuc> getListDanhMuc() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM DanhMuc";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setID_DanhMuc(rs.getInt("ID_DM"));
                dm.setDanhMuc(rs.getString("TenDanhMuc"));
                list.add(dm);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public DanhMuc getDanhMucByID(int id_dm) {
        
        String sql = "SELECT * FROM DanhMuc WHERE ID_DM = ?";
        DanhMuc dm = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_dm);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dm = new DanhMuc();
                dm.setID_DanhMuc(rs.getInt("ID_DM"));
                dm.setDanhMuc(rs.getString("TenDanhMuc"));
                
            }
            return dm;
        } catch (SQLException ex) {
            ex.printStackTrace();
             return null;
        }
        
    }
}
