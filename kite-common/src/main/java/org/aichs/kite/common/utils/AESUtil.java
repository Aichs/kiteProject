package org.aichs.kite.common.utils;

import cn.hutool.core.codec.Base64;
import org.aichs.kite.common.base.GlobalContract;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @ClassName AESUtil
 * @Deacription AES加密工具
 * @Author Kite
 * @Date 2019/11/29 15:03
 **/
public class AESUtil {


    /**
     * @Author 琴弦
     * @Description //生成加密秘钥
     * @Date 15:19 2019/11/29
     * @Param [password]
     * @return javax.crypto.spec.SecretKeySpec
     **/
    private static SecretKeySpec getSecretKey(final String password){
        try {
            // 返回生成指定算法密钥生成器的 KeyGenerator 对象
            KeyGenerator keyGenerator;
            keyGenerator = KeyGenerator.getInstance("AES");

            // AES要求密码长度为128
            keyGenerator.init(128,new SecureRandom(password.getBytes()));

            // 生成一个密钥
            SecretKey secretKey = keyGenerator.generateKey();

            // 转换为AES专用密钥
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * @Author 琴弦
     * @Description //AES加密
     * @Date 15:17 2019/11/29
     * @Param [content]
     * @return java.lang.String
     **/
    public static String encrypt(String content) {
        try {
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] byteContent = content.getBytes(StandardCharsets.UTF_8);

            // 使用密钥初始化，设置为解密模式
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(GlobalContract.AES_KEY));

            byte[] result = cipher.doFinal(byteContent);

            return Base64.encode(result);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return null;
    }
    
    /**
     * @Author 琴弦
     * @Description //AES 解密
     * @Date 15:28 2019/11/29
     * @Param [content]
     * @return java.lang.String
     **/
    public static String decrypt(String content){

        try {
            // 实例化
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // 使用密钥初始化，设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(GlobalContract.AES_KEY));

            // 执行操作
            byte[] result = cipher.doFinal(Base64.decode(content));

            return new String(result, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return null;
    }
}
