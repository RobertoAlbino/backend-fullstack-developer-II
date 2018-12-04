package com.roberto.cotaeasy.utils;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class MD5Utils {

    public static String encript(String string)  {
        try {
            byte[] hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            return hexString.toString();
        } catch(NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return null;
        }
    }
}