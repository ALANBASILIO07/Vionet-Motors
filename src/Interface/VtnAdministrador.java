/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import javax.swing.JOptionPane;

/**
 *
 * @author Alan Basilio
 */
public class VtnAdministrador extends javax.swing.JFrame
{

    /**
     * Creates new form VtnAdministrador
     */
    public VtnAdministrador()
    {
        initComponents();
    }
    
    private String usuario;

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
        lblUser.setText(usuario);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        gestionaAuto = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        transmision = new javax.swing.JTextField();
        modelo = new javax.swing.JTextField();
        fabricante = new javax.swing.JTextField();
        tipo = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        color = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        transmision1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        modelo1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        fabricante1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        transmision2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        transmision3 = new javax.swing.JTextField();
        tipo1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        precio1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        color1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        buscaProducto = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        detalleProduct = new javax.swing.JTable();
        eliminaProduct = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        verProductos = new javax.swing.JTable();
        jLabel27 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gestionar Sucursales");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 30));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gestionar Autos");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 30));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Gestionar Usuarios");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 30));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Gestionar Citas");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 200, 640));

        gestionaAuto.setBackground(new java.awt.Color(255, 102, 0));
        gestionaAuto.setForeground(new java.awt.Color(255, 255, 255));
        gestionaAuto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(transmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 230, 30));
        jPanel3.add(modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 230, 30));
        jPanel3.add(fabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 230, 30));
        jPanel3.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 230, 30));
        jPanel3.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 230, 30));
        jPanel3.add(color, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 230, 30));

        jLabel4.setText("jLabel4");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 60, 50));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Transmisión");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 230, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modelo");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 116, 230, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fabricante");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 230, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tipo");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 230, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Precio");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 230, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Color");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 230, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Año");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 230, 20));
        jPanel3.add(transmision1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 230, 30));

        gestionaAuto.addTab("Alta Autos", jPanel3);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Modelo");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 116, 230, 20));
        jPanel5.add(modelo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 230, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Fabricante");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 230, 20));
        jPanel5.add(fabricante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 230, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Transmisión");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 230, 20));
        jPanel5.add(transmision2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 230, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Año");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 230, 20));
        jPanel5.add(transmision3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, 230, 30));
        jPanel5.add(tipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 230, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Tipo");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 230, 20));
        jPanel5.add(precio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 230, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Precio");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 230, 20));
        jPanel5.add(color1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 230, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Color");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 230, 20));

        gestionaAuto.addTab("Modifica Autos", jPanel5);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Escriba algún indicio");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 130, -1));

        buscaProducto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buscaProductoActionPerformed(evt);
            }
        });
        jPanel4.add(buscaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 200, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Detalles del auto");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 130, -1));

        detalleProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "No. Control", "Nombre", "Tipo", "Precio", "Cantidad", "Descuento %", "Fecha Agregación", "Fecha Caducidad", "Proveedor", "Descripción"
            }
        ));
        jScrollPane3.setViewportView(detalleProduct);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 880, 290));

        eliminaProduct.setText("ELIMINAR PRODUCTO");
        eliminaProduct.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                eliminaProductActionPerformed(evt);
            }
        });
        jPanel4.add(eliminaProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, -1, -1));

        gestionaAuto.addTab("Elimina Autos", jPanel4);

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String []
            {
                "No. Control", "Nombre", "Tipo", "Precio", "Cantidad", "Descuento %", "Fecha Agregación", "Fecha Caducidad", "Proveedor", "Descripción"
            }
        ));
        jScrollPane2.setViewportView(verProductos);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 930, 360));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Autos Existentes");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 20));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel6.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 140, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("FILTROS");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, -1));

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Fecha de Caducidad");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ascendente", "Descendente" }));
        jComboBox9.setEnabled(false);
        jPanel6.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 140, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ascendente", "Descendente" }));
        jComboBox5.setEnabled(false);
        jPanel6.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 140, -1));

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Fecha de Agregación");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ascendente", "Descendente" }));
        jComboBox6.setEnabled(false);
        jPanel6.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 140, -1));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Fecha de Agregación");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, -1, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ascendente", "Descendente" }));
        jComboBox10.setEnabled(false);
        jPanel6.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 140, -1));

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Fecha de Caducidad");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ascendente", "Descendente" }));
        jComboBox7.setEnabled(false);
        jPanel6.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, 140, -1));

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Fecha de Agregación");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 80, -1, -1));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Ascendente", "Descendente" }));
        jComboBox11.setEnabled(false);
        jPanel6.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 140, -1));

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Fecha de Caducidad");
        jPanel6.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        gestionaAuto.addTab("Consulta Autos", jPanel6);

        jPanel1.add(gestionaAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 1000, 640));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VIONET MOTORS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 310, -1));

        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("USUARIO");
        jPanel1.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 130, 40));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("USER");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 40, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMINISTRADOR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 140, -1));

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaProductoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buscaProductoActionPerformed
    {//GEN-HEADEREND:event_buscaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaProductoActionPerformed

    private void eliminaProductActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_eliminaProductActionPerformed
    {//GEN-HEADEREND:event_eliminaProductActionPerformed
        int index;
        // CORREGIR BUSQUEDA
        index = 1;
        if (index == -1)
        {
            JOptionPane.showMessageDialog(this, "Error al eliminar");
        } else
        {
            VtnAdmin.getProduct().remove(index);
            JOptionPane.showMessageDialog(this, "Producto eliminado de forma exitosa");
        }
    }//GEN-LAST:event_eliminaProductActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnActualizarActionPerformed
    {//GEN-HEADEREND:event_btnActualizarActionPerformed
        //despProductos();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VtnAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VtnAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JTextField buscaProducto;
    private javax.swing.JTextField color;
    private javax.swing.JTextField color1;
    private javax.swing.JTable detalleProduct;
    private javax.swing.JButton eliminaProduct;
    private javax.swing.JTextField fabricante;
    private javax.swing.JTextField fabricante1;
    private javax.swing.JTabbedPane gestionaAuto;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField modelo;
    private javax.swing.JTextField modelo1;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField precio1;
    private javax.swing.JTextField tipo;
    private javax.swing.JTextField tipo1;
    private javax.swing.JTextField transmision;
    private javax.swing.JTextField transmision1;
    private javax.swing.JTextField transmision2;
    private javax.swing.JTextField transmision3;
    private javax.swing.JTable verProductos;
    // End of variables declaration//GEN-END:variables
}
