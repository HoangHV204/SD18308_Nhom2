package DAO;

import Model.SanPham;
import Utils.DBUtils;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SanPhamDAO {

    Connection conn = DBUtils.getConnection();

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setID_SP(rs.getInt("ID_SP"));
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSp"));

                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addSanPham(SanPham sp) {
        String sql = "INSERT INTO SanPham (MaSP, TenSP) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean suaSanPham(SanPham sp) {
        String sql = "UPDATE SanPham SET MaSP = ?, TenSP = ? WHERE ID_SP = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setInt(3, sp.getID_SP());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public SanPham getByID(int id) {
        String sql = "SELECT * FROM SanPham WHERE ID_SP = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setID_SP(rs.getInt("ID_SP"));
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                
                return sp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<SanPham> getKey(String keyword) {
        String sql = "SELECT * FROM SanPham WHERE TenSP LIKE ?";
        List<SanPham> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+keyword+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setID_SP(rs.getInt("ID_SP"));
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
