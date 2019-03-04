package com.charlie;

import com.charlie.entity.Menu;
import com.charlie.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml"}) //加载spring容器
//@ContextConfiguration(locations = { "classpath:spring-mybatis.xml"})  也可以这样加载

public class junitDao2 {
    @Autowired
    private MenuService menuService;
    //@Transactional 事务处理
    @Test
    public void test(){
        //调用service方法得到用户列表
        List<Menu> menuList = menuService.getMenuList();
    }

}
