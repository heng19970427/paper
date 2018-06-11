package com.zr.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Digest {

    public static String digestPassword(String password) {
        String result = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = password.getBytes("UTF-8");
            byte[] digested = md5.digest(bytes);
            Base64.Encoder encoder = Base64.getEncoder();
            result = encoder.encodeToString(digested);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }

}
