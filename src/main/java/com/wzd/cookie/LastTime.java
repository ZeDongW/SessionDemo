package com.wzd.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ZeDongW
 * @ClassName LastTime
 * @Description 通过Cookie记录用户上次访问时间
 * @Version 1.0
 * @date ：Created in 2019/5/3 0003 7:21
 * @modified By：
 */

public class LastTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //Cookie不能存储中文
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd@hh:mm:ss");
        String nowTime = simpleDateFormat.format(new Date());
        Cookie lastTime = null;
        Cookie[] cookies = req.getCookies();
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("lastTime".equals(cookie.getName())) {
                    lastTime = cookie;
                    break;
                }
            }
        }

        if(lastTime != null){
            resp.getWriter().write("欢迎回来，您上次访问本网站时间为：" + lastTime.getValue());
        } else {
            resp.getWriter().write("欢迎登录，您是首次访问本网站");
        }
        resp.getWriter().write(", 当前时间为：" + nowTime);
        Cookie cookie = new Cookie("lastTime", nowTime);
        cookie.setMaxAge(1*60*60*24);//保存一年
        resp.addCookie(cookie);
    }
}
