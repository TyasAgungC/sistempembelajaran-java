package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDmateri {
    private String bab, sub_materi, uraian;
    private int urutan_bab, urutan_sub;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDmateri(){
        try { 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDKoneksi = connection.getKoneksi(); //non-static method
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setBab(String bab){
        this.bab = bab;
    }
    
    public String getBab(){
        return bab;
    }
    
    public void setUrutanBab(int urutan_bab){
        this.urutan_bab = urutan_bab;
    }
    
    public int getUrutanBab(){
        return urutan_bab;
    }
    
    public void setSubMateri(String sub_materi){
        this.sub_materi = sub_materi;
    }
    
    public String getSubMateri(){
        return sub_materi;
    }
    
    public void setUrutanSub(int urutan_sub){
        this.urutan_sub = urutan_sub;
    }
    
    public int getUrutanSub(){
        return urutan_sub;
    }
    
    public void setUraian(String uraian){
        this.uraian = uraian;
    }
    
    public String getUraian(){
        return uraian;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM materi";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilData1(){
        CRUDquery = "SELECT * FROM materi where bab='Enkapsulasi'";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilData2(){
        CRUDquery = "SELECT * FROM materi where bab='Abstract Class'";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String bab, int urutan_bab, String sub_materi, int urutan_sub, String uraian){
        CRUDquery = "INSERT INTO materi values(?,?,?,?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, bab);
            CRUDpsmt.setInt(2, urutan_bab);
            CRUDpsmt.setString(3, sub_materi);
            CRUDpsmt.setInt(4, urutan_sub);
            CRUDpsmt.setString(5, uraian);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahData(String bab, int urutan_bab, String sub_materi, int urutan_sub, String uraian){
        CRUDquery = "Update materi set bab=?, urutan_bab=?, sub_materi=?, uraian=? WHERE urutan_sub=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, bab);
            CRUDpsmt.setInt(2, urutan_bab);
            CRUDpsmt.setString(3, sub_materi);
            CRUDpsmt.setString(4, uraian);
            CRUDpsmt.setInt(5, urutan_sub);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();   
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(int urutan_sub){
        CRUDquery = "DELETE from materi WHERE urutan_sub=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setInt(1, urutan_sub);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
