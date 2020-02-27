package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDdsn {
    private String NIP, Nama, Username, Password, Confirm;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDdsn(){
        try { 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDKoneksi = connection.getKoneksi(); //non-static method
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setNip(String NIP){
        this.NIP = NIP;
    }
    
    public String getNip(){
        return NIP;
    }
    
    public void setNama(String Nama){
        this.Nama = Nama;
    }
    
    public String getNama(){
        return Nama;
    }
    
    public void setUsername(String Username){
        this.Username = Username;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public void setPass(String Password){
        this.Password = Password;
    }
    
    public String getPass(){
        return Password;
    }
    
    public void setConfirm(String Confirm){
        this.Confirm = Confirm;
    }
    
    public String getConfirm(){
        return Confirm;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM dsn";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String NIP, String Nama, String Username, String Password, String Confirm){
        CRUDquery = "INSERT INTO dsn values(?,?,?,?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, NIP);
            CRUDpsmt.setString(2, Nama);
            CRUDpsmt.setString(3, Username);
            CRUDpsmt.setString(4, Password);
            CRUDpsmt.setString(5, Confirm);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahData(String NIP, String Nama, String Username, String Password, String Confirm){
        CRUDquery = "UPDATE dsn SET NIP=?, Nama=?, Username=?, Password=?, Confirm=? WHERE NIP=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(2, Nama);
            CRUDpsmt.setString(3, Username);
            CRUDpsmt.setString(4, Password);
            CRUDpsmt.setString(5, Confirm);
            CRUDpsmt.setString(1, NIP);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();   
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String NIP){
        CRUDquery = "DELETE from dsn WHERE NIP=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, NIP);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
