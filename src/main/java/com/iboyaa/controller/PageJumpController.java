/**
 * 
 */
package com.iboyaa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 股票数据中心界面
     * 根据前端点击的tree值，摆渡到指定的页面
     * @param request
     * @param response
     * @param page 前端跳转页面对应的值
     * @return
     * @author 清水贤人
     * @version 2017年9月19日  下午3:56:31
     */
    @RequestMapping(value = "/navigation", method = RequestMethod.GET)
    public String navigationSearchPage(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "page", required = true, defaultValue = "1") Integer code) {

        return "error404";

    }
}
