package com.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashExample {
    public static void main(String[] args) {
        try {
            String hexString = "9a";
            byte[] byteArray = hexStringToByteArray(hexString);

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = md.digest(byteArray);
            String resultHash = bytesToHex(hashBytes);

            System.out.println("SHA-1 hash: " + resultHash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error: SHA-1 algorithm not found.");
        }
    }

    // Metodo per convertire una stringa esadecimale in un array di byte
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    // Metodo per convertire un array di byte in una stringa esadecimale
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
