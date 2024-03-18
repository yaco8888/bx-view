package com.bx.portrait.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5Utils
 */
public class MD5Utils {

    public static String toMd5(String password) {
        String md5Hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();

            // 将字节数组转换为十六进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            md5Hash = sb.toString();
//            System.out.println("MD5 加密结果: " + md5Hash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 算法未找到");
        }
        return md5Hash;
    }
}
