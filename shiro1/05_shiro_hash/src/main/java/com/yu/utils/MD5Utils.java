package com.yu.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName MD5Utils.java
 * @Description TODO
 * @Date 2020/4/10 15:59
 */
public class MD5Utils {
    public static void main(String[] args) {
     /*   String source = "123456";
        //1.使用MD5加密1次
        Md5Hash hash1 = new Md5Hash(source);
        System.out.println("MD5加密一次"+hash1);

        //2.使用MD5加密2次
        Md5Hash hash2 = new Md5Hash(hash1.toString());
        System.out.println("MD5加密2次"+hash2);

        //3.使用MD5加密1次并加盐
        Md5Hash hash3 = new Md5Hash(source,"扶余市");
        System.out.println("MD5加密1次并加盐"+hash3);

        //4,使用MD5加密二次并加盐
		Md5Hash hash4=new Md5Hash(source, "扶余市",2);
		System.out.println("使用MD5加密二次并加盐"+hash4);*/

        System.out.println(md5("123456","zhaoliu",2));

    }

    /**
     * 封装方法
     * @param source 明文
     * @param salt   盐
     * @param hashIterations 散列次数
     * @return
     */
    public static String md5(Object source,Object salt,Integer hashIterations){
        return new Md5Hash(source,salt,hashIterations).toString();
    }
}
