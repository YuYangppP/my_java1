package com.yu.shiro;

import com.yu.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuyang
 * @version 1.0.0
 * @ClassName TestApp.java
 * @Description 用户授权
 * @Date 2020/4/9 16:46
 */
public class TestApp2 {
    public static void main(String[] args) {
        String username = "lisi";
        String password = "123456";
        //1.创建一个安全管理器的工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2.从工厂里面得到SecurityManager
        DefaultSecurityManager securityManager = (DefaultSecurityManager) factory.getInstance();

        Realm realm = new UserRealm();
        securityManager.setRealm(realm);
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

            Object object = subject.getPrincipal(); //得到doGetAuthenticationInfo的返回值SimpleAuthenticationInfo里面的第一个参数
            System.out.println(object);
        } catch (AuthenticationException e) {
            System.out.println("用户名或密码不正确");
        }
		/*} catch (IncorrectCredentialsException e) {
			System.out.println("密码不正确");
		} catch (UnknownAccountException e) {
			System.out.println("用户名不存在");
		}*/

		//1.判断用户是否有一个角色
        boolean hasRole1 = subject.hasRole("role1");
        System.out.println(username+"是否有role1的角色"+hasRole1);

        List<String> roleIdentifiers=new ArrayList<String>();
        roleIdentifiers.add("role1");
        roleIdentifiers.add("role2");
        roleIdentifiers.add("role3");
        boolean allRoles = subject.hasAllRoles(roleIdentifiers);
        System.out.println(username+"是否同时拥有roleIdentifiers集合里面的所有角色:"+allRoles);
        //3,分别判断用户是否有集合里面的角色
        boolean[] hasRoles = subject.hasRoles(roleIdentifiers);
        System.out.println("分别判断用户是否有集合里面的角色:"+Arrays.toString(hasRoles));



        //4,判断用户是否有某一个权限
        boolean permitted = subject.isPermitted("user:query");
        System.out.println(username+"是否有user:query的权限:"+permitted);
        //5,分别判断用户是否有数组里面的权限
        String[] permissions= {"user:query","user:add","user:xxxx"};
        boolean[] permitted2 = subject.isPermitted(permissions);
        System.out.println("分别判断用户是否有数组里面的权限:"+Arrays.toString(permitted2));

        //6,判断用户是否有数组里面的所有权限
        boolean permittedAll = subject.isPermittedAll(permissions);
        System.out.println("判断用户是否有数组里面的所有权限:"+permittedAll);

        //7,
        boolean permitted3 = subject.isPermitted("user:xxx");
        System.out.println(permitted3);
    }
}
