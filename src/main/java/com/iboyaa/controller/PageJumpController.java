/**
 * 
 */
package com.iboyaa.controller;

import javax.annotation.Resource;
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
            @RequestParam(value = "page", required = true, defaultValue = "1") Integer page) {

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
                return "blacklist";

            case 7:
                //回款管理
                return "back_payment";

            case 8:
                //客户查询
                return "custom_serach";


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
