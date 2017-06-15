<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>股票列表</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	 
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body>
	
 	<div class="easyui-tabs" data-options="tabWidth:120" style="width:100%">
		<div title="持仓" style="padding:10px">
			<table class="easyui-datagrid"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=1',
			method:'get',
			toolbar:'#tb',
			multiSort:true"
			pagination="true">
			
			<div id="tbct" style="padding:5px;height:auto">
				<div style="margin-bottom:10px">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除"></a>
				
			 
				<span style="margin-left:40px;">开始时间:</span> <input class="easyui-datebox" style="width:100px">
				<span style="margin-left:10px;">结束时间:</span> <input class="easyui-datebox" style="width:100px">
				<span style="margin-left:10px;">客户名称:</span>
				<select class="easyui-combobox" panelHeight="auto" style="width:100px,">
					<option value="java">张三三三</option>
					<option value="c">C</option>
					<option value="basic">Basic</option>
					<option value="perl">Perl</option>
					<option value="python">Python</option>
				</select>
				<span style="margin-left:10px;">所属经理:</span>
				<select class="easyui-combobox" panelHeight="auto" style="width:100px,">
					<option value="java">张三三三</option>
					<option value="c">C</option>
					<option value="basic">Basic</option>
					<option value="perl">Perl</option>
					<option value="python">Python</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;">搜索一下</a>
				 
			   </div>
			</div>
			
			<thead>
				<tr>
				    <th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'createtime',width:140,align:'center',sortable:true">建仓日期</th>
					<th data-options="field:'code',width:90,align:'center'">股票代码</th>
					<th data-options="field:'name',width:90,align:'center'">股票名称</th>
					<th data-options="field:'num',width:60,align:'center'">股票数量</th>
					<th data-options="field:'costprice',width:60,align:'center'">成本价</th>
					<th data-options="field:'money',width:60,align:'center'">金额</th>
					<th data-options="field:'currentprice',width:60,align:'center'">现价</th>
					
					<th data-options="field:'zsprice',width:60,align:'center'">止损价</th>
					<th data-options="field:'daypercent',width:90,align:'center', formatter:formatPrice ,sortable:true">当日盈亏率</th>	
					<th data-options="field:'percent',width:90,align:'center', formatter:formatPrice,sortable:true">总盈亏率</th>	
					<th data-options="field:'ccstate',width:60,align:'center'">持仓状况</th>	
					
					<th data-options="field:'customer',width:70,align:'center'">客户姓名</th>
					<th data-options="field:'phone',width:100,align:'center'">客户电话</th>
					<th data-options="field:'manager',width:70,align:'center'">所属经理</th>
					<th data-options="field:'comment',width:300,align:'center'">备注</th>
				 
				</tr>
				
			</thead>
		 
		       </table>
	
		</div>
		
		
		
		<div title="止盈" style="padding:10px">
			 
			 
			 <table class="easyui-datagrid"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=2',
			method:'get',
			toolbar:'#tb',
			multiSort:true"
			pagination="true">
			
			<div id="tbzy" style="padding:5px;height:auto">
			<div style="margin-bottom:10px">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除"></a>
				
			 
				<span style="margin-left:40px;">开始时间:</span> <input class="easyui-datebox" style="width:100px">
				<span style="margin-left:10px;">结束时间:</span> <input class="easyui-datebox" style="width:100px">
				<span style="margin-left:10px;">客户名称:</span>
				<select class="easyui-combobox" panelHeight="auto" style="width:100px,">
					<option value="java">张三三三</option>
					<option value="c">C</option>
					<option value="basic">Basic</option>
					<option value="perl">Perl</option>
					<option value="python">Python</option>
				</select>
				<span style="margin-left:10px;">所属经理:</span>
				<select class="easyui-combobox" panelHeight="auto" style="width:100px,">
					<option value="java">张三三三</option>
					<option value="c">C</option>
					<option value="basic">Basic</option>
					<option value="perl">Perl</option>
					<option value="python">Python</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;">搜索一下</a>
				 
			   </div>
		    </div> 
			
			<thead>
				<tr>
				    <th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'createtime',width:140,align:'center',sortable:true">建仓日期</th>
					<th data-options="field:'code',width:90,align:'center'">股票代码</th>
					<th data-options="field:'name',width:90,align:'center'">股票名称</th>
					<th data-options="field:'num',width:60,align:'center'">股票数量</th>
					<th data-options="field:'costprice',width:60,align:'center'">成本价</th>
					<th data-options="field:'money',width:60,align:'center'">金额</th>
					<th data-options="field:'currentprice',width:60,align:'center'">现价</th>
					
					<th data-options="field:'zsprice',width:60,align:'center'">止损价</th>
					<th data-options="field:'daypercent',width:90,align:'center', formatter:formatPrice ,sortable:true">当日盈亏率</th>	
					<th data-options="field:'percent',width:90,align:'center', formatter:formatPrice,sortable:true">总盈亏率</th>	
					<th data-options="field:'ccstate',width:60,align:'center'">持仓状况</th>	
					
					<th data-options="field:'customer',width:70,align:'center'">客户姓名</th>
					<th data-options="field:'phone',width:100,align:'center'">客户电话</th>
					<th data-options="field:'manager',width:70,align:'center'">所属经理</th>
					<th data-options="field:'comment',width:300,align:'center'">备注</th>
				 
				</tr>
				
			</thead>
		 
	       </table>
		       
		</div>
		<div title="止损" style="padding:10px">
			
			 <table class="easyui-datagrid"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=3',
			method:'get',
			toolbar:'#tb',
			multiSort:true "
			pagination="true" >
			
			<div id="tbzs" style="padding:5px;height:auto">
				<div style="margin-bottom:10px">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除"></a>
				
			 
				<span style="margin-left:40px;">开始时间:</span> <input class="easyui-datebox" style="width:100px">
				<span style="margin-left:10px;">结束时间:</span> <input class="easyui-datebox" style="width:100px">
				<span style="margin-left:10px;">客户名称:</span>
				<select class="easyui-combobox" panelHeight="auto" style="width:100px,">
					<option value="java">张三三三</option>
					<option value="c">C</option>
					<option value="basic">Basic</option>
					<option value="perl">Perl</option>
					<option value="python">Python</option>
				</select>
				<span style="margin-left:10px;">所属经理:</span>
				<select class="easyui-combobox" panelHeight="auto" style="width:100px,">
					<option value="java">张三三三</option>
					<option value="c">C</option>
					<option value="basic">Basic</option>
					<option value="perl">Perl</option>
					<option value="python">Python</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;">搜索一下</a>
				 
			   </div>
		    </div> 
		<thead>
			<tr>
			    <th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'createtime',width:140,align:'center',sortable:true">建仓日期</th>
				<th data-options="field:'code',width:90,align:'center'">股票代码</th>
				<th data-options="field:'name',width:90,align:'center'">股票名称</th>
				<th data-options="field:'num',width:60,align:'center'">股票数量</th>
				<th data-options="field:'costprice',width:60,align:'center'">成本价</th>
				<th data-options="field:'money',width:60,align:'center'">金额</th>
				<th data-options="field:'currentprice',width:60,align:'center'">现价</th>
				
				<th data-options="field:'zsprice',width:60,align:'center'">止损价</th>
				<th data-options="field:'daypercent',width:90,align:'center', formatter:formatPrice ,sortable:true">当日盈亏率</th>	
				<th data-options="field:'percent',width:90,align:'center', formatter:formatPrice,sortable:true">总盈亏率</th>	
				<th data-options="field:'ccstate',width:60,align:'center'">持仓状况</th>	
				
				<th data-options="field:'customer',width:70,align:'center'">客户姓名</th>
				<th data-options="field:'phone',width:100,align:'center'">客户电话</th>
				<th data-options="field:'manager',width:70,align:'center'">所属经理</th>
				<th data-options="field:'comment',width:300,align:'center'">备注</th>
			 
			</tr>
			
		</thead>
		 
	       </table>
				
			
		</div>
		 
	</div>
	
</body>
</html>
<script>
		function formatPrice(val,row){
			if (val > 0){
				return '<span style="color:red;">'+val+'</span>';
			} else {
				return val;
			}
		}
	</script>
