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
    void  updateManager(ManagerEntity manager);
    ManagerEntity getManagerDetail(Integer id);
}