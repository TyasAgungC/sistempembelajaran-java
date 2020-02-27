package media.interaktif;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Materi extends javax.swing.JFrame {
    private DefaultTableModel tabmode;
    private ResultSet hasil;
    
    CRUDmateri materi = new CRUDmateri();
    
    public Materi() {
        initComponents();
        setLocationRelativeTo(null);
        //tampil_database();
    }
    
    public void tampil_database1(){
        Object[]baris = {"bab", "urutan_bab", "sub_materi", "urutan_sub", "uraian"};
        tabmode = new DefaultTableModel(null, baris);
        tbl_materi.setModel(tabmode);
        try{
            hasil = materi.tampilData1();
            while(hasil.next()){
                materi.setBab(hasil.getString("bab"));
                materi.setUrutanBab(hasil.getInt("urutan_bab"));
                materi.setSubMateri(hasil.getString("sub_materi"));
                materi.setUrutanSub(hasil.getInt("urutan_sub"));
                materi.setUraian(hasil.getString("uraian"));
                Object[] data = {materi.getBab(), materi.getUrutanBab(), materi.getSubMateri(), materi.getUrutanSub(), materi.getUraian()};
                tabmode.addRow(data);
            } 
        } catch(Exception e){
        }
    }
    
    public void tampil_database2(){
        Object[]baris = {"bab", "urutan_bab", "sub_materi", "urutan_sub", "uraian"};
        tabmode = new DefaultTableModel(null, baris);
        tbl_materi.setModel(tabmode);
        try{
            hasil = materi.tampilData2();
            while(hasil.next()){
                materi.setBab(hasil.getString("bab"));
                materi.setUrutanBab(hasil.getInt("urutan_bab"));
                materi.setSubMateri(hasil.getString("sub_materi"));
                materi.setUrutanSub(hasil.getInt("urutan_sub"));
                materi.setUraian(hasil.getString("uraian"));
                Object[] data = {materi.getBab(), materi.getUrutanBab(), materi.getSubMateri(), materi.getUrutanSub(), materi.getUraian()};
                tabmode.addRow(data);
            } 
        } catch(Exception e){
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_materi = new javax.swing.JTable();
        btn_kembali = new javax.swing.JButton();
        cb_pilih = new javax.swing.JComboBox();
        btn_ok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_materi = new javax.swing.JTextArea();

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("PILIHAN GANDA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("MATERI");

        tbl_materi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_materiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_materi);

        btn_kembali.setText("Kembali");
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });

        cb_pilih.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enkapsulasi", "Abstract Class", "Interface", "Polymorphism" }));
        cb_pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pilihActionPerformed(evt);
            }
        });

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        jLabel2.setText("Pilihan Materi");

        ta_materi.setColumns(20);
        ta_materi.setRows(5);
        jScrollPane3.setViewportView(ta_materi);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cb_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(btn_ok)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_kembali)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ok)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btn_kembali)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        String mtr = (String)cb_pilih.getSelectedItem();
        if(mtr=="Enkapsulasi"){
            Object[]baris = {"bab", "urutan_bab", "sub_materi", "urutan_sub", "uraian"};
            tabmode = new DefaultTableModel(null, baris);
            tbl_materi.setModel(tabmode);
            try{
                hasil = materi.tampilData1();
                while(hasil.next()){
                    materi.setBab(hasil.getString("bab"));
                    materi.setUrutanBab(hasil.getInt("urutan_bab"));
                    materi.setSubMateri(hasil.getString("sub_materi"));
                    materi.setUrutanSub(hasil.getInt("urutan_sub"));
                    materi.setUraian(hasil.getString("uraian"));
                    Object[] data = {materi.getBab(), materi.getUrutanBab(), materi.getSubMateri(), materi.getUrutanSub(), materi.getUraian()};
                    tabmode.addRow(data);
                } 
            } catch(Exception e){
            }
        } else if(mtr=="Abstract Class"){
            Object[]baris = {"bab", "urutan_bab", "sub_materi", "urutan_sub", "uraian"};
            tabmode = new DefaultTableModel(null, baris);
            tbl_materi.setModel(tabmode);
            try{
                hasil = materi.tampilData2();
                while(hasil.next()){
                    materi.setBab(hasil.getString("bab"));
                    materi.setUrutanBab(hasil.getInt("urutan_bab"));
                    materi.setSubMateri(hasil.getString("sub_materi"));
                    materi.setUrutanSub(hasil.getInt("urutan_sub"));
                    materi.setUraian(hasil.getString("uraian"));
                    Object[] data = {materi.getBab(), materi.getUrutanBab(), materi.getSubMateri(), materi.getUrutanSub(), materi.getUraian()};
                    tabmode.addRow(data);
                } 
            } catch(Exception e){
            }
        } else {
            System.out.println("Error");
        }
    }//GEN-LAST:event_btn_okActionPerformed

    private void cb_pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pilihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_pilihActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        // TODO add your handling code here:
        Beranda n = new Beranda();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void tbl_materiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_materiMouseClicked
        try {
            int row = tbl_materi.rowAtPoint(evt.getPoint());
            
            String bab = tbl_materi.getValueAt(row, 0).toString();
            String urutan_bab = tbl_materi.getValueAt(row, 1).toString();
            String sub_materi = tbl_materi.getValueAt(row, 2).toString();
            String urutan_sub = tbl_materi.getValueAt(row, 3).toString();
            String uraian = tbl_materi.getValueAt(row, 4).toString();

            ta_materi.setText(String.valueOf(uraian));
            //ta_pilgan.setText(String.valueOf(pilihan_a));
            //ta_pilgan.setText(String.valueOf(pilihan_b));
            //ta_pilgan.setText(String.valueOf(pilihan_c));
            //ta_pilgan.setText(String.valueOf(pilihan_d));

        } catch(Exception e){

        }
    }//GEN-LAST:event_tbl_materiMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Materi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Materi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Materi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Materi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Materi().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox cb_pilih;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea ta_materi;
    private javax.swing.JTable tbl_materi;
    // End of variables declaration//GEN-END:variables
}
