package org.aichs.kite.common.interceptor;

import entity.SysPermission;
import entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import service.SysPermissionService;
import service.SysUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : UserDetailsServiceImpl
 * @Description : 实现自定义用户认证的核心逻辑
 * @Author : Kite
 * @Date: 2020-02-15 21:03
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;
    
    /**
     *
     * 功能描述:
     *
     * @Author Kite
     * @Description //TODO 
     * @Date 9:04 下午 2020/2/15
     * @Param 
     * @return 
     **/
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // 需要构造出 org.springframework.security.core.userdetails.User 对象并返回
        if (name == null || "".equals(name)){
            throw new RuntimeException("用户不能为空!");
        }

        // 根据用户名查询用户
        SysUser sysUser = sysUserService.selectByName(name);
        if (sysUser == null) {
            throw  new RuntimeException("用户不存在");
        }
        /**
         * UserDeitails接口里面有一个getAuthorities()方法。这个方法将返回此用户的所拥有的权限。这个集合将用于用户的访问控制，也就是Authorization。
         *
         * 所谓权限，就是一个字符串。一般不会重复。
         *
         * 所谓权限检查，就是查看用户权限列表中是否含有匹配的字符串。
         */
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (sysUser != null) {
            // 获取该用户所拥有的权限
            List<SysPermission> sysPermissions = sysPermissionService.selectListByUser(sysUser.getId());
            // 声明用户授权
            sysPermissions.forEach(sysPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getPermissionCode());
                grantedAuthorityList.add(grantedAuthority);
            });
        }
        return new User(sysUser.getAccount(), // 账号
                sysUser.getPassword(), // 密码
                sysUser.getEnabled(), // 账号是否可用
                sysUser.getAccountNonExpired(), // 账号是否过期
                sysUser.getCredentialsNonExpired(), // 密码是否过期
                sysUser.getAccountNonLocked(), // 账号是否锁定
                grantedAuthorityList); // 用户权限列表
    }
}
