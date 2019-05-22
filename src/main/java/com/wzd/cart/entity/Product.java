package com.wzd.cart.entity;

/**
 * @Author ZeDongW
 * @ClassName Product
 * @Description 商品实体类
 * @Version 1.0
 * @date ：Created in 2019/5/3 0003 16:35
 * @modified By：
 */

public class Product {
    private String id;  //商品ID
    private String prodName; //商品名称
    private String prodType; //商品类型
    private double price; //商品价格

    public Product() {
    }

    public Product(String id, String prodName, String prodType, double price) {
        this.id = id;
        this.prodName = prodName;
        this.prodType = prodType;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodType='" + prodType + '\'' +
                ", price=" + price +
                '}';
    }
}