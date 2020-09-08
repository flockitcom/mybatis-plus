package com.zq.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 辅助类
 */
@Slf4j
public class MD5Util {

    /**
     * 密码MD5双重加密
     *
     * @param password
     * @param salt
     * @return
     */
    public static String pwdEncrypt(String password, String salt) {
        return MD5Util.genMD5(MD5Util.genMD5(password) + salt);
    }

    /**
     * 生成MD5
     *
     * @param str
     * @return
     */
    public static String genMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString();
            // 16位的加密
            // return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {

            log.error("Failed to reset password encryption==========================================》");
            return null;
        }
    }
}
