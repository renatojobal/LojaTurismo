/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BL.BLClient;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import CLASES.Client;
import DATA.GlobalVariables;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO add your handling code here:
//        Date date = jDateChooser1.getDate();
//        System.out.println(DateFormat.getDateInstance().format(date));
/**
 *
 * @author carlo
 */
public class Login_V31 extends javax.swing.JFrame {
    
    ArrayList<Client> arrayClients = new ArrayList<Client>();
    BLClient objBLClient = new BLClient();
    Client objClient = new Client();
    
    
    public Login_V31() throws ClassNotFoundException, SQLException {
        
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdentification = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        jPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Identificación:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 98, -1, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Contraseña: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 170, -1, -1));
        getContentPane().add(txtIdentification, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 102, 170, 23));

        btnLogin.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnLogin.setText("Iniciar Sesión");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 233, -1, -1));

        btnRegister.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnRegister.setText("Registrarse");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 233, -1, -1));
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        try {
            objClient = objBLClient.findIdentificationDB(this.txtIdentification.getText());  
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login_V31.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        if(objClient.getIdClient() != 0){
            objClient = objBLClient.ValidarPassword(objClient, String.valueOf(this.jPassword.getPassword()));
            if(objClient != null){
                GlobalVariables.loggedClient = objClient;
                OptionClient objOptionClient = new OptionClient();
                objOptionClient.setVisible(true);
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "La identificacion o contraseña no coinciden con ninguna cuenta\n\n"
                        + "Registrate para crea una cuenta");
            }
        }else{
            JOptionPane.showMessageDialog(null, "La identificacion o contraseña no coinciden con ninguna cuenta\n\n"
                        + "Registrate para crea una cuenta");
        }
        
        
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        CreateAccount objCrearAcount = new CreateAccount();
        objCrearAcount.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Login_V31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_V31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_V31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_V31.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login_V31().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login_V31.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Login_V31.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField txtIdentification;
    // End of variables declaration//GEN-END:variables
}
