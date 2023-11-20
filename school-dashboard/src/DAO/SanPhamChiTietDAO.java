package DAO;

import Model.SanPhamCT;
import Utils.DBUtils;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanPhamChiTietDAO {

    Connection conn = DBUtils.getConnection();

    public List<SanPhamCT> getAll() {
        List<SanPhamCT> list = new ArrayList<>();
        String sql = "SELECT ID_SPCT, spct.ID_SP, sp.MaSP, sp.TenSP, ID_Hang, ID_KC, ID_MS, ID_DM, DonGia, SoLuong, TrangThai\n"
                + "FROM SanPhamChiTiet AS spct JOIN SanPham AS sp ON spct.ID_SP = sp.ID_SP\n";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT sp = new SanPhamCT();
                sp.setID_SPCT(rs.getInt("ID_SPCT"));
                sp.setID_SP(rs.getInt("ID_SP"));
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setID_Hang(rs.getInt("ID_Hang"));
                sp.setID_KC(rs.getInt("ID_KC"));
                sp.setID_MS(rs.getInt("ID_MS"));
                sp.setID_DM(rs.getInt("ID_DM"));
                sp.setDonGia(rs.getInt("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getString("TrangThai"));

                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addSP(SanPhamCT sp) {
        String sql = "INSERT INTO SanPhamChiTiet (ID_SP, ID_Hang, ID_KC, ID_MS, ID_DM, DonGia, SoLuong, TrangThai) VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sp.getID_SP());
            ps.setInt(2, sp.getID_Hang());
            ps.setInt(3, sp.getID_KC());
            ps.setInt(4, sp.getID_MS());
            ps.setInt(5, sp.getID_DM());
            ps.setDouble(6, sp.getDonGia());
            ps.setInt(7, sp.getSoLuong());
            ps.setString(8, sp.getTrangThai());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSP(SanPhamCT sp) {
        String sql = "UPDATE SanPhamChiTiet SET ID_SP =?, ID_Hang=?, ID_KD=?, ID_KC=?, ID_MS=?, ID_DM=?, DonGia=?, SoLuong=?, TrangThai=? WHERE ID_SPCT=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sp.getID_SP());
            ps.setInt(2, sp.getID_Hang());
            ps.setInt(3, sp.getID_KC());
            ps.setInt(4, sp.getID_MS());
            ps.setInt(5, sp.getID_DM());
            ps.setDouble(6, sp.getDonGia());
            ps.setInt(7, sp.getSoLuong());
            ps.setString(8, sp.getTrangThai());
            ps.setInt(9, sp.getID_SPCT());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SanPhamCT> getByID_SP(int id_SP) {
          String sql ="""
                      SELECT ID_SPCT, spct.ID_SP, sp.MaSP, sp.TenSP, ID_Hang, ID_KC, ID_MS, ID_DM, DonGia, SoLuong, TrangThai
                      FROM SanPhamChiTiet AS spct JOIN SanPham AS sp ON spct.ID_SP = sp.ID_SP
                      WHERE sp.ID_SP = ?
                      """;
        List<SanPhamCT> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id_SP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamCT sp = new SanPhamCT();
                sp.setID_SPCT(rs.getInt("ID_SPCT"));
                sp.setID_SP(rs.getInt("ID_SP"));
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setID_Hang(rs.getInt("ID_Hang"));
                sp.setID_KC(rs.getInt("ID_KC"));
                sp.setID_MS(rs.getInt("ID_MS"));
                sp.setID_DM(rs.getInt("ID_DM"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setTrangThai(rs.getString("TrangThai"));

                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public SanPhamCT getByID_SPCT(int id_SPCT) {
          String sql ="""
                      SELECT ID_SPCT, spct.ID_SP, sp.MaSP, sp.TenSP, ID_Hang, ID_KC, ID_MS, ID_DM, DonGia, SoLuong, TrangThai
                      FROM SanPhamChiTiet AS spct JOIN SanPham AS sp ON spct.ID_SP = sp.ID_SP
                      WHERE ID_SPCT = ?
                      """;
        SanPhamCT spct = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id_SPCT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                spct = new SanPhamCT();
                spct.setID_SPCT(rs.getInt("ID_SPCT"));
                spct.setID_SP(rs.getInt("ID_SP"));
                spct.setMaSP(rs.getString("MaSP"));
                spct.setTenSP(rs.getString("TenSP"));
                spct.setID_Hang(rs.getInt("ID_Hang"));
                spct.setID_KC(rs.getInt("ID_KC"));
                spct.setID_MS(rs.getInt("ID_MS"));
                spct.setID_DM(rs.getInt("ID_DM"));
                spct.setDonGia(rs.getDouble("DonGia"));
                spct.setSoLuong(rs.getInt("SoLuong"));
                spct.setTrangThai(rs.getString("TrangThai"));

            }
            return spct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
