package com.charlie.service.impl;

import com.charlie.dao.mapper.ManagerMapper;
import com.charlie.entity.ManagerEntity;
import com.charlie.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    public List<ManagerEntity> queryAllManager() {
        return managerMapper.queryAllManager();

    }
    public List<ManagerEntity> queryManagerList(Map<String,Object> query) {
        return managerMapper.queryManagerList(query);

    }
    public int  queryManagerToTal() {
        return managerMapper.queryManagerToTal();

    }
    public void  updateManager(ManagerEntity manager) {
        managerMapper.updateManager(manager);
    }

    public ManagerEntity getManagerDetail(Integer id){
        return  managerMapper.getManagerDetail(id);
    }

}
