package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDjawab {
    private String jawaban, jwb1, jwb2, jwb3, jwb4, jwb5;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDjawab(){
        try { 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDKoneksi = connection.getKoneksi(); //non-static method
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setJwb(String jawaban){
        this.jawaban = jawaban;
    }
    
    public String getJwb(){
        return jawaban;
    }
    
    public void setJwb1(String jwb1){
        this.jwb1 = jwb1;
    }
    
    public String getJwb1(){
        return jwb1;
    }
    
    public void setJwb2(String jwb2){
        this.jwb2 = jwb2;
    }
    
    public String getJwb2(){
        return jwb2;
    }
    
    public void setJwb3(String jwb3){
        this.jwb3 = jwb3;
    }
    
    public String getJwb3(){
        return jwb3;
    }
    
    public void setJwb4(String jwb4){
        this.jwb4 = jwb4;
    }
    
    public String getJwb4(){
        return jwb4;
    }
    
    public void setJwb5(String jwb5){
        this.jwb5 = jwb5;
    }
    
    public String getJwb5(){
        return jwb5;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM jawabal_pilgan";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String jwb1, String jwb2, String jwb3, String jwb4, String jwb5){
        CRUDquery = "INSERT INTO jawabal_pilgan values(?,?,?,?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, jwb1);
            CRUDpsmt.setString(2, jwb2);
            CRUDpsmt.setString(3, jwb3);
            CRUDpsmt.setString(4, jwb4);
            CRUDpsmt.setString(5, jwb5);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void simpanData(String jawaban){
        CRUDquery = "INSERT INTO jawaban_stukas values(?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, jawaban);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
