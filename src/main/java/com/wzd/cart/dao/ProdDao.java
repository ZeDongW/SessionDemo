package com.wzd.cart.dao;

import com.wzd.cart.entity.Product;

import java.util.ArrayList;

/**
 * @Author ZeDongW
 * @ClassName ProdDao
 * @Description 产品查询
 * @Version 1.0
 * @date ：Created in 2019/5/3 0003 16:41
 * @modified By：
 */

public class ProdDao {

    //浏览商品的集合
    private static ArrayList<Product> data = new ArrayList<Product>();

    /**
     * 初始化产品信息
     */
    static {
        for (int i = 1; i <= 10; i++){
            data.add(new Product("" + i,"笔记本" + i,"LN00" +i,3500 + i*200));
        }
    }

    //查询所有方法
    public ArrayList<Product> findAll(){
        return data;
    }

    //根据商品ID返回商品
    public Product findById(String id){
        for (Product datum : data) {
            if(id.equals(datum.getId())){
                return datum;
            }
        }
        return null;
    }
}
