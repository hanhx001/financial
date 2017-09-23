package com.iboyaa.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户信息实体类
 * @author 清水贤人
 *
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 8481425695407147844L;

    private Integer id;//客户ID

    private String customer;//客户名称

    private String manager; //经理名称

    private String phone;//电话

    private Date createtime;//开始时间

    private Date updatetime;//更新时间

    private String comment;//黑名单备注

    private Byte state; //人员状态

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

    //新建黑名单构造函数
    public UserInfo(String customer, String manager, String phone, String comment, Byte state) {
        super();
        this.customer = customer;
        this.manager = manager;
        this.phone = phone;
        this.comment = comment;
        this.state = state;
        this.createtime = new Date();
        this.updatetime = new Date();
    }
    // 新建股票时，新建客户构造函数
    public UserInfo(String customer, String manager, String phone ) {
        super();
        this.customer = customer;
        this.manager = manager;
        this.phone = phone;
        this.createtime = new Date();
        this.updatetime = new Date();
    }



}
