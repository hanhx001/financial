package com.iboyaa.pojo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class GPinfo {
    private Integer id;

    private String name;

    private String code;

    private Double money;

    private Double costprice;

    private Double currentprice;

    private Double percent;

    private String manager;

    private String customer;

    private String phone;

    private String comment;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date createtime;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")  
    private Date updatetime;
    
    
    private String num;//股票数量
    private Double sum;//股票总价
    private Double daypercent;//当日盈亏比率
    private String ccstate;//持仓状况 1持仓；2止盈；3止损
    private String zsprice;//止损价
    private String beginTime;//结束时间
    private String endTime;//结束时间
    
    
    
    public GPinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	 


	@Override
	public String toString() {
		return "GPinfo [id=" + id + ", name=" + name + ", code=" + code + ", money=" + money + ", costprice="
				+ costprice + ", currentprice=" + currentprice + ", percent=" + percent + ", manager=" + manager
				+ ", customer=" + customer + ", phone=" + phone + ", comment=" + comment + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", num=" + num + ", sum=" + sum + ", daypercent=" + daypercent
				+ ", ccstate=" + ccstate + ", zsprice=" + zsprice + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ "]";
	}





	public GPinfo(Integer id, String name, String code, Double money, Double costprice, Double currentprice,
			Double percent, String manager, String customer, String phone, String comment, Date createtime,
			Date updatetime, String num, Double sum, Double daypercent, String ccstate, String zsprice,
			String beginTime, String endTime) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.money = money;
		this.costprice = costprice;
		this.currentprice = currentprice;
		this.percent = percent;
		this.manager = manager;
		this.customer = customer;
		this.phone = phone;
		this.comment = comment;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.num = num;
		this.sum = sum;
		this.daypercent = daypercent;
		this.ccstate = ccstate;
		this.zsprice = zsprice;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}





	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}



	public String getZsprice() {
		return zsprice;
	}



	public void setZsprice(String zsprice) {
		this.zsprice = zsprice;
	}



	public String getCcstate() {
		return ccstate;
	}

	public void setCcstate(String ccstate) {
		this.ccstate = ccstate;
	}

	public Double getDaypercent() {
		return daypercent;
	}

	public void setDaypercent(Double daypercent) {
		this.daypercent = daypercent;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public Double getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(Double currentprice) {
        this.currentprice = currentprice;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
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
}