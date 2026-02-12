package com.lms.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Hash password
    public static String hash(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    // Verify password
    public static boolean verify(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
