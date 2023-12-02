/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pert3;

import pert3.daoData_absen;
import pert3.implementData_absen;
import pert3.data_absen;
import pert3.table_absen;
import pert3.view;

import java.util.List;  

/**
 *
 * @author Asus TUF
 */
public class controllerData_absen {
    view ve;
    implementData_absen iD;
    List<data_absen> ib;
    
    public controllerData_absen(view ve){
        this.ve = ve;
        iD = (implementData_absen) new daoData_absen();
        ib = iD.getAll();
    }
    public void reset(){
        ve.getText_nama().setText("");
        ve.getText_npm().setText("");
        ve.getText_kelas().setText("");
        
    }
    public void table(){
        ib = iD.getAll();
        table_absen ta = new table_absen(ib);
        ve.getTable_data().setModel(ta);
    }
    public void isiField(int row){
        ve.getText_nama().setText(ib.get(row).getNama());
        ve.getText_npm().setText(ib.get(row).getNPM());
        ve.getText_kelas().setText(ib.get(row).getKelas());     
    }
    public void insert(){
        data_absen b = new data_absen();
        b.setNama(ve.getText_nama().getText());
        b.setNPM(ve.getText_npm().getText());
        b.setKelas(ve.getText_kelas().getText());
        
        iD.insert(b);
    }
}
