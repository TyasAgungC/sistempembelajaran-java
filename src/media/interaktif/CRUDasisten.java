package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDasisten {
    private String nim, username, prodi, offering, password, status;
    private int angkatan;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDasisten(){
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
    
    public void setusername(String username){
        this.username = username;
    }
    
    public String getusername(){
        return username;
    }
    
    public void setProdi(String prodi){
        this.prodi = prodi;
    }
    
    public String getProdi(){
        return prodi;
    }
    
    public void setAngkatan(int angkatan){
        this.angkatan = angkatan;
    }
    
    public int getAngkatan(){
        return angkatan;
    }
    
    public void setOffering(String offering){
        this.offering = offering;
    }
    
    public String getOffering(){
        return offering;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return status;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM asisten";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String nim, String username, String prodi, int angkatan, String offering, String password, String status){
        CRUDquery = "INSERT INTO mhs values(?,?,?,?,?,?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nim);
            CRUDpsmt.setString(2, username);
            CRUDpsmt.setString(3, prodi);
            CRUDpsmt.setInt(4, angkatan);
            CRUDpsmt.setString(5, offering);
            CRUDpsmt.setString(6, password);
            CRUDpsmt.setString(7, status);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahData(String nim, String username, String prodi, int angkatan, String offering, String password, String status){
        CRUDquery = "Update asisten set nim=?, username=?, prodi=?, angkatan=?, offering=?, password=?, status=? WHERE nim=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nim);
            CRUDpsmt.setString(2, username);
            CRUDpsmt.setString(3, prodi);
            CRUDpsmt.setInt(4, angkatan);
            CRUDpsmt.setString(5, offering);
            CRUDpsmt.setString(6, password);
            CRUDpsmt.setString(7, status);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();   
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String nim){
        CRUDquery = "DELETE from asisten WHERE nim=?";
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
