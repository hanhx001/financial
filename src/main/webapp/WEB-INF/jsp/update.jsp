<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
	<title>更新股票</title>
	<style>
		*{margin:0; padding:0;}
		table{
			 border-collapse:collapse
		}
		.form_input{
			width:100%;
			height:35px;
			border:none;
		}
		.form_texttarea{
			resize: none;
			width:100%;
			height:100%;
			border:none;
		}
	</style>
  </head>
  
  <body>
  <center>
 
  <form name="myForm" method="post" action="update">  
   
        <table border="1" width="500" >  
        
        <input type="hidden" name="id" value="${data.id}" />
        <tr>  
           <td>股票代码：   </td>  
           <td><input class="form_input" name="code" type="text" value="${data.code}" /></td>         
        </tr>  
         <tr>  
           <td>客户姓名：  </td>  
           <td><input class="form_input" name="customer" type="text"  value="${data.customer}" /></td>  
        </tr> 
        <tr>  
           <td>客户经理：  </td>  
           <td><input class="form_input" name="manager" type="text" value="${data.manager}" /></td>  
        </tr>
        <tr>  
           <td>成本价：   </td>  
           <td><input class="form_input" name="costprice" type="text" value="${data.costprice}" /></td>  
        </tr> 
        <tr>  
           <td>金额：   </td>  
           <td><input class="form_input" name="money" type="text" value="${data.money}" /></td>  
        </tr> 
         
        
         <tr>  
           <td>电话：  </td>  
           <td><input class="form_input" name="phone" type="text" value="${data.phone}" /></td>  
        </tr>
         
         <tr>  
           <td>备注：  </td>  
           <td><textarea class="form_texttarea" name="comment"  >
				${data.comment}
				</textarea>
		  </td>  
        </tr>
        <tr>  
          
            <td colspan="2"><input class="form_input" type="submit" value="更新"/></td>  
        </tr>  
        </table>  
         
    </form>  
    
     <a href="${pageContext.request.contextPath}/gp/showAll">股票列表</a>
   </div>
    
  </center>
</html>
