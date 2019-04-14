package com.charlie.dao.mapper;

import com.charlie.entity.BrandEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BrandMapper {
    List<BrandEntity> queryAllBrand();
    List<BrandEntity> queryBrandList(Map<String,Object> params);
    int  queryBrandToTal();
    void  updateBrand(BrandEntity brandVo);;
    BrandEntity getBrandDetail(Integer id);
}