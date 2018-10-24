/*
package com.lmk.springboot;

import com.lmk.springboot.dao.ItemDAO;
import com.lmk.springboot.dao.OrderDAO;
import com.lmk.springboot.entity.ItemEntity;
import com.lmk.springboot.entity.OrderEntity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


*/
/**
 * 测试jpa级联
 *
 * @author LiuMengKe
 * @create 2018-06-16-21:05
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaCascadeTest{

    @Autowired
    CascadeServiceImpl cascadeService;

    ItemDAO itemDAO;
    OrderDAO orderDAO;

    @Before
    public void init(){
        itemDAO = cascadeService.getItemDAO();
        orderDAO = cascadeService.getOrderDAO();
    }

    @Test
    public void testPersist() {

        OrderEntity entity = new OrderEntity();
        entity.setId(1L);
        entity.setName("entity1");


        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(1L);
        itemEntity.setName("item1");
        itemEntity.setOrderEntity(entity);

        ItemEntity itemEntity2 = new ItemEntity();
        itemEntity.setId(2L);
        itemEntity.setName("item2");
        itemEntity.setOrderEntity(entity);


        List<ItemEntity> list = new ArrayList<>();
        list.add(itemEntity);
        list.add(itemEntity2);

        entity.setItemEntityList(list);

        //代码片段1
        //单独在order @OneToMany 添加 cascade = CascadeType.PERSIST  只有order保存了数据
        */
/*orderDAO.insert(entity);
        Assert.assertTrue(orderDAO.selectAll().size()==1);
        Assert.assertTrue(orderDAO.selectAll().size()==2);*//*



        itemDAO.insertList(list);
        Assert.assertTrue(orderDAO.selectAll().size()==1);
        Assert.assertTrue(orderDAO.selectAll().size()==2);


    }


    @Test
    public void test() {
        List list = orderDAO.selectInMyModuleType();
        System.out.println(list);
    }

}

*/
