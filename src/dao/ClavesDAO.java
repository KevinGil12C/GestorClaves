package dao;

import entity.Claves;
import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.crypto.Cipher;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevscl
 */
public class ClavesDAO {

    public String agregarClave(Connection con, Claves cl) {
        String mensaje;
        PreparedStatement pst = null;
        String sql = "INSERT INTO CLAVES(sitio_web, correo, clave) VALUES(?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cl.getSitio_web());
            pst.setString(2, cl.getCorreo());
            pst.setBytes(3, cl.getClave());  // Corregido aquí
            pst.execute();
            mensaje = "GUARDADO CORRECTAMENTE";
        } catch (SQLException e) {
            mensaje = "ERROR: " + e.getMessage();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mensaje;
    }

    public String actualizarClave(Connection con, Claves cl) {
        String mensaje;
        PreparedStatement pst = null;
        String sql = "UPDATE CLAVES SET sitio_web=?, correo=?, clave=? WHERE id_clave=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cl.getSitio_web());
            pst.setString(2, cl.getCorreo());
            pst.setBytes(3, cl.getClave());
            pst.setInt(4, cl.getId_clave());
            pst.execute();
            pst.close();
            mensaje = "ACTUALIZADO CORRECTAMENTE";
        } catch (SQLException e) {
            mensaje = "ERROR: " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarClave(Connection con, int idClave) {
        String mensaje;
        PreparedStatement pst = null;
        String sql = "DELETE FROM CLAVES WHERE id_clave=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idClave);
            pst.execute();
            pst.close();
            mensaje = "ELIMINADO CORRECTAMENTE";
        } catch (SQLException e) {
            mensaje = "ERROR: " + e.getMessage();
        }
        return mensaje;
    }

    public void listarClaves(Connection con, JTable tabla, PrivateKey privateKey) {
        DefaultTableModel model;
        String[] columnas = {"ID", "SITIO WEB", "CORREO", "CLAVE"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM CLAVES ORDER BY id_clave ASC";
        String[] filas = new String[4];
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_clave");
                filas[1] = rs.getString("sitio_web");
                filas[2] = rs.getString("correo");

                // Obtener la clave cifrada como byte[]
                byte[] encryptedData = rs.getBytes("clave");

                // Descifrar la clave utilizando la clave privada
                byte[] decryptedData = decryptData(privateKey, encryptedData);
                String claveDescifrada = new String(decryptedData);

                filas[3] = claveDescifrada; // Asignar la clave descifrada al modelo de la tabla

                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error al listar la tabla: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al descifrar los datos: " + e.getMessage());
        } finally {
            // Cerrar PreparedStatement y ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void listarClavesSinClave(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID", "STIO WEB", "CORREO", "CLAVE"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM CLAVES ORDER BY id_clave ASC";
        String[] filas = new String[4];
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                filas[0] = rs.getString("id_clave");
                filas[1] = rs.getString("sitio_web");
                filas[2] = rs.getString("correo");
                filas[3] = rs.getString("clave");
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al listar la tabla: " + e.getMessage());
        } finally {
            // Cerrar PreparedStatement y ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public byte[] decryptData(PrivateKey privateKey, byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encryptedData);
    }

    public void buscarClave(Connection con, JTable tabla, String campo, PrivateKey privateKey) {
        DefaultTableModel model;
        String[] columnas = {"ID", "SITIO WEB", "CORREO", "CLAVE"};
        model = new DefaultTableModel(null, columnas);

        // Modificar el SQL para usar LIKE y permitir coincidencias parciales
        String sql = "SELECT * FROM CLAVES WHERE sitio_web LIKE ? OR correo LIKE ? ORDER BY id_clave ASC";
        String[] filas = new String[4];
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = con.prepareStatement(sql);

            // Usar "%" para buscar coincidencias parciales
            String searchPattern = "%" + campo + "%";
            pst.setString(1, searchPattern);
            pst.setString(2, searchPattern);

            rs = pst.executeQuery();

            while (rs.next()) {
                filas[0] = rs.getString("id_clave");
                filas[1] = rs.getString("sitio_web");
                filas[2] = rs.getString("correo");

                // Obtener la clave cifrada como byte[]
                byte[] encryptedData = rs.getBytes("clave");

                // Descifrar la clave utilizando la clave privada
                byte[] decryptedData = decryptData(privateKey, encryptedData);
                String claveDescifrada = new String(decryptedData);

                filas[3] = claveDescifrada; // Asignar la clave descifrada al modelo de la tabla

                model.addRow(filas);
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            System.out.println("Error al listar la tabla: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al descifrar los datos: " + e.getMessage());
        } finally {
            // Cerrar PreparedStatement y ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
