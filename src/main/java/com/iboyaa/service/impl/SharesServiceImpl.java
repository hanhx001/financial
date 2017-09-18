/**
 * 
 */
package com.iboyaa.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iboyaa.dao.ISharesDao;
import com.iboyaa.pojo.SharesInfo;
import com.iboyaa.service.ISharesService;

/**
 * @author 清水贤人
 *
 */
@Service("sharesService")
public class SharesServiceImpl implements ISharesService {

    @Resource
   private ISharesDao sharesDao;

    public SharesServiceImpl() {

    }

    // 调取新浪股票数据
    public String getHtmlConentByUrl(String code) {
        try {
            URL url = new URL("http://hq.sinajs.cn/list=" + code);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("contentType", "GBK");
            con.setInstanceFollowRedirects(false);
            con.setUseCaches(false);
            con.setAllowUserInteraction(false);
            con.connect();

            StringBuffer sb = new StringBuffer();
            String line = "";
            BufferedReader URLinput =
                    new BufferedReader(new InputStreamReader(con.getInputStream(), "GBK"));

            while ((line = URLinput.readLine()) != null) {
                sb.append(line);
            }
            con.disconnect();

            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return "0";
        }
    }

    @Override
    public String getSharesName(String code) {

        String gpName = "";
        // 根据股票代码 调取远程接口获取数据
        String remoteDate = getHtmlConentByUrl(code);

        String[] tempSplit = remoteDate.split("=");

        if (tempSplit.length == 2) {
            String[] newData = tempSplit[1].split(",");
            gpName = newData[0].replaceAll("\"", "").trim();
        } else {
            gpName = "";

        }

        return gpName;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return sharesDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SharesInfo record) {
        // TODO Auto-generated method stub
        return sharesDao.insertSelective(record);
    }

    @Override
    public SharesInfo selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return sharesDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SharesInfo record) {
        // TODO Auto-generated method stub
        return sharesDao.updateByPrimaryKeySelective(record);
    }

}
