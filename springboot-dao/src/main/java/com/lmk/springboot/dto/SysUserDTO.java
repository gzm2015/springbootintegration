package com.lmk.springboot.dto;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 系统用户DTO . <br>
 * 
 * @author hkb <br>
 */
@Data
public class SysUserDTO  {

    /**
     * 用户名
     */
    private String username;

    private String password;

}
