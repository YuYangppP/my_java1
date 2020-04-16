package com.yu.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName SHA1Utils.java
 * @Description TODO
 * @Date 2020/4/10 15:59
 */
public class SHA1Utils {
    public static void main(String[] args) {
        /*String source = "123456";
        //1.使用SHA1加密1次
        Sha1Hash hash1 = new Sha1Hash(source);
        System.out.println("SHA1加密一次"+hash1);

        //2.使用SHA1加密2次
        Sha1Hash hash2 = new Sha1Hash(hash1.toString());
        System.out.println("SHA1加密2次"+hash2);

        //3.使用SHA1加密1次并加盐
        Sha1Hash hash3 = new Sha1Hash(source,"扶余市");
        System.out.println("SHA1加密1次并加盐"+hash3);

        //4,使用SHA1加密二次并加盐
		Sha1Hash hash4=new Sha1Hash(source, "扶余市",2);
		System.out.println("使用SHA1加密二次并加盐"+hash4);*/

        System.out.println(sha1("123456","zhangsan",2));

    }

    /**
     * 封装方法
     * @param source 明文
     * @param salt   盐
     * @param hashIterations 散列次数
     * @return
     */
    public static String sha1(Object source,Object salt,Integer hashIterations){
        return new Sha1Hash(source,salt,hashIterations).toString();
    }
}
