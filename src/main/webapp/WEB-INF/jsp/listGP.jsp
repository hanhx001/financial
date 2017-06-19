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
	 
 	<div class="easyui-tabs" data-options="tabWidth:120" style="width:100% ;">
		<div title="持仓" style="padding:10px;display:none">
			<table   class="easyui-datagrid dg"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=1',
			method:'get',
			toolbar:'#tb', 
			multiSort:true"
			pagination="true" >
			
			<div id="tbct" style="padding:5px;height:auto;">
				<div style="margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改" onclick="getSelected()"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除" onclick="toDelete()"></a>
					<span style="margin-left:40px;">开始时间:</span> <input class="easyui-datebox" style="width:100px">
					<span style="margin-left:10px;">结束时间:</span> <input class="easyui-datebox" style="width:100px">
					<span style="margin-left:10px;">所属经理:</span>
					<select class="easyui-combobox" panelHeight="auto" >
						<option value="java">张三三</option>
						<option value="c">C</option>
						<option value="basic">Basic</option>
						<option value="perl">Perl</option>
						<option value="python">Python</option>
					</select>
					<span style="margin-left:10px;">股票代码:</span>
					<input class="ttgpdm" style="width:100px" data-options="prompt: '例如：sh…' ">
					<span style="margin-left:10px;">客户名称:</span>
					<input class="ttgpdm" style="width:100px"/>
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;">搜索一下</a>
						 
			   </div>
			</div>
			
			<thead >
				<tr>
				    <th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'createtime',width:140,align:'center',sortable:true">建仓日期</th>
					<th data-options="field:'code',width:90,align:'center'">股票代码</th>
					<th data-options="field:'name',width:90,align:'center'">股票名称</th>
					<th data-options="field:'num',width:60,align:'center'">股票数量</th>
					<th data-options="field:'costprice',width:60,align:'center'">成本价</th>
					<th data-options="field:'money',width:60,align:'center'">金额</th>
					<th data-options="field:'currentprice',width:60,align:'center'">现价</th>
					
					<th data-options="field:'zsprice',width:60,align:'center' ">止损价</th>
					<th data-options="field:'daypercent',width:90,align:'center', formatter:formatPrice ,sortable:true">当日盈亏率</th>	
					<th data-options="field:'percent',width:90,align:'center', formatter:formatPrice,sortable:true">总盈亏率</th>	
					<th data-options="field:'ccstate',width:60,align:'center',formatter:formatChines ">持仓状况</th>	
					
					<th data-options="field:'customer',width:70,align:'center'">客户姓名</th>
					<th data-options="field:'phone',width:100,align:'center'">客户电话</th>
					<th data-options="field:'manager',width:70,align:'center'">所属经理</th>
					<th data-options="field:'comment',width:300,align:'center'">备注</th>
				 
				</tr>
				
			</thead>
		 
		       </table>
	
		</div>
		
		
		
		<div title="止盈" style="padding:10px;display:none">
			 
			 
			<table class="easyui-datagrid dg"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=2',
			method:'get',
			toolbar:'#tb',
			multiSort:true"
			pagination="true" >
			
			<div id="tbzy" style="padding:5px;height:auto">
			<div style="margin-bottom:10px">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除"></a>
					<span style="margin-left:40px;">开始时间:</span> <input class="easyui-datebox" style="width:100px">
					<span style="margin-left:10px;">结束时间:</span> <input class="easyui-datebox" style="width:100px">
					<span style="margin-left:10px;">所属经理:</span>
					<select class="easyui-combobox" panelHeight="auto" >
						<option value="java">张三三</option>
						<option value="c">C</option>
						<option value="basic">Basic</option>
						<option value="perl">Perl</option>
						<option value="python">Python</option>
					</select>
					<span style="margin-left:10px;">股票代码:</span>
					<input class="ttgpdm" style="width:100px" data-options="prompt: '例如：sh…' ">
					<span style="margin-left:10px;">客户名称:</span>
					<input class="ttgpdm" style="width:100px"/>
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;">搜索一下</a>
					 
			   </div>
		    </div> 
			
			<thead >
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
					<th data-options="field:'ccstate',width:60,align:'center',formatter:formatChines">持仓状况</th>	
					
					<th data-options="field:'customer',width:70,align:'center'">客户姓名</th>
					<th data-options="field:'phone',width:100,align:'center'">客户电话</th>
					<th data-options="field:'manager',width:70,align:'center'">所属经理</th>
					<th data-options="field:'comment',width:300,align:'center'">备注</th>
				 
				</tr>
				
			</thead>
		 
	       </table>
		       
		</div>
		<div title="止损" style="padding:10px;display:none">
			
			<table class="easyui-datagrid dg"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=3',
			method:'get',
			toolbar:'#tb',
			multiSort:true "
			pagination="true">
			
			<div id="tbzs" style="padding:5px;height:auto">
				<div style="margin-bottom:10px">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除"></a>
					<span style="margin-left:40px;">开始时间:</span> <input class="easyui-datebox" style="width:100px">
					<span style="margin-left:10px;">结束时间:</span> <input class="easyui-datebox" style="width:100px">
					<span style="margin-left:10px;">所属经理:</span>
					<select class="easyui-combobox" panelHeight="auto" >
						<option value="java">张三三</option>
						<option value="c">C</option>
						<option value="basic">Basic</option>
						<option value="perl">Perl</option>
						<option value="python">Python</option>
					</select>
					<span style="margin-left:10px;">股票代码:</span>
					<input class="ttgpdm" style="width:100px" data-options="prompt: '例如：sh…' ">
					<span style="margin-left:10px;">客户名称:</span>
					<input class="ttgpdm" style="width:100px"/>
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;">搜索一下</a>
					 
			   </div>
		    </div> 
		<thead >
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
				<th data-options="field:'ccstate',width:60,align:'center',formatter:formatChines">持仓状况</th>	
				
				<th data-options="field:'customer',width:70,align:'center'">客户姓名</th>
				<th data-options="field:'phone',width:100,align:'center'">客户电话</th>
				<th data-options="field:'manager',width:70,align:'center'">所属经理</th>
				<th data-options="field:'comment',width:300,align:'center'">备注</th>
			</tr>
		</thead>
	       </table>
		</div>
	</div>
	<!-- 编辑股票信息的隐藏div -->
	 <div id="win" class="easyui-window" title="编辑股票信息"  
	   style="width:350px;height:430px;padding:5px;display:none" closed="true";>  
    	<form id="ffupdate" name="myForm" class="easyui-form" method="post" action="addgp">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>股票名称：</td>
	    			<td><input  class="easyui-textbox"  name="name" style="width:160px"  readonly="true"></td>
	    		</tr>
	    		<tr>
	    			<td>股票数量：</td>
	    			<td><input class="easyui-textbox" name="num" style="width:160px" type="text"  ></input></td>
	    		</tr>
	    		<tr>
	    			<td>客户姓名：</td>
	    			<td><input class="easyui-textbox" style="width:160px" type="text" name="customer" ></input></td>
	    		</tr>
	    		<tr>
	    			<td>客户经理：</td>
	    			<td><input class="easyui-textbox" style="width:160px"  type="text" name="manager" ></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>成本价：</td>
	    			<td><input class="easyui-textbox" style="width:160px" type="text" name="costprice"  ></input></td>
	    		</tr>
	    		 <tr>
	    			<td  style="color:Brown;">止损价：</td>
	    			<td><input class="easyui-textbox" style="width:160px"  type="text" name="zsprice"  ></input></td>
	    		</tr> 
	    		 <tr>
	    		 <td  style="color:Brown;">持仓状况：</td>
	    			<td>
	    			<select class="easyui-combobox"  name="ccstate">
						<option value="1">持仓</option>
						<option value="2">止盈</option>
						<option value="3">止损</option>
					</select>
					</td>	
				</tr> 
	    		<tr>
	    			<td>电话：</td>
	    			<td><input class="easyui-textbox" style="width:160px" type="text" name="phone"  ></input></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>备注：  </td>
	    			<td><input class="easyui-textbox" style="width:160px" name="comment"   style="height:60px"></input></td>
	    		</tr>
	    		 <input type="hidden" name="id"></input>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">保存</a>
	    </div>
    </div>   
    
</div>
</body>
</html>
<script>
		$.extend($.fn.textbox.methods, {
		    addClearBtn: function (jq, iconCls) {
		
		        var opts = jq.textbox('options');
		        opts.icons = opts.icons || [];
		
		        opts.icons.unshift({
		            iconCls: iconCls,
		            handler: function (e) {
		                $(e.data.target).textbox('clear').textbox('textbox').focus();
		                $(this).css('visibility', 'hidden');
		            }
		        });
		        return jq.each(function () {
		            var t = $(this);
		            t.textbox();
		            if (!t.textbox('getText')) {
		                t.textbox('getIcon', 0).css('visibility', 'hidden');
		            }
		            t.textbox('textbox').bind('keyup', function () {
		                var icon = t.textbox('getIcon', 0);
		                if ($(this).val()) {
		                    icon.css('visibility', 'visible');
		                } else {
		                    icon.css('visibility', 'hidden');
		                }
		            });
		        });
		    } 
		});
		
		$(function(){
			$('.ttgpdm').textbox().textbox('addClearBtn', 'icon-clear');
		});

		function formatPrice(val,row){
			if (val > 0){
				return '<span style="color:red;">'+val+'</span>';
			} else {
				return val;
			}
		}
		
		function formatChines(val,row){
			if (val == 1){
				return '持仓';
			} else if (val == 2){
				return '止盈';
			}else if(val == 3){
				return '止损';
			}
		}
		//  编辑股票信息
		function getSelected(){
			var row = $('.dg').datagrid('getSelected');
			 
			$.ajax({
				url: "${pageContext.request.contextPath}/gp/update",
				type: "POST",
				data: {"id":row.id},
				dataType:"json",
				success: function (returnValue)
				{
					var datasource = { total:returnValue.total ,rows: returnValue.rows };
					$('#win').window('open');  
					$("#ffupdate").form('load',returnValue);
					
					$('#dg').datagrid('reload');
				}
			})
		}
		
		function submitForm(){
			$('#ffupdate').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
				success:function(){
					//window.location.href="${pageContext.request.contextPath}/gp/showAll";
				}
			});
		}
		
		function toDelete(){
			var row = $('.dg').datagrid('getSelected');
			alert(row);
			$.ajax({
				url: "${pageContext.request.contextPath}/gp/delete",
				type: "POST",
				data: {"id":row.id},
				dataType:"json",
				success: function ()
				{
					window.location.href="${pageContext.request.contextPath}/gp/showAll";
				}
			})
			
		}
		
	</script>
