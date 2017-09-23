/**
 * 
 */
package com.iboyaa.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 股票基本信息实体
 * @author 清水贤人
 *
 */
public class SharesInfo implements Serializable {

    private static final long serialVersionUID = -1737236271975001200L;

    private Integer id;

    private String code;//股票代码

    private String num;//股票数量

    private String customer;//客户姓名

    private String manager;//客户经理

    private String costPrice;//成本价

    private String phone;//电话

    private String comment;//备注信息



    // 以下为程序自动计算得出，非用户输入

    private String sharseName;//股票名称

    private Double totalPrice;//股票总价

    private String unitPrice;//股票单价

    private String stopLossPrice;//止损价

    private String position; //持仓状况

    private String currentPrice;//现价
    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;//创建时间

    private Date updatetime;//更新时间

    private String daypercent;
    private String percent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSharseName() {
        return sharseName;
    }

    public void setSharseName(String sharseName) {
        this.sharseName = sharseName;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStopLossPrice() {
        return stopLossPrice;
    }

    public void setStopLossPrice(String stopLossPrice) {
        this.stopLossPrice = stopLossPrice;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getDaypercent() {
        return daypercent;
    }

    public void setDaypercent(String daypercent) {
        this.daypercent = daypercent;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }


    //新建股票构造函数
    public SharesInfo(String code, String num, String customer, String manager, String costPrice,
            String phone, String comment, String position) {
        super();
        this.code = code;
        this.num = num;
        this.customer = customer;
        this.manager = manager;
        this.costPrice = costPrice;
        this.phone = phone;
        this.comment = comment;
        this.position = position;
        this.createtime = new Date();
        this.updatetime = new Date();

    }

    public SharesInfo() {
        super();
        // TODO Auto-generated constructor stub
    }



}
