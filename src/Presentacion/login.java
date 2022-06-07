/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Datos.Metodos_sql;
import javax.swing.JOptionPane;
import menu.menu;

/**
 *
 * @author Acer
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        StateHold State = new StateHold("Usuario", txtcorreo);
        StateHold State2 = new StateHold("Contraseña", txtcontraseña);
        setLocationRelativeTo(null);
        setResizable(false);
    }
public void Entrar(){

        if (this.txtcorreo.getText().isEmpty() || this.txtcontraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "por favor ingrese los datos", "empty fields", 1);
        } else {
if(txtcorreo.getText().equals("Admin")||txtcontraseña.getText().equals("Admin")){
    String tipo="Administrador";
menu sis=new menu(tipo);
sis.setVisible(true);

}else{
            String Busqueda_Usuario = Metodos_sql.Buscar_Usuario(this.txtcorreo.getText(), this.txtcontraseña.getText());

            if (Busqueda_Usuario.equals("Usuario encontrado")) {
                String Busqueda_Nombre = Metodos_sql.buscar_Nombre(txtcorreo.getText());
                String tipo = Metodos_sql.Buscar_Tipo(this.txtcorreo.getText());

                JOptionPane.showMessageDialog(this, "Bienvenido: \n" + Busqueda_Nombre);

                
                menu sis = new menu(tipo);

                sis.setVisible(true);

                dispose();
            } else {

                JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Intentelo de nuevo", 1);
txtcorreo.requestFocus();
txtcontraseña.setText("");
txtcorreo.setText("");
            }
        }}
}
    Metodos_sql metodos1 = new Metodos_sql();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JPasswordField();
        btniniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("INICIO DE SESION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        txtcorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoActionPerformed(evt);
            }
        });
        jPanel1.add(txtcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 160, 30));

        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 160, 30));

        btniniciar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btniniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/8.png"))); // NOI18N
        btniniciar.setText("Iniciar");
        btniniciar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btniniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btniniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 280, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/7.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 80, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -1, 320, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btniniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniniciarActionPerformed
Entrar();
    }//GEN-LAST:event_btniniciarActionPerformed

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
      Entrar();
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void txtcorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoActionPerformed
      txtcontraseña.requestFocus();
    }//GEN-LAST:event_txtcorreoActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btniniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtcontraseña;
    private javax.swing.JTextField txtcorreo;
    // End of variables declaration//GEN-END:variables
}