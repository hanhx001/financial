<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>录入股票基本信息</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	 
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
	 
</head>
<body>
<center>
	 <div style="margin:100px 5px 15px 20px;">
	<div class="easyui-panel" title="录入股票基本信息" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" name="myForm" class="easyui-form" method="post" data-options="novalidate:true" action="addgp">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>股票代码：</td>
	    			<td><input id="tt" name="code" style="width:160px" data-options="prompt: '来，写下你的代码!',icons:[{iconCls:'icon-search',
				        handler: function(e){
					    var v = $(e.data.target).textbox('getValue');
					    ajaxLook(v);
					     }}],
					    required:true,validType:'minLength[8]'">
					    </td>
	    		   </tr>
	    		<tr>
	    			<td>股票数量：</td>
	    			<td><input class="easyui-textbox" type="text" name="num" data-options="required:true,validType:'numberCheckSub'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>客户姓名：</td>
	    			<td><input class="easyui-textbox" type="text" name="customer" data-options="required:true "></input></td>
	    		</tr>
	    		<tr>
	    			<td>客户经理：</td>
	    			<td><input class="easyui-textbox" type="text" name="manager" data-options="required:true"></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>成本价：</td>
	    			<td><input class="easyui-textbox" type="text" name="costprice" data-options="required:true,validType:'numberCheckSub'"></input></td>
	    		</tr>
	    		<!--  
	    		<tr>
	    			<td>金额：</td>
	    			<td><input class="easyui-textbox" type="text" name="money" data-options="required:true,validType:'numberCheckSub'"></input></td>
	    		</tr>-->
	    		<tr>
	    			<td>电话：</td>
	    			<td><input class="easyui-textbox" type="text" name="phone" data-options="required:true,validType:'mobile'"></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>备注：  </td>
	    			<td><input class="easyui-textbox" name="comment" data-options="multiline:true" style="height:60px"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清除</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    </div>
	    </div>
	</div>
	</div>
	</center>
	<script>
	
	function centerRight(data){
		$.messager.show({
			title:'Hi! 猜猜是啥',
			msg:data,
			showType:'fade',
			style:{
				left:'',
				right:0,
				bottom:''
			}
		});
	}
	function ajaxLook(v){
		$.ajax(
				{
					url: "${pageContext.request.contextPath}/gp/searchName", 
					scriptCharset: 'utf-8',
					type:"post",
				    data:{"code":v},
				    datatype:String,
					success: function(data)
					{
						centerRight(data)
					}
	        
	       });
		
	}
	$.extend($.fn.validatebox.defaults.rules, {
	    minLength: {
			validator: function(value, param){
				return value.length >= param[0];
			},
			message: '输入以字母开头数字结尾的最少8位字符'
	    },
	    // 验证中文
	    CHS : {
	     validator : function(value) {
	     return /^[\u0391-\uFFE5]+$/.test(value);},
	     message : "请输入汉字"
	    },
	    numberCheckSub : {
	        validator : function(value) {
	        return /^[0-9]+$/.test(value);},
	        message : "请输入数字"
	    },  
	    //移动手机号码验证  
	    mobile: {//value值为文本框中的值  
	        validator: function (value) {  
	            var reg = /^13[0-9]{9}$|14[0-9]{9}|17[0-9]{9}|15[0-9]{9}$|18[0-9]{9}$/;  
	            return reg.test(value);  
	        },  
	        message: '输入手机号码格式不准确.'  
	    }
	});
 
		function submitForm(){
			$('#ff').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
				success:function(){
					window.location.href="${pageContext.request.contextPath}/gp/showAll";
				}
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
		
		$.extend($.fn.textbox.methods, {
			addClearBtn: function(jq, iconCls){
				return jq.each(function(){
					var t = $(this);
					var opts = t.textbox('options');
					opts.icons = opts.icons || [];
					opts.icons.unshift({
						iconCls: iconCls,
						handler: function(e){
							$(e.data.target).textbox('clear').textbox('textbox').focus();
							$(this).css('visibility','hidden');
						}
					});
					t.textbox();
					if (!t.textbox('getText')){
						t.textbox('getIcon',0).css('visibility','hidden');
					}
					t.textbox('textbox').bind('keyup', function(){
						var icon = t.textbox('getIcon',0);
						if ($(this).val()){
							icon.css('visibility','visible');
						} else {
							icon.css('visibility','hidden');
						}
					});
				});
			}
		});
		
		$(function(){
			$('#tt').textbox().textbox('addClearBtn', 'icon-clear');
		});
	</script>
</body>
</html>