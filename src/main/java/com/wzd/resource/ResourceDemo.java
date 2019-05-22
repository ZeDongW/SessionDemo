package com.wzd.resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author ZeDongW
 * @ClassName ResourceDemo
 * @Description javaWeb读取配置文件信息
 * @Version 1.0
 * @date ：Created in 2019/5/2 0002 22:59
 * @modified By：
 */

public class ResourceDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置response响应类型和编码格式
        resp.setContentType("text/html;charset=utf-8");
        //创建Properties类
        Properties properties = new Properties();
        //加载文件
//        properties.load(this.getServletContext().getResourceAsStream("/conf/db.properties"));
        properties.load(new FileReader(new File(this.getServletContext().getRealPath("/conf/db.properties"))));
        //获取数据
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        resp.getWriter().write("user=" + user + "</br>");
        resp.getWriter().write("password=" + password + "</br>");
    }
}
