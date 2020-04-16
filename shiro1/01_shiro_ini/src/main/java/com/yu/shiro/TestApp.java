package com.yu.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TestApp.java
 * @Description 用户认证
 * @Date 2020/4/9 16:46
 */
public class TestApp {
    public static void main(String[] args) {
        String username = "zhangsan";
        String password = "123456";
        //1.创建一个安全管理器的工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.从工厂里面得到SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3.将当前的securityManager绑定到当前线程
        SecurityUtils.setSecurityManager(securityManager);
        //4.取出当前的Subject
        Subject subject = SecurityUtils.getSubject();
        //5,封装用户名和密码
        UsernamePasswordToken token=new UsernamePasswordToken(username, password);
        try {
            //6,进行登陆认证
            subject.login(token);
            System.out.println("是否认证成功:"+subject.isAuthenticated());
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码不正确");
        }
		/*} catch (IncorrectCredentialsException e) {
			System.out.println("密码不正确");
		} catch (UnknownAccountException e) {
			System.out.println("用户名不存在");
		}*/
    }
}
