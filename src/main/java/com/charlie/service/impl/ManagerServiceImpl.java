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

    public List<ManagerEntity> queryManagerList(Map<String,Object> query) {
        return managerMapper.queryManagerList(query);

    }
    public int  queryManagerToTal() {
        return managerMapper.queryManagerToTal();
    }
    public int  save(ManagerEntity managerEntity) {
        return managerMapper.save(managerEntity);
    }
    public int  update(ManagerEntity manager) {
        return  managerMapper.update(manager);
    }

    public ManagerEntity queryObject(Integer id){
        return  managerMapper.queryObject(id);
    }

}
