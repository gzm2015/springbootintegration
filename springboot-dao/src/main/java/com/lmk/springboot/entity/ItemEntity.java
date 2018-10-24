package com.lmk.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author LiuMengKe
 * @create 2018-06-16-20:56
 */
@Data
@NoArgsConstructor

public class ItemEntity extends BaseEntity {

    public Long id ;

    public String name;


    public OrderEntity orderEntity;

}
