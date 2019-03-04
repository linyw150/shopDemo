package com.charlie.service.impl;

import com.charlie.dao.mapper.MenuMapper;
import com.charlie.entity.BrandVo;
import com.charlie.entity.Menu;
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

    public List<Menu> getMenuList() {
        try {
            List<Menu> allMenu = menuMapper.getMenuList();
            //遍历menu对象，查找menu 中parent_id=null 添加到
            List<Menu> rootMenu = new ArrayList<Menu>();
            for(Menu nav:allMenu){
                if(nav.getLevel().equals("1")){
                    rootMenu.add(nav);
                }
            }
            //为根菜单设置子节点
            for(Menu nav:rootMenu){
                List<Menu> childMenu = getChild(nav.getId(),allMenu);
                nav.setChildren(childMenu);
            }
            return  rootMenu;
        } catch (Exception e) {
            return new ArrayList<Menu>();
        }
    }

    /**
     *
     * @param id  根节点
     * @param allMenu 所有菜单
     * @return
     */
    public  List<Menu> getChild(String id,List<Menu> allMenu){
        List<Menu> childMenu = new ArrayList<Menu>();
        for(Menu nav:allMenu){
            if(id.equals(nav.getParentId())){
                childMenu.add(nav);
            }
        }
        if(childMenu.size()==0){
            return new ArrayList<Menu>();
        }
        for(Menu nav:childMenu){
            nav.setChildren(getChild(nav.getId(),allMenu));
        }
        return childMenu;
    }


}
