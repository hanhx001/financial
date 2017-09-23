package com.iboyaa.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iboyaa.pojo.SharesInfo;
import com.iboyaa.pojo.UserInfo;
import com.iboyaa.service.ISharesService;
import com.iboyaa.service.IUserInfoService;
import com.iboyaa.util.CommonCode;

/**
 * @author 清水贤人
 *
 */
@Controller
public class BaseController {

    @Resource
    private ISharesService sharesService;
    @Resource
    private IUserInfoService userinfoService;

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
    public ModelAndView addUiData(
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
                sharesService.getSharesDataByCondition(startDate, endDate, keyWord, flag, sort,
                        pageNum, CommonCode.PAGESIZE),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 查询股票详细 信息
     * @param id 股票ID
     * @param navigation 页面导航ID，用于返回时页面的跳转   为1代表是查看详情界面，为2是更新界面
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月22日  下午2:55:45
     */
    @RequestMapping(value = "/getOneSharesDetail", method = RequestMethod.GET)
    public ModelAndView getOneSharesDetail(
            @RequestParam(value = "id", required = true, defaultValue = "") Integer id,
            @RequestParam(value = "navigation", required = true,
                    defaultValue = "") Integer navigation,
            HttpServletRequest request, HttpServletResponse response) {

        // 查询单条股票详细信息
        SharesInfo sharesInfo = sharesService.selectByPrimaryKey(id);

        //返回的页面视图
        ModelAndView modelAndView = null;

        // 返回查询到的数据
        if (1 == navigation) {
            modelAndView = new ModelAndView("detailShares");
            modelAndView.addObject("data", sharesInfo);
        } else if (2 == navigation) {
            modelAndView = new ModelAndView("manageShares");
            modelAndView.addObject("data", sharesInfo);
        }

        //对错误输入的判断和页面跳转
        if (null == sharesInfo || null == modelAndView) {

            return new ModelAndView("redirect:/errorPage");
        }


        return modelAndView;


    }

    /**
     * 更新股票数据信息
     * @param id  　　　  股票ID
     * @param num　　　　  股票数量
     * @param costprice　  成本价
     * @param phone　　　  电话号码
     * @param comment　　  备注
     * @param customer    客户名称
     * @param manager     客户经理名称
     * @param position　    股票状态
     * @param blackstate　客户黑名单状态　0 是默认白名单，1是黑名单
     * @param blackcommon 黑名单备注
     * @param request
     * @param response
     * @return  返回到对应的页面导航
     * @author 清水贤人
     * @version 2017年9月22日  下午5:21:57
     */
    @RequestMapping(value = "/updateOneSharesDetail", method = RequestMethod.POST)
    public ModelAndView updateOneSharesDetail(
            @RequestParam(value = "id", required = true, defaultValue = "") Integer id,
            @RequestParam(value = "num", required = true, defaultValue = "0") String num,
            @RequestParam(value = "costprice", required = true,
                    defaultValue = "0") String costprice,
            @RequestParam(value = "customer", required = true, defaultValue = "") String customer,
            @RequestParam(value = "manager", required = true, defaultValue = "") String manager,
            @RequestParam(value = "phone", required = true, defaultValue = "") String phone,
            @RequestParam(value = "comment", required = true, defaultValue = "") String comment,
            @RequestParam(value = "position", required = true, defaultValue = "") String position,
            @RequestParam(value = "close", required = true, defaultValue = "") String close,
            @RequestParam(value = "blackcommon", required = true,
                    defaultValue = "") String blackcommon,
            HttpServletRequest request, HttpServletResponse response) {

        // 查询单条股票详细信息
        SharesInfo sharesInfo = sharesService.selectByPrimaryKey(id);
        sharesInfo.setComment(comment);
        sharesInfo.setCostPrice(costprice);
        sharesInfo.setNum(num);
        sharesInfo.setPhone(phone);
        sharesInfo.setPosition(position);
        sharesInfo.setTotalPrice(Double.parseDouble(num) * Double.parseDouble(costprice));
        sharesInfo.setUpdatetime(new Date());
        //更新股票基本信息
        sharesService.updateByPrimaryKeySelective(sharesInfo);

        //更新黑名单信息
        if ("on".equals(close)) {
            UserInfo userInfo =
                    new UserInfo(customer, manager, phone, blackcommon, Byte.parseByte("4"));
            userinfoService.insertSelective(userInfo);
        }

        return new ModelAndView("redirect:/successPage");


    }


}
