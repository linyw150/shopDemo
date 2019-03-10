package com.charlie.controller;

import com.charlie.common.GenericController;
import com.charlie.entity.BrandVo;
import com.charlie.service.BrandService;
import com.charlie.util.ApiBaseAction;
import com.charlie.util.ApiPageUtils;
import com.charlie.util.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/shop")
public class BrandController extends GenericController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    //返回json格式数据，形式1
    @RequestMapping(value = "/getAllBrand",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllBrand(HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<BrandVo> brandEntityList = brandService.queryAllBrand();
        logger.info("===============================成功查询品牌列表！");
        ApiBaseAction api =new ApiBaseAction();
        return api.toResponseSuccess(brandEntityList);
    }
    //返回json格式数据，形式1
    @RequestMapping(value = "/getBrandList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getBrandList(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize

    ) {
        //调用service方法得到用户列表
        Map params = new HashMap();
        params.put("fields","id,name,simple_desc,floor_price,pic_url");
        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);
        params.put("limit",pageSize);
        params.put("sidx","id");//排序的列表
        params.put("order","asc"); //排序的方式
        Query query = new Query(params);
        List<BrandVo> brandEntityList = brandService.queryBrandList(query);
        logger.info("===============================成功查询品牌列表！");
        int total = brandService.queryBrandToTal();
        ApiPageUtils pageUtils = new ApiPageUtils(brandEntityList,total,query.getLimit(),query.getPageNum());
        ApiBaseAction api =new ApiBaseAction();
        return api.toResponseSuccess(pageUtils);
    }
}
