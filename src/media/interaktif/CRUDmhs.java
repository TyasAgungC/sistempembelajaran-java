package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDmhs {
    private String nim, nama, prodi, angkatan, off, pass;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDmhs(){
        try { 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDKoneksi = connection.getKoneksi(); //non-static method
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setNim(String nim){
        this.nim = nim;
    }
    
    public String getNim(){
        return nim;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setProdi(String prodi){
        this.prodi = prodi;
    }
    
    public String getProdi(){
        return prodi;
    }
    
    public void setAng(String angkatan){
        this.angkatan = angkatan;
    }
    
    public String getAng(){
        return angkatan;
    }
    
    public void setOff(String off){
        this.off = off;
    }
    
    public String getOff(){
        return off;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public String getPass(){
        return pass;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM mhs";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String nim, String nama, String prodi, String angkatan, String off, String pass){
        CRUDquery = "INSERT INTO mhs values(?,?,?,?,?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nim);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, prodi);
            CRUDpsmt.setString(4, angkatan);
            CRUDpsmt.setString(5, off);
            CRUDpsmt.setString(6, pass);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahData(String nim, String nama, String prodi, String angkatan, String off, String pass){
        CRUDquery = "Update mhs set nama=?, prodi=?, angkatan=?, off=?, pass=? WHERE nim=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, prodi);
            CRUDpsmt.setString(3, angkatan);
            CRUDpsmt.setString(4, off);
            CRUDpsmt.setString(5, pass);
            CRUDpsmt.setString(6, nim);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();   
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String nim){
        CRUDquery = "DELETE from mhs WHERE nim=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nim);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
