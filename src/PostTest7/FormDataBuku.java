/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PostTest7;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ARIF
 */
public class FormDataBuku extends javax.swing.JFrame {
    
    private DefaultTableModel model; //untuk membuat model pada tabel
    private Connection con = koneksi.getConnection(); //untuk mengambil koneksi
    private Statement stt; // untuk eksekusi query
    private ResultSet rss; //untuk menampung data
    private PreparedStatement pst;
    /**
     * Creates new form FormDataBuku
     */
    public FormDataBuku() {
        initComponents();
    }

    private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("ID BUKU");
        model.addColumn("JUDUL");
        model.addColumn("PENULIS");
        model.addColumn("HARGA");
        
        Tbuku.setModel(model);
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        // TODO add your handling code here:
        Judul.setText("");
        Harga.setText("");
//        simpan.setEnabled(false);
//        ubah.setEnabled(false);
//        reset.setEnabled(false);
//        hapus.setEnabled(false);
    }
    
    private void TampilData(){
        try{
            String sql = "SELECT * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object [4];
                o[0] = rss.getString("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getInt("harga");
                model.addRow(o);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public boolean UbahData(String id, String judul, String penulis, String harga){
        try{
            String sql = "UPDATE buku set judul = '"+judul+"', penulis = '"+penulis+"', harga = "+harga+" WHERE id = "+id+";";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean HapusData(String id){
        try{
            String sql = "DELETE FROM buku WHERE id = "+id+";";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    private void TambahData(String judul, String penulis, int harga){
        try{
            
            String sql = "INSERT INTO buku VALUES (NULL, '"+judul+"','"+penulis+"',"+harga+")";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{judul,penulis,harga});
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        InitTable();
        TampilData();
    }
//    
//    private boolean validasi(String judul){
//        try{
//            String sql = "SELECT * FROM buku where judul = '"+judul+"'";
//            //stt = con.createStatement();
//            rss = stt.executeQuery(sql);
//            if (rss.next()) 
//                return true;
//            else
//                return false;
//        }
//        catch(SQLException e){
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
    
    private boolean validasi2(String judul,String penulis){
        try{
            //String sql = "SELECT * FROM buku where judul = '"+penulis+"'";
            String sql = "SELECT * FROM buku where judul = '"+judul+"' AND penulis = '"+penulis+"';";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            if (rss.next()) 
                return true;
            else
                return false;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    private void pencarian(String by, String cari){
        try{
            String sql = "select * from buku where "+by+" like '%"+cari+"%'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            //caritabel.setRowCount(0);
//            ResultSet rss = stt.executeQuery(sql);
                while(rss.next()){
                    Object[] o = new Object[4];
                    o[0] = rss.getString("id");
                    o[1] = rss.getString("judul");
                    o[2] = rss.getString("penulis");
                    o[3] = rss.getString("harga");
                    model.addRow(o);
                }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * 
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Judul = new javax.swing.JTextField();
        Harga = new javax.swing.JTextField();
        Penulis = new javax.swing.JComboBox();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        cbcari = new javax.swing.JComboBox();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbuku = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM DATA BUKU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("NAMA");

        jLabel3.setText("PENULIS");

        jLabel4.setText("HARGA");

        Judul.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                JudulCaretUpdate(evt);
            }
        });

        Harga.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                HargaCaretUpdate(evt);
            }
        });

        Penulis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tere Liye", "W.S Rendra", "Felix Siauw", "Asma Nadia", "Dewi Lestari" }));

        simpan.setText("Simpan");
        simpan.setEnabled(false);
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.setEnabled(false);
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.setEnabled(false);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        jLabel5.setText("Search :");

        cari.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                cariCaretUpdate(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariKeyTyped(evt);
            }
        });

        cbcari.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JUDUL", "PENULIS", "HARGA" }));
        cbcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcariActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.setEnabled(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbcari, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Penulis, 0, 275, Short.MAX_VALUE)
                                .addComponent(Judul)
                                .addComponent(Harga))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Judul, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Penulis, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Harga, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(hapus)
                    .addComponent(ubah)
                    .addComponent(reset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(cbcari)
                    .addComponent(keluar))
                .addGap(17, 17, 17))
        );

        Tbuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "JUDUL", "PENULIS", "HARGA"
            }
        ));
        Tbuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tbuku);

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DATA BUKU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_formComponentShown

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        
        if (Judul.getText().length()!=0 && Harga.getText().length()!=0) {
            
            simpan.setEnabled(true);
            reset.setEnabled(true);
            
            String judul = Judul.getText();
            String penulis = Penulis.getSelectedItem().toString();
            int harga = Integer.parseInt(Harga.getText());
            
            if (validasi2(judul,penulis)) {
                JOptionPane.showMessageDialog(null, "Judul dengan nama pengarang yang sama sudah tersedia");
            }
//            else if(validasi(judul)){
//                JOptionPane.showMessageDialog(null, "Nama Judul tidak boleh sama");
//            }
            else{
            TambahData(judul, penulis, harga);
            }
        }
        else {
        JOptionPane.showMessageDialog(this, "Isi Data Terlebih Dahulu");
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void cbcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcariActionPerformed

    private void cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyTyped

    }//GEN-LAST:event_cariKeyTyped

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        int baris = Tbuku.getSelectedRow();
        String id = Tbuku.getValueAt(baris, 0).toString();
        String judul = Judul.getText();
        String penulis = Penulis.getSelectedItem().toString();
        String harga = Harga.getText();
        if(UbahData(id,judul,penulis,harga)){
            JOptionPane.showMessageDialog(null, "Berhasil Ubah Data");
            Judul.setText(null);
            Penulis.setSelectedItem("");
            Harga.setText(null);
            Judul.requestFocus(); 
        }
        else{
            JOptionPane.showConfirmDialog(null, "Gagal Ubah Data");
            
        }
        InitTable();
        TampilData();
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        int baris = Tbuku.getSelectedRow();
        String id = Tbuku.getValueAt(baris, 0).toString();
        if(HapusData(id)){
            JOptionPane.showMessageDialog(null, "Berhasil Hapus Data");
        }
        else{
            JOptionPane.showConfirmDialog(null, "Gagal Hapus Data");
            
        }
        InitTable();
        TampilData();
    }//GEN-LAST:event_hapusActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        Judul.setText(null);
        Penulis.setSelectedItem("");
        Harga.setText(null);
        Judul.requestFocus(); 
    }//GEN-LAST:event_resetActionPerformed

    private void TbukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbukuMouseClicked
        // TODO add your handling code here:
        int baris = Tbuku.getSelectedRow();
        
        simpan.setEnabled(false);
        ubah.setEnabled(true);
        hapus.setEnabled(true);
        
        Judul.setText(Tbuku.getValueAt(baris, 1).toString());
        Penulis.setSelectedItem(Tbuku.getValueAt(baris, 2).toString());
        Harga.setText(Tbuku.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_TbukuMouseClicked

    private void cariCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_cariCaretUpdate
        // TODO add your handling code here:
        InitTable();
        if (cari.getText().length()==0) {
            TampilData();
        }
        else{
            pencarian(cbcari.getSelectedItem().toString(),cari.getText());
        }
    }//GEN-LAST:event_cariCaretUpdate

    private void JudulCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_JudulCaretUpdate
        // TODO add your handling code here:
        if (Judul.getText().length()== 0 || Harga.getText().length()==0) {
            simpan.setEnabled(false);
            reset.setEnabled(false);
        }
        else if (Judul.getText().length()!=0 && Harga.getText().length()!=0){
            simpan.setEnabled(true);
            reset.setEnabled(true);
        }
    }//GEN-LAST:event_JudulCaretUpdate

    private void HargaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_HargaCaretUpdate
        // TODO add your handling code here:
        if (Judul.getText().length()== 0 || Harga.getText().length()==0) {
            simpan.setEnabled(false);
            reset.setEnabled(false);
        }
        else if (Judul.getText().length()!=0 && Harga.getText().length()!=0){
            simpan.setEnabled(true);
            reset.setEnabled(true);
        }
    }//GEN-LAST:event_HargaCaretUpdate

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
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Harga;
    private javax.swing.JTextField Judul;
    private javax.swing.JComboBox Penulis;
    private javax.swing.JTable Tbuku;
    private javax.swing.JTextField cari;
    private javax.swing.JComboBox cbcari;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluar;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
