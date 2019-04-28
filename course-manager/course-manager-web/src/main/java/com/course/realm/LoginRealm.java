package com.course.realm;

import com.course.pojo.Privilege;
import com.course.pojo.Role;
import com.course.pojo.Userlogin;
import com.course.service.ILoginService;
import com.course.service.IRoleService;
import com.course.service.impl.PrivilegeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义realm
 */

public class LoginRealm extends AuthorizingRealm {

    @Resource
    private ILoginService loginService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    /**
     * 授权
     * @param principals
     * @return info
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) getAvailablePrincipal(principals);
        if(username==null){
            return null;
        }
        Role role = null;

//      Set<Privilege> privileges = null;
        try {
            Userlogin userlogin = loginService.findByName(username);
            //获取用户角色 当前用户只有一个角色
            Integer roleId = userlogin.getRole();
            if(roleId != null) {
                role = roleService.findByID(roleId);
//              privileges =  privilegeService.getByID(roleId);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<>();
        if(role!=null){
            r.add(role.getRolename());
        }
//        Set<String> p = new HashSet<>();
//        if(privileges!=null){
//            for (Privilege pri : privileges){
//                p.add(pri.getPrivilegename());
//            }
//        }
        info.setRoles(r);
//        info.setStringPermissions(p);
        return info;
    }

    /**
     * 认证
     * @param token
     * @return info
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        String password = new String(userToken.getPassword());
        System.out.println("从UsernamePassword中获取username" + username);
        System.out.println("从UsernamePassword中获取password" + password);
//      String password =new String((char[])token.getCredentials());

        //从数据库取出用户数据,作为认证实体
        Userlogin userlogin = loginService.findByName(username);

        System.out.println(userlogin);
        if(userlogin == null){
            throw new UnknownAccountException("username not found");
        }

        //credentials：密码
        String credentials = userlogin.getPassword();
        //当前realm对象的name
        String realmName = getName();
        //盐值
        ByteSource salt = ByteSource.Util.bytes(userlogin.getCredentialsSalt());

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
              userlogin.getUsername(),
              credentials,
              salt,
              realmName
        );

        Session session = SecurityUtils.getSubject().getSession();
        session.setTimeout(2400000);//设置超时时间 40min
        session.setAttribute("username",userlogin.getUsername());
//        session.setAttribute("userId",userlogin.getUserid());
//        System.out.println(userlogin.getUserid());
//        Object aa = session.getAttribute("username");
//        Object id = session.getId();
//        System.out.println("id:"+id+",username:"+aa);
        return info;
    }

}
