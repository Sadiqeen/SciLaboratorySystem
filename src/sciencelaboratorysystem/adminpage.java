package sciencelaboratorysystem;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sadiqeen
 */
public class adminpage extends javax.swing.JFrame {
    
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    String get;

    /**
     * Creates new form adminpage
     */
    public adminpage() {
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        con = connect.ConnectDB();
        showdata();
        setbutton();
        this.setIconImage(new ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/ico.png")).getImage());

    }
    
    private void showdata(){
        String tableshow = choosetable.getSelectedItem().toString();
        String status = statuschoose.getSelectedItem().toString();
        if (tableshow.equals("Chemical") ){
            if(status.equals("Request in process")) {
                sql = "SELECT `borrow_chemical`.`ID`, `borrow_chemical`.`user_id` AS 'User ID', `borrow_chemical`.`chemical_id` AS 'Chemical ID' , `chemical`.`chemical` AS 'Chemical Name' ,`borrow_chemical`.`Consentration`,"
                    + "`borrow_chemical`.`Quantity`,`borrow_chemical`.`borrow_date` AS Reques,`status`.`status` AS Status FROM `borrow_chemical`, "
                    + "`user`,`chemical`,`status` WHERE `borrow_chemical`.`user_id` = `user`.`id` AND "
                    + "`borrow_chemical`.`chemical_id` =`chemical`.`ID` AND `borrow_chemical`.`status`=`status`.`id` AND "
                    + "`borrow_chemical`.`status` = 2";
            } else {
               sql = "SELECT `borrow_chemical`.`ID`, `borrow_chemical`.`user_id` AS 'User ID', `borrow_chemical`.`chemical_id` AS 'Chemical ID' , `chemical`.`chemical` AS 'Chemical Name' ,`borrow_chemical`.`Consentration`,"
                    + "`borrow_chemical`.`Quantity`,`borrow_chemical`.`borrow_date` AS Reques,`status`.`Status` FROM `borrow_chemical`, "
                    + "`user`,`chemical`,`status` WHERE `borrow_chemical`.`user_id` = `user`.`id` AND "
                    + "`borrow_chemical`.`chemical_id` =`chemical`.`ID` AND `borrow_chemical`.`status`=`status`.`id` AND "
                    + "`borrow_chemical`.`status` = 2";
            }
            
        } else {
            if(status.equals("Request in process")) {
                sql = "SELECT `borrow_equipment`.`ID`, `user`.`ID` AS 'User ID', `equipment`.`Equipment`,"
                    + " `borrow_equipment`.`Quantity`, `borrow_equipment`.`Borrow_date` AS 'Borrow',"
                    + " `borrow_equipment`.`Return_date` AS 'Return',`status`.`Status` "
                    + "FROM `borrow_equipment`, `user`,`equipment`,`status`  "
                    + "WHERE `borrow_equipment`.`user_id` = `user`.`id` "
                    + "AND `borrow_equipment`.`equipment_id` = `equipment`.`ID` "
                    + "AND `borrow_equipment`.`status` = `status`.`id` "
                    + "AND `borrow_equipment`.`status` = 2";
            } else {
                   sql = "SELECT `borrow_equipment`.`ID`, `user`.`id` AS 'User ID', `equipment`.`Equipment`,"
                    + " `borrow_equipment`.`Quantity`, `borrow_equipment`.`borrow_date` AS 'Borrow',"
                    + " `borrow_equipment`.`return_date` AS 'Return',`status`.`Status` "
                    + "FROM `borrow_equipment`, `user`,`equipment`,`status`  "
                    + "WHERE `borrow_equipment`.`user_id` = `user`.`id` "
                    + "AND `borrow_equipment`.`equipment_id` = `equipment`.`ID` "
                    + "AND `borrow_equipment`.`status` = `status`.`id` "
                    + "AND `borrow_equipment`.`status` BETWEEN 3 AND 4";
            }
            
        }
        
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            tableborrow.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
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

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableborrow = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        manageequipment = new javax.swing.JButton();
        manageuser = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        information = new javax.swing.JButton();
        confirmborrow = new javax.swing.JButton();
        deny = new javax.swing.JButton();
        confirmreturn = new javax.swing.JButton();
        choosetable = new javax.swing.JComboBox<>();
        statuschoose = new javax.swing.JComboBox<>();
        searchInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Welcom to Science Laboratory System");
        setMinimumSize(new java.awt.Dimension(1247, 600));

        jPanel1.setBackground(new java.awt.Color(28, 35, 41));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/studentpage/titleIMG.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(252, 148, 13));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(28, 35, 41));
        jPanel3.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        tableborrow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableborrow.setRowHeight(25);
        jScrollPane3.setViewportView(tableborrow);

        jPanel3.add(jScrollPane3);

        jPanel4.setBackground(new java.awt.Color(28, 35, 41));
        jPanel4.setMaximumSize(new java.awt.Dimension(0, 52));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 52));
        jPanel4.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        jButton2.setBackground(new java.awt.Color(28, 35, 41));
        jButton2.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("จัดการสารเคมี");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        manageequipment.setBackground(new java.awt.Color(28, 35, 41));
        manageequipment.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        manageequipment.setForeground(new java.awt.Color(255, 255, 255));
        manageequipment.setText("จัดการอุปกรณ์");
        manageequipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageequipmentActionPerformed(evt);
            }
        });
        jPanel4.add(manageequipment);

        manageuser.setBackground(new java.awt.Color(28, 35, 41));
        manageuser.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        manageuser.setForeground(new java.awt.Color(255, 255, 255));
        manageuser.setText("จัดการผู้ใช้งาน");
        manageuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageuserActionPerformed(evt);
            }
        });
        jPanel4.add(manageuser);

        logout.setBackground(new java.awt.Color(28, 35, 41));
        logout.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Log Out");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(28, 35, 41));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        information.setBackground(new java.awt.Color(28, 35, 41));
        information.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        information.setForeground(new java.awt.Color(255, 255, 255));
        information.setText("โหลดข้อมูลใหม่");
        information.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informationActionPerformed(evt);
            }
        });
        jPanel6.add(information);

        confirmborrow.setBackground(new java.awt.Color(28, 35, 41));
        confirmborrow.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        confirmborrow.setForeground(new java.awt.Color(255, 255, 255));
        confirmborrow.setText("ยืนยันการขอยืม");
        confirmborrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmborrowActionPerformed(evt);
            }
        });
        jPanel6.add(confirmborrow);

        deny.setBackground(new java.awt.Color(28, 35, 41));
        deny.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        deny.setForeground(new java.awt.Color(255, 255, 255));
        deny.setText("ปฏิเสธการขอยืม");
        deny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyActionPerformed(evt);
            }
        });
        jPanel6.add(deny);

        confirmreturn.setBackground(new java.awt.Color(28, 35, 41));
        confirmreturn.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        confirmreturn.setForeground(new java.awt.Color(255, 255, 255));
        confirmreturn.setText("ยืนยันการคืน");
        confirmreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmreturnActionPerformed(evt);
            }
        });
        jPanel6.add(confirmreturn);

        choosetable.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        choosetable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chemical", "Equipment" }));
        choosetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosetableActionPerformed(evt);
            }
        });
        jPanel6.add(choosetable);

        statuschoose.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        statuschoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Request in process", "Return awaiting" }));
        statuschoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statuschooseActionPerformed(evt);
            }
        });
        jPanel6.add(statuschoose);

        searchInput.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        searchInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchInputKeyReleased(evt);
            }
        });
        jPanel6.add(searchInput);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void manageequipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageequipmentActionPerformed
        manageequipment sc = new manageequipment();
        sc.setVisible(true);
        dispose();
    }//GEN-LAST:event_manageequipmentActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        managechemical sc = new managechemical();
        sc.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        mainpage sc = new mainpage();
        sc.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void manageuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageuserActionPerformed
        manageuser sc = new manageuser();
        sc.setVisible(true);
        dispose();
    }//GEN-LAST:event_manageuserActionPerformed

    private void choosetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosetableActionPerformed
       showdata();
    }//GEN-LAST:event_choosetableActionPerformed

    private void informationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informationActionPerformed
        showdata();
    }//GEN-LAST:event_informationActionPerformed

    private void confirmborrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmborrowActionPerformed
        String tableshow = choosetable.getSelectedItem().toString();
        int row = tableborrow.getSelectedRow();
        String get = tableborrow.getValueAt(row, 0).toString();
            if (tableshow.equals("Chemical")){
                sql = "UPDATE `borrow_chemical` SET `status`= 3 WHERE `id` = " + get;
            } else {
                sql = "UPDATE `borrow_equipment` SET `status`= 3 WHERE `id` = " + get;
            }

            try {
                Statement st = con.createStatement();
                st.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(addequipment.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null,"Confirm success!");
            showdata();

        
    }//GEN-LAST:event_confirmborrowActionPerformed

    private void searchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyReleased
        DefaultTableModel table = (DefaultTableModel)tableborrow.getModel();
        String search = searchInput.getText();
        TableRowSorter sorter = new TableRowSorter(tableborrow.getModel());
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableborrow.setRowSorter(tr);
        System.out.println(search);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchInputKeyReleased

    private void statuschooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statuschooseActionPerformed
        setbutton();
        showdata();
    }//GEN-LAST:event_statuschooseActionPerformed

    private void confirmreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmreturnActionPerformed
        String tableshow = choosetable.getSelectedItem().toString();
        int row = tableborrow.getSelectedRow();
        String get = tableborrow.getValueAt(row, 0).toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        Date date = new Date();
        String datewrite = dateFormat.format(date);
           
                if (tableshow.equals("Equipment")){
                    try {
                        Statement st = con.createStatement();
                        st.executeUpdate("UPDATE `borrow_equipment` SET `status`= 5 , `return_date`= '" + datewrite + "' WHERE `id` = " + get);
                        st.executeUpdate("UPDATE `equipment` SET `Quantity` = '" + getquantity() + "' WHERE `id` = " + getequipmentid());
                        JOptionPane.showMessageDialog(null,"Confirm success!");    
                    } catch (SQLException ex) {
                        Logger.getLogger(addequipment.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    showdata();
                }
    }//GEN-LAST:event_confirmreturnActionPerformed

    private void denyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyActionPerformed
        String tableshow = choosetable.getSelectedItem().toString();
        int row = tableborrow.getSelectedRow();
        get = tableborrow.getValueAt(row, 0).toString();
            try {
                Statement st = con.createStatement();
                if (tableshow.equals("Chemical")){
                     st.executeUpdate("UPDATE `borrow_chemical` SET `status`= 7 WHERE `id` = " + get);
                } else {
                     st.executeUpdate("UPDATE `borrow_equipment` SET `status`= 7 WHERE `id` = " + get);
                     st.executeUpdate("UPDATE `equipment` SET `Quantity`= '" + getquantity() + "' WHERE `id` = " + getequipmentid());
                }
                JOptionPane.showMessageDialog(null,"Deny reques success!");
            } catch (SQLException ex) {
                Logger.getLogger(addequipment.class.getName()).log(Level.SEVERE, null, ex);
            }
            showdata();
    }//GEN-LAST:event_denyActionPerformed

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
            java.util.logging.Logger.getLogger(adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> choosetable;
    private javax.swing.JButton confirmborrow;
    private javax.swing.JButton confirmreturn;
    private javax.swing.JButton deny;
    private javax.swing.JButton information;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton logout;
    private javax.swing.JButton manageequipment;
    private javax.swing.JButton manageuser;
    private javax.swing.JTextField searchInput;
    private javax.swing.JComboBox<String> statuschoose;
    private javax.swing.JTable tableborrow;
    // End of variables declaration//GEN-END:variables

    private void setbutton() {
        String status = statuschoose.getSelectedItem().toString();
        String table = choosetable.getSelectedItem().toString();
        if(status.equals("Return awaiting") &&  table.equals("Chemical")) {
            confirmreturn.setEnabled(false);
            confirmborrow.setEnabled(false);
            deny.setEnabled(false);
        } else if (status.equals("Request in process")) {
            confirmreturn.setEnabled(false);
            confirmborrow.setEnabled(true);
            deny.setEnabled(true);
        } else {
            confirmreturn.setEnabled(true);
            confirmborrow.setEnabled(false);
            deny.setEnabled(false);
        }
    }
    
    private int getquantity(){
        int row = tableborrow.getSelectedRow();
        get = tableborrow.getValueAt(row, 0).toString();
        int borrowquantiy = 0;
        int quantiy = 0;
        for (int i = 0; i < 2; i++) {
            if (i ==0){
                sql = "SELECT * FROM `borrow_equipment` WHERE `id` = " + get;
            } else if (i == 1) {
                sql = "SELECT * FROM `equipment` WHERE `id` = '" + getequipmentid() +"'";
            }
            try {
                pst = con.prepareCall(sql);
                rs = pst.executeQuery();
                if (rs.next()){
                    if (i ==0){
                        borrowquantiy = Integer.parseInt(rs.getString("quantity"));
                    } else if (i == 1) {
                        quantiy = Integer.parseInt(rs.getString("quantity"));
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return borrowquantiy + quantiy;
    }
    
    private String getequipmentid(){
        int row = tableborrow.getSelectedRow();
        get = tableborrow.getValueAt(row, 0).toString();
        String id = "";
        sql = "SELECT * FROM `borrow_equipment` WHERE `id` = " + get;
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                id = rs.getString("equipment_id");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(id);
        return id;
    }

}