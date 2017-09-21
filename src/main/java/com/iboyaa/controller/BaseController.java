package com.iboyaa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iboyaa.pojo.SharesInfo;
import com.iboyaa.service.ISharesService;
import com.iboyaa.util.CommonCode;
import com.iboyaa.util.StringIsNull;

/**
 * @author 清水贤人
 *
 */
@Controller
public class BaseController {

    @Resource
    private ISharesService sharesService;

    /**
     * 新建股票 信息界面返回的数据，持久化到数据库
     * 新建成功后 返回到股票列表界面,默认跳转到 持仓界面
     * @param code
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月16日  下午9:13:04
     */
    @RequestMapping(value = "/addUiData", method = RequestMethod.POST)
    public ModelAndView  addUiData(
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

            // return "errorNewGp404";
        }

        //初始化构造函数
        SharesInfo info =
                new SharesInfo(code, num, customer, manager, costprice, phone, comment, "1");

        // 金额=股票数量 * 股票成本价
        info.setTotalPrice(Double.parseDouble(num) * Double.parseDouble(costprice));

        info.setSharseName(sharseName);

        //持久化数据
        sharesService.insertSelective(info);
        
        return new ModelAndView("redirect:/navigation?flag=1");
      
    }

    /**
     * 用于根据股票状态、时间、关键字查询股票数据
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param keyWord   复合关键字，模糊查询该记录中所有匹配的记录
     * @param flag      股票状态：分为持仓（1）、止盈（2）、止损（3）
     * @param sort      排序规则：0 是按照总盈亏率倒叙；1 是按照日盈亏率排序
     * @param request
     * @param responseInteger pageNum, Integer pageSize
     * @return          股票JSON数据
     * @author 清水贤人
     * @version 2017年9月20日  下午3:03:37
     */
    @RequestMapping(value = "/getSharesListData", method = RequestMethod.POST)
    @ResponseBody
    public String getSharesListData(
            @RequestParam(value = "startDate", required = true, defaultValue = "") String startDate,
            @RequestParam(value = "endDate", required = true, defaultValue = "") String endDate,
            @RequestParam(value = "keyWord", required = true, defaultValue = "") String keyWord,
            @RequestParam(value = "flag", required = true, defaultValue = "1") String flag,
            @RequestParam(value = "sort", required = true, defaultValue = "0") String sort,
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            HttpServletRequest request, HttpServletResponse response) {
       
        return JSON.toJSONString(
                sharesService.getSharesDataByCondition(startDate, endDate, keyWord, flag, sort,pageNum,CommonCode.PAGESIZE),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
    }
}
