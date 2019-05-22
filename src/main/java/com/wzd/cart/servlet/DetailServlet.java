package com.wzd.cart.servlet;

import com.wzd.cart.dao.ProdDao;
import com.wzd.cart.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @Author ZeDongW
 * @ClassName DetailServlet
 * @Description 商品明细
 * @Version 1.0
 * @date ：Created in 2019/5/3 0003 23:06
 * @modified By：
 */

public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置内容格式和编码格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        ProdDao prodDao = new ProdDao();
        Product p = prodDao.findById(id);
        String html = "";
        html += "<html>";
        html += "<head>";
        html += "<title>商品详细</title>";
        html += "</head>";
        html += "<body>";
        html += "<table border='1' align='center' width='300px'>";
        if(p != null){
            html += "<tr><th>商品编号</th><td>" + p.getId() + "</td></tr>";
            html += "<tr><th>商品名称</th><td>" + p.getProdName() + "</td></tr>";
            html += "<tr><th>商品类型</th><td>" + p.getProdType() + "</td></tr>";
            html += "<tr><th>商品价格</th><td>" + p.getPrice() + "</td></tr>";
        }
        html += "</table>";
        html += "<center><a href='" + req.getContextPath() +"/ListServlet'>[返回列表]</a></center>";
        html += "</body>";
        html += "</html>";

        //创建cookie 并发送
        String value = createValue(req, id);
        Cookie cookie = new Cookie("prodHist", value);
        cookie.setMaxAge(1*60*60*24*30);

        resp.addCookie(cookie);
        writer.write(html);

    }

    /**
     * @Author: ZeDongW
     * @Description: 动态生成cookie的值
     * @Date: 2019/5/3 0003 23:26
     * @Param: [req, id]
     * @return: java.lang.String
     */
    private String createValue(HttpServletRequest req, String id) {
        //获取request的cookie值
        Cookie[] cookies = req.getCookies();
        //cookie内容
        String prodHist = null;
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if("prodHist".equals(cookie.getName())){
                    prodHist = cookie.getValue();
                    break;
                }
            }
        }

        if(cookies == null || prodHist == null){
            return id;
        }

        String[] split = prodHist.split("@");
        Collection coll = Arrays.asList(split);
        LinkedList<String> strings = new LinkedList<String>(coll);
        if(strings.contains(id)){
            strings.remove(id);
            strings.addFirst(id);
        } else {
            if(strings.size() < 3) {
                strings.addFirst(id);
            } else {
                strings.removeLast();
                strings.addFirst(id);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strings.size(); i++){
            sb.append(strings.get(i));
            if(i != strings.size() -1 ){
                sb.append("@");
            }
        }
        return sb.toString();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
