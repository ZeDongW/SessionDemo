package com.wzd.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName Session2
 * @Description 获取Session并获取属性
 * @Version 1.0
 * @date ：Created in 2019/5/4 0004 10:00
 * @modified By：
 */

public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获取Session
        HttpSession session = req.getSession();
        if (session == null) {
            resp.getWriter().write("没有获取到session");
            return;
        }
        resp.getWriter().write("name = " + session.getAttribute("name"));
    }
}
