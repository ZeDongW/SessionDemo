package com.wzd.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName DeleteCookieDemo
 * @Description 删除Cookie
 * @Version 1.0
 * @date ：Created in 2019/5/3 0003 7:16
 * @modified By：
 */

public class DeleteCookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("name", "");
        cookie.setPath("/SessionDemo");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }
}
