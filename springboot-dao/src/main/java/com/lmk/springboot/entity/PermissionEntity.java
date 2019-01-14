package com.lmk.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiuMengKe
 * @create 2019-01-12-10:21
 */
@Data
public class PermissionEntity implements Serializable {

    private int id;

    private String name;

    private String code;

}
