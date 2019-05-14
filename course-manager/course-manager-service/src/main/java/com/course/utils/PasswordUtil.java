package com.course.utils;

import com.course.pojo.Userlogin;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtil {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }
    /**
     * 密码加密
     */
    public void encryptPassword(Userlogin user){
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

}
