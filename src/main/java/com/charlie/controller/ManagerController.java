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
import java.sql.Timestamp;
import java.util.Date;
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
        params.put("fields","id,state,areacode,mobile,name,headpath,createtime,updatetime");
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
    @RequestMapping(value = "/saveManager",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveManager(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String, String> params) {
        //调用service方法得到用户列表
        ManagerEntity ManagerInfo = new ManagerEntity();
        ApiBaseAction api =new ApiBaseAction();
        String id = params.get("id");
        ManagerInfo.setMobile(params.get("mobile"));
        ManagerInfo.setName(params.get("name"));
        ManagerInfo.setHeadPath(params.get("headpath"));
        if(params.get("state")!=null&&!"".equals(params.get("state"))){
            ManagerInfo.setState(Integer.valueOf(params.get("state")));
        }
        Date date = new Date();
        if(params.get("areaCode")!=null){
            ManagerInfo.setAreaCode(Integer.valueOf(params.get("areaCode")));
        }
        if(id==null||"".equals(id)||Integer.valueOf(id)==0){
            ManagerInfo.setCreateTime(new Timestamp(date.getTime()));
            ManagerInfo.setUpdateTime(new Timestamp(date.getTime()));
            managerService.save(ManagerInfo);
            return api.toResponseSuccess();
        }else {
            ManagerEntity manager = managerService.queryObject(Integer.valueOf(id));
            if(manager==null){
                return api.toResponseObject(500,"用户不存在","");
            }else{
                ManagerInfo.setUpdateTime(new Timestamp(date.getTime()));
                ManagerInfo.setId(Integer.valueOf(id));
                managerService.update(ManagerInfo);
                return api.toResponseSuccess();
            }
        }
    }
    @RequestMapping(value = "/getManager",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getManager(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="id", required = false) String id) {
        ApiBaseAction api =new ApiBaseAction();
        if(id==null||"".equals(id)){
            return api.toResponseObject(500,"用户不存在","");
        }
        ManagerEntity manager = managerService.queryObject(Integer.parseInt(id));
        return api.toResponseSuccess(manager);
    }
    @RequestMapping(value = "/stopManager",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> stopManager(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="ids", required = false) String ids) {
        ApiBaseAction api =new ApiBaseAction();

        if(ids==null||"".equals(ids)){
            return api.toResponseSuccess();
        }else{
            String[] idsArr = ids.split(",");
            for(String id:idsArr){
                try {
                    ManagerEntity manager = managerService.queryObject(Integer.parseInt(id));
                    manager.setState(2);
                    managerService.update(manager);
                }catch (Exception e){
                    return api.toResponseFail();
                }
            }
            return api.toResponseSuccess();
        }
    }
}
