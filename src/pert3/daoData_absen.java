/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pert3;

import com.sun.jdi.connect.spi.Connection;
import java.beans.Statement;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus TUF
 */
public class daoData_absen implements implementData_absen {

    Connection c;
    final String insert = "insert into data_absen VALUES (?,?,?)";
    final String select = "select * from data_absen";

    public daoData_absen() {
        c = Koneksi.connection();
    }

    @Override
    public void insert(data_absen a) {
        PreparedStatement stm = null;
        try {
            stm = c.prepareStatement(insert);
            stm.setString(1, a.getNama());
            stm.setString(2, a.getNPM());
            stm.setString(3, a.getKelas());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while (rs.next()) {
                a.setNama(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                stm.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<data_absen> getAll() {
        List<data_absen> ib = null;
        try {
            ib = new ArrayList<data_absen>();
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(select);
            while (rs.next()) {
                data_absen da = new data_absen();
                da.setNama(rs.getString("nama"));
                da.setNPM(rs.getString("npm"));
                da.setKelas(rs.getString("kelas"));
                ib.add(da);
            }
        } catch (Exception ex) {
            Logger.getLogger(daoData_absen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ib;
    }
}
