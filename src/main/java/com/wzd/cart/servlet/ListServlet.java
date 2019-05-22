package com.wzd.cart.servlet;

import com.wzd.cart.dao.ProdDao;
import com.wzd.cart.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author ZeDongW
 * @ClassName ListServlet
 * @Description 浏览商品页面
 * @Version 1.0
 * @date ：Created in 2019/5/3 0003 22:21
 * @modified By：
 */

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置内容格式和编码格式
        resp.setContentType("text/html;charset=utf-8");
        //产品操作
        ProdDao prodDao = new ProdDao();
        //获取所有产品信息
        ArrayList<Product> all = prodDao.findAll();
        //拼接页面
        String html = "<html>";
        html += "<head><title>商品列表</title></head><body><table><tr><th>商品编号</th><th>商品名称</th><th>商品类型</th><th>商品价格</th></tr>";
        //遍历显示商品
        if(all != null && all.size() > 0){
            for (Product p : all) {
                html += "<tr>";
                html += "<td><a href='" + req.getContextPath() + "/DetailServlet?id=" + p.getId() + "'>"+p.getId()+"</a></td>";
                html += "<td><a href='" + req.getContextPath() + "/DetailServlet?id=" + p.getId() + "'>"+p.getProdName()+"</a></td>";
                html += "<td><a href='" + req.getContextPath() + "/DetailServlet?id=" + p.getId() + "'>"+p.getProdType()+"</a></td>";
                html += "<td><a href='" + req.getContextPath() + "/DetailServlet?id=" + p.getId() + "'>"+p.getPrice()+"</a></td>";
                html += "</tr>";
            }
        }
        html += "</table>";
        html += "</hr>";
        html += "最近浏览过的商品: </br>";

        //去除cookie信息
        Cookie[] cookies = req.getCookies();
        if(cookies != null && cookies.length >0){
            for (Cookie cookie : cookies) {
                if("prodHist".equals(cookie.getName())){
                    String value = cookie.getValue();
                    String[] split = value.split("@");
                    for (String s : split) {
                        Product p = prodDao.findById(s);
                        html += "" + p.getId() + "&nbsp;" + p.getProdName() + "&nbsp;" + p.getProdType() + "&nbsp" + p.getPrice() + "</br>";
                    }
                }
            }
        }

        html += "</body></html>";
        resp.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
