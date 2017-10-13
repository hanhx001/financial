/**
 * 
 */
package com.iboyaa.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iboyaa.pojo.SharesInfo;
import com.iboyaa.service.ISharesService;
import com.iboyaa.util.DoubleWith2Point;
import com.iboyaa.util.StringIsNull;

/**
 * 定时任务
 * @author 清水贤人
 *
 */
@Component
public class ScheduledTask {

    @Resource
    private ISharesService sharesService;

    @Scheduled(cron = "0/5 * *  * * ? ")
    public void updateSinaData() {

        List<SharesInfo> data = (List<SharesInfo>) sharesService.getAllpreData("1");
        if (data.size() > 0) {

            for (SharesInfo temp : data) {


                String remoteDate = getHtmlConentByUrl(temp.getCode());
                String[] tempSplit = remoteDate.split("=");

                if (tempSplit[1].length() > 3) {
                    // 证明股票代码正确，有股票信息返回

                    String[] newData = tempSplit[1].split(",");

                    String openPrice = newData[1].toString();
                    double closePrice =
                            Double.parseDouble(StringIsNull.isNULL(newData[2].toString()) ? "0"
                                    : newData[2].toString());
                    double currentPrice =
                            Double.parseDouble(StringIsNull.isNULL(newData[3].toString()) ? "0"
                                    : newData[3].toString());

                    temp.setCurrentPrice(currentPrice + "");
                    temp.setPercent(DoubleWith2Point
                            .noForFive((currentPrice - Double.parseDouble(temp.getCostPrice()))
                                    / Double.parseDouble(temp.getCostPrice()) * 100));


                    temp.setDaypercent(DoubleWith2Point.noForFive(currentPrice - closePrice)
                            / closePrice * 100);// 当日盈亏比率
                    sharesService.updateByPrimaryKeySelective(temp);

                }
            }

        }
    }


    // 调取新浪股票数据
    public String getHtmlConentByUrl(String gpCode) {
        try {
            URL url = new URL("http://hq.sinajs.cn/list=" + gpCode);
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
}
