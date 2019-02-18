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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadiqeen
 */
public class addequipment extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    int checkuserexist,checkuserunregist,checkpassword,checkName,check;
   
    public addequipment() {
        initComponents();
        con = connect.ConnectDB();
        showbrand();
        this.setIconImage(new ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/ico.png")).getImage());
    }
    
    public void showbrand () {
        String brand;
        sql = "SELECT `id`, `Brand` FROM `e_brand`";
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                brand = rs.getString("Brand");
                brandlist.addItem(brand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int check(String check , int a) {
        if (a == 1) {
        sql = "SELECT `equipment`.`Equipment` FROM `equipment`";
        } else if (a == 2){
        sql = "SELECT `Brand` FROM `e_brand`";
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
    
    public String getkeybrand () {
        String brandcheck = (String) brandlist.getSelectedItem();
        String get = "";
        sql = "SELECT * FROM `e_brand` WHERE brand = '" + brandcheck + "'";
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
        String eq = equipment.getText();
        int p = Integer.parseInt(price1.getText());
        int q = Integer.parseInt(quantity.getText());
        int brandlistnum = Integer.parseInt(getkeybrand());
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dFormat.format(datec.getDate());
        System.out.println(brandlistnum);
        try {
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO `equipment`(`id`,`Equipment`, `Ordered`"
                        + ", `Price`, `Quantity`, `brand`) VALUES"
                        + " (null,'" + eq + "','" + date + "','" + p + "','" + q + "','" + brandlistnum +"')");
                JOptionPane.showMessageDialog(null, "Add equipment done!", 
                        "Complete", JOptionPane.INFORMATION_MESSAGE);
                dispose();
        } catch (SQLException ex) {
                Logger.getLogger(addequipment.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Sorry! we got something"
                         + " wrong ,please contact administrator", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int checkempty(){
        if (equipment.getText().length() == 0 || price1.getText().length() == 0 
                || quantity.getText().length() == 0 ){
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

        jLabel2 = new javax.swing.JLabel();
        equipment = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datec = new org.jdesktop.swingx.JXDatePicker();
        addbrand = new javax.swing.JButton();
        quantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        price1 = new javax.swing.JTextField();
        brandlist = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add eqiupment | Science Laboratory System");
        setBackground(new java.awt.Color(28, 35, 41));
        setMaximumSize(new java.awt.Dimension(400, 382));
        setMinimumSize(new java.awt.Dimension(400, 410));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 470));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ชื่ออุปกรณ์");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 80, 30);

        equipment.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        equipment.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(equipment);
        equipment.setBounds(120, 110, 260, 30);

        jLabel3.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ปริมาณ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 230, 80, 30);

        jLabel4.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("แบรนด์");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 270, 60, 30);

        datec.setFont(new java.awt.Font("Angsana New", 1, 24)); // NOI18N
        getContentPane().add(datec);
        datec.setBounds(120, 150, 260, 30);

        addbrand.setBackground(new java.awt.Color(28, 35, 41));
        addbrand.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        addbrand.setForeground(new java.awt.Color(255, 255, 255));
        addbrand.setText("+");
        addbrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbrandActionPerformed(evt);
            }
        });
        getContentPane().add(addbrand);
        addbrand.setBounds(80, 270, 40, 30);

        quantity.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(quantity);
        quantity.setBounds(120, 230, 260, 30);

        jLabel8.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ราคา/หน่วย");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 190, 80, 30);

        jLabel7.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("วันที่สั่งซื้อ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 150, 90, 30);

        price1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        price1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(price1);
        price1.setBounds(120, 190, 260, 30);

        brandlist.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        brandlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandlistActionPerformed(evt);
            }
        });
        getContentPane().add(brandlist);
        brandlist.setBounds(120, 270, 260, 30);

        jPanel1.setBackground(new java.awt.Color(28, 35, 41));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 390, 400, 110);

        cancel.setBackground(new java.awt.Color(193, 41, 43));
        cancel.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("ยกเลิก");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(20, 320, 170, 40);

        add.setBackground(new java.awt.Color(107, 166, 16));
        add.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("เพิ่ม");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(210, 320, 170, 40);

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
            checkchemical = check(equipment.getText() ,1);
            if (checkchemical == 1) {
                JOptionPane.showMessageDialog(null, "Sorry your equipment is Exist", 
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                writedata();

            }
        }

    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void addbrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbrandActionPerformed
        String addbrand = JOptionPane.showInputDialog(null, "Input new brand",
                "Add more brand", JOptionPane.QUESTION_MESSAGE);
        int checkbrand = check(addbrand ,2);
        if (checkbrand == 1) {
            JOptionPane.showMessageDialog(null, "Sorry your brand is Exist", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Statement st = con.createStatement();
                st.executeUpdate("INSERT INTO `e_brand`(`Brand`) VALUES ('" + addbrand + "')");
            } catch (SQLException ex) {
                Logger.getLogger(addequipment.class.getName()).log(Level.SEVERE, null, ex);
            }
            brandlist.addItem(addbrand);
        }
    }//GEN-LAST:event_addbrandActionPerformed

    private void brandlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandlistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brandlistActionPerformed

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
            java.util.logging.Logger.getLogger(addequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addequipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addequipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton addbrand;
    private javax.swing.JComboBox<String> brandlist;
    private javax.swing.JButton cancel;
    private org.jdesktop.swingx.JXDatePicker datec;
    private javax.swing.JTextField equipment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField price1;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}
