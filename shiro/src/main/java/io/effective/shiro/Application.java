package io.effective.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class Application {
    public static void main(String[] args) {
//        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        Realm realm = new MyCustomRealm();
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();

        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("user", "password");
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                System.out.println("Login success!");
                System.out.println("IsAuthenticated: " + currentUser.isAuthenticated());
            }catch (UnknownAccountException e){
                System.out.println("Username not found!");
            }catch (IncorrectCredentialsException e){
                System.out.println("Invalid credentials!");
            }catch (LockedAccountException e){
                System.out.println("Your account is locked!");
            }catch (AuthenticationException e){
                System.out.println("Unexpected error!");
            }
        }

        if(currentUser.hasRole("admin"))
            System.out.println("Welcome admin.");
        else if(currentUser.hasRole("editor"))
            System.out.println("Welcome editor.");
        else if(currentUser.hasRole("author"))
            System.out.println("Welcome author.");
        else
            System.out.println("Welcome guest.");

        if(currentUser.isPermitted("articles:compose"))
            System.out.println("You can compose an article.");
        else
            System.out.println("You are not permitted to compose an article.");
        if(currentUser.isPermitted("articles:save"))
            System.out.println("You can save articles");
        else
            System.out.println("You can not save articles");
        if(currentUser.isPermitted("articles:publish"))
            System.out.println("You can publish articles.");
        else
            System.out.println("You can not publish articles.");
    }
}
