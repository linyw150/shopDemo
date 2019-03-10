package com.charlie.dao.mapper;

import com.charlie.entity.BrandVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BrandMapper {
    List<BrandVo> queryAllBrand();
    List<BrandVo> queryBrandList(Map<String,Object> params);
    int  queryBrandToTal();
}