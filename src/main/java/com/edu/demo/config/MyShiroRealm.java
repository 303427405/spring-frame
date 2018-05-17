package com.edu.demo.config;

import com.edu.demo.pojo.entity.User;
import com.edu.demo.service.permission.PermissionService;
import com.edu.demo.service.role.RoleService;
import com.edu.demo.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created By zhangyufei on 2018/5/16
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserService userService;

    //权限配置
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        /**从数据里获取权限信息*/
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User) principalCollection.getPrimaryPrincipal();
        authorizationInfo.addRoles(roleService.selectRoleByUserId(user.getUserId()));
        List<Long> roleIds = roleService.selectRoleIdByUserId(user.getUserId());
        authorizationInfo.addStringPermissions(permissionService.selectPermissionByRoleIds(roleIds));
        return authorizationInfo;

    }


    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.selectByUserName(username);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
