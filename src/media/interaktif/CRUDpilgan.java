package media.interaktif;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDpilgan {
    private String materi, kode_soal, soal, pilihan_a, pilihan_b, pilihan_c, pilihan_d, kunci;
    private int urutan;
    private Connection CRUDKoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;
    
    public CRUDpilgan(){
        try { 
            KoneksiMysql connection = new KoneksiMysql();
            CRUDKoneksi = connection.getKoneksi(); //non-static method
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void setMateri(String materi){
        this.materi = materi;
    }
    
    public String getMateri(){
        return materi;
    }
    
    public void setKode(String kode_soal){
        this.kode_soal = kode_soal;
    }
    
    public String getKode(){
        return kode_soal;
    }
    
    public void setUrutan(int urutan){
        this.urutan = urutan;
    }
    
    public int getUrutan(){
        return urutan;
    }
    
    public void setSoal(String soal){
        this.soal = soal;
    }
    
    public String getSoal(){
        return soal;
    }
    
    public void setPA(String pilihan_a){
        this.pilihan_a = pilihan_a;
    }
    
    public String getPA(){
        return pilihan_a;
    }
    
    public void setPB(String pilihan_b){
        this.pilihan_b = pilihan_b;
    }
    
    public String getPB(){
        return pilihan_b;
    }
    
    public void setPC(String pilihan_c){
        this.pilihan_c = pilihan_c;
    }
    
    public String getPC(){
        return pilihan_c;
    }
    
    public void setPD(String pilihan_d){
        this.pilihan_d = pilihan_d;
    }
    
    public String getPD(){
        return pilihan_d;
    }
    public void setKunci(String kunci){
        this.kunci = kunci;
    }
    
    public String getKunci(){
        return kunci;
    }
    
    public ResultSet tampilData(){
        CRUDquery = "SELECT * FROM soal_pilgan";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilData1(){
        CRUDquery = "SELECT * FROM soal_pilgan where materi='Enkapsulasi'";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public ResultSet tampilData2(){
        CRUDquery = "SELECT * FROM soal_pilgan where materi='Abstract Class'";
        try{
            CRUDstat = CRUDKoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        }catch(Exception e){
        }
        return CRUDhasil;
    }
    
    public void simpanData(String materi, String kode_soal, int urutan, String soal, String pilihan_a, 
            String pilihan_b, String pilihan_c, String pilihan_d, String kunci){
        CRUDquery = "INSERT INTO soal_pilgan values(?,?,?,?,?,?,?,?,?)";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, materi);
            CRUDpsmt.setString(2, kode_soal);
            CRUDpsmt.setInt(3, urutan);
            CRUDpsmt.setString(4, soal);
            CRUDpsmt.setString(5, pilihan_a);
            CRUDpsmt.setString(6, pilihan_b);
            CRUDpsmt.setString(7, pilihan_c);
            CRUDpsmt.setString(8, pilihan_d);
            CRUDpsmt.setString(9, kunci);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void ubahData(String materi, String kode_soal, int urutan, String soal, String pilihan_a, 
            String pilihan_b, String pilihan_c, String pilihan_d, String kunci){
        CRUDquery = "UPDATE soal_pilgan SET materi=?, urutan=?, soal=?, "
                + "pilihan_a=?, pilihan_b=?, pilihan_c=?, , pilihan_d=?, kunci=? WHERE kode_soal=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, materi);
            CRUDpsmt.setInt(2, urutan);
            CRUDpsmt.setString(3, soal);
            CRUDpsmt.setString(4, pilihan_a);
            CRUDpsmt.setString(5, pilihan_b);
            CRUDpsmt.setString(6, pilihan_c);
            CRUDpsmt.setString(7, pilihan_d);
            CRUDpsmt.setString(8, kunci);
            CRUDpsmt.setString(9, kode_soal);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();   
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void hapusData(String kode_soal){
        CRUDquery = "DELETE from soal_pilgan WHERE kode_soal=?";
        try{
            CRUDpsmt = CRUDKoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, kode_soal);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
