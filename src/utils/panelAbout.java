/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package utils;

/**
 *
 * @author kevscl
 */
public class panelAbout extends javax.swing.JPanel {

    /**
     * Creates new form panelAbout
     */
    public panelAbout() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rSLabelLineWrap1 = new rojeru_san.rslabel.RSLabelLineWrap();
        rSPanelMaterialImage1 = new RSMaterialComponent.RSPanelMaterialImage();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Aviso de privacidad");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        rSLabelLineWrap1.setColorForeground(new java.awt.Color(0, 0, 0));
        rSLabelLineWrap1.setFuente(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        rSLabelLineWrap1.setText("Gestor de contraseñas - Kevscl\n\nEste proyecto es un gestor de contraseñas diseñado para almacenar y gestionar de manera segura información sensible, como contraseñas y datos de acceso a sitios web. Las contraseñas se cifran utilizando un certificado X.509 generado por el propio usuario y se almacenan en una base de datos SQLite para garantizar la seguridad y la accesibilidad.\n\nCaracterísticas\n\n- Almacenamiento seguro de contraseñas\n- Cifrado avanzado para proteger tus credenciales\n- Gestión fácil de contraseñas\n- Autenticación segura con certificado digital\n\nDesarrollado por\nKevscl\n\nVersión\n1.0.0\n\nLicencia\nBajo la licencia MIT\n\nContacto\nhttps://github.com/KevinGil12C");
        jPanel2.add(rSLabelLineWrap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 590, 450));

        rSPanelMaterialImage1.setBackground(new java.awt.Color(255, 255, 255));
        rSPanelMaterialImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/icons/KeIWVHueSHCoexSmVL_Chg.jpg"))); // NOI18N
        rSPanelMaterialImage1.setShadowBottom(false);
        rSPanelMaterialImage1.setShadowLeft(false);
        rSPanelMaterialImage1.setShadowRight(false);
        rSPanelMaterialImage1.setShadowTop(false);
        jPanel2.add(rSPanelMaterialImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 340, 250));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojeru_san.rslabel.RSLabelLineWrap rSLabelLineWrap1;
    private RSMaterialComponent.RSPanelMaterialImage rSPanelMaterialImage1;
    // End of variables declaration//GEN-END:variables
}
