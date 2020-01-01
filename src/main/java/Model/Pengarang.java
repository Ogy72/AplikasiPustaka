/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author ogy
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Config.DbKoneksi;

public class Pengarang {
    
    private static ResultSet result;
    private static String sql;
    private static String rd;
    private static String search, NamaPengarang, Key;
    
    
    
    
    public static void setSearch(String search){
        Pengarang.search = search;
    }
    
    public static void setPengarang(String namaPengarang){
        Pengarang.NamaPengarang = namaPengarang;
    }
    
    public static void setKey(String key){
        Pengarang.Key = key;
    }
    
    public static ResultSet lihatPengarang(){
        rd = queryMelihatPengarang();
        
        try{
            Statement stat = (Statement) DbKoneksi.getKoneksi().createStatement();
            result = stat.executeQuery(rd);
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
        }
        return result;
    }
    
    public static void masukkanPengarang(){
        rd = queryMemasukkanPengarang();
        
        try{
            PreparedStatement x = (PreparedStatement) DbKoneksi.getKoneksi().prepareStatement(rd);
            x.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pengarang Berhasil Di Simpan");
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public static void ubahPengarang(){
        rd = queryMengubahPengarang();
        
        try{
            PreparedStatement x = (PreparedStatement) DbKoneksi.getKoneksi().prepareStatement(rd);
            x.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pengarang Berhasil Di Ubah");
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public static void hapusPengarang(){
        rd = queryMenghapusPengarang();
        
        try{
            PreparedStatement x = (PreparedStatement) DbKoneksi.getKoneksi().prepareStatement(rd);
            x.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pengarang Berhasil Di Hapus");
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private static String queryMelihatPengarang(){
        sql = "SELECT * FROM pengarang WHERE nm_pengarang LIKE '%"+search+"%'";
        return sql;
    }
    
    private static String queryMemasukkanPengarang(){
        sql = "INSERT INTO pengarang VALUES(null,'"+NamaPengarang+"')";
        return sql;
    }
    
    private static String queryMengubahPengarang(){
        sql = "UPDATE pengarang SET nm_pengarang='"+NamaPengarang+"' WHERE id='"+Key+"'";
        return sql;
    }
    
    private static String queryMenghapusPengarang(){
        sql = "DELETE FROM pengarang WHERE id='"+Key+"'";
        return sql;
    }
}
