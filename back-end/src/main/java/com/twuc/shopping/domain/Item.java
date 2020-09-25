package com.twuc.shopping.domain;

import javax.validation.constraints.NotNull;

/**
 * Create by 木水 on 2020/9/25.
 */
public class Item {
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private int num;
    @NotNull
    private String url;

    public Item(@NotNull String name, @NotNull double price, @NotNull int num, @NotNull String url) {
        this.name = name;
        this.price = price;
        this.num = num;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
