package com.charlie.controller;

import com.charlie.common.GenericController;
import com.charlie.entity.BrandVo;
import com.charlie.entity.User;
import com.charlie.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/api/brand")
public class ApiBrandController extends GenericController {
    private static final Logger logger = LoggerFactory.getLogger(ApiBrandController.class);

    @Autowired
    private BrandService brandService;

    //返回json格式数据，形式1
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List getBrandList( HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<BrandVo> brandEntityList = brandService.queryBrandList();
        logger.info("===============================成功查询品牌列表！");
        System.out.print(brandEntityList);
        for(BrandVo brand:brandEntityList){
            System.out.println(brand.getId()+""+brand.getName());
        }
        return brandEntityList;
    }
}
