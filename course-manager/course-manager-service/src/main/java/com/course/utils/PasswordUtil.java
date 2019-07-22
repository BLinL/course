package com.course.utils;

import com.course.pojo.Userlogin;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtil {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static String algorithmName = "md5";
    private static int hashIterations = 2;
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }
    /**
     * 密码加密
     */
    public static void encryptPassword(Userlogin user){
        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        System.out.println("salt:"+user.getSalt());
        String password = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();
        System.out.println("------"+password);
        user.setPassword(password);
    }

    public static void main(String[] args) {
        Userlogin user = new Userlogin("li","123");
        PasswordUtil.encryptPassword(user);
    }

}
