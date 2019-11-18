package top.imlgw.demo.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author imlgw.top
 * @date 2019/11/18 20:13
 */

public class CredentialMatcher  extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        String password = new String(usernamePasswordToken.getPassword());
        //数据库中的密码
        String dbPassword = (String) info.getCredentials();
        return  this.equals(password,dbPassword);
    }
}
