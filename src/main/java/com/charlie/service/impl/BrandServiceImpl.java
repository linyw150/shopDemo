package com.charlie.service.impl;

import com.charlie.dao.mapper.BrandMapper;
import com.charlie.dao.mapper.UserMapper;
import com.charlie.entity.BrandVo;
import com.charlie.entity.User;
import com.charlie.entity.UserExample;
import com.charlie.service.BrandService;
import com.charlie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public List<BrandVo> queryBrandList() {
        return brandMapper.queryBrandList();

    }
}
