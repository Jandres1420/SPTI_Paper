package edu.eci.spti.logs.persistance;
import javax.crypto.Cipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Date;

public class SecurityLogs {


    private PrivateKey privateKey;
    private PublicKey publicKey;

    public SecurityLogs() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(1024);
            KeyPair pair = generator.generateKeyPair();
            privateKey = pair.getPrivate();
            publicKey = pair.getPublic();
        } catch (Exception ignored) {
        }
    }

    public String encrypt(String message) throws Exception {
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return encode(encryptedBytes);
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] encryptedBytes = decode(encryptedMessage);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedMessage = cipher.doFinal(encryptedBytes);
        return new String(decryptedMessage, "UTF8");
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void main(String[] args) {
        SecurityLogs rsa = new SecurityLogs();
        try {
            String encryptedMessage = rsa.encrypt("This is Linuxhint.com");
            String decryptedMessage = rsa.decrypt(encryptedMessage);

            System.err.println("Encrypted:\n" + encryptedMessage);
            System.err.println("Decrypted:\n" + decryptedMessage);
            Date date = new Date();
            System.err.println("Fecha actual\n" + date.toString());
        } catch (Exception ignored) {
        }
    }
}
