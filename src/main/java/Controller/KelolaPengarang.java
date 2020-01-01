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

import Model.Pengarang;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class KelolaPengarang {
    
    private static ResultSet data;
    
    
    public static ResultSet melihatPengarang(String search){
        Pengarang.setSearch(search);
        data = Pengarang.lihatPengarang();
        return data;
    }
    
    public static void memasukkanPengarang(String namaPengarang){
        Pengarang.setPengarang(namaPengarang);
        Pengarang.masukkanPengarang();
    }
    
    public static void mengubahPengarang(String key, String namaPengarang){
        Pengarang.setKey(key);
        Pengarang.setPengarang(namaPengarang);
        Pengarang.ubahPengarang();
    }
    
    public static void menghapusPengarang(String key){
        Pengarang.setKey(key);
        Pengarang.hapusPengarang();
    }
    
}
