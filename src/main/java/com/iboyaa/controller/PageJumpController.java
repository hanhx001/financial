/**
 * 
 */
package com.iboyaa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/addShares")
    public String jump2AddSharesUi(HttpServletRequest request, HttpServletResponse response) {

        return "newsharesinfo";
    }

    /**
     * 跳转到录入人员信息界面
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月28日  下午5:51:53
     */
    @RequestMapping("/addUserinfoUi")
    public String jump2AddUserInfoUi(HttpServletRequest request, HttpServletResponse response) {
        return "newuserinfo";

    }

    @RequestMapping("/addloginUserUi")
    public String addloginUserUi(HttpServletRequest request, HttpServletResponse response) {
        return "newloginuser";

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
            @RequestParam(value = "page", required = true, defaultValue = "1") Integer page) {
        
        HttpSession session = request.getSession();
        Integer author = (Integer) session.getAttribute("author");

        if (null != author) {
            if (0 == author) {
                //普通用户  
                page=11;
            } else if (1 == author) {
               
            } else {
                page=12;
            }
        } else {
            page=12;
        }
        
        
        
        
        switch (page) {
            case 1:
                // 持仓界面
                return "list_position";

            case 2:
                //止盈界面
                return "list_stoprofit";

            case 3:
                //止损界面
                return "list_stoploss";

            case 4:
                //意向客户界面
                return "list_intention_client";

            case 5:
                //合作客户界面
                return "list_clients";

            case 6:
                //黑名单
                return "list_blacklist";

            case 7:
                //回款管理
                return "list_payment";

            case 8:
                //客户查询
                return "custom_serach";
            case 9:
                //客户查询
                return "errorNewGp404";
            case 10:
                //系统用户
                return "list_loginuser";
            case 11:
                //没有权限的用户跳转
                return "list_intention_client_noauth";
            case 12:
                //登陆界面
                return "index";

            default:
                return "error404";

        }



    }

    /**
     * 跳转到错误页
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月22日  下午3:12:43
     */
    @RequestMapping(value = "/errorPage", method = RequestMethod.GET)
    public String jump2ErrorPage(HttpServletRequest request, HttpServletResponse response) {

        return "error404";
    }

    /**
     * 跳转到成功页面
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月23日  下午10:20:25
     */
    @RequestMapping(value = "/successPage", method = RequestMethod.GET)
    public String jump2SuccessPage(HttpServletRequest request, HttpServletResponse response) {

        return "success";
    }

}
