/**
 * 
 */
package com.iboyaa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * @author 清水贤人
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        
        String requestURI = request.getRequestURI(); 
       
       //登陆验证
        if(requestURI.indexOf("loginloading")>=0) {
            return true;
        } 
         
        HttpSession session = request.getSession();
 
        if (null != session) {
            String author = (String) session.getAttribute("author");


            if ("0".equals(author)) {
                //普通用户  
                response.sendRedirect("/navigation?flag=11");
                return true;
            } else if ("1".equals(author)) {
                //管理员
                response.sendRedirect("/navigation?flag=1");
                return true;

            } else {
                request.getRequestDispatcher("/index.jsp");
                return false;
            }
        } else {
            request.getRequestDispatcher("/index.jsp");
            return false;
        }



    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub

    }


}
