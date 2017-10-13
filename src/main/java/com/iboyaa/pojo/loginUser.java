package com.iboyaa.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class loginUser {
    private Integer id;

    private String loginname;

    private String username;

    private String password;

    private Integer author;

    private Integer state;

    private String common;
    @JSONField(format = "yyyy-MM-dd")
    private Date createtime;
    @JSONField(format = "yyyy-MM-dd")
    private Date updatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public loginUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public loginUser(String loginname, String username, String password, Integer author,
            String common) {
        super();
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.author = author;
        this.common = common;
        this.updatetime = new Date();
        this.createtime = new Date();
    }


}
