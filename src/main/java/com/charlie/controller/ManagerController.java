package com.charlie.controller;

import com.charlie.common.GenericController;
import com.charlie.entity.ManagerEntity;
import com.charlie.service.ManagerService;
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
public class ManagerController extends GenericController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/getManagerList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getManagerList(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize

    ) {
        //调用service方法得到用户列表
        Map params = new HashMap();
        params.put("fields","id,areacode,name,headpath,createtime,updatetime");
        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);
        params.put("limit",pageSize);
        params.put("sidx","id");//排序的列表
        params.put("order","asc"); //排序的方式
        Query query = new Query(params);
        List<ManagerEntity> managerEntityList = managerService.queryManagerList(query);
        int total = managerService.queryManagerToTal();
        ApiPageUtils pageUtils = new ApiPageUtils(managerEntityList,total,query.getLimit(),query.getPageNum());
        ApiBaseAction api =new ApiBaseAction();
        return api.toResponseSuccess(pageUtils);
    }
    //返回json格式数据，形式1
    @RequestMapping(value = "/saveManager",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editManagerDetail(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, String> params) {
        //调用service方法得到用户列表
        ManagerEntity ManagerInfo = new ManagerEntity();
        String bid = params.get("id");
        String bname = params.get("name");
        String pictureUrl  = params.get("pictureUrl");
        String desc  =params.get("desc");
        ApiBaseAction api =new ApiBaseAction();
        if(bname==null||"".equals(bname)){
            return api.toResponseObject(500,"品牌名称不能为空","");
        }else {
            ManagerInfo.setName(bname);
        }
        try{
            managerService.updateManager(ManagerInfo);
            return api.toResponseSuccess();
        }catch (Exception e){
            return api.toResponseFail();

        }
    }
    @RequestMapping(value = "/getManager",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getManagerDetail(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="id", required = false) String id) {
        ManagerEntity manager = managerService.getManagerDetail(Integer.parseInt(id));
        ApiBaseAction api =new ApiBaseAction();
        return api.toResponseSuccess(manager);
    }
}
