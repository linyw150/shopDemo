package com.charlie;

import com.charlie.entity.BrandEntity;
import com.charlie.entity.ManagerEntity;
import com.charlie.service.BrandService;
import com.charlie.service.ManagerService;
import com.charlie.util.ApiBaseAction;
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

public class brandjunit {
    @Autowired
    private BrandService brandService;

    //@Transactional 事务处理
    @Test
    public void test(){
        //调用service方法得到用户列表
        Map params = new HashMap();
        params.put("fields","id");
        params.put("pageNum",1);
        params.put("pageSize",10);
        params.put("limit",10);
        params.put("sidx","id");//排序的列表
        params.put("order","asc"); //排序的方式
        Query query = new Query(params);
        List<BrandEntity> brrandEntityList = brandService.queryBrandList(query);
        int total = brandService.queryBrandToTal();
        ApiPageUtils pageUtils = new ApiPageUtils(brrandEntityList,total,query.getLimit(),query.getPageNum());
        ApiBaseAction api =new ApiBaseAction();
        System.out.println("***********");
        for (int i = 0; i < brrandEntityList.size(); i++) {
            System.out.println(brrandEntityList.toString());
        }
        System.out.println("***********");
    }

}
