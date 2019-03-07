package com.charlie;

import com.charlie.entity.BrandVo;
import com.charlie.service.BrandService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml"}) //加载spring容器
//@ContextConfiguration(locations = { "classpath:spring-mybatis.xml"})  也可以这样加载

public class junitDao {
    @Autowired
    private BrandService brandService;
    //@Transactional 事务处理
    @Test
    public void test(){
        //调用service方法得到用户列表
        List<BrandVo> brandEntityList = brandService.queryBrandList();
        System.out.print(brandEntityList);
        for(BrandVo brand:brandEntityList){
            System.out.println(brand.toString());
        }
    }

}
