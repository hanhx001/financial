/**
 * 
 */
package com.iboyaa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主要用于视图之间的跳转，没有具体业务逻辑、
 * 
 * @author 清水贤人
 * 
 *
 */
@Controller
public class PageJumpController {


 
    /**
     * 跳转到录入股票信息界面
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月15日  下午6:39:59
     */
    @RequestMapping("/add")
    public String jump2AddUi(HttpServletRequest request, HttpServletResponse response) {
      
        return "newinfo";
    }
}
