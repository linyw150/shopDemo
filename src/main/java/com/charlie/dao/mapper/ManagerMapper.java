package com.charlie.dao.mapper;

import com.charlie.entity.ManagerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ManagerMapper {
    List<ManagerEntity> queryAllManager();
    List<ManagerEntity> queryManagerList(Map<String, Object> params);
    int  queryManagerToTal();
    int  save(ManagerEntity manager);
    int  update(ManagerEntity manager);
    ManagerEntity queryObject(Integer id);
}