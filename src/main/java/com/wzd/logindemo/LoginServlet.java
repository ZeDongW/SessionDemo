package com.wzd.logindemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName LoginServlet
 * @Description 登录控制
 * @Version 1.0
 * @date ：Created in 2019/5/4 0004 12:32
 * @modified By：
 */

public class LoginServlet extends HttpServlet {
    /**
     * @Author: ZeDongW
     * @Description: 登录校验分发
     * @Date: 2019/5/4 0004 12:33
     * @Param: [req, resp]
     * @return: void
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        //登录失败
        if(!"jack".equals(name) || !"123456".equals(password)){
            //重定向到失败页面
            resp.sendRedirect(req.getContextPath() + "/page/fail.html");
            return;
        }
        //获取会话session
        HttpSession session = req.getSession();
        session.setAttribute("name",name);
        //成功
        resp.sendRedirect(req.getContextPath() + "/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
