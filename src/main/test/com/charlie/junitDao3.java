package com.charlie;

import com.charlie.entity.BrandEntity;
import com.charlie.service.BrandService;
import com.charlie.util.ApiPageUtils;
import com.charlie.util.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:applicationContext.xml"}) //加载spring容器
//@ContextConfiguration(locations = { "classpath:spring-mybatis.xml"})  也可以这样加载

public class junitDao3 {
    @Autowired
    private BrandService brandService;
    //@Transactional 事务处理
    @Test
    public void test(){
        BrandEntity brandInfo = new BrandEntity();
        brandInfo.setId(1001000);
        brandInfo.setPictureUrl("3333");
        brandInfo.setDesc("aaaa");
        brandService.updateBrand(brandInfo);
    }

}
