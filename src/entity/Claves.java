package entity;

/**
 *
 * @author kevscl
 */
public class Claves {

    private int id_clave;
    private String sitio_web;
    private String correo;
    private byte[] clave;
    public Claves() {
    }
    public Claves(int id_clave, String sitio_web, String correo, byte[] clave) {
        this.id_clave = id_clave;
        this.sitio_web = sitio_web;
        this.correo = correo;
        this.clave = clave;
    }

    public Claves(String sitio_web, String correo, byte[] clave) {
        this.sitio_web = sitio_web;
        this.correo = correo;
        this.clave = clave;
    }
    
    public int getId_clave() {
        return id_clave;
    }
    public void setId_clave(int id_clave) {
        this.id_clave = id_clave;
    }
    public String getSitio_web() {
        return sitio_web;
    }
    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public byte[] getClave() {
        return clave;
    }
    public void setClave(byte[]clave) {
        this.clave = clave;
    }
    @Override
    public String toString() {
        return "Claves [id_clave=" + id_clave + ", sitio_web=" + sitio_web + ", correo=" + correo + ", clave=" + clave
                + "]";
    }

    

}
