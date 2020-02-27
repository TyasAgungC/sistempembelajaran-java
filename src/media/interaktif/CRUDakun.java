package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDakun {
    private String nama, username, password, confirm;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDakun(){
        try { 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDKoneksi = connection.getKoneksi(); //non-static method
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setnama(String nama){
        this.nama = nama;
    }
    
    public String getnama(){
        return nama;
    }
    
    public void setusername(String username){
        this.username = username;
    }
    
    public String getusername(){
        return username;
    }
    
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setconfirm(String confirm){
        this.confirm = confirm;
    }
    
    public String getconfirm(){
        return confirm;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM akun";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String nama, String username, String password, String confirm){
        CRUDquery = "INSERT INTO akun values(?,?,?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, username);
            CRUDpsmt.setString(3, password);
            CRUDpsmt.setString(4, confirm);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahData(String nama, String username, String password, String confirm){
        CRUDquery = "Update akun set nama=?, username=?,password=?, confirm=? WHERE nama=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, username);
            CRUDpsmt.setString(3, password);
            CRUDpsmt.setString(4, confirm);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();   
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String nama){
        CRUDquery = "DELETE from akun WHERE nama=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
