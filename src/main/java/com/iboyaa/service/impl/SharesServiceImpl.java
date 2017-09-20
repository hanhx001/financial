/**
 * 
 */
package com.iboyaa.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.iboyaa.dao.ISharesDao;
import com.iboyaa.pojo.SharesInfo;
import com.iboyaa.service.ISharesService;
import com.iboyaa.util.StringIsNull;

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
        return sharesDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SharesInfo record) {
        return sharesDao.insertSelective(record);
    }

    @Override
    public SharesInfo selectByPrimaryKey(Integer id) {
        return sharesDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SharesInfo record) {
        return sharesDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SharesInfo> getSharesDataByCondition(String startDate, String endDate,
            String keyWord, String flag, String sort) {

        DateTime nowTime = new DateTime();

        //如果时间都为空，则查询当天的数据
        if (StringIsNull.isNULL(startDate) && StringIsNull.isNULL(endDate)) {
            startDate = nowTime.toString("yyyy-MM-dd");
            endDate = nowTime.toString("yyyy-MM-dd");
        }

        return sharesDao.getSharesDataByCondition(startDate, endDate, keyWord, flag, sort);
    }

}
