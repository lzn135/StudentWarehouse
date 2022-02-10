package com.fish.blog.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Base64;

public class MD5Util {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String value) {
        String resultString = null;
        try {
            resultString = new String(value);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
        } catch (Exception e) {
        }
        return resultString;
    }
//    /**
//     * 生成java.security.key
//     * @param password 自定义密码规则【对称本质所在】
//     * @return
//     * @throws Exception
//     */
//    private static Key generateKey(String password) throws Exception {
//        //设置编码
//        DESKeySpec dks = new DESKeySpec(password.getBytes("utf-8"));
//        //密钥算法
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//        return keyFactory.generateSecret(dks);
//    }
//    /**
//     * DES加密字符串
//     * @param IV_PARAMETER 偏移量 固定8位字节
//     * @param password 加密密码
//     * @param data 待加密字符串
//     * @return
//     */
//    public static String desencrypt(String IV_PARAMETER, String password, String data) {
//        if (password== null || password.length() < 8) {
//            throw new RuntimeException("加密失败，key不能小于8位");
//        }
//        if (data == null){
//            return null;
//        }
//        try {
//            Key secretKey = generateKey(password);
//            //加密/解密算法-工作模式-填充模式
//            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//            IvParameterSpec iv = new IvParameterSpec(IV_PARAMETER.getBytes("utf-8"));
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
//            byte[] bytes = cipher.doFinal(data.getBytes("utf-8"));
//            //JDK1.8及以上可直接使用Base64，JDK1.7及以下可以使用BASE64Encoder
//            //Android平台可以使用android.util.Base64
//            String after =  new String(Base64.getEncoder().encode(bytes));
//            System.out.println("对称之DES加密后的字符: "+ after);
//            return after;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return data;
//        }
//    }

    public static String MD5Decrypt(String inStr) {
        // String s = new String(inStr);
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
}
