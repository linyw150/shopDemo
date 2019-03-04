package com.charlie.dao.mapper;

import com.charlie.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    List<Menu> getMenuList();
}