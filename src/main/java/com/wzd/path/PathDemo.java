package com.wzd.path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName PathDemo
 * @Description javaWeb路径问题
 * @Version 1.0
 * @date ：Created in 2019/5/2 0002 21:52
 * @modified By：
 */

public class PathDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //转发
//        req.getRequestDispatcher("/page/target.html").forward(req,resp);
        //请求重定向
//        resp.sendRedirect("/SessionDemo/page/target.html");
        //html页面超链接
//        resp.getWriter().write("<html><body><a href='/SessionDemo/page/target.html'>目标资源文件</a></body></html>");
        //form提交表单
        resp.getWriter().write("<html><body><form action='/SessionDemo/page/target.html'><input type='submit' value='目标资源文件'></form></body></html>");
    }
}
