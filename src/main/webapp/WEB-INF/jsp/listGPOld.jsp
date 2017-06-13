<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
	<title>股票列表</title>
	<style type="text/css">  
    tr.foreach_tr1{background-color:#D7E9FD;color:black;}  
    tr.foreach_tr2{background-color:#A7DBFF; color:black ;}  
    </style>
   
  </head>
  
  <body>
  <a href="${pageContext.request.contextPath}/gp/addUi">新建股票</a>
   <table border="1" width="100%" cellpadding="0" cellspacing="0">  
        <tr align="center"  class="first_tr">  
            <td style="font-size:15px;">日期</td> 
            <td style="font-size:15px;">股票代码</td> 
            <td style="font-size:15px;">股票名称</td>   
            <td style="font-size:15px;">金额</td>
            <td style="font-size:15px;">成本价</td>
            <td style="font-size:15px;">盈亏比例 </td> 
            <td style="font-size:15px;">现价</td>
            <td style="font-size:15px;">客户姓名</td>
            <td style="font-size:15px;">电话</td>
            <td style="font-size:15px;">经理</td>
            <td style="font-size:15px;">备注</td> 
            <td colspan="2" style="font-size:15px;">操作</td>  
              
        </tr>  
        <c:forEach items="${data}" varStatus="i" var="item" >  
         
           <td width="7%" style="font-size:12px;"><fmt:formatDate value="${item.createtime}" pattern="MM-dd"/> </td>
           
           <td style="font-size:12px;">${item.code}</td>
          
           <td style="font-size:12px;">${item.name}</td>
           
           <td style="font-size:12px;">${item.money}</td>
           
          
            
           <td style="font-size:12px;"> ${item.costprice} </td>
            <td ${item.percent >0 ? "bgColor=#FF0000":"bgColor=#00EE00"}" style="font-size:12px;">
             
            ${item.percent}%
             
            
            </td>
           
           <td style="font-size:12px;"> ${item.currentprice} </td>
           <td style="font-size:12px;">${item.customer}</td>
           <td style="font-size:12px;">${item.phone}</td>
           <td style="font-size:12px;">${item.manager}</td>
           <td style="font-size:12px;">${item.comment}</td>
           
           <td style="font-size:12px;"><a href="${pageContext.request.contextPath}/gp/updateUi?id=${item.id}">编辑</a></td>
           <td style="font-size:12px;"><a href="${pageContext.request.contextPath}/gp/delete?id=${item.id}">删除</a></td>
            
            
           
           
            
             
        </tr>  
        </c:forEach>  
    </table>  
  </body>
</html>
