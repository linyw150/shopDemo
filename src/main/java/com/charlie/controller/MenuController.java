package com.charlie.controller;

import com.charlie.common.GenericController;
import com.charlie.entity.Menu;
import com.charlie.entity.User;
import com.charlie.service.MenuService;
import com.charlie.service.UserService;
import com.charlie.util.ApiBaseAction;
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
import java.util.Map;

@Controller
@RequestMapping(value = "/shop")
public class MenuController extends GenericController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;
    //返回json格式数据，形式1
    @RequestMapping(value = "/getMenuList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMenuList(HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        List<Menu> menuList = menuService.getMenuList();
        ApiBaseAction api =new ApiBaseAction();
        return api.toResponseSuccess(menuList);
    }
}
