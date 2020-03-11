/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 *
 * @author rnovak
 */
public class PasswordUtil {

    /**
     * Hashes a string password
     *
     * @param password the password
     * @return hash the hashed password
     * @throws NoSuchAlgorithmException
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        byte[] messageDigestArray = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder(messageDigestArray.length * 2);
        for (byte b : messageDigestArray) {
            int v = b & 0xff;
            if (v < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(v));

        }
        return stringBuilder.toString();
    }

    /**
     * Generates salt based on secure random
     *
     * @return salt the salt
     */
    public static String generateSalt() {
        Random random = new SecureRandom();
        byte[] saltBytes = new byte[32];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }
}
