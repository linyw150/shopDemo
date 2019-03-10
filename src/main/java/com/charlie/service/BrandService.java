package com.charlie.service;

import com.charlie.entity.BrandVo;

import java.util.List;
import java.util.Map;

public interface BrandService {

    List<BrandVo> queryAllBrand();
    List<BrandVo> queryBrandList(Map<String,Object> query);
    int queryBrandToTal();
}
