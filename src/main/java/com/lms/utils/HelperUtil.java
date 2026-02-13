package com.lms.utils;

import java.util.UUID;

public class HelperUtil {

//    1.UUID generator...
    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

//   2.Version for first time....
    public static int initialVersion() {
        return 0;
    }

//   3.Version on updated...
    public static int nextVersion(int currentVersion) {
        return currentVersion + 1;
    }

    public static boolean isEmpty(String s){
        return s == null || s.trim().isEmpty();
    }

}
