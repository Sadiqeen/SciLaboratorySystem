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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Sadiqeen
 */
public class mainpage extends javax.swing.JFrame {
    
    
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    String sql = "";
    
    
    public mainpage() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/ico.png")).getImage());
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JButton();
        login = new javax.swing.JButton();
        checkC = new javax.swing.JButton();
        checkE = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Science Laboratory System");
        setBackground(new java.awt.Color(29, 36, 42));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 625));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(null);

        register.setToolTipText("");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register);
        register.setBounds(700, 110, 90, 40);
        register.setContentAreaFilled( false );

        login.setToolTipText("");
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginMouseExited(evt);
            }
        });
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        getContentPane().add(login);
        login.setBounds(620, 110, 70, 40);
        login.setContentAreaFilled( false );

        checkC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                checkCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                checkCMouseExited(evt);
            }
        });
        checkC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCActionPerformed(evt);
            }
        });
        getContentPane().add(checkC);
        checkC.setBounds(330, 190, 420, 170);
        checkC.setContentAreaFilled( false );

        checkE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                checkEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                checkEMouseExited(evt);
            }
        });
        checkE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEActionPerformed(evt);
            }
        });
        getContentPane().add(checkE);
        checkE.setBounds(330, 370, 420, 180);
        checkE.setContentAreaFilled( false );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCMouseEntered
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bgC.png")));
    }//GEN-LAST:event_checkCMouseEntered

    private void checkCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCMouseExited
         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bg.png")));
    }//GEN-LAST:event_checkCMouseExited

    private void checkEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkEMouseEntered
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bgE.png")));
    }//GEN-LAST:event_checkEMouseEntered

    private void checkEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkEMouseExited
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bg.png")));
    }//GEN-LAST:event_checkEMouseExited

    private void loginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseEntered
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bgL.png")));
    }//GEN-LAST:event_loginMouseEntered

    private void loginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseExited
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bg.png")));
    }//GEN-LAST:event_loginMouseExited

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bgR.png")));
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sciencelaboratorysystem/mainpage/bg.png")));
    }//GEN-LAST:event_registerMouseExited

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        if (checkconnection() == 1) {
            login login = new login();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_loginActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        if (checkconnection() == 1) {
            register register = new register();
            register.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_registerActionPerformed

    private void checkCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCActionPerformed
        if (checkconnection() == 1) {
            checkc check= new checkc();
            check.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_checkCActionPerformed

    private void checkEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEActionPerformed
        if (checkconnection() == 1) {
            checke check= new checke();
            check.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_checkEActionPerformed

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
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkC;
    private javax.swing.JButton checkE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login;
    private javax.swing.JButton register;
    // End of variables declaration//GEN-END:variables

    private int checkconnection() {
        sql = "SELECT * FROM `user` ORDER BY `phone_number` ASC";
        try {
            con = connect.ConnectDB();
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(checkc.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
