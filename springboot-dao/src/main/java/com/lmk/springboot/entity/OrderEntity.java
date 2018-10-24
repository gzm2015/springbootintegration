package com.lmk.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author LiuMengKe
 * @create 2018-06-16-20:55
 */
@Data
@NoArgsConstructor
public class OrderEntity extends BaseEntity {

    private Long id;

    private String name;

    private List<ItemEntity> itemEntityList;

}
