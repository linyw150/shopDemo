package com.charlie;

import com.charlie.entity.BrandVo;
import com.charlie.service.BrandService;
import com.charlie.util.ApiPageUtils;
import com.charlie.util.Query;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        Map params = new HashMap();
        params.put("fields","id,name,simple_desc,floor_price,pic_url");
        params.put("pageNum",1);
        params.put("pageSize",10);
        params.put("limit",10);
        params.put("sidx","id");//排序的列表
        params.put("order","asc"); //排序的方式
        Query query = new Query(params);
        List<BrandVo> brandEntityList = brandService.queryBrandList(query);
        int total = brandService.queryBrandToTal();
        ApiPageUtils pageUtils = new ApiPageUtils(brandEntityList,total,query.getLimit(),query.getPageNum());
        System.out.println(pageUtils.toString());
    }

}
