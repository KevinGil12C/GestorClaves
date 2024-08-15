/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package utils;

import bo.ClavesBO;
import entity.Claves;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rojerusan.RSNotifyFade;

/**
 *
 * @author kevscl
 */
public class panelTabla extends javax.swing.JPanel implements PanelListener{

    /**
     * Creates new form panelTabla
     */
    ClavesBO cbo = new ClavesBO();
    private X509Certificate certificate;
    private PrivateKey privateKey;

    public panelTabla(X509Certificate certificate, PrivateKey privateKey) {
        initComponents();
        this.certificate = certificate;
        this.privateKey = privateKey;
        listar();
        validar();
        jPopupMenu1.add(menu);
    }

    public void validar() {
        if (privateKey != null) {
            txtBuscar.setEditable(true);
        }else{
            txtBuscar.setEditable(false);
        }
    }

    public void listar() {
        if (privateKey != null) {
            // Si la clave privada está presente, listar con descifrado
            cbo.listarClaves(tablaClaves, privateKey);
            validar();
        } else {
            // Si la clave privada no está presente, listar sin descifrado
            cbo.listarClavesSinClave(tablaClaves);
        }
    }
    
     public void onPanelClosed() {
        listar(); // Método para actualizar la lista de empleados
    }
    public void editar() {
        int fila = tablaClaves.getSelectedRow();
        if (fila != -1) {
            ActualizarCuenta c = new ActualizarCuenta();
            c.labelID.setText(tablaClaves.getValueAt(fila, 0).toString());
            c.txtSitio.setText(tablaClaves.getValueAt(fila, 1).toString());
            c.txtCorreo.setText(tablaClaves.getValueAt(fila, 2).toString());
            c.txtPassword.setText(tablaClaves.getValueAt(fila, 3).toString());
            c.setPanelListener(this);
            c.pasaDatos(certificate, privateKey);
            c.setAlwaysOnTop(true); // Mantener la ventana emergente en la capa superior
            c.setVisible(true);
            tablaClaves.clearSelection();
        } else {
            listar();
        }
        jPopupMenu1.setVisible(false);
    }

    public void eliminar() {
        int fila = tablaClaves.getSelectedRow();
        if (fila != -1) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (resp == 0) {
                Claves c = new Claves();
                int id = Integer.parseInt(tablaClaves.getValueAt(fila, 0).toString());
                String mensaje = cbo.eliminarClave(id);
                if (!mensaje.equals("ELIMINADO CORRECTAMENTE")) {
                    new rojerusan.RSNotifyFade("¡ERROR!", "¡Error al eliminar el cliente!", 3, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
                } else {
                    new rojerusan.RSNotifyFade("¡SUCCESS!", "¡Eliminado Correctamente!", 5, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                    listar();
                }
            }
            tablaClaves.clearSelection();

        } else {
            listar();
        }
        jPopupMenu1.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        btnEditar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEliminar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClaves = new RSMaterialComponent.RSTableMetro();
        txtBuscar = new rojeru_san.rsfield.RSTextMaterial();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();

        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar.setBackground(new java.awt.Color(65, 110, 223));
        btnEditar.setText("EDITAR (F4)");
        btnEditar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        menu.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(65, 110, 223));
        btnEliminar.setText("ELIMINAR (F5)");
        btnEliminar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        menu.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        tablaClaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaClaves.setBackgoundHead(new java.awt.Color(65, 110, 223));
        tablaClaves.setBackgoundHover(new java.awt.Color(65, 110, 223));
        tablaClaves.setColorPrimaryText(new java.awt.Color(65, 110, 223));
        tablaClaves.setColorSecundaryText(new java.awt.Color(65, 110, 223));
        tablaClaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaClavesMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClaves);

        txtBuscar.setPlaceholder("BUSCAR");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String campo = txtBuscar.getText();
        if(campo == null || campo.trim().isEmpty() ){
            //no hace nada
        }else{
            cbo.buscarClave(tablaClaves, campo, privateKey);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaClavesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClavesMouseReleased
         int fila = tablaClaves.getSelectedRow();
        // Verificar si se ha seleccionado una fila
        if (fila != -1) {
            // Mostrar el JPopupMenu en la posición del clic
            jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            listar();
        }
    }//GEN-LAST:event_tablaClavesMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel menu;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSTableMetro tablaClaves;
    private rojeru_san.rsfield.RSTextMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables
}