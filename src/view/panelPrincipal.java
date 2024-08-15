/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import necesario.RSFileChooser;
import rojerusan.RSNotifyFade;
import utils.CambiaPanel;
import utils.CertificateUtils;
import utils.CrearCuenta;
import utils.panelCarga;
import utils.panelTabla;
import utils.PanelListener;
import utils.panelAbout;

/**
 *
 * @author kevscl
 */
public class panelPrincipal extends javax.swing.JPanel implements PanelListener{

    /**
     * Creates new form panelPrincipal
     */
    public panelPrincipal() {
        initComponents();
        new CambiaPanel(panelCambio, new panelTabla(certificate, privateKey));
    }

    private boolean isCertificateAndKeyLoaded = false;
    private X509Certificate certificate;
    private PrivateKey privateKey;

    public void onPanelClosed() {
        new CambiaPanel(panelCambio, new panelTabla(certificate, privateKey));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelLineWrap1 = new rojeru_san.rslabel.RSLabelLineWrap();
        panelCarga = new javax.swing.JPanel();
        panelAbout = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        rSLabelIcon1 = new RSMaterialComponent.RSLabelIcon();
        rSLabelHora1 = new rojeru_san.componentes.RSLabelHora();
        rSLabelIcon2 = new RSMaterialComponent.RSLabelIcon();
        rSLabelImage2 = new rojeru_san.rslabel.RSLabelImage();
        buttonConectar = new rojerusan.RSButtonIconI();
        buttonDesconectar = new rojerusan.RSButtonIconI();
        jLabel5 = new javax.swing.JLabel();
        buttonGeneraClaves = new rojerusan.RSButtonIconI();
        buttonAgregar = new rojerusan.RSButtonIconI();
        buttonAcercaDe = new rojerusan.RSButtonIconI();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        buttonGitHub = new rojeru_san.rsbutton.RSButtonRoundEffectIcon();
        buttonLinkedin = new rojeru_san.rsbutton.RSButtonRoundEffectIcon();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rSPanelMaterialImage2 = new RSMaterialComponent.RSPanelMaterialImage();
        panelCambio = new javax.swing.JPanel();

        rSLabelLineWrap1.setColorForeground(new java.awt.Color(0, 0, 0));
        rSLabelLineWrap1.setFuente(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        rSLabelLineWrap1.setText("El presente Aviso de Privacidad establece los términos y condiciones bajo los cuales \"Kevscl\" utiliza y protege la información que es proporcionada por los usuarios al utilizar el sistema de ventas \"Sistema de ventas Kevscl\", desarrollado por KevinGil12C y JorgeRenteriaA.\n\nLa Empresa se compromete a proteger la información personal de los usuarios y a implementar medidas de seguridad adecuadas para prevenir el acceso no autorizado, la divulgación, modificación o destrucción de los datos recopilados, de acuerdo con las políticas de seguridad de CIA (Confidencialidad, Integridad, Disponibilidad). Se mantendrán salvaguardias físicas y electrónicas para garantizar la seguridad de la información.\n\nLa Empresa no venderá, cederá ni transferirá la información personal de los usuarios a terceros, a menos que sea necesario para cumplir con los fines mencionados anteriormente o cuando la ley lo requiera.\n\nLos usuarios podrán ejercer los derechos de acceso, rectificación, cancelación y oposición (derechos ARCO) sobre sus datos personales. Para ejercer estos derechos, deberán enviar una solicitud por escrito al siguiente correo electrónico: kebo.jcg77@gmail.com");

        javax.swing.GroupLayout panelCargaLayout = new javax.swing.GroupLayout(panelCarga);
        panelCarga.setLayout(panelCargaLayout);
        panelCargaLayout.setHorizontalGroup(
            panelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelCargaLayout.setVerticalGroup(
            panelCargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelAboutLayout = new javax.swing.GroupLayout(panelAbout);
        panelAbout.setLayout(panelAboutLayout);
        panelAboutLayout.setHorizontalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelAboutLayout.setVerticalGroup(
            panelAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(23, 35, 23));
        setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(65, 110, 223));

        rSLabelTextIcon1.setBackground(new java.awt.Color(65, 110, 223));
        rSLabelTextIcon1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelTextIcon1.setText("Gestor de contraseñas Kevscl");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.COMPUTER);

        rSLabelIcon1.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        rSLabelIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSLabelIcon1MouseClicked(evt);
            }
        });

        rSLabelHora1.setForeground(new java.awt.Color(255, 255, 255));

        rSLabelIcon2.setForeground(new java.awt.Color(255, 255, 255));
        rSLabelIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SPACE_BAR);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rSLabelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/gestor-contraseñas-ciberprotector.png"))); // NOI18N

        buttonConectar.setBackground(new java.awt.Color(65, 110, 223));
        buttonConectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/material-symbols--usb.png"))); // NOI18N
        buttonConectar.setText("Conectar");
        buttonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConectarActionPerformed(evt);
            }
        });

        buttonDesconectar.setBackground(new java.awt.Color(65, 110, 223));
        buttonDesconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lucide--shield-close.png"))); // NOI18N
        buttonDesconectar.setText("Desconectar");
        buttonDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDesconectarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Gestor contraseñas - Kevscl");

        buttonGeneraClaves.setBackground(new java.awt.Color(65, 110, 223));
        buttonGeneraClaves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arcticons--clavepin.png"))); // NOI18N
        buttonGeneraClaves.setText("Generar claves");
        buttonGeneraClaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGeneraClavesActionPerformed(evt);
            }
        });

        buttonAgregar.setBackground(new java.awt.Color(65, 110, 223));
        buttonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/material-symbols--create-new-folder-outline.png"))); // NOI18N
        buttonAgregar.setText("Agregar cuenta");
        buttonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarActionPerformed(evt);
            }
        });

        buttonAcercaDe.setBackground(new java.awt.Color(65, 110, 223));
        buttonAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mdi--about-circle-outline.png"))); // NOI18N
        buttonAcercaDe.setText("Acerca de");
        buttonAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcercaDeActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Soporte y Desarrollo");

        buttonGitHub.setBackground(new java.awt.Color(69, 87, 252));
        buttonGitHub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/uiw--github.png"))); // NOI18N
        buttonGitHub.setText("Kevin Heath");
        buttonGitHub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGitHubActionPerformed(evt);
            }
        });

        buttonLinkedin.setBackground(new java.awt.Color(69, 87, 252));
        buttonLinkedin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/skill-icons--linkedin.png"))); // NOI18N
        buttonLinkedin.setText("Kevin Gil");
        buttonLinkedin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLinkedinActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(93, 97, 92));
        jLabel3.setText("Tel: (+52) 722-159-5250");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(93, 97, 92));
        jLabel4.setText("Correo: kebo.jcg77@gmail.com");

        rSPanelMaterialImage2.setImagen(new javax.swing.ImageIcon(getClass().getResource("/icons/KeIWVHueSHCoexSmVL_Chg.jpg"))); // NOI18N
        rSPanelMaterialImage2.setShadowBottom(false);
        rSPanelMaterialImage2.setShadowLeft(false);
        rSPanelMaterialImage2.setShadowRight(false);
        rSPanelMaterialImage2.setShadowTop(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(rSPanelMaterialImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonGitHub, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLinkedin, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonGitHub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonLinkedin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rSPanelMaterialImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelCambio.setBackground(new java.awt.Color(255, 255, 255));
        panelCambio.setLayout(new javax.swing.BoxLayout(panelCambio, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(buttonDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonGeneraClaves, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonConectar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(panelCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rSLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addComponent(buttonGeneraClaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDesconectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGitHubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGitHubActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/KevinGil12C"));
        } catch (URISyntaxException | IOException ex) {

        }
    }//GEN-LAST:event_buttonGitHubActionPerformed

    private void buttonLinkedinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLinkedinActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://www.linkedin.com/in/kevin-jesus-coyote-gil-030287288/"));
        } catch (URISyntaxException | IOException ex) {

        }
    }//GEN-LAST:event_buttonLinkedinActionPerformed

    private void buttonGeneraClavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGeneraClavesActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/KevinGil12C/genera_certificado"));
        } catch (URISyntaxException | IOException ex) {

        }
    }//GEN-LAST:event_buttonGeneraClavesActionPerformed

    private void buttonConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConectarActionPerformed
        try {
            RSFileChooser fileChooser = new RSFileChooser();
            fileChooser.setDialogTitle("Selecciona el certificado");
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File certFile = fileChooser.getSelectedFile();
                fileChooser.setDialogTitle("Selecciona la clave privada");
                returnValue = fileChooser.showOpenDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File keyFile = fileChooser.getSelectedFile();
                    String password = JOptionPane.showInputDialog("Introduce la contraseña para la clave privada:");

                    // Cargar certificado y clave
                    certificate = CertificateUtils.loadCertificate(certFile);
                    privateKey = CertificateUtils.loadEncryptedPrivateKey(keyFile, password);

                    // Si se carga correctamente, marcamos la bandera como verdadera
                    isCertificateAndKeyLoaded = true;
                    if (isCertificateAndKeyLoaded) {
                        panelTabla panel = new panelTabla(certificate, privateKey);
                        new CambiaPanel(panelCambio, panel);
                        new rojerusan.RSNotifyFade("¡SUCCESS!", "¡Certificado y clave cargados correctamente!", 5, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            new rojerusan.RSNotifyFade("¡ERROR!", "¡Error al cargar el certificado o la clave!", 3, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
        }
    }//GEN-LAST:event_buttonConectarActionPerformed

    private void buttonDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDesconectarActionPerformed
        // Limpiar las variables de instancia para el certificado y la clave privada
        certificate = null;
        privateKey = null;

        // Cambiar el panel a panelCarga
        new CambiaPanel(panelCambio, new panelTabla(certificate, privateKey));

        // Mostrar un mensaje de éxito o de confirmación
        new rojerusan.RSNotifyFade("¡SUCCESS!", "Se ha desconectado correctamente.", 5, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
    }//GEN-LAST:event_buttonDesconectarActionPerformed

    private void buttonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarActionPerformed

        if (certificate != null && privateKey != null) {
            CrearCuenta c = new CrearCuenta();
            c.pasaDatos(certificate, privateKey);
            c.setPanelListener(this);
            c.setVisible(true);
        } else {
            new rojerusan.RSNotifyFade("¡ERROR!", "¡El certificado o la clave privada no están cargados!", 3, RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.WARNING).setVisible(true);
        }
    }//GEN-LAST:event_buttonAgregarActionPerformed

    private void rSLabelIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSLabelIcon1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_rSLabelIcon1MouseClicked

    private void buttonAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcercaDeActionPerformed
        new CambiaPanel(panelCambio, new panelAbout());
    }//GEN-LAST:event_buttonAcercaDeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSButtonIconI buttonAcercaDe;
    private rojerusan.RSButtonIconI buttonAgregar;
    private rojerusan.RSButtonIconI buttonConectar;
    private rojerusan.RSButtonIconI buttonDesconectar;
    private rojerusan.RSButtonIconI buttonGeneraClaves;
    private rojeru_san.rsbutton.RSButtonRoundEffectIcon buttonGitHub;
    private rojeru_san.rsbutton.RSButtonRoundEffectIcon buttonLinkedin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelAbout;
    private javax.swing.JPanel panelCambio;
    private javax.swing.JPanel panelCarga;
    private rojeru_san.componentes.RSLabelHora rSLabelHora1;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon1;
    private RSMaterialComponent.RSLabelIcon rSLabelIcon2;
    private rojeru_san.rslabel.RSLabelImage rSLabelImage2;
    private rojeru_san.rslabel.RSLabelLineWrap rSLabelLineWrap1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSPanelMaterialImage rSPanelMaterialImage2;
    // End of variables declaration//GEN-END:variables
}
