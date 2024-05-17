/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Files.Administradores;
import Files.Clientes;
import cjb.ci.Validaciones;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Basilio
 */
public class VtnSignIn extends javax.swing.JFrame
{

    /**
     * Creates new form VtnSignIn
     */
    public VtnSignIn()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        admin = new javax.swing.JRadioButton();
        client = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        admin.setBackground(new java.awt.Color(255, 102, 0));
        admin.setText("ADMINISTRADOR");
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 210, -1));

        client.setText("CLIENTE");
        client.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clientActionPerformed(evt);
            }
        });
        jPanel1.add(client, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 210, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingresa un nombre de Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 210, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingresa una contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 210, -1));

        userName.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                userNameKeyTyped(evt);
            }
        });
        jPanel1.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 210, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("REGISTRARSE");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 150, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materials/Usuario.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 60, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materials/Sign In img.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("REGISTRO DE USUARIO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 340, 30));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 210, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 800, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clientActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clientActionPerformed
    {//GEN-HEADEREND:event_clientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        String usuario = userName.getText();
        String contrasenia = "";
        char[] contra = password.getPassword();
        // GUARDA LOS REGISTROS
        if (admin.isSelected())  // REGISTRAR ADMINISTRADOR
        {
            for (int i = 0; i < contra.length; i++)
            {
                contrasenia += contra[i];
            }
            if (usuario.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Faltó por llenar el campo usuario", "Alerta", JOptionPane.WARNING_MESSAGE);
                userName.requestFocus();
            } else if (contrasenia.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Faltó por llenar el campo contraseña", "Alerta", JOptionPane.WARNING_MESSAGE);
                password.requestFocus();
            } else
            {
                int flag;
                Administradores d = new Administradores();
                flag = d.buscarUsuario(userName);
                if (flag == 1)
                {
                    JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe, pruebe con otro");
                    userName.setText("");
                    password.setText("");
                } else
                {
                    d.altaUsuario(userName, password);
                    this.dispose();
                }
            }
        } else if (client.isSelected()) // REGISTRAR CLIENTE
        {
            for (int i = 0; i < contra.length; i++)
            {
                contrasenia += contra[i];
            }
            if (usuario.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Faltó por llenar el campo usuario", "Alerta", JOptionPane.WARNING_MESSAGE);
                userName.requestFocus();
            } else if (contrasenia.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Faltó por llenar el campo contraseña", "Alerta", JOptionPane.WARNING_MESSAGE);
                password.requestFocus();
            } else
            {
                int flag;
                Clientes c = new Clientes();
                flag = c.buscarUsuario(userName);
                if (flag == 1)
                {
                    JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe, pruebe con otro");
                    userName.setText("");
                    password.setText("");
                } else
                {
                    c.altaUsuario(userName, password);
                    this.dispose();
                }
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void userNameKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_userNameKeyTyped
    {//GEN-HEADEREND:event_userNameKeyTyped
        Validaciones.validaAlfabeticos(evt, 23, userName.getText());
    }//GEN-LAST:event_userNameKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VtnSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnSignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnSignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton admin;
    private javax.swing.JRadioButton client;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
