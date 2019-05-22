package com.wzd.logindemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName IndexServlet
 * @Description 用户主页
 * @Version 1.0
 * @date ：Created in 2019/5/4 0004 17:12
 * @modified By：
 */

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(false);
        if(session == null) {
            resp.sendRedirect(req.getContextPath() + "/page/login.html");
            return;
        }
        String name = (String)session.getAttribute("name");
        if(name == null){
            resp.sendRedirect(req.getContextPath() + "/page/login.html");
            return;
        }
        String html = "<html><head><title>登录成功</title></head><body>欢迎登录，<font color='green' size='20px'> " + name + " </font>" +
                "<a href=' " + req.getContextPath() + "/logout'>安全退出</a></body></html>";
        resp.getWriter().write(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
