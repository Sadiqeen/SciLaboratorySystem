/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencelaboratorysystem;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sadiqeen
 */
public class studentpage extends javax.swing.JFrame {
    
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    String getid = "";
    String get = "";
    

    /**
     * Creates new form managechemical
     */
    public studentpage(String getid1) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        con = connect.ConnectDB();
        getid = getid1;
        showdatatable();
        showdatatableborrow();
        getuser();
        tableshow.setAutoCreateRowSorter(true);
        tableborrow.setAutoCreateRowSorter(true);
        this.setIconImage(new ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/ico.png")).getImage());
    }

    private studentpage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void getuser() {
        sql = "SELECT * FROM `user` WHERE `ID` = '" + getid + "'" ;
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                username.setText(rs.getString("firstname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void showdatatable(){
        String choosetable = (String) table.getSelectedItem();
        if (choosetable.equals("Chemical")){
            sql = "SELECT`chemical`. `ID`, `chemical`.`Chemical`,`chemical`.`chemical_fomula` AS 'Formula', "
                + " `storage`.`Place` FROM `chemical` , `storage`,`status` WHERE `chemical`.`storage`"
                + " = `storage`.`ID` AND `chemical`.`status` = `status`.`id`  AND `chemical`.`Status` = 1 ORDER BY `chemical`.`ID` ASC";
        } else if (choosetable.equals("Equipment")){
            sql = "SELECT `equipment`.`ID`, `equipment`.`Equipment` ,"
                + "`equipment`.`Quantity`, `e_brand`.`Brand` FROM `equipment` , "
                + "`e_brand` WHERE `equipment`.`brand` = `e_brand`.`id` AND `equipment`.`Quantity` != '0' ORDER BY `id` ASC";
        }
        
        
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            tableshow.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showdatatableborrow(){
        String choosetable = (String) table.getSelectedItem();
        if (choosetable.equals("Chemical")){
            sql = "SELECT `borrow_chemical`.`ID`,`chemical`.`Chemical`,`borrow_chemical`"
                    + ".`Consentration`,`borrow_chemical`.`Quantity`,`storage`.`Place`,"
                    + "`status`.`Status` FROM `status`,`borrow_chemical`,`chemical`,`user`,`storage`"
                    + " WHERE `borrow_chemical`.`user_id` = `user`.`id` AND `status`.`id` = `borrow_chemical`.`status` AND "
                    + "`chemical`.`ID` = `borrow_chemical`.`chemical_id`AND "
                    + "`chemical`.`storage` = `storage`.`id` "
                    + "AND `borrow_chemical`.`user_id` = " + getid;
        } else if (choosetable.equals("Equipment")){
            sql = "SELECT `borrow_equipment`.`ID`,`equipment`.`Equipment`, `borrow_equipment`.`Quantity`,"
                    + " `borrow_equipment`.`return_date` AS 'Return' , `status`.`Status` FROM `borrow_equipment`,"
                    + "`status`,`equipment`,`user` WHERE `borrow_equipment`.`user_id` = `user`.`id` "
                    + "AND `borrow_equipment`.`equipment_id` = `equipment`.`ID` AND"
                    + " `borrow_equipment`.`status` = `status`.`id` "
                    + "AND `user`.`id` = " + getid;
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

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        user = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        export = new javax.swing.JButton();
        table = new javax.swing.JComboBox<>();
        statuscom = new javax.swing.JComboBox<>();
        searchInput = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableshow = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableborrow = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        refresh = new javax.swing.JButton();
        borrowbutton = new javax.swing.JButton();
        cancelbutton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Welcome to Science Laboratory System");
        setMinimumSize(new java.awt.Dimension(800, 608));

        jPanel2.setBackground(new java.awt.Color(28, 35, 41));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/studentpage/titleIMG.png"))); // NOI18N

        logout.setBackground(new java.awt.Color(28, 35, 41));
        logout.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("ออกจากระบบ");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(252, 148, 13));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(252, 148, 13));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(28, 35, 41));
        jPanel6.setLayout(new java.awt.GridLayout(1, 5, 3, 3));

        user.setBackground(new java.awt.Color(28, 35, 41));

        username.setBackground(new java.awt.Color(255, 255, 255));
        username.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel6.add(user);

        export.setBackground(new java.awt.Color(28, 35, 41));
        export.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        export.setForeground(new java.awt.Color(255, 255, 255));
        export.setText("นำออก");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        jPanel6.add(export);

        table.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chemical", "Equipment" }));
        table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableActionPerformed(evt);
            }
        });
        jPanel6.add(table);

        statuscom.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        statuscom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทั้งหมด", "ส่งคำขอแล้ว", "อนุมัติคำขอ", "คำขอถูกปฏิเสธ", "ยืนยันการคืน", "ยกเลิก" }));
        statuscom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statuscomActionPerformed(evt);
            }
        });
        jPanel6.add(statuscom);

        searchInput.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        searchInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchInputKeyReleased(evt);
            }
        });
        jPanel6.add(searchInput);

        jPanel5.setBackground(new java.awt.Color(28, 35, 41));
        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 5, 0));

        tableshow.setModel(new javax.swing.table.DefaultTableModel(
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
        tableshow.setRowHeight(25);
        jScrollPane2.setViewportView(tableshow);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8);

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7);

        jPanel3.setBackground(new java.awt.Color(28, 35, 41));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        refresh.setBackground(new java.awt.Color(28, 35, 41));
        refresh.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("โหลดข้อมูลใหม่");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel3.add(refresh);

        borrowbutton.setBackground(new java.awt.Color(28, 35, 41));
        borrowbutton.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        borrowbutton.setForeground(new java.awt.Color(255, 255, 255));
        borrowbutton.setText("ส่งคำขอ");
        borrowbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrowbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(borrowbutton);

        cancelbutton.setBackground(new java.awt.Color(28, 35, 41));
        cancelbutton.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        cancelbutton.setForeground(new java.awt.Color(255, 255, 255));
        cancelbutton.setText("ยกเลิก");
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });
        jPanel3.add(cancelbutton);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        toexel sent = new toexel();
        String username = System.getProperty("user.name");
        File FileWriter = new File("C:\\Users\\"+username+"\\Desktop\\" + getid + ".xls");
        sent.toExcel(tableshow, FileWriter);
        JOptionPane.showMessageDialog(null, "Export file to desktop complete!", 
                        "Complete", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_exportActionPerformed

    private void searchInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyReleased
        DefaultTableModel table = (DefaultTableModel)tableshow.getModel();
        String search = searchInput.getText();
        TableRowSorter sorter = new TableRowSorter(tableshow.getModel());
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tableshow.setRowSorter(tr);
        System.out.println(search);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(search));
    }//GEN-LAST:event_searchInputKeyReleased

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        mainpage sc = new mainpage();
        sc.setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableActionPerformed
        showdatatable();
        showdatatableborrow();
    }//GEN-LAST:event_tableActionPerformed

    private void borrowbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrowbuttonActionPerformed
        String choosetable = (String) table.getSelectedItem();
        int row = tableshow.getSelectedRow();
        String get = tableshow.getValueAt(row, 0).toString();
        if (choosetable.equals("Chemical")){
            int check = checkborrow(get);
            if (check == 1) {
                allowborrowchemical sc = new allowborrowchemical(get,getid);
                sc.setVisible(true);
            }
        } else if (choosetable.equals("Equipment")){
            int check = checkborrow(get);
            if (check == 1) {
                allowborrowequipment sc = new allowborrowequipment(get,getid);
                sc.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_borrowbuttonActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        showdatatable();
        showdatatableborrow();
    }//GEN-LAST:event_refreshActionPerformed

    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed
        int check = checkcancelborrow();
        System.out.println(check);
        if (check == 1)  {
            delete(0);
        }
    }//GEN-LAST:event_cancelbuttonActionPerformed

    private void statuscomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statuscomActionPerformed
        String search = "";
        DefaultTableModel table = (DefaultTableModel)tableborrow.getModel();
        if (statuscom.getSelectedItem().toString().equals("ทั้งหมด")){
            search = "";
        } else {
            search = statuscom.getSelectedItem().toString();
        }
        TableRowSorter sorter = new TableRowSorter(tableborrow.getModel());
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        tableborrow.setRowSorter(tr);
        tr.setRowFilter(javax.swing.RowFilter.regexFilter(search));
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
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new studentpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrowbutton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelbutton;
    private javax.swing.JButton export;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logout;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField searchInput;
    private javax.swing.JComboBox<String> statuscom;
    private javax.swing.JComboBox<String> table;
    private javax.swing.JTable tableborrow;
    private javax.swing.JTable tableshow;
    private javax.swing.JPanel user;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

    private int checkborrow(String get) {
        String choosetable = (String) table.getSelectedItem();
        String getvaluedb = "";
        String getvaluestatus = "";
        String getstats = "";
        if (choosetable.equals("Chemical")){
            sql = "SELECT * FROM `borrow_chemical` WHERE `borrow_chemical`.`user_id` = " + getid + " AND `borrow_chemical`.`Chemical_id` = '" + get + "' AND `borrow_chemical`.`status` = 2  ORDER BY `borrow_chemical`.`id` DESC" ;
        } else if (choosetable.equals("Equipment")){
            sql = "SELECT * FROM `borrow_Equipment` WHERE `borrow_equipment`.`user_id` = " + getid + " AND `borrow_equipment`.`equipment_id` = '" + get + "' AND `borrow_equipment`.`status` = 2  ORDER BY `borrow_equipment`.`id` DESC";
        }
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            if  (rs.next()) {
                if (choosetable.equals("Chemical")){
                    getvaluedb = rs.getString("chemical_id");
                } else if (choosetable.equals("Equipment")){
                    getvaluedb = rs.getString("equipment_id");
                }
                getvaluestatus = rs.getString("status");
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(getvaluestatus);
        getstats = status(getvaluestatus);
        if (getvaluedb.equals(get) && !getvaluestatus.equals("5")) {
            JOptionPane.showMessageDialog(null, "You " + getstats + " this " + choosetable, "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        } else {
            return 1;
        }
    }

    private String status(String valuestatus) {
        String status = "";
        sql = "SELECT * FROM `status` WHERE id = '" + valuestatus + "'";
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                status = rs.getString("status");
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    private int checkcancelborrow() {
        String choosetable = (String) table.getSelectedItem();
        int row = tableborrow.getSelectedRow();
        String get = tableborrow.getValueAt(row, 0).toString();
        String check = "";
        if (choosetable.equals("Chemical")){
            sql = "SELECT * FROM `borrow_chemical` WHERE `borrow_chemical`.`id` = " + get;
        } else if (choosetable.equals("Equipment")){
            sql = "SELECT * FROM `borrow_Equipment` WHERE `borrow_equipment`.`id` = " + get;
        }
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                check = rs.getString("status");
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(check);
        if (check.equals("2")) {
            return 1;
        } else {
            return 0;
        }
        
    }

    private void delete(int a) {
        String choosetable = (String) table.getSelectedItem();
        int row = tableborrow.getSelectedRow();
        String get = tableborrow.getValueAt(row, 0).toString();
        String check = "";
        int reply = JOptionPane.showConfirmDialog(null, "Do you to cancel?", "Cancel", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
          try { 
            Statement st = con.createStatement();
            if (choosetable.equals("Chemical")){
                st.executeUpdate("UPDATE `borrow_chemical` SET `status`= 6 WHERE `borrow_chemical`.`id` =" + get);
            } else if (choosetable.equals("Equipment")){
                st.executeUpdate("UPDATE `borrow_equipment` SET `status`= 6 WHERE `borrow_equipment`.`id` =" + get);
                st.executeUpdate("UPDATE `equipment` SET `Quantity`= " + getquantity() + " WHERE `id` =" + getequipmentid());
            }
            JOptionPane.showMessageDialog(null,"Cancel complete!");
            } catch (SQLException ex) {
                Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
            }
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
