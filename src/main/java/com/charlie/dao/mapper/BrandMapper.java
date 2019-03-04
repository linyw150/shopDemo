package com.charlie.dao.mapper;

import com.charlie.entity.BrandVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper {
    List<BrandVo> queryBrandList();
}