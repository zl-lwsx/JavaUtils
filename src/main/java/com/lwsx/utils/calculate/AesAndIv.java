package com.lwsx.utils.calculate;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class AesAndIv {
    public static void main(String[] args) throws Exception {
//        java aes 加密 iv
//        https://juejin.cn/s/java%20aes%20%E5%8A%A0%E5%AF%86%20iv
        // 生成随机密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println("secretKey string: " + secretKey.getEncoded());

        // 指定IV
        byte[] ivBytes = new byte[16];
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        // 加密
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encryptedBytes = cipher.doFinal("Hello World".getBytes());
        System.out.println("encryptedBytes string: " + encryptedBytes.toString());

        // 将加密后的数据用Base64编码
        String encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted string: " + encryptedString);

        // 解密
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
        System.out.println("Decrypted string: " + new String(decryptedBytes));
    }
}
