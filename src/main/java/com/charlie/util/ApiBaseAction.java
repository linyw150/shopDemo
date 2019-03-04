package com.charlie.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019-03-03.
 */
public class ApiBaseAction {
    public Map<String,Object> toResponseSuccess(Object data){
        Map<String,Object> rp = toResponseObject(0,"执行成功",data);
        return rp;
    }
    public Map<String,Object> toResponseObject(int errorCode,String errMsg,Object data){
        Map<String,Object> obj = new HashMap<String, Object>();
        obj.put("errorCode",errorCode);
        obj.put("errMsg",errMsg);
        obj.put("result",data);
        return obj;
    }
}
