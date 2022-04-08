/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.encryped;

import java.security.MessageDigest;

/**
 *
 * @author ayrton
 */
public class encriptacion {

    public String encrip(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer a = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String b = Integer.toHexString(0xff & hash[i]);
                if (b.length() == 1) {
                    a.append("0");
                }
                a.append(b);
            }
            return a.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
