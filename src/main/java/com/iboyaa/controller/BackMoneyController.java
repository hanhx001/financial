/**
 * 
 */
package com.iboyaa.controller;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.css.ElementCSSInlineStyle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iboyaa.pojo.BackMoney;
import com.iboyaa.service.IBackMoneyService;
import com.iboyaa.util.CommonCode;


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
     * 录入回款信息
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
            @RequestParam(value = "backmoney", required = true, defaultValue = "") Double backmoney,
            @RequestParam(value = "backbank", required = true, defaultValue = "") String backbank,
            @RequestParam(value = "comment", required = true, defaultValue = "") String comment,
            @RequestParam(value = "customId", required = true, defaultValue = "") String customId,
            HttpServletRequest request, HttpServletResponse response) {

        BackMoney backMoneyTemp = new BackMoney(code, sharseName, customId, customer, manager,
                phone, sendtime, percent, sendoutprice, devidepoint, devidenum, backmoney, backbank,
                comment, custompercent);

        backMoneyService.insertSelective(backMoneyTemp);

        return "success";
    }

    /**
     * 根据筛选条件查询回款信息
     * @param startDate
     * @param endDate
     * @param keyWord
     * @param pageNum
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月26日  下午5:35:08
     */
    @RequestMapping(value = "/getBackMoneyDatas", method = RequestMethod.POST)
    @ResponseBody
    public String getBackMoneyDatas(
            @RequestParam(value = "startDate", required = true, defaultValue = "") String startDate,
            @RequestParam(value = "endDate", required = true, defaultValue = "") String endDate,
            @RequestParam(value = "keyWord", required = true, defaultValue = "") String keyWord,
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            HttpServletRequest request, HttpServletResponse response) {

        return JSON.toJSONString(
                backMoneyService.getBackMoneyDatas(startDate, endDate, keyWord, pageNum,
                        CommonCode.PAGESIZE),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);

    }

    /**
     * 
     * 查询回款详情根据ID
     * @param id
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月26日  下午6:13:03
     */
    @RequestMapping(value = "/getOneBackMoneyDetail", method = RequestMethod.GET)
    public ModelAndView getOneBackMoneyDetail(
            @RequestParam(value = "id", required = true, defaultValue = "") Integer id,
            HttpServletRequest request, HttpServletResponse response) {

        BackMoney backMoney = backMoneyService.selectByPrimaryKey(id);

        ModelAndView modelAndView = new ModelAndView("manage_Backmoney");
        backMoney.setUpdatetime2String(new DateTime(backMoney.getUpdatetime())
                .toString("yyyy-MM-dd HH:mm:ss", Locale.CHINESE));
        modelAndView.addObject("data", backMoney);

        //对错误输入的判断和页面跳转
        if (null == backMoney.getId()) {
            return new ModelAndView("redirect:/errorPage");
        }

        HttpSession session = request.getSession();
        Integer author = (Integer) session.getAttribute("author");

        if (null != author) {
            if (0 == author) {
                //普通用户  
                return new ModelAndView("redirect:/navigation?page=12");
            } else if (1 == author) {
                //管理员
              return modelAndView;
            } else {
                return new ModelAndView("redirect:/navigation?page=12");
            }
        } else {
            return new ModelAndView("redirect:/navigation?page=12");
        }

    }
}
