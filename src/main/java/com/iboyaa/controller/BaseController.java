/**
 * 
 */
package com.iboyaa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.iboyaa.pojo.SharesInfo;

/**
 * @author 清水贤人
 *
 */
@Controller
public class BaseController {


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
    public String addUiData(@RequestBody String code, HttpServletRequest request,
            HttpServletResponse response) {

        // 转换json数据
        SharesInfo infoJsonData = JSON.parseObject(code, SharesInfo.class);

        //初始化构造函数
        SharesInfo info = new SharesInfo(infoJsonData.getCode(), infoJsonData.getNum(),
                infoJsonData.getCustomer(), infoJsonData.getManager(), infoJsonData.getCostPrice(),
                infoJsonData.getPhone(), infoJsonData.getComment(), "1");

        return null;

    }
}
