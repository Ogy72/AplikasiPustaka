/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author ogy
 */

import Model.Pustaka;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class KelolaPustaka {
    
    private static ResultSet data;
    
    
    public static ResultSet melihatPustaka(String search){
        Pustaka.setSearch(search);
        data = Pustaka.lihatPustaka();
        return data;
    }
    
    public static ResultSet melihatPengarang(){
        data = Pustaka.lihatPengarang();
        return data;
    }
    
    public static void memasukkanPustaka(String judul, String jenis, String penerbit, String tahun, String pengarang){
        Pustaka.setData(judul, jenis, penerbit, tahun, pengarang);
        Pustaka.getIdPengarang();
        Pustaka.masukkanPustaka();
    }
    
    public static void mengubahPustaka(String key, String judul, String jenis, String penerbit, String tahun, String pengarang){
        Pustaka.setKey(key);
        Pustaka.setData(judul, jenis, penerbit, tahun, pengarang);
        Pustaka.getIdPengarang();
        Pustaka.ubahPustaka();
    }
    
    public static void menghapusPustaka(String key){
        Pustaka.setKey(key);
        Pustaka.hapusPustaka();
    }
    
}
