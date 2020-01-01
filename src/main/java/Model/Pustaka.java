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

import Config.DbKoneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Pustaka {
    
    private static ResultSet result;
    private static String sql;
    private static String rd;
    private static String search, judul, jenis, penerbit, tahun, pengarang, key;
    private static String idPengarang;
    
    public static void setSearch(String search){
        Pustaka.search = search;
    }
    
    public static void setKey(String key){
        Pustaka.key = key;
    }
    
    public static void setData(String judul, String jenis, String penerbit, String tahun, String pengarang){
        Pustaka.judul = judul;
        Pustaka.jenis = jenis;
        Pustaka.penerbit = penerbit;
        Pustaka.tahun = tahun;
        Pustaka.pengarang = pengarang;
        
    }
    
    public static ResultSet lihatPustaka(){
        rd = queryMelihatPustaka();
        
        try{
            Statement stat = (Statement) DbKoneksi.getKoneksi().createStatement();
            result = stat.executeQuery(rd);
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
        }
        return result;
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
    
    public static String getIdPengarang(){
        rd = queryGetIdPengarang();
        
        try{
            Statement stat = (Statement) DbKoneksi.getKoneksi().createStatement();
            result = stat.executeQuery(rd);
            result.next();
            idPengarang = result.getString("id");
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage() );
        }
        return idPengarang;
    }
    
    public static void masukkanPustaka(){
        rd = queryMemasukkanPustaka();
        
        try{
            PreparedStatement x = (PreparedStatement) DbKoneksi.getKoneksi().prepareStatement(rd);
            x.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pustaka Berhasil Di Simpan");
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public static void ubahPustaka(){
        rd = queryMengubahPustaka();
        
        try{
            PreparedStatement x = (PreparedStatement) DbKoneksi.getKoneksi().prepareStatement(rd);
            x.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pustaka Berhasil Di Ubah");
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public static void hapusPustaka(){
        rd = queryMenghapusPustaka();
        
        try{
            PreparedStatement x = (PreparedStatement) DbKoneksi.getKoneksi().prepareStatement(rd);
            x.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pustaka Berhasil Di Hapus");
        } catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    private static String queryMelihatPustaka(){
        sql = "SELECT pustaka.*, pengarang.* FROM pustaka, pengarang WHERE pustaka.pengarang=pengarang.id AND pustaka.judul LIKE '%"+search+"%'";
        return sql;
    }
    
    private static String queryMelihatPengarang(){
        sql = "SELECT * FROM pengarang";
        return sql;
    }
    
    private static String queryGetIdPengarang(){
        sql = "SELECT * FROM pengarang WHERE nm_pengarang='"+pengarang+"'";
        return sql;
    }
    
    private static String queryMemasukkanPustaka(){
        sql = "INSERT INTO pustaka VALUES(null,'"+judul+"','"+jenis+"','"+penerbit+"','"+tahun+"','"+idPengarang+"')";
        return sql;
    }
    
    private static String queryMengubahPustaka(){
        sql = "UPDATE pustaka SET judul='"+judul+"', jenis='"+jenis+"', penerbit='"+penerbit+"', tahun='"+tahun+"', pengarang='"+idPengarang+"' WHERE id='"+key+"'";
        return sql;
    }
    
    private static String queryMenghapusPustaka(){
        sql = "DELETE FROM pustaka WHERE id='"+key+"'";
        return sql;
    }
}
