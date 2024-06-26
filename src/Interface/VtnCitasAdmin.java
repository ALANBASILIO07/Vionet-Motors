/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Interface;

import Files.Autos;
import Files.Citas;
import Files.Cliente;
import cjb.ci.Validaciones;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Basilio
 */
public class VtnCitasAdmin extends javax.swing.JPanel
{

    /**
     * Creates new form VtnCitasAdmin
     */
    public VtnCitasAdmin()
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

        gestionaCita = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboModeloAuto = new javax.swing.JComboBox<>();
        comboPrecioAuto = new javax.swing.JComboBox<>();
        comboNombreCliente = new javax.swing.JComboBox<>();
        comboAnioAuto = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        modifFolio = new javax.swing.JTextField();
        comboCita = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        comboAA = new javax.swing.JComboBox<>();
        comboNC = new javax.swing.JComboBox<>();
        comboMA = new javax.swing.JComboBox<>();
        comboPA = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        buscaCita = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        detalleCita = new javax.swing.JTable();
        eliminaAuto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        verCitas = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        comboFiltroCliente = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gestionaCita.setBackground(new java.awt.Color(255, 102, 0));
        gestionaCita.setForeground(new java.awt.Color(255, 255, 255));
        gestionaCita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gestionaCita.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                gestionaCitaMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materials/guardar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 500, -1, 60));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Precio Auto");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 230, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Año Auto");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 230, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre Cliente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 230, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Modelo Auto");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, 230, 20));

        jPanel2.add(comboModeloAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 230, 34));

        jPanel2.add(comboPrecioAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 230, 34));

        comboNombreCliente.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                comboNombreClienteMouseClicked(evt);
            }
        });
        jPanel2.add(comboNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 230, 34));

        jPanel2.add(comboAnioAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 230, 34));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Alta Cita");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 110, -1));

        gestionaCita.addTab("Alta Cita", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SELECCIONA ALGÚN FOLIO DE CITA");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 230, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Número de Folio");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 230, 30));

        modifFolio.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                modifFolioKeyTyped(evt);
            }
        });
        jPanel3.add(modifFolio, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 230, 30));

        comboCita.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comboCitaItemStateChanged(evt);
            }
        });
        jPanel3.add(comboCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 230, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Nombre del Cliente");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 230, 20));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Modelo de Auto");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 230, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Año del Auto");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 230, 20));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Precio del Auto");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 230, 20));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materials/guardar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(899, 510, -1, 60));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Modifica Cita");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 180, -1));

        jPanel3.add(comboAA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 230, 30));

        jPanel3.add(comboNC, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 230, 30));

        comboMA.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comboMAItemStateChanged(evt);
            }
        });
        jPanel3.add(comboMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 230, 30));

        jPanel3.add(comboPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 230, 30));

        gestionaCita.addTab("Modifica Cita", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Escriba algún folio de cita");

        buscaCita.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                buscaCitaActionPerformed(evt);
            }
        });
        buscaCita.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                buscaCitaKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Detalles del auto");

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materials/lupa.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jButton2MouseClicked(evt);
            }
        });

        detalleCita.setBackground(new java.awt.Color(51, 51, 51));
        detalleCita.setForeground(new java.awt.Color(255, 255, 255));
        detalleCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Folio", "Nombre Cliente", "Modelo Auto", "Año Auto", "Precio Auto"
            }
        ));
        jScrollPane3.setViewportView(detalleCita);

        eliminaAuto.setText("ELIMINAR CITA");
        eliminaAuto.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                eliminaAutoActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Elimina Cita");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(454, Short.MAX_VALUE)
                .addComponent(eliminaAuto)
                .addGap(435, 435, 435))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel25)
                                .addGap(30, 30, 30)
                                .addComponent(buscaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButton2))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(407, 407, 407)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))))
                .addGap(30, 30, 30)
                .addComponent(jLabel26)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(eliminaAuto)
                .addGap(52, 52, 52))
        );

        gestionaCita.addTab("Baja Cita", jPanel4);

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verCitas.setBackground(new java.awt.Color(51, 51, 51));
        verCitas.setForeground(new java.awt.Color(255, 255, 255));
        verCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Folio", "Nombre del Cliente", "Modelo del Auto", "Año del Auto", "Precio del Auto"
            }
        ));
        jScrollPane2.setViewportView(verCitas);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 930, 300));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Consulta Cita");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 180, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("FILTRO");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 70, -1));

        btnActualizar.setBackground(new java.awt.Color(51, 51, 51));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Materials/update.png"))); // NOI18N
        btnActualizar.setToolTipText("");
        btnActualizar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel5.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 60, 50));

        comboFiltroCliente.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                comboFiltroClienteItemStateChanged(evt);
            }
        });
        comboFiltroCliente.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                comboFiltroClienteMouseClicked(evt);
            }
        });
        jPanel5.add(comboFiltroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 140, -1));

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Cliente");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, -1));

        gestionaCita.addTab("Consulta Citas", jPanel5);

        add(gestionaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 640));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        Citas ct = new Citas();
        ct.altaCita(comboNombreCliente, comboModeloAuto, comboAnioAuto, comboPrecioAuto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buscaCitaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_buscaCitaActionPerformed
    {//GEN-HEADEREND:event_buscaCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscaCitaActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jButton2MouseClicked
    {//GEN-HEADEREND:event_jButton2MouseClicked
        if (buscaCita.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Ingrese el modelo de algún auto");
            buscaCita.requestFocus();
        } else
        {
            Citas ct = new Citas();
            int flagBusca;
            flagBusca = ct.buscaCitaEliminar(buscaCita, detalleCita);
            if (flagBusca == 0)
            {
                JOptionPane.showMessageDialog(this, "No se encontró ningún modelo con ese nombre");
            }
            eliminaAuto.setEnabled(true);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void eliminaAutoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_eliminaAutoActionPerformed
    {//GEN-HEADEREND:event_eliminaAutoActionPerformed
        if (buscaCita.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Faltó por llenar el campo folio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            buscaCita.requestFocus();
        }
        int decision = JOptionPane.showConfirmDialog(this, "Advertencia, eso borrará completamente la cita", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (decision == JOptionPane.YES_OPTION)
        {
            Citas ct = new Citas();
            int opc;
            opc = ct.eliminarCita(buscaCita, detalleCita);
            if (opc == 0)
            {
            } else
            {
                JOptionPane.showMessageDialog(this, "Se ha eliminado la cita de la base de datos");
                eliminaAuto.setEnabled(false);
            }
        }
    }//GEN-LAST:event_eliminaAutoActionPerformed

    private void comboCitaItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_comboCitaItemStateChanged
    {//GEN-HEADEREND:event_comboCitaItemStateChanged
        Citas ct = new Citas();
        ct.selecCita(comboCita, modifFolio, comboNC, comboMA, comboAA, comboPA);
        ct.agregaCombosAnioPrecio(comboMA, comboAA, comboPA);
    }//GEN-LAST:event_comboCitaItemStateChanged

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnActualizarActionPerformed
    {//GEN-HEADEREND:event_btnActualizarActionPerformed
        Citas ct = new Citas();
        //ct.activarTodosCombos(comboFiltroCliente, comboFiltroModelo, comboFiltroAnio, comboFiltroPrecio);
        ct.consultaGeneralCita(verCitas);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void comboFiltroClienteMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_comboFiltroClienteMouseClicked
    {//GEN-HEADEREND:event_comboFiltroClienteMouseClicked
        Citas ct = new Citas();
        String campoFiltrado = "NombreCliente"; // Campo por el cual filtrar
        String valorFiltrado = (String) comboFiltroCliente.getSelectedItem(); // Valor a filtrar
        ct.desactivarOtrosCombos(verCitas, campoFiltrado, valorFiltrado, comboFiltroCliente, comboFiltroCliente/*, comboFiltroModelo, comboFiltroAnio, comboFiltroPrecio*/);
    }//GEN-LAST:event_comboFiltroClienteMouseClicked

    private void gestionaCitaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_gestionaCitaMouseClicked
    {//GEN-HEADEREND:event_gestionaCitaMouseClicked
        Citas ct = new Citas();
        // CONSULTA TABLA CITA
        ct.consultaGeneralCita(verCitas);
        Autos a = new Autos();
        Cliente c = new Cliente();
        // COMBO CITAS
        ct.agregaCombo(comboCita);
        // COMBOS ALTA
        a.agregaCombo(comboModeloAuto);
        c.agregaCombo(comboNombreCliente);
        ct.agregaCombosAnioPrecio(comboModeloAuto, comboAnioAuto, comboPrecioAuto);
        // COMBOS MODIFICA
        c.agregaCombo(comboNC);
        ct.agregaComboModelo(comboMA);
        ct.agregaCombosAnioPrecio(comboMA, comboAA, comboPA);
        // COMBOS FLITROS
        ct.agregaComboNombreCliente(comboFiltroCliente);
        //ct.agregaComboModeloAuto(comboFiltroModelo);
        //ct.agregaComboAnioAuto(comboFiltroAnio);
        //ct.agregaComboPrecioAuto(comboFiltroPrecio);
    }//GEN-LAST:event_gestionaCitaMouseClicked

    private void comboNombreClienteMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_comboNombreClienteMouseClicked
    {//GEN-HEADEREND:event_comboNombreClienteMouseClicked
        
    }//GEN-LAST:event_comboNombreClienteMouseClicked

    private void comboMAItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_comboMAItemStateChanged
    {//GEN-HEADEREND:event_comboMAItemStateChanged
        
    }//GEN-LAST:event_comboMAItemStateChanged

    private void comboFiltroClienteItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_comboFiltroClienteItemStateChanged
    {//GEN-HEADEREND:event_comboFiltroClienteItemStateChanged
        Citas ct = new Citas();
        String campoFiltrado = "NombreCliente"; // Campo por el cual filtrar
        String valorFiltrado = (String) comboFiltroCliente.getSelectedItem(); // Valor a filtrar
        ct.desactivarOtrosCombos(verCitas, campoFiltrado, valorFiltrado, comboFiltroCliente, comboFiltroCliente/*, comboFiltroModelo, comboFiltroAnio, comboFiltroPrecio*/);
    }//GEN-LAST:event_comboFiltroClienteItemStateChanged

    private void modifFolioKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_modifFolioKeyTyped
    {//GEN-HEADEREND:event_modifFolioKeyTyped
        Validaciones.validaEntero(evt, 4, modifFolio.getText());
    }//GEN-LAST:event_modifFolioKeyTyped

    private void buscaCitaKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_buscaCitaKeyTyped
    {//GEN-HEADEREND:event_buscaCitaKeyTyped
        Validaciones.validaEntero(evt, 4, buscaCita.getText());
    }//GEN-LAST:event_buscaCitaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JTextField buscaCita;
    private javax.swing.JComboBox<String> comboAA;
    private javax.swing.JComboBox<String> comboAnioAuto;
    private javax.swing.JComboBox<String> comboCita;
    private javax.swing.JComboBox<String> comboFiltroCliente;
    private javax.swing.JComboBox<String> comboMA;
    private javax.swing.JComboBox<String> comboModeloAuto;
    private javax.swing.JComboBox<String> comboNC;
    private javax.swing.JComboBox<String> comboNombreCliente;
    private javax.swing.JComboBox<String> comboPA;
    private javax.swing.JComboBox<String> comboPrecioAuto;
    private javax.swing.JTable detalleCita;
    private javax.swing.JButton eliminaAuto;
    private javax.swing.JTabbedPane gestionaCita;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField modifFolio;
    private javax.swing.JTable verCitas;
    // End of variables declaration//GEN-END:variables
}
