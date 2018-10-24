package com.lmk.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 系统用户 . <br>
 * 
 * @author hkb <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserEntity extends BaseEntity  implements UserDetails {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态 0：禁用 1：正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createDate;


    private List<SysRoleEntity> roles;



    public SysUserEntity(Long userId, Long deptId, String username, String password, String salt, String mobile, String email, Integer status, Date createDate) {
        this.userId = userId;
        this.deptId = deptId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.mobile = mobile;
        this.email = email;
        this.status = status;
        this.createDate = createDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
