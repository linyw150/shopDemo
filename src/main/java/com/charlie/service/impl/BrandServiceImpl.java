package com.charlie.service.impl;

import com.charlie.dao.mapper.BrandMapper;
import com.charlie.dao.mapper.UserMapper;
import com.charlie.entity.BrandEntity;
import com.charlie.entity.User;
import com.charlie.entity.UserExample;
import com.charlie.service.BrandService;
import com.charlie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public List<BrandEntity> queryAllBrand() {
        return brandMapper.queryAllBrand();

    }
    public List<BrandEntity> queryBrandList(Map<String,Object> query) {
        return brandMapper.queryBrandList(query);

    }
    public int  queryBrandToTal() {
        return brandMapper.queryBrandToTal();

    }
    public void  updateBrand(BrandEntity brandEntity) {
        brandMapper.updateBrand(brandEntity);
    }

    public BrandEntity getBrandDetail(Integer id){
        return  brandMapper.getBrandDetail(id);
    }

}
