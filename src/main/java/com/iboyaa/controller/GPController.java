/**
 * 
 */
package com.iboyaa.controller;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSON;
import com.iboyaa.pojo.GPinfo;
import com.iboyaa.service.IGPinfoService;
import com.iboyaa.util.StringIsNull;

/**
 * @author 清水贤人
 *
 */
@Controller
@RequestMapping("/gp")
public class GPController {

	@Resource
	private IGPinfoService gPinfoService;
	
	// 实时查询股票名称
	@RequestMapping(value ="/searchName",method = RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String searchName(HttpServletRequest request,Model model,HttpServletResponse response){
			
		String  code = request.getParameter("code");
			//更新新浪服务器股票数据
		String gpName = gPinfoService.searchRemoteGpData(code);
		 
		return gpName;
	}
	
	
	
	
	@RequestMapping(value ="/showAll",method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request,Model model){
	 
		System.out.println("进入跳转页面");
		return "listGP";
		
	}
	
	@RequestMapping(value = "/showJsonData", method = RequestMethod.GET)
	@ResponseBody
	public String showJsonData(HttpServletRequest request,Model model){
		
		String code =request.getParameter("code");
		//更新新浪服务器股票数据
		gPinfoService.updateRemoteGpData();
		
		List<GPinfo> data = gPinfoService.selectAll(Integer.parseInt(code));
		
		 return JSON.toJSONString(data);
		
	}
	
	// 新建股票逻辑
	@RequestMapping(value = "/addgp",method = RequestMethod.POST)
	public String  add(HttpServletRequest request,Model model ){
		 
		String  code = request.getParameter("code");
		
		  
		
		String  name  = request.getParameter("name");
		String  manager  = request.getParameter("manager");
		String   costprice = request.getParameter("costprice");
		String  money  = request.getParameter("money");
		String   phone = request.getParameter("phone");
		String   customer = request.getParameter("customer");
		String   comment = request.getParameter("comment").trim();
		String   num = request.getParameter("num").trim();//股票数量
		
		GPinfo info = new GPinfo();
		info.setCode(code);
		info.setName(name);
		info.setManager(manager);
		info.setCostprice(StringIsNull.isNotNull(costprice) ? Double.parseDouble(costprice):0);
		
		 
		
		info.setMoney(Double.parseDouble(costprice) * Double.parseDouble(num));
		info.setPhone(phone);
		info.setComment(comment);	
		info.setCreatetime(new Date());
		info.setCustomer(customer);
		info.setNum(num);
		info.setSum(Integer.parseInt(num) * Double.parseDouble(costprice) );
		info.setCcstate("1");
 
		gPinfoService.insert(info);
		 
		return null;
	}
	
	// 新建股票界面
	@RequestMapping("/addUi")
	public String adUi(HttpServletRequest request,HttpServletResponse response){
		
		return "add";
		
	}
	
	//删除股票
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,HttpServletResponse response){
		
		String gPrimaryKey = request.getParameter("id");
		gPinfoService.deleteByPrimaryKey(Integer.parseInt(gPrimaryKey.trim()));
		
		return "redirect:/gp/showAll";
		
		
	}
	@RequestMapping("/updateUi")
	//更新股票界面
	public String updateUi(HttpServletRequest request,Model model){
		
		//获取到要更改的股票ID主键
		String id = request.getParameter("id");
		
		GPinfo info = gPinfoService.selectByPrimaryKey(Integer.parseInt(id.toString().trim()));
		
		model.addAttribute("data", info);
		return "update";
		
	}
	
	//更新股票信息
	@RequestMapping("/update")
	public String update(HttpServletRequest request,HttpServletResponse response){
		
		//获取到要更改的股票ID主键
		String id = request.getParameter("id");
		
		GPinfo info = gPinfoService.selectByPrimaryKey(Integer.parseInt(id.toString().trim()));
		
		 
		String  code = request.getParameter("code");
		
		 String regEx = "\\w{6,20}"; //编写正则表达式的规则
		 Pattern pat = Pattern.compile(regEx);  
		 Matcher mat = pat.matcher(code);  
		 boolean rs = mat.find(); 
		if(!rs){
			return "redirect:/gp/showAll";
		}
		
		String  name  = request.getParameter("name");
		String  manager  = request.getParameter("manager");
		String   costprice = request.getParameter("costprice");
		String  money  = request.getParameter("money");
		String   phone = request.getParameter("phone");
		String   customer = request.getParameter("customer");
		String   comment = request.getParameter("comment").trim();
		
		info.setCode(code);
		info.setName(name);
		info.setManager(manager);
		info.setCostprice(StringIsNull.isNotNull(costprice) ? Double.parseDouble(costprice):0);
		info.setMoney(StringIsNull.isNotNull(money) ? Double.parseDouble(money):0);
		info.setPhone(phone);
		info.setComment(comment);	
		info.setCreatetime(new Date());
		info.setCustomer(customer);
		
		gPinfoService.updateByPrimaryKeySelective(info);
		
		return "redirect:/gp/showAll";
		
	}

}
