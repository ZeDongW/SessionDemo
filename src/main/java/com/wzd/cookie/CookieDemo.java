package com.wzd.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName CookieDemo
 * @Description CookieDemo
 * @Version 1.0
 * @date ：Created in 2019/5/3 0003 6:11
 * @modified By：
 */

public class CookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie cookie1 = new Cookie("name","jack");
        Cookie cookie2 = new Cookie("age","20");
        Cookie cookie3 = new Cookie("email","123@qq.com");
        cookie1.setPath("/SessionDemo");
        cookie2.setPath("/SessionDemo");
        cookie3.setPath("/SessionDemo");

        cookie1.setMaxAge(-1);
        cookie2.setMaxAge(-1);
        cookie3.setMaxAge(-1);

        resp.addCookie(cookie1);
//        resp.addCookie(cookie2);
//        resp.addCookie(cookie3);

        System.out.println("=================获取Cookies==============");
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
            }
        } else {
            System.out.println("没有Cookie数据");
        }
    }
}
