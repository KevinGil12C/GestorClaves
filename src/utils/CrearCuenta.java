/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Point;

import dao.*;
import bo.*;
import entity.*;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import rojerusan.RSNotifyFade;
import utils.CertificateUtils;
import static utils.CertificateUtils.decryptData;

/**
 *
 * @author kevscl
 */
public class CrearCuenta extends javax.swing.JFrame {

    /**
     * Creates new form CrearCuenta
     */
    private X509Certificate certificate;
    private PrivateKey privateKey;

    private Color mTransaparent;
    private Point mPoint;
    ClavesBO cbo = new ClavesBO();
    CertificateUtils cert = new CertificateUtils();

    private PanelListener panelListener;

    public void setPanelListener(PanelListener listener) {
        this.panelListener = listener;
    }

    public CrearCuenta() {
        mTransaparent = new Color(0, 0, 0, 0);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        setBackground(mTransaparent);
    }

    public void pasaDatos(X509Certificate certificate, PrivateKey privateKey) {
        this.certificate = certificate;
        this.privateKey = privateKey;
    }

    public void crearCuenta() throws Exception {
        // Validar que los campos no sean null ni estén vacíos
        if (txtSitio.getText() == null || txtSitio.getText().trim().isEmpty()) {
            new rojerusan.RSNotifyFade("¡ERROR!", "El campo 'Sitio' no puede estar vacío.", 3, RSNotifyFade.PositionNotify.TopRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
            return; // Detener ejecución si es inválido
        }

        if (txtCorreo.getText() == null || txtCorreo.getText().trim().isEmpty()) {
            new rojerusan.RSNotifyFade("¡ERROR!", "El campo 'Correo' no puede estar vacío.", 3, RSNotifyFade.PositionNotify.TopRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
            return; // Detener ejecución si es inválido
        }

        if (txtPassword.getText() == null || txtPassword.getText().trim().isEmpty()) {
            new rojerusan.RSNotifyFade("¡ERROR!", "El campo 'Contraseña' no puede estar vacío.", 3, RSNotifyFade.PositionNotify.TopRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
            return; // Detener ejecución si es inválido
        }

        PublicKey publicKey = certificate.getPublicKey();
        String sitio = txtSitio.getText();
        String correo = txtCorreo.getText();
        String pass = txtPassword.getText();

        // Cifrar clave
        byte[] encryptedData = cert.encryptData(publicKey, pass.getBytes());
        System.out.println(sitio + " " + correo + " " + Base64.getEncoder().encodeToString(encryptedData));  // Para depuración

        Claves c = new Claves();
        c.setClave(encryptedData);  // Usar byte[] directamente
        c.setCorreo(correo);
        c.setSitio_web(sitio);

        String mensaje = cbo.agregarClave(c);  // Asegúrate de pasar la conexión
        byte[] decryptedData = decryptData(privateKey, encryptedData);
        //System.out.println("Datos descifrados: " + new String(decryptedData));
        if (!mensaje.equals("GUARDADO CORRECTAMENTE")) {
            new rojerusan.RSNotifyFade("¡ERROR!", "¡Error al guardar la cuenta!", 3, RSNotifyFade.PositionNotify.TopRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
        } else {
            new rojerusan.RSNotifyFade("¡SUCCESS!", "¡Guardado Correctamente!", 3, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
            if (panelListener != null) {
                panelListener.onPanelClosed();
            }
            dispose();
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

        panelVista = new javax.swing.JPanel();
        labelBienvenido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rSPanelImage1 = new rojeru_san.rspanel.RSPanelImage();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();
        panelLogin = new javax.swing.JPanel();
        txtSitio = new rojeru_san.rsfield.RSTextMaterial();
        btnIngresar = new rojeru_san.RSButtonRiple();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        rSLabelTextIcon2 = new RSMaterialComponent.RSLabelTextIcon();
        rSLabelTextIcon3 = new RSMaterialComponent.RSLabelTextIcon();
        txtPassword = new RSMaterialComponent.RSPasswordTwo();
        txtCorreo = new rojeru_san.rsfield.RSTextMaterial();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelVista.setBackground(new java.awt.Color(69, 87, 252));
        panelVista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBienvenido.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        labelBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBienvenido.setText("¡BIENVENIDO!");
        panelVista.add(labelBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 300, 80));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Por favor ingrese sus datos para ");
        panelVista.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("agregar la cuenta.");
        panelVista.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, -1, -1));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/icons/gestor-contraseñas-ciberprotector.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        panelVista.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 320, 240));

        rSLabelIcon1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        rSLabelIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSLabelIcon1MouseClicked(evt);
            }
        });
        panelVista.add(rSLabelIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        getContentPane().add(panelVista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 560));

        panelLogin.setBackground(new java.awt.Color(255, 255, 255));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSitio.setForeground(new java.awt.Color(0, 0, 0));
        txtSitio.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtSitio.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        txtSitio.setPlaceholder("GitHub");
        txtSitio.setSelectionColor(new java.awt.Color(220, 23, 111));
        panelLogin.add(txtSitio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 306, -1));

        btnIngresar.setBackground(new java.awt.Color(66, 183, 42));
        btnIngresar.setText("Crear una cuenta");
        btnIngresar.setColorHover(new java.awt.Color(173, 187, 194));
        btnIngresar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelLogin.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 306, -1));

        rSLabelTextIcon1.setText("Ingrese el sitio web");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LANGUAGE);
        panelLogin.add(rSLabelTextIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 190, -1));

        rSLabelTextIcon2.setText("Ingrese su correo");
        rSLabelTextIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        panelLogin.add(rSLabelTextIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 190, -1));

        rSLabelTextIcon3.setText("Ingrese su contraseña");
        rSLabelTextIcon3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SECURITY);
        panelLogin.add(rSLabelTextIcon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 230, -1));

        txtPassword.setPlaceholder("********");
        panelLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreo.setColorMaterial(new java.awt.Color(69, 87, 252));
        txtCorreo.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        txtCorreo.setPlaceholder("example@example.com");
        txtCorreo.setSelectionColor(new java.awt.Color(220, 23, 111));
        panelLogin.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 306, -1));

        getContentPane().add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        try {
            crearCuenta();
        } catch (Exception ex) {
            Logger.getLogger(CrearCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void rSLabelIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSLabelIcon1MouseClicked
        this.dispose();
    }//GEN-LAST:event_rSLabelIcon1MouseClicked

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
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPanel panelVista;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon2;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon3;
    private rojeru_san.rspanel.RSPanelImage rSPanelImage1;
    private rojeru_san.rsfield.RSTextMaterial txtCorreo;
    private RSMaterialComponent.RSPasswordTwo txtPassword;
    private rojeru_san.rsfield.RSTextMaterial txtSitio;
    // End of variables declaration//GEN-END:variables
}
