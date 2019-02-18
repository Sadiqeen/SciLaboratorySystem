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
public class register extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    int checkuserexist,checkuserunregist,checkpassword,checkName,check;
   
    public register() {
        initComponents();
        con = connect.ConnectDB();
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
    
    public int checkuserexist () {
         int a = 1;
        sql = "SELECT `user`.`id` FROM `user`";
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String staffname = rs.getString(a);
                if (staffname.equals(studentID.getText().toString())){
                    return 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int checkuserunregist () {
         int a = 1;
        sql = "SELECT `user_unregis`.`id` FROM `user_unregis`";
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString(a);
                if (id.equals(studentID.getText())){
                    return 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int checkstudentID () {
        checkuserexist = checkuserexist();
       if (checkuserexist == 1) {
            JOptionPane.showMessageDialog(null, "Sorry your studentID is Exist", 
                    "studentID is Exist", JOptionPane.ERROR_MESSAGE);
       } else if (checkuserexist == 0){
           checkuserunregist = checkuserunregist();
           if (checkuserunregist == 1) {
               return 0;                                                           //Allow register
           } else {
               return 1;                                                           //Can't register have no studentID in database
           }
       }
       return 3;                                                                  //Return for avoiding eror
    }
    
    public int checkpassword(){
        if (password.getPassword().length == 0 && repassword.getPassword().length == 0 ){
            JOptionPane.showMessageDialog(null, "Please Enter password", 
                    "Password issue", JOptionPane.ERROR_MESSAGE);
            return 3;
            
        } else {
            if (Arrays.equals(password.getPassword(), repassword.getPassword())){
                return 1;
            } else {
                return 0;
            }
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
        int ID;
        ID = Integer.parseInt(studentID.getText());
        String passString = new String(pass);
        passwordDatabase = hash(passString , Integer.toString(ID));
        fname = firstname.getText();
        lname = lastname.getText();
        phone = phoneinput.getText();
       
        try { 
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO `user` (`id`, `password`, `position`, `firstname`, `lastname`, `status`, `department_id`, `phone_number`) " + 
                "VALUES ('" + ID + "', '" + passwordDatabase + "', 'Student','" + fname +
                    "','" + lname + "','1', '" + department() + "','" + phone +"');");
            JOptionPane.showMessageDialog(null,"Register success!");
            mainpage mainpage = new mainpage();
            mainpage.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
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
        studentID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        phoneinput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        checkstudentID = new javax.swing.JButton();
        repassword = new javax.swing.JPasswordField();
        password = new javax.swing.JPasswordField();
        firstname = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Register | Science Laboratory System");
        setBackground(new java.awt.Color(28, 35, 41));
        setMaximumSize(new java.awt.Dimension(400, 470));
        setMinimumSize(new java.awt.Dimension(400, 470));
        setPreferredSize(new java.awt.Dimension(400, 470));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 470));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("รหัสนักศึกษา");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 90, 30);

        studentID.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        studentID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(studentID);
        studentID.setBounds(120, 110, 260, 30);

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

        phoneinput.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        phoneinput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(phoneinput);
        phoneinput.setBounds(120, 350, 260, 30);

        jLabel5.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("เบอร์โทร");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 350, 90, 30);

        checkstudentID.setBackground(new java.awt.Color(107, 166, 16));
        checkstudentID.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        checkstudentID.setForeground(new java.awt.Color(255, 255, 255));
        checkstudentID.setText("ตรวจสอบรหัสนักศึกษา");
        checkstudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkstudentIDActionPerformed(evt);
            }
        });
        getContentPane().add(checkstudentID);
        checkstudentID.setBounds(120, 150, 260, 30);

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
        firstname.setBounds(120, 190, 260, 30);

        lastname.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(lastname);
        lastname.setBounds(120, 230, 260, 30);

        jLabel8.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("สกุล");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 230, 80, 30);

        jLabel7.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ชื่อ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 190, 80, 30);

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

        register.setBackground(new java.awt.Color(107, 166, 16));
        register.setFont(new java.awt.Font("CS Cheangkhan", 1, 24)); // NOI18N
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("ลงทะเบียน");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 70, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 390, 400, 110);

        jLabel1.setBackground(new java.awt.Color(28, 35, 41));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/login/login.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 400);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkstudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkstudentIDActionPerformed
       check = checkstudentID();
       if (check == 1) {
           JOptionPane.showMessageDialog(null,"Your student ID is not on database please contact administrator");
       } else if (check == 0){
           JOptionPane.showMessageDialog(null,"Your student ID is Allow");
       }
    }//GEN-LAST:event_checkstudentIDActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        check = checkstudentID();
        if (check == 1) {
            JOptionPane.showMessageDialog(null,"Your student ID is not on database please contact administrator");
        } else if (check == 0){
            checkName = checkName();
            if (checkName == 1) {
                checkpassword = checkpassword();
                if (checkpassword == 1){
                    String phone = phoneinput.getText();
                    if (phone.length() != 10){
                        JOptionPane.showMessageDialog(null, "Sorry Please check your phone numbers",
                            "Phone numbers issue", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            writedatabase();
                            
                        } catch (UnsupportedEncodingException ex) {
                            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (checkpassword == 0) {
                    JOptionPane.showMessageDialog(null, "Sorry your password are not match",
                        "Password issue", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_registerActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        mainpage sc = new mainpage();
        sc.setVisible(true);
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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton checkstudentID;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastname;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phoneinput;
    private javax.swing.JButton register;
    private javax.swing.JPasswordField repassword;
    private javax.swing.JTextField studentID;
    // End of variables declaration//GEN-END:variables

    private String department() {
        String storage = "";
        sql = "SELECT * FROM `user_unregis` WHERE `id` = " + studentID.getText();
        try {
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                storage = rs.getString("department_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return storage;
    }
}
