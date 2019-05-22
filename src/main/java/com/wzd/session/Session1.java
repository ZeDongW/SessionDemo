package com.wzd.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName Session1
 * @Description 获取Session，并设置属性
 * @Version 1.0
 * @date ：Created in 2019/5/4 0004 10:00
 * @modified By：
 */

public class Session1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;utf-8;");
        HttpSession session = req.getSession();
        if(session != null){
            resp.getWriter().write("JSESSIONID = " + session.getId());
        }
        session.setAttribute("name","张三");
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
    }
}
