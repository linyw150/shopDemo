package com.charlie.dao.mapper;

import com.charlie.entity.MenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    List<MenuEntity> getMenuList();
}