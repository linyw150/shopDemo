package com.charlie;

import com.charlie.entity.ManagerEntity;
import com.charlie.entity.ManagerEntity;
import com.charlie.util.ApiBaseAction;
import com.charlie.util.ApiPageUtils;
import com.charlie.util.Query;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import com.charlie.service.ManagerService;

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

public class managerjunit {
    @Autowired
    private ManagerService managerService;

    //@Transactional 事务处理
    @Test
    public void test(){
        //调用service方法得到用户列表
        Map params = new HashMap();
        params.put("fields","id,areacode,mobile,name,headpath,createtime,updatetime");
        params.put("pageNum",1);
        params.put("pageSize",10);
        params.put("limit",10);
        params.put("sidx","id");//排序的列表
        params.put("order","asc"); //排序的方式
        Query query = new Query(params);
        List<ManagerEntity> managerEntityList = managerService.queryManagerList(query);
        int total = managerService.queryManagerToTal();
        ApiPageUtils pageUtils = new ApiPageUtils(managerEntityList,total,query.getLimit(),query.getPageNum());
        ApiBaseAction api =new ApiBaseAction();
        System.out.println("***********");
        for (int i = 0; i < managerEntityList.size(); i++) {
            System.out.println(managerEntityList.toString());
        }
        System.out.println("***********");
    }

}
