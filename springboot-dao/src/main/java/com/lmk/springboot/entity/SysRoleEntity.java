package com.lmk.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色
 *
 * @author LiuMengKe
 * @create 2018-06-15-16:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleEntity implements Serializable {

    private Integer roleId;

    //角色名称
    private String name;

    //角色名称对应的英文
    private String roleType;

}
