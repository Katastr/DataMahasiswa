/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pert3;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus TUF
 */
public class table_absen extends AbstractTableModel{
    List<data_absen> ib;
    public table_absen(List<data_absen> ib){
        this.ib = ib;
    }
    @Override
    public int getRowCount() {
        return ib.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return ib.get(row).getNama();
            case 1:
                return ib.get(row).getNPM();
            case 2:
                return ib.get(row).getKelas();
            default:
                return null;
        }
    }
    
}
