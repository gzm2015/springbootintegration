package com.lmk.springboot.dao;

import com.lmk.springboot.entity.OrderEntity;
import com.lmk.springboot.util.MyMapper;

import java.util.List;

/**
 * Created by LiuMengKe on 2018/6/16.
 */
public interface OrderDAO extends MyMapper<OrderEntity> {

    List<OrderEntity>  selectInMyModuleType();

}
