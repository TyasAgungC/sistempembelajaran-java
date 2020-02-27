package media.interaktif;
public class mhs_main {
    public static void main(String[]args){
        try{
            Mahasiswa mhs = new Mahasiswa();
            mhs.setVisible(true);
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
