package top.imlgw.demo.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import top.imlgw.demo.pojo.Permission;
import top.imlgw.demo.pojo.Role;
import top.imlgw.demo.pojo.User;
import top.imlgw.demo.service.UserService;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author imlgw.top
 * @date 2019/11/18 19:53
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从Session中读然后进行授权
        User user= (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        ArrayList<String> permissionList = new ArrayList<>();
        ArrayList<String> rolenameList = new ArrayList<>();
        Set<Role> roleSet =user.getRoles();
        if (!CollectionUtils.isEmpty(roleSet)){
            for (Role role:roleSet){
                rolenameList.add(role.getRname());
                Set<Permission> permissionSet=role.getPermissions();
                if (!CollectionUtils.isEmpty(permissionSet)){
                    for (Permission permission:permissionSet){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        //SimpleAuthorizationInfo
        //SimpleAuthenticationInfo 注意区分
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList); //权限列表
        info.addRoles(rolenameList); //角色列表
        return info;
    }

    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user= userService.findByUsername(username);
        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
