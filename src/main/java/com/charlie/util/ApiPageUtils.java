package com.charlie.util;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019-03-03.
 */
public class ApiPageUtils {
   private List<?> data;
   private int total;
   private int pageSize;
   private int pageNum;

   public ApiPageUtils(List<?> data,int total,int pageSize,int pageNum){
      this.data = data;
      this.total = total;
      this.pageSize = pageSize;
      this.pageNum = pageNum;
   }

   public List<?> getData() {
      return data;
   }

   public void setData(List<?> data) {
      this.data = data;
   }

   public int getTotal() {
      return total;
   }

   public void setTotal(int total) {
      this.total = total;
   }

   public int getPageSize() {
      return pageSize;
   }

   public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
   }

   public int getPageNum() {
      return pageNum;
   }

   public void setPageNum(int pageNum) {
      this.pageNum = pageNum;
   }
}
