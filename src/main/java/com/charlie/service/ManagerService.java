package com.charlie.service;

import com.charlie.entity.ManagerEntity;

import java.util.List;
import java.util.Map;

public interface ManagerService {

    List<ManagerEntity> queryAllManager();
    List<ManagerEntity> queryManagerList(Map<String, Object> query);
    int queryManagerToTal();
    void updateManager(ManagerEntity manager);
    ManagerEntity getManagerDetail(Integer id);
}
