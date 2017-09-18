package com.iboyaa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.iboyaa.pojo.SharesInfo;
import com.iboyaa.service.ISharesService;
import com.iboyaa.util.StringIsNull;

/**
 * @author 清水贤人
 *
 */
@Controller
public class BaseController {

   @Resource
   private  ISharesService sharesService;

    /**
     * 新建股票 信息界面返回的数据，持久化到数据库
     * 新建成功后 返回到股票列表界面
     * @param code
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月16日  下午9:13:04
     */
    @RequestMapping(value = "/addUiData", method = RequestMethod.POST)
    public String addUiData(
            @RequestParam(value = "code", required = true, defaultValue = "") String code,
            @RequestParam(value = "num", required = true, defaultValue = "0") String num,
            @RequestParam(value = "customer", required = true, defaultValue = "") String customer,
            @RequestParam(value = "manager", required = true, defaultValue = "") String manager,
            @RequestParam(value = "costprice", required = true,
                    defaultValue = "0") String costprice,
            @RequestParam(value = "phone", required = true, defaultValue = "") String phone,
            @RequestParam(value = "comment", required = true, defaultValue = "") String comment,
            HttpServletRequest request, HttpServletResponse response) {

        /**
         * 根据股票代码查询名称
         * 如果返回结果为空,证明股票代码错误，直接返回错误页
         * 不执行插入操作
         */
        String sharseName = sharesService.getSharesName(code);
        if ("failed;".equals(sharseName)) {

            return "errorNewGp404";
        }

        //初始化构造函数
        SharesInfo info =
                new SharesInfo(code, num, customer, manager, costprice, phone, comment, "1");

        // 金额=股票数量 * 股票成本价
        info.setTotalPrice(Double.parseDouble(num) * Double.parseDouble(costprice));

        info.setSharseName(sharseName);
        
        //持久化数据
        sharesService.insertSelective(info);

        return "";



    }
}
