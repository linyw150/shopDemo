package com.charlie.entity;

import java.io.Serializable;

public class BrandVo implements Serializable {
    private  int id;

    private  String name;

    private String pictureUrl;

    private  String price;

    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BrandVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
