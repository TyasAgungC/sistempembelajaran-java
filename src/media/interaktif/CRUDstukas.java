package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDstukas {
    private String Bab, Kasus;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDstukas(){
        try { 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDKoneksi = connection.getKoneksi(); //non-static method
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setBab(String Bab){
        this.Bab = Bab;
    }
    
    public String getBab(){
        return Bab;
    }
    
    public void setKasus(String Kasus){
        this.Kasus = Kasus;
    }
    
    public String getKasus(){
        return Kasus;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM stukas";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
        
    public ResultSet tampilData1(){
        CRUDquery = "SELECT * FROM stukas where Bab='Enkapsulasi'";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilData2(){
        CRUDquery = "SELECT * FROM stukas where Bab='Abstract Class'";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String bab, String kasus){
        CRUDquery = "INSERT INTO stukas values(?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, Bab);
            CRUDpsmt.setString(2, Kasus);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahData(String Bab, String Kasus){
        CRUDquery = "Update stukas set Bab=? WHERE Kasus=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, Bab);
            CRUDpsmt.setString(2, Kasus);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();   
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String kasus){
        CRUDquery = "DELETE from stukas WHERE Bab=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, Bab);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
