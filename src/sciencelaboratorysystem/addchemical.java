/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencelaboratorysystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadiqeen
 */
public class addchemical extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    int checkuserexist,checkuserunregist,checkpassword,checkName,check;
   
    public addchemical() {
        initComponents();
        con = connect.ConnectDB();
        showstorage();
        this.setIconImage(new ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/ico.png")).getImage());
    }
    
    public void showstorage () {
        String storage;
        sql = "SELECT * FROM `storage`";
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                storage = rs.getString("Place");
                storagelist.addItem(storage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int check(String check , int a) {
        if (a == 1) {
        sql = "SELECT `chemical`.`id` FROM `chemical`";
        } else if (a == 2){
        sql = "SELECT `Place` FROM `storage`";
        }
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String checkfromdatabase = rs.getString(1);
                if (checkfromdatabase.equals(check)){
                    return 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public String getkeystorage () {
        String storagecheck = (String) storagelist.getSelectedItem();
        String get = "";
        sql = "SELECT * FROM `storage` WHERE Place = '" + storagecheck + "'";
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {                
                get = rs.getString("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return get;
    }
    
    public void writedata() {
        int p = Integer.parseInt(price1.getText());
        int storagelistnum = Integer.parseInt(getkeystorage());
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        String date = dFormat.format(Odered.getDate());
        String date2 = dFormat.format(expire.getDate());
        try {
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO `chemical`(`ID`, `chemical`, `chemical_fomula`, "
                        + "`expire_date`, `order_date`, `price`, `storage`, `status`) VALUES "
                        + "('" + id.getText() 
                        + "','" + chemical.getText() 
                        + "','" + fomular.getText() 
                        + "','" + date2 
                        + "','" + date 
                        + "','" + p 
                        + "'," + storagelistnum 
                        + ",1)");
                
                JOptionPane.showMessageDialog(null, "Add chemical done!", 
                        "Complete", JOptionPane.INFORMATION_MESSAGE);
                dispose();
        } catch (SQLException ex) {
                Logger.getLogger(addchemical.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Sorry! we got something"
                         + " wrong ,please contact administrator", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int checkempty(){
        if (chemical.getText().length() == 0 || price1.getText().length() == 0 
                || id.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null, "Please fill all", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
            
        } else {
            return 1;
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

        jLabel4 = new javax.swing.JLabel();
        addplace = new javax.swing.JButton();
        storagelist = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        chemical = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Odered = new org.jdesktop.swingx.JXDatePicker();
        fomular = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        expire = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        price1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add chemical | Science Laboratory System");
        setBackground(new java.awt.Color(28, 35, 41));
        setMinimumSize(new java.awt.Dimension(400, 475));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 470));
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ที่เก็บ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 350, 60, 30);

        addplace.setBackground(new java.awt.Color(28, 35, 41));
        addplace.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        addplace.setForeground(new java.awt.Color(255, 255, 255));
        addplace.setText("+");
        addplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addplaceActionPerformed(evt);
            }
        });
        getContentPane().add(addplace);
        addplace.setBounds(340, 350, 40, 30);

        storagelist.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        storagelist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storagelistActionPerformed(evt);
            }
        });
        getContentPane().add(storagelist);
        storagelist.setBounds(120, 350, 210, 30);

        jPanel1.setBackground(new java.awt.Color(28, 35, 41));

        add.setBackground(new java.awt.Color(107, 166, 16));
        add.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("เพิ่ม");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(193, 41, 43));
        cancel.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("ยกเลิก");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 370, 400, 110);

        jLabel2.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ชื่อสาร");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 80, 30);

        chemical.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        chemical.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(chemical);
        chemical.setBounds(120, 150, 260, 30);

        jLabel3.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("สูตรเคมี");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 190, 80, 30);

        Odered.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        Odered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OderedActionPerformed(evt);
            }
        });
        getContentPane().add(Odered);
        Odered.setBounds(120, 230, 260, 30);

        fomular.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        fomular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(fomular);
        fomular.setBounds(120, 190, 260, 30);

        jLabel8.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ราคา/หน่วย");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 310, 100, 30);

        jLabel7.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("วันที่สั่ง");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 230, 90, 30);

        id.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(id);
        id.setBounds(120, 110, 260, 30);

        jLabel5.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ดัชนี");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 110, 80, 30);

        expire.setFont(new java.awt.Font("Quark", 1, 24)); // NOI18N
        getContentPane().add(expire);
        expire.setBounds(120, 270, 260, 30);

        jLabel9.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("วันหมดอายุ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 270, 90, 30);

        price1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        price1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(price1);
        price1.setBounds(120, 310, 260, 30);

        jLabel1.setBackground(new java.awt.Color(28, 35, 41));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/login/login.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 400);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        int checkchemical;
        int checktextfiel = checkempty();
        if (checktextfiel == 1) {
            checkchemical = check(id.getText() ,1);
            if (checkchemical == 1) {
                JOptionPane.showMessageDialog(null, "Sorry your ID is Exist", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                writedata();

            }
        }

    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void addplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addplaceActionPerformed
        String addplace = JOptionPane.showInputDialog(null, "Input new place",
                "Add more storage place", JOptionPane.QUESTION_MESSAGE);
        int checkplace = check(addplace ,2);
        if (checkplace == 1) {
            JOptionPane.showMessageDialog(null, "Sorry your place is Exist", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO `storage`(`place`) VALUES ('" + addplace + "')");
            } catch (SQLException ex) {
                Logger.getLogger(addchemical.class.getName()).log(Level.SEVERE, null, ex);
            }
            storagelist.addItem(addplace);
        }
    }//GEN-LAST:event_addplaceActionPerformed

    private void storagelistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storagelistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_storagelistActionPerformed

    private void OderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OderedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OderedActionPerformed

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
            java.util.logging.Logger.getLogger(addchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addchemical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addchemical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker Odered;
    private javax.swing.JButton add;
    private javax.swing.JButton addplace;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField chemical;
    private org.jdesktop.swingx.JXDatePicker expire;
    private javax.swing.JTextField fomular;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField price1;
    private javax.swing.JComboBox<String> storagelist;
    // End of variables declaration//GEN-END:variables
}
