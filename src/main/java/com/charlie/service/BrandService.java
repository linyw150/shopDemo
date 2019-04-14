package com.charlie.service;

import com.charlie.entity.BrandEntity;

import java.util.List;
import java.util.Map;

public interface BrandService {

    List<BrandEntity> queryAllBrand();
    List<BrandEntity> queryBrandList(Map<String,Object> query);
    int queryBrandToTal();
    void updateBrand(BrandEntity brandEntity);
    BrandEntity getBrandDetail(Integer id);
}
