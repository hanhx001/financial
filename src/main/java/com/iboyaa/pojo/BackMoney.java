package com.iboyaa.pojo;

import java.util.Date;

public class BackMoney {
    private Integer id;

    private String code;

    private String sharseName;

    private String customId;

    private String customer;

    private String manager;

    private String phone;

    private String sendtime;

    private String percent;

    private String sendoutprice;

    private String devidepoint;

    private String devidenum;

    private Double backmoney;

    private String backbank;

    private String common;

    private Date createtime;

    private String custompercent;

    private Date updatetime;

    private String state;
    
    private String updatetime2String;//更新时间字符串格式化
    
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
        this.code = code == null ? null : code.trim();
    }

    public String getSharseName() {
        return sharseName;
    }

    public void setSharseName(String sharseName) {
        this.sharseName = sharseName == null ? null : sharseName.trim();
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent == null ? null : percent.trim();
    }

    public String getSendoutprice() {
        return sendoutprice;
    }

    public void setSendoutprice(String sendoutprice) {
        this.sendoutprice = sendoutprice == null ? null : sendoutprice.trim();
    }

    public String getDevidepoint() {
        return devidepoint;
    }

    public void setDevidepoint(String devidepoint) {
        this.devidepoint = devidepoint == null ? null : devidepoint.trim();
    }

    public String getDevidenum() {
        return devidenum;
    }

    public void setDevidenum(String devidenum) {
        this.devidenum = devidenum;
    }
 

    public Double getBackmoney() {
        return backmoney;
    }

    public void setBackmoney(Double backmoney) {
        this.backmoney = backmoney;
    }

    public String getBackbank() {
        return backbank;
    }

    public void setBackbank(String backbank) {
        this.backbank = backbank == null ? null : backbank.trim();
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common == null ? null : common.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCustompercent() {
        return custompercent;
    }

    public void setCustompercent(String custompercent) {
        this.custompercent = custompercent == null ? null : custompercent.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
    
    public String getUpdatetime2String() {
        return updatetime2String;
    }

    public void setUpdatetime2String(String updatetime2String) {
        this.updatetime2String = updatetime2String;
    }

    // 保存回款信息 构造函数
    public BackMoney(String code, String sharseName, String customId, String customer,
            String manager, String phone, String sendtime, String percent, String sendoutprice,
            String devidepoint, String devidenum, Double backmoney, String backbank, String common,
            String custompercent) {
        super();
        this.code = code;
        this.sharseName = sharseName;
        this.customId = customId;
        this.customer = customer;
        this.manager = manager;
        this.phone = phone;
        this.sendtime = sendtime;
        this.percent = percent;
        this.sendoutprice = sendoutprice;
        this.devidepoint = devidepoint;
        this.devidenum = devidenum;
        this.backmoney = backmoney;
        this.backbank = backbank;
        this.common = common;
        this.custompercent = custompercent;
        this.updatetime =new Date();
        this.createtime= new Date();
    }

    public BackMoney() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
}