package com.charlie.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private String id;

    private String title;

    private String level;

    private String parentId;

    //子菜单
    private List<Menu> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", level='" + level + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                '}';
    }
}
