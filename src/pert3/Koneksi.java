/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pert3;

import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author Asus TUF
 */
public class Koneksi {
    static Connection c;
    
    public static Connection connection(){
        if(c == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("mhs");
            data.setUser("root");
            data.setPassword("");
            try{
                c = data.getConnection();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return c;
    }
}
