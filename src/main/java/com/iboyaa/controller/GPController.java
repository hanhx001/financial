/**
 * 
 */
package com.iboyaa.controller;

 
import java.util.ArrayList;
import java.util.Date;
 
import java.util.List;
 

import javax.annotation.Resource;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 

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
	@RequestMapping(value = "/searchName", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;")
	@ResponseBody
	public String searchName(HttpServletRequest request, Model model, HttpServletResponse response) {

		String code = request.getParameter("code");
		// 更新新浪服务器股票数据
		String gpName = gPinfoService.searchRemoteGpData(code);

		return gpName;
	}

	@RequestMapping(value = "/showAll", method = RequestMethod.GET)
	public String toIndex(HttpServletRequest request, Model model) {

		System.out.println("进入跳转页面");
		return "listGP";

	}

	@RequestMapping(value = "/showJsonData", method = RequestMethod.GET)
	@ResponseBody
	public String showJsonData(HttpServletRequest request, Model model) {

		String code = request.getParameter("code");
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		// 更新新浪服务器股票数据
		gPinfoService.updateRemoteGpData();

		List<GPinfo> data = gPinfoService.selectAll(Integer.parseInt(code), sort, order);

		return JSON.toJSONString(data);

	}

	// 新建股票逻辑
	@RequestMapping(value = "/addgp", method = RequestMethod.POST)
	public String add(HttpServletRequest request, Model model) {

		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String manager = request.getParameter("manager");
		String costprice = request.getParameter("costprice");
		String money = request.getParameter("money");
		String phone = request.getParameter("phone");
		String customer = request.getParameter("customer");
		String comment = request.getParameter("comment");
		String num = request.getParameter("num");// 股票数量
		String zsprice = request.getParameter("zsprice");// 止损价
		String id = request.getParameter("id");
		String ccstate = request.getParameter("ccstate");
		GPinfo info = null;
		if (null != id) {
			// 更新操作
			info = gPinfoService.selectByPrimaryKey(Integer.parseInt(id.toString().trim()));
			info.setId(Integer.parseInt(id));
			info.setNum(num);
			info.setManager(manager);
			info.setCustomer(customer);
			info.setZsprice(zsprice);
			info.setCostprice(StringIsNull.isNotNull(costprice) ? Double.parseDouble(costprice) : 0);
			info.setCcstate(ccstate);
			info.setPhone(phone);
			info.setComment(comment);
			info.setMoney(Double.parseDouble(costprice) * Double.parseDouble(num));
			gPinfoService.updateByPrimaryKeySelective(info);
		} else {
			// 新建操作
			info = new GPinfo();
			info.setCode(code);
			info.setName(name);
			info.setManager(manager);
			info.setCostprice(StringIsNull.isNotNull(costprice) ? Double.parseDouble(costprice) : 0);
			info.setCreatetime(new Date());
			info.setMoney(Double.parseDouble(costprice) * Double.parseDouble(num));
			info.setPhone(phone);
			info.setComment(comment);
			info.setCreatetime(new Date());
			info.setCustomer(customer);
			info.setNum(num);
			info.setSum(Integer.parseInt(num) * Double.parseDouble(costprice));
			info.setCcstate("1");

			gPinfoService.insert(info);
		}

		return null;
	}

	// 新建股票界面
	@RequestMapping("/addUi")
	public String adUi(HttpServletRequest request, HttpServletResponse response) {

		return "newinfo";
	}

	// 删除股票
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request, HttpServletResponse response) {

		String gPrimaryKey = request.getParameter("id");
		gPinfoService.deleteByPrimaryKey(Integer.parseInt(gPrimaryKey.trim()));

		return "1";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "text/html;charset=UTF-8;")
	@ResponseBody
	// 更新股票界面
	public String update(HttpServletRequest request, Model model) {

		// 获取到要更改的股票ID主键
		String id = request.getParameter("id");

		GPinfo info = gPinfoService.selectByPrimaryKey(Integer.parseInt(id.toString().trim()));

		return JSON.toJSONString(info);

	}

	// 动态获取所属经理返回给前台
	@RequestMapping(value = "/backManager", method = RequestMethod.GET)
	@ResponseBody
	public List<GPinfo> backManager(HttpServletRequest request, HttpServletResponse response) {

		List<GPinfo> data = gPinfoService.selectManager();
		// JSONArray jsonArr = JSON.parseArray(JSON.toJSONString(data));
		// System.out.println(jsonArr);
		// return jsonArr;
		return data;

	}

	// 模糊检索
	@RequestMapping(value = "/fuzzySearch", method = RequestMethod.POST)
	@ResponseBody
	public String fuzzySearch(GPinfo info) {

		List<GPinfo> data = gPinfoService.fuzzySearch(info);
		return JSON.toJSONString(data);

	}

	// 字段排序
	@RequestMapping(value = "/sortAble", method = RequestMethod.POST)
	@ResponseBody
	public String sortAble(HttpServletRequest request, HttpServletResponse response) {

		String ccstate = request.getParameter("sheet");// 那个栏目的排序请求，
		String order = request.getParameter("order");// 排序方式
		String column = request.getParameter("column");// 要排序的字段
		List<GPinfo> backDate = new ArrayList<>();

		switch (ccstate) {
		case "1":// 持仓
			backDate = gPinfoService.sortAble(ccstate, order, column);
			break;
		case "2":// 止盈

			break;
		case "3":// 止损

			break;

		default:
			break;
		}

		return JSON.toJSONString(backDate);

	}

}
