package com.charlie.util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019-03-03.
 */
public class Query extends LinkedHashMap<String,Object> {

    private int pageNum = 1;//当前页数

    private int limit = 10; //每页总数

    public Query(Map<String,Object> params){
        this.putAll(params);
        this.pageNum = Integer.parseInt(String.valueOf(params.get("pageNum")));
        this.limit = Integer.parseInt(String.valueOf(params.get("pageSize")));
        int offset = (pageNum-1) * limit;
        this.put("offset",offset);
        this.put("limit",limit);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
