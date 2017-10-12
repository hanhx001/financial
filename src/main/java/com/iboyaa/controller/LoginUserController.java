/**
 * 
 */
package com.iboyaa.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iboyaa.dao.loginUserDao;
import com.iboyaa.pojo.loginUser;
import com.iboyaa.service.ILoginUserService;
import com.iboyaa.util.CommonCode;
import com.iboyaa.util.MD5Util;

/**
 * 登陆用户管理
 * @author 清水贤人
 *
 */
@Controller
public class LoginUserController {

    @Resource
    private ILoginUserService loginUserService;

    /**
     * 管理员新建人员
     * @param loginname
     * @param username
     * @param password
     * @param author
     * @param common
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年9月29日  下午2:42:53
     */
    @RequestMapping(value = "/addLoginUser", method = RequestMethod.POST)

    public ModelAndView addLoginUser(
            @RequestParam(value = "loginname", required = true, defaultValue = "") String loginname,
            @RequestParam(value = "username", required = true, defaultValue = "") String username,
            @RequestParam(value = "password", required = true, defaultValue = "") String password,
            @RequestParam(value = "author", required = true, defaultValue = "") String author,
            @RequestParam(value = "common", required = true, defaultValue = "") String common,
            HttpServletRequest request, HttpServletResponse response) {

        // 权限字符转换
        Integer authNum = 0;
        if ("ON".equalsIgnoreCase(author)) {
            authNum = 1;
        }
        // 初始化构造函数
        loginUser loginUser =
                new loginUser(loginname, username, MD5Util.convertMD5(password), authNum, common);

        //持久化数据
        loginUserService.insertSelective(loginUser);

        return new ModelAndView("redirect:/navigation?page=10");

    }

    @RequestMapping(value = "/getLoginUserDatas", method = RequestMethod.POST)
    @ResponseBody
    public String getLoginUserDatas(
            @RequestParam(value = "startDate", required = true, defaultValue = "") String startDate,
            @RequestParam(value = "endDate", required = true, defaultValue = "") String endDate,
            @RequestParam(value = "keyWord", required = true, defaultValue = "") String keyWord,
            @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum,
            HttpServletRequest request, HttpServletResponse response) {

        return JSON.toJSONString(
                loginUserService.getLoginUserInfoByCondition(startDate, endDate, keyWord, pageNum,
                        CommonCode.PAGESIZE),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     * @author 清水贤人
     * @version 2017年10月11日  下午5:01:24
     */
    @RequestMapping(value = "/loginloading", method = RequestMethod.POST)
    public ModelAndView loginloading(
            @RequestParam(value = "username", required = true, defaultValue = "") String username,
            @RequestParam(value = "password", required = true, defaultValue = "") String password,
            HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) {

        loginUser userData = loginUserService.login(username, MD5Util.convertMD5(password));

        if(null == userData) {
            return new ModelAndView("redirect:/navigation?page=12");
        }
        
        httpSession.setAttribute("username", userData.getUsername());
        httpSession.setAttribute("author", userData.getAuthor());
        
        if (0==userData.getAuthor()) {
            return new ModelAndView("redirect:/navigation?page=11");
        }
        
        return new ModelAndView("redirect:/navigation?page=1");


    }
}
