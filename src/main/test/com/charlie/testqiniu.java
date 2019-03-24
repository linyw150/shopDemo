package com.charlie;


import com.qiniu.util.Auth;
import org.junit.Test;


public class testqiniu {
    @Test
    public void test(){
        String accessKey = "aN1wXZMptHfZwZmx2OkfmFI1kAHkA7EsWErkJTIA";
        String secretKey = "4AM4vKL0njfaJXbR-laHSJ8wsNgVsampBnOr5jeP";
        String bucket = "shop_image";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);
    }

}
