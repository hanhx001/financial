/**
 * 
 */
package com.iboyaa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iboyaa.pojo.BackMoney;
import com.iboyaa.service.IBackMoneyService;


/**
 * 回款管理 控制类
 * @author 清水贤人
 *
 */
@Controller
public class BackMoneyController {
    
    @Resource
    private IBackMoneyService backMoneyService;
    /**
     * @param code
     * @param sharseName
     * @param customer
     * @param manager
     * @param phone
     * @param sendtime
     * @param percent
     * @param sendoutprice
     * @param custompercent
     * @param devidepoint
     * @param devidenum
     * @param backmoney
     * @param backbank
     * @param comment
     * @param customId
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月26日  下午4:34:58
     */
    @RequestMapping(value = "/addBackMoney", method = RequestMethod.POST)
    public String addBackMoney(
            @RequestParam(value = "code", required = true, defaultValue = "") String code,
            @RequestParam(value = "sharseName", required = true,
                    defaultValue = "") String sharseName,
            @RequestParam(value = "customer", required = true, defaultValue = "") String customer,
            @RequestParam(value = "manager", required = true, defaultValue = "") String manager,
            @RequestParam(value = "phone", required = true, defaultValue = "") String phone,
            @RequestParam(value = "sendtime", required = true, defaultValue = "") String sendtime,
            @RequestParam(value = "percent", required = true, defaultValue = "") String percent,
            @RequestParam(value = "sendoutprice", required = true,
                    defaultValue = "") String sendoutprice,
            @RequestParam(value = "custompercent", required = true,
                    defaultValue = "") String custompercent,
            @RequestParam(value = "devidepoint", required = true,
                    defaultValue = "") String devidepoint,
            @RequestParam(value = "devidenum", required = true, defaultValue = "") String devidenum,
            @RequestParam(value = "backmoney", required = true, defaultValue = "") String backmoney,
            @RequestParam(value = "backbank", required = true, defaultValue = "") String backbank,
            @RequestParam(value = "comment", required = true, defaultValue = "") String comment,
            @RequestParam(value = "customId", required = true, defaultValue = "") String customId,
            HttpServletRequest request, HttpServletResponse response) {
           
            BackMoney backMoneyTemp =new BackMoney(code, sharseName, customId, customer, manager, phone, sendtime, percent, sendoutprice, devidepoint, devidenum, backmoney, backbank, comment, custompercent);
            
            backMoneyService.insertSelective(backMoneyTemp);
            
        return "success";


    }
}
