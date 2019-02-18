/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencelaboratorysystem;

import static com.github.lgooddatepicker.durationpicker_underconstruction.DurationUnit.Month;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadiqeen
 */
public class editchemical extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    String ID = "";
   
    public editchemical(String recieve) {
        initComponents();
        con = connect.ConnectDB();
        ID = recieve;
        setdata();
        this.setIconImage(new ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/ico.png")).getImage());
    }
    
    public void setdata(){
        try {
            String storage = "";
            String status = "";
            String expire = "";
            String ordered = "";
            try {
                sql = "SELECT * FROM `chemical` WHERE`ID` = '" + ID + "'";
                pst = con.prepareCall(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    id.setText(rs.getString("ID"));
                    chemical.setText(rs.getString("Chemical"));
                    fomula.setText(rs.getString("chemical_fomula"));
                    price.setText(rs.getString("price"));
                    expire = rs.getString("expire_date");
                    ordered = rs.getString("order_date");
                    storage = rs.getString("storage");
                    status = rs.getString("status");
                }
            } catch (SQLException ex) {
                Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
            }
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date a = dateFormat.parse(expire);
            Date b = dateFormat.parse(ordered);
            expiredate.setDate(a);
            ordereddate.setDate(b);
            showcombo (1);
            showcombo (2);
            storagecom.setSelectedItem(getkey(storage,1));
            statuscom.setSelectedItem(getkey(status,2));
        } catch (ParseException ex) {
            Logger.getLogger(editchemical.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showcombo (int a) {
        String label;
        if (a == 1){
            sql = "SELECT * FROM `storage`";
        } else if (a == 2){
            sql = "SELECT * FROM `status` WHERE `id` < 2";
        }
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (a == 1){
                    label = rs.getString("place");
                    storagecom.addItem(label);
                } else if (a == 2) {
                    label = rs.getString("status");
                    statuscom.addItem(label);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getkey(String check , int a) {
        String get = "";
        if (a == 1) {
            sql = "SELECT * FROM `storage` WHERE id = '" + check + "'";
        } else if (a == 2) {
            sql = "SELECT * FROM `status` WHERE id = '" + check + "'";
        }
        
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                if (a == 1) {
                    get = rs.getString("place");
                } else if (a == 2) {
                    get = rs.getString("status");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return get;
    }
    
    public int getvalue ( int a) {
        int get = 0;
        if (a == 1) {
            sql = "SELECT * FROM `storage` WHERE place = '" + storagecom.getSelectedItem().toString() + "'";
        } else if (a == 2) {
            sql = "SELECT * FROM `status` WHERE status = '" + statuscom.getSelectedItem().toString() + "'";
        }
        
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                get = Integer.parseInt(rs.getString("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return get;
    }
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        chemical = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        statuscom = new javax.swing.JComboBox<>();
        storagecom = new javax.swing.JComboBox<>();
        expiredate = new org.jdesktop.swingx.JXDatePicker();
        ordereddate = new org.jdesktop.swingx.JXDatePicker();
        fomula = new javax.swing.JTextField();
        fomular = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit chemical | Science Laboratory System");
        setBackground(new java.awt.Color(28, 35, 41));
        setMinimumSize(new java.awt.Dimension(400, 515));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 416));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ดัชนี");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 80, 30);

        id.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(id);
        id.setBounds(120, 110, 260, 30);

        chemical.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        chemical.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(chemical);
        chemical.setBounds(120, 150, 260, 30);

        price.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(price);
        price.setBounds(120, 310, 260, 30);

        jLabel8.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("วันสั่งซื้อ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 230, 80, 30);

        jLabel7.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ชื่อสาร");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 150, 80, 30);

        jLabel9.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("ราคา/หน่วย");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 310, 80, 30);

        jLabel6.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("สถานะ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 390, 90, 30);

        statuscom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statuscomActionPerformed(evt);
            }
        });
        getContentPane().add(statuscom);
        statuscom.setBounds(120, 390, 260, 30);

        getContentPane().add(storagecom);
        storagecom.setBounds(120, 350, 260, 30);
        getContentPane().add(expiredate);
        expiredate.setBounds(120, 270, 260, 30);
        getContentPane().add(ordereddate);
        ordereddate.setBounds(120, 230, 260, 30);

        fomula.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        fomula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(fomula);
        fomula.setBounds(120, 190, 260, 30);

        fomular.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        fomular.setForeground(new java.awt.Color(255, 255, 255));
        fomular.setText("สูตรเคมี");
        getContentPane().add(fomular);
        fomular.setBounds(20, 190, 80, 30);

        jLabel11.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("วันหมดอายุ");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 270, 80, 30);

        jLabel10.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ที่เก็บ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 350, 90, 30);

        jLabel1.setBackground(new java.awt.Color(28, 35, 41));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/login/login.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 400);

        jPanel1.setBackground(new java.awt.Color(28, 35, 41));

        cancel.setBackground(new java.awt.Color(193, 41, 43));
        cancel.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("ยกเลิก");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(107, 166, 16));
        save.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("บันทึก");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 390, 400, 110);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dFormat.format(ordereddate.getDate());
        String date2 = dFormat.format(expiredate.getDate());
        int str = getvalue(1);
        int stt = getvalue(2);
        System.out.println(stt);
        try {
                Statement st = con.createStatement();
                st.executeUpdate("UPDATE `chemical` SET "
                        + "`ID`= '" + id.getText()
                        + "',`chemical`= '" + chemical.getText()
                        + "',`chemical_fomula`= '" + fomula.getText()
                        + "',`expire_date`= '" + date2
                        + "',`order_date`= '"  + date
                        + "',`price`= '" + price.getText()
                        + "',`storage`= '" + str
                        + "',`status`= '" + stt
                        + "' WHERE `ID` = '" + ID + "'");
                JOptionPane.showMessageDialog(null, "Save chemical!", 
                        "Complete", JOptionPane.INFORMATION_MESSAGE);
                dispose();
        } catch (SQLException ex) {
                Logger.getLogger(addequipment.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Sorry! we got something"
                         + " wrong ,please contact administrator", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void statuscomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statuscomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statuscomActionPerformed

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
            java.util.logging.Logger.getLogger(editchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editchemical("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField chemical;
    private org.jdesktop.swingx.JXDatePicker expiredate;
    private javax.swing.JTextField fomula;
    private javax.swing.JLabel fomular;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker ordereddate;
    private javax.swing.JTextField price;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> statuscom;
    private javax.swing.JComboBox<String> storagecom;
    // End of variables declaration//GEN-END:variables
}
