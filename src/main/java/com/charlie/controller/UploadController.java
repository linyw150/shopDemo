package com.charlie.controller;

import com.charlie.common.GenericController;
import com.charlie.entity.BrandVo;
import com.charlie.service.BrandService;
import com.charlie.util.ApiBaseAction;
import com.charlie.util.ApiPageUtils;
import com.charlie.util.QiniuCloudUtil;
import com.charlie.util.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController extends GenericController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);


    //返回json格式数据，形式1
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadImg(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "file") MultipartFile file) {
        //调用service方法得到用户列表
        String url = "";
        try {
            byte[] bytes = file.getBytes();
            String imageName = String.valueOf(System.currentTimeMillis());;
            String imageType = getFileType(file.getContentType());
            System.out.println("-------");
            System.out.println(imageType);
            System.out.println("-------");
            QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
            try {
                url = qiniuUtil.put64image(bytes, imageName+"."+imageType);
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (IOException e){
        }
        ApiBaseAction api =new ApiBaseAction();
        return api.toResponseSuccess(url);
    }
    public String getFileType(String str){
        String ftype = "png";
        if(str==null){
            return  ftype;
        }
        if(str.indexOf("/")!=-1){
            ftype = str.substring(str.indexOf("/")+1);
        }
        return ftype;
    }
}
