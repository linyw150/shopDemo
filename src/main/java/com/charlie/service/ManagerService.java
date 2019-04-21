package com.charlie.service;

import com.charlie.entity.ManagerEntity;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    List<ManagerEntity> queryManagerList(Map<String, Object> query);
    int queryManagerToTal();
    int save(ManagerEntity manager);
    int update(ManagerEntity manager);
    ManagerEntity queryObject(Integer id);
}
