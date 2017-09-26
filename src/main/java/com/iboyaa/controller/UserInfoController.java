/**
 * 
 */
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
import com.iboyaa.pojo.UserInfo;
import com.iboyaa.service.ISharesService;
import com.iboyaa.service.IUserInfoService;
import com.iboyaa.util.CommonCode;

/**
 * 用户对应的控制类
 * @author 清水贤人
 *
 */
@Controller
public class UserInfoController {
    
    @Resource
    private ISharesService sharesService;
    @Resource
    private IUserInfoService userinfoService;
    /**
     * 根据筛选条件，查询人员数据
     * @param startDate  开始时间
     * @param endDate    结束时间
     * @param keyWord    关键字
     * @param state      人员状态 人员状态：0是合作客户，1是意向客户，2是停用账户 ，4是黑名单，
     * @param pageNum    第几页
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月24日  上午11:51:52
     */
    @RequestMapping(value = "/getUserinfoList", method = RequestMethod.POST)
    @ResponseBody
    public String getUserinfoList(
            @RequestParam(value = "startDate", required = true, defaultValue = "") String startDate,
            @RequestParam(value = "endDate", required = true, defaultValue = "") String endDate,
            @RequestParam(value = "keyWord", required = true, defaultValue = "") String keyWord,
            @RequestParam(value = "state", required = true, defaultValue = "") Integer state,
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            HttpServletRequest request, HttpServletResponse response) {

        return JSON.toJSONString(
                userinfoService.getUserInfo(startDate, endDate, keyWord, state, pageNum,
                        CommonCode.PAGESIZE),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 查询人员详细信息，跳转到对应界面
     * @param id           人员ID
     * @param navigation   导航选项 1代表查询详细，2代表编辑
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月24日  下午12:56:03
     */
    @RequestMapping(value = "/getOneUserInfoDetail", method = RequestMethod.GET)
    public ModelAndView getOneUserInfoDetail(
            @RequestParam(value = "id", required = true, defaultValue = "") Integer id,
            @RequestParam(value = "navigation", required = true,
                    defaultValue = "") Integer navigation,
            HttpServletRequest request, HttpServletResponse response) {

        // 根据ID查询人员详细信息
        UserInfo userInfo = userinfoService.selectByPrimaryKey(id);

        ModelAndView modelAndView = null;

        // 返回查询到的数据 2代表跳转到更新界面
        if (1 == navigation) {

        } else if (2 == navigation) {
            modelAndView = new ModelAndView("manage_UserInfo");
            modelAndView.addObject("data", userInfo);
        }

        //对错误输入的判断和页面跳转
        if (null == userInfo || null == modelAndView) {

            return new ModelAndView("redirect:/errorPage");
        }

        return modelAndView;
    }

    /**
     * 更新人员基本信息 
     * @param id       人员ID
     * @param state    人状态
     * @param customer 客户名称
     * @param manager  客户经理
     * @param phone    客户电话
     * @param comment  备注
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月25日  下午2:58:30
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ModelAndView updateUserInfo(
            @RequestParam(value = "id", required = true, defaultValue = "") Integer id,
            @RequestParam(value = "state", required = true, defaultValue = "") Integer state,
            @RequestParam(value = "customer", required = true, defaultValue = "") String customer,
            @RequestParam(value = "manager", required = true, defaultValue = "") String manager,
            @RequestParam(value = "phone", required = true, defaultValue = "") String phone,
            @RequestParam(value = "comment", required = true, defaultValue = "") String comment,
            HttpServletRequest request, HttpServletResponse response) {

        // 根据ID查询人员详细信息
        UserInfo userInfo = userinfoService.selectByPrimaryKey(id);
        userInfo.setComment(comment);
        userInfo.setUpdatetime(new Date());
        userInfo.setCustomer(customer);
        userInfo.setManager(manager);
        userInfo.setPhone(phone);
        userInfo.setState(state.byteValue());
        // 更新人员基本信息
        userinfoService.updateByPrimaryKeySelective(userInfo);

        //对错误输入的判断和页面跳转
        if (null == userInfo.getId()) {
            return new ModelAndView("redirect:/errorPage");
        }

        return new ModelAndView("redirect:/successPage");
    }

}
