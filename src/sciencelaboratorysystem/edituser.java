/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sciencelaboratorysystem;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadiqeen
 */
public class edituser extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    String studentID = "";
    int checkuserexist,checkuserunregist,checkpassword,checkName,check;
   
    public edituser(String get) {
        initComponents();
        con = connect.ConnectDB();
        studentID = get;
        departmentsetcombo();
        setdata();
        this.setIconImage(new ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/ico.png")).getImage());
    }
    
    public static String stringArrayToString( String[] stringArray, String delimiter ) {
    StringBuilder sb = new StringBuilder();
    for ( String element : stringArray ) {
        if (sb.length() > 0) {
            sb.append( delimiter );
        }
        sb.append( element );
    }
    return sb.toString();
}

    edituser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    
    public int checkpassword(){
            if (Arrays.equals(password.getPassword(), repassword.getPassword())){
                return 1;
            } else {
                return 0;
            }
        
    }
    
    
    public int checkName(){
        if (firstname.getText().length() == 0 || lastname.getText().length() == 0 ){
            JOptionPane.showMessageDialog(null, "Please Enter your name", 
                    "Name issue", JOptionPane.ERROR_MESSAGE);
            return 0;
            
        } else {
            return 1;
        }
    }
    
    public String hash(String passwordToHash, String   salt) throws UnsupportedEncodingException{
String generatedPassword = null;
    try {
         MessageDigest md = MessageDigest.getInstance("SHA-512");
         md.update(salt.getBytes("UTF-8"));
         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         generatedPassword = sb.toString();
        } 
       catch (NoSuchAlgorithmException e){
        e.printStackTrace();
       }
    return generatedPassword;
}
    
    
    
    public void writedatabase() throws UnsupportedEncodingException {
        String fname,lname,passwordDatabase,phone;
        char[] pass = repassword.getPassword();
        String passString = new String(pass);
        passwordDatabase = hash(passString , studentID);
        try { 
            Statement st = con.createStatement();
            if (repassword.getPassword().length != 0) {
            st.executeUpdate("UPDATE `user` SET "
                    + "`password`= '" + passwordDatabase
                    + "',`position`= '" + position.getSelectedItem()
                    + "',`firstname`= '" + firstname.getText()
                    + "',`lastname`= '"  + lastname.getText()
                    + "',`status`= '"  + getwritedatavalue(2)
                    + "',`department_id`= '"  + getwritedatavalue(1)
                    + "',`phone_number`= '"  + phoneinput.getText()
                    + "' WHERE `id` = " + studentID);  
            } else {
                st.executeUpdate("UPDATE `user` SET "
                        + "`position`= '" + position.getSelectedItem()
                        + "',`firstname`= '"  + firstname.getText()
                        + "',`lastname`= '" + lastname.getText()
                        + "',`status`= '"  + getwritedatavalue(2)
                        + "',`department_id`= '"  + getwritedatavalue(1)
                        + "',`phone_number`= '"  + phoneinput.getText()
                        + "' WHERE  `id` = " + studentID);
            }
            JOptionPane.showMessageDialog(null,"Edit save success!");
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(edituser.class.getName()).log(Level.SEVERE, null, ex);
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
        id = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        repassword = new javax.swing.JPasswordField();
        password = new javax.swing.JPasswordField();
        firstname = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lastname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        departmentset = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        position = new javax.swing.JComboBox<>();
        statusset = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        phoneinput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit user | Science Laboratory System");
        setBackground(new java.awt.Color(28, 35, 41));
        setMinimumSize(new java.awt.Dimension(400, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 470));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("รหัสผู้ใช้");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 80, 30);

        id.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(id);
        id.setBounds(120, 110, 260, 30);

        jLabel3.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("รหัสผ่าน");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 270, 80, 30);

        jLabel4.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ยืนยันรหัส");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 310, 90, 30);

        repassword.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        repassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(repassword);
        repassword.setBounds(120, 310, 260, 30);

        password.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(password);
        password.setBounds(120, 270, 260, 30);

        firstname.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(firstname);
        firstname.setBounds(120, 150, 260, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(120, 110, 260, 30);

        lastname.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(lastname);
        lastname.setBounds(120, 190, 260, 30);

        jLabel8.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("สกุล");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 190, 80, 30);

        jLabel7.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ชื่อ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 150, 80, 30);

        jLabel9.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("สาขา");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 230, 90, 30);

        departmentset.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        getContentPane().add(departmentset);
        departmentset.setBounds(120, 230, 259, 30);

        jPanel1.setBackground(new java.awt.Color(28, 35, 41));
        jPanel1.setLayout(null);

        cancel.setBackground(new java.awt.Color(193, 41, 43));
        cancel.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("ยกเลิก");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel);
        cancel.setBounds(20, 90, 170, 40);

        save.setBackground(new java.awt.Color(107, 166, 16));
        save.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("บันทึก");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save);
        save.setBounds(210, 90, 170, 40);

        jLabel6.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ตำแหน่ง");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 10, 90, 30);

        position.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Student" }));
        jPanel1.add(position);
        position.setBounds(119, 11, 259, 33);

        statusset.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        statusset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Ban" }));
        jPanel1.add(statusset);
        statusset.setBounds(120, 50, 259, 33);

        jLabel10.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("สถานะ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 50, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 380, 400, 170);

        phoneinput.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        phoneinput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(phoneinput);
        phoneinput.setBounds(120, 350, 260, 30);

        jLabel5.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("เบอร์โทร");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 350, 90, 30);

        jLabel1.setBackground(new java.awt.Color(28, 35, 41));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/login/login.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 400);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       if  (firstname.getText().length() == 0 || lastname.getText().length() == 0 ||
               phoneinput.getText().length() != 10)
       {
           JOptionPane.showMessageDialog(null, "Sorry! Please check data",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
       } else {
           if (password.getPassword().length != 0 || repassword.getPassword().length != 0){
               check = checkpassword();
               if (check == 1){
                   try {
                       writedatabase();
                   } catch (UnsupportedEncodingException ex) {
                       Logger.getLogger(edituser.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } else {
                   JOptionPane.showMessageDialog(null, "Sorry your password are not match",
                        "Password issue", JOptionPane.ERROR_MESSAGE);
               }
           } else {
               try {
                   writedatabase();
               } catch (UnsupportedEncodingException ex) {
                   Logger.getLogger(edituser.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
          
       }
    }//GEN-LAST:event_saveActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

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
            java.util.logging.Logger.getLogger(edituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edituser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edituser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> departmentset;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastname;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phoneinput;
    private javax.swing.JComboBox<String> position;
    private javax.swing.JPasswordField repassword;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> statusset;
    // End of variables declaration//GEN-END:variables

    private void departmentsetcombo() {
        String storage;
        sql = "SELECT * FROM `department` ";
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                storage = rs.getString("department");
                departmentset.addItem(storage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getwritedatavalue(int a) {
        String storage;
        String get = "";
        if (a == 1){
            sql = "SELECT * FROM `department` WHERE `department` = '" + departmentset.getSelectedItem() + "'";
        } else {
            sql = "SELECT * FROM `userstatus` WHERE `status` = '" + statusset.getSelectedItem() + "'";
        }
        
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                   get = rs.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return get;
    }

    private void setdata() {
         String department = "";
         String status = "";
        try {
            sql = "SELECT *  FROM `user` WHERE`ID` = '" + studentID + "'";
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                id.setText(rs.getString("id"));
                firstname.setText(rs.getString("firstname"));
                lastname.setText(rs.getString("lastname"));
                phoneinput.setText(rs.getString("phone_number"));
                position.setSelectedItem(rs.getString("position"));
                status = rs.getString("status");
                department = rs.getString("department_id");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(status + "adadw");
        statusset.setSelectedItem(getvalue(status,2));
        departmentset.setSelectedItem(getvalue(department,1));
    }

    private String getvalue(String value,int a) {
        String get = "";
        if (a == 1) {
            sql = "SELECT * FROM `department` WHERE `department`.`id` = " + value;
        } else {
            sql = "SELECT * FROM `userstatus` WHERE `userstatus`.`id` = " + value;
        }
        System.out.println(a);
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (a == 1) {
                   get = rs.getString("department"); 
                } else {
                    get = rs.getString("status"); 
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return get;
    }
}
