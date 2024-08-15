package bo;

import bd.Conexion;
import dao.ClavesDAO;
import entity.Claves;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JTable;

import bd.Conexion;
import java.security.PrivateKey;

public class ClavesBO {
    private ClavesDAO cdao = new ClavesDAO();

    private static String mensaje = "";

    public String agregarClave(Claves c) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = cdao.agregarClave(conn, c);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String actualizarClave(Claves c) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = cdao.actualizarClave(conn, c);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String eliminarClave(int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = cdao.eliminarClave(conn, id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
    
    public void listarClaves(JTable tabla, PrivateKey privateKey) {
        Connection conn = Conexion.getConnection();
        cdao.listarClaves(conn, tabla, privateKey);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarClavesSinClave(JTable tabla) {
        Connection conn = Conexion.getConnection();
        cdao.listarClavesSinClave(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void buscarClave(JTable tabla, String campo, PrivateKey privateKey) {
        Connection conn = Conexion.getConnection();
        cdao.buscarClave(conn, tabla, campo, privateKey);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
