<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
	<title>新建股票</title>
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
 
  <form name="myForm" method="post" action="add">  
        <table border="1" width="500" >  
        <tr>  
           <td>股票代码：   </td>  
           <td><input class="form_input" name="code" type="text" /></td>         
        </tr>  
         <tr>  
           <td>客户姓名：  </td>  
           <td><input class="form_input" name="customer" type="text"/></td>  
        </tr> 
        <tr>  
           <td>客户经理：  </td>  
           <td><input class="form_input" name="manager" type="text"/></td>  
        </tr>
        <tr>  
           <td>成本价：   </td>  
           <td><input class="form_input" name="costprice" type="text" /></td>  
        </tr> 
        <tr>  
           <td>金额：   </td>  
           <td><input class="form_input" name="money" type="text" /></td>  
        </tr> 
         
        
         <tr>  
           <td>电话：  </td>  
           <td><input class="form_input" name="phone" type="text"/></td>  
        </tr>
         
         <tr>  
           <td>备注：  </td>  
           <td><textarea class="form_texttarea" name="comment">
				
				</textarea>
		  </td>  
        </tr>
        <tr>  
          
            <td colspan="2"><input class="form_input" type="submit" value="保存"/></td>  
        </tr>  
        </table>  
    </form>  
    
     <a href="${pageContext.request.contextPath}/gp/showAll">股票列表</a>
   </div>
    
  </center>
</html>
