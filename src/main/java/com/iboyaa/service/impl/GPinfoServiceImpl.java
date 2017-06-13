package com.iboyaa.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iboyaa.dao.IGPinfoDao;
import com.iboyaa.pojo.GPinfo;
import com.iboyaa.service.IGPinfoService;
import com.iboyaa.util.StringIsNull;
import com.mysql.fabric.xmlrpc.base.Array;

@Service("gpinfoService")
public class GPinfoServiceImpl implements IGPinfoService {
	
	@Resource
	private IGPinfoDao gPinfoDao;
	
	public GPinfoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.gPinfoDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(GPinfo record) {
		// TODO Auto-generated method stub
		return this.gPinfoDao.insert(record);
	}

	@Override
	public int insertSelective(GPinfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GPinfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return this.gPinfoDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GPinfo record) {
		// TODO Auto-generated method stub
		return this.gPinfoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GPinfo record) {
		// TODO Auto-generated method stub
		return this.gPinfoDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<GPinfo> selectAll(Integer state) {
		
		return this.gPinfoDao.selectAllByC(state);
	}
	
	//调取新浪股票数据
	public String getHtmlConentByUrl(String gpCode){
		 try
	        {
	            URL url = new URL("http://hq.sinajs.cn/list="+gpCode);
	            HttpURLConnection con = (HttpURLConnection) url.openConnection();
	            con.setRequestProperty("contentType", "GBK");
	            con.setInstanceFollowRedirects(false);
	            con.setUseCaches(false);
	            con.setAllowUserInteraction(false);
	            con.connect();
	            
	            StringBuffer sb = new StringBuffer();
	            String line = "";
	            BufferedReader URLinput = new BufferedReader(new InputStreamReader(
	                    con.getInputStream(),"GBK"));
	          
	            while ((line = URLinput.readLine()) != null)
	            {
	                sb.append(line);
	            }
	            con.disconnect();
	 
	            return sb.toString().toLowerCase();
	        }
	        catch (Exception e)
	        {
	            return "0";
	        }
	}

	@Override
	public void updateRemoteGpData() {
		
		// 查询出没更新股票价格的的所有数据
				List <GPinfo> data = this.gPinfoDao.selectAllByC(1);
				
				for(GPinfo info : data){
					
					//根据股票代码 调取远程接口获取数据
					String remoteDate = getHtmlConentByUrl(info.getCode());
					 
					String[] tempSplit = remoteDate.split("=");
					
					if(tempSplit.length == 2){
					// 证明股票代码正确，有股票信息返回
						
						String[] newData = tempSplit[1].split(",");
					 
						String openPrice = newData[1].toString();
						double closePrice = Double.parseDouble(StringIsNull.isNULL(newData[2].toString()) ? "0":newData[2].toString());
						double currentPrice = Double.parseDouble(StringIsNull.isNULL(newData[3].toString()) ? "0":newData[2].toString());
						
						info.setName(newData[0].replaceAll("\"", "").trim());//股票名称
						info.setCurrentprice( currentPrice);
						info.setPercent((currentPrice - info.getCostprice()) / info.getCostprice() *100);//总盈亏比率
					    info.setDaypercent(( currentPrice - closePrice ) / closePrice *100);//当日盈亏比率
						
					}
					
				  
 					
			        info.setUpdatetime(new Date());
			        
			        gPinfoDao.updateByPrimaryKeySelective(info);
				}
	}

	@Override
	public String searchRemoteGpData(String code) {
		 
		String gpName ="";
		//根据股票代码 调取远程接口获取数据
		String remoteDate = getHtmlConentByUrl(code);
		
		String[] tempSplit = remoteDate.split("=");
		
		if(tempSplit.length == 2){
			String[] newData = tempSplit[1].split(",");
			gpName = newData[0].replaceAll("\"", "").trim();
		}else{
			gpName = "啥也没查到！";
			
		}
		
		return gpName;
	}
}
