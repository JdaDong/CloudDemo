package com.example.springelk;



public class Cat {


    private String name; //标题

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    private String category;// 分类

    private String weight; // 品牌

    public Cat(String name, String category, String weight) {
        this.name = name;
        this.category = category;
        this.weight = weight;
    }
}
