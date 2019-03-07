package com.charlie.controller;

import com.charlie.common.GenericController;
import com.charlie.entity.BrandVo;
import com.charlie.service.BrandService;
import com.charlie.util.ApiBaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/shop")
public class BrandController extends GenericController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    //返回json格式数据，形式1
    @RequestMapping(value = "/getBrandList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBrandList(HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<BrandVo> brandEntityList = brandService.queryBrandList();
        logger.info("===============================成功查询品牌列表！");
        ApiBaseAction api =new ApiBaseAction();
        return api.toResponseSuccess(brandEntityList);
    }
}
