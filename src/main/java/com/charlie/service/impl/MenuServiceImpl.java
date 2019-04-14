package com.charlie.service.impl;

import com.charlie.dao.mapper.MenuMapper;
import com.charlie.entity.MenuEntity;
import com.charlie.service.MenuService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<MenuEntity> getMenuList() {
        try {
            List<MenuEntity> allMenu = menuMapper.getMenuList();
            //遍历menu对象，查找menu 中parent_id=null 添加到
            List<MenuEntity> rootMenu = new ArrayList<MenuEntity>();
            for(MenuEntity nav:allMenu){
                if(nav.getLevel().equals("1")){
                    rootMenu.add(nav);
                }
            }
            //为根菜单设置子节点
            for(MenuEntity nav:rootMenu){
                List<MenuEntity> childMenu = getChild(nav.getId(),allMenu);
                nav.setChildren(childMenu);
            }
            return  rootMenu;
        } catch (Exception e) {
            return new ArrayList<MenuEntity>();
        }
    }

    /**
     *
     * @param id  根节点
     * @param allMenu 所有菜单
     * @return
     */
    public  List<MenuEntity> getChild(String id,List<MenuEntity> allMenu){
        List<MenuEntity> childMenu = new ArrayList<MenuEntity>();
        for(MenuEntity nav:allMenu){
            if(id.equals(nav.getParentId())){
                childMenu.add(nav);
            }
        }
        if(childMenu.size()==0){
            return new ArrayList<MenuEntity>();
        }
        for(MenuEntity nav:childMenu){
            nav.setChildren(getChild(nav.getId(),allMenu));
        }
        return childMenu;
    }


}
