package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.EncryptedPrivateKeyInfo;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Utilidades para la carga, desciframiento y ciframiento de certificados y claves privadas.
 */
public class CertificateUtils {

    /**
     * Carga un certificado X.509 desde un archivo.
     * 
     * @param file El archivo que contiene el certificado.
     * @return El certificado X.509 cargado.
     * @throws Exception Si ocurre un error al leer el archivo o al generar el certificado.
     */
    public static X509Certificate loadCertificate(File file) throws Exception {
        try (FileInputStream fis = new FileInputStream(file)) {
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            return (X509Certificate) certFactory.generateCertificate(fis);
        }
    }

    /**
     * Carga una clave privada cifrada desde un archivo y la descifra usando una contraseña.
     * 
     * @param file El archivo que contiene la clave privada cifrada.
     * @param password La contraseña utilizada para descifrar la clave privada.
     * @return La clave privada descifrada.
     * @throws Exception Si ocurre un error al leer el archivo o al descifrar la clave.
     */
    public static PrivateKey loadEncryptedPrivateKey(File file, String password) throws Exception {
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            // Leer el contenido del archivo en un buffer
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }
            String keyString = new String(baos.toByteArray());

            // Extraer la clave cifrada del contenido del archivo
            Pattern pattern = Pattern.compile("-----BEGIN .*?-----\\s*(.*?)\\s*-----END .*?-----", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(keyString);
            if (matcher.find()) {
                String base64Key = matcher.group(1).replaceAll("\\s", "");
                byte[] encryptedKeyBytes = Base64.getDecoder().decode(base64Key);

                // Crear un objeto EncryptedPrivateKeyInfo a partir de los bytes decodificados
                EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(encryptedKeyBytes);
                
                // Generar una clave secreta a partir de la contraseña proporcionada
                PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
                SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(encryptedPrivateKeyInfo.getAlgName());
                SecretKey secretKey = keyFactory.generateSecret(pbeKeySpec);

                // Descifrar la clave privada
                Cipher cipher = Cipher.getInstance(encryptedPrivateKeyInfo.getAlgName());
                cipher.init(Cipher.DECRYPT_MODE, secretKey, encryptedPrivateKeyInfo.getAlgParameters());

                PKCS8EncodedKeySpec keySpec = encryptedPrivateKeyInfo.getKeySpec(cipher);
                KeyFactory kf = KeyFactory.getInstance("RSA");
                return kf.generatePrivate(keySpec);
            } else {
                throw new IllegalArgumentException("No se encontró una clave privada válida en el archivo.");
            }
        }
    }

    /**
     * Cifra datos usando una clave pública RSA.
     * 
     * @param publicKey La clave pública RSA utilizada para cifrar los datos.
     * @param data Los datos a cifrar.
     * @return Los datos cifrados.
     * @throws Exception Si ocurre un error al cifrar los datos.
     */
    public static byte[] encryptData(PublicKey publicKey, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * Descifra datos usando una clave privada RSA.
     * 
     * @param privateKey La clave privada RSA utilizada para descifrar los datos.
     * @param encryptedData Los datos cifrados.
     * @return Los datos descifrados.
     * @throws Exception Si ocurre un error al descifrar los datos.
     */
    public static byte[] decryptData(PrivateKey privateKey, byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encryptedData);
    }
 
}
