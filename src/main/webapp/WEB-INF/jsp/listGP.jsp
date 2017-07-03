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
	<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
	 
</head>
<body>
	 
 	<div class="easyui-tabs"   data-options="tabWidth:120" style="width:100% ;">
		<div title="持仓" style="padding:10px;display:none">
			<table  id="chicang" class="easyui-datagrid"  
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
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改" onclick="getSelected(1)"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除" onclick="toDelete(1)"></a>
					<span style="margin-left:40px;">开始时间:</span> <input id ="beginTimect" class="easyui-datebox  start2"   style="width:100px">
					<span style="margin-left:10px;">结束时间:</span> <input id="endTimect" class="easyui-datebox" validType="md['.start2']"  style="width:100px">
					<span style="margin-left:10px;">所属经理:</span>
					 
					<input id="managerBackct" class="easyui-combobox "  panelHeight="auto" 
					data-options=" 
					width:100,
					valueField: 'id', 
					textField: 'manager', 
					url: '../gp/backManager',
					method:'get'"></>
				 
					<span style="margin-left:10px;">股票代码:</span>
					<input id="gpcodect" class="ttgpdm" style="width:100px" data-options="prompt: '例如：sh…' ">
					<span style="margin-left:10px;">客户名称:</span>
					<input id="customnamect" class="ttgpdm " style="width:100px"/>
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;" onclick="beginSearch(1)">搜索一下</a>
						 
			   </div>
			</div>
			
			<thead >
				<tr>
				    <th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'createtime',width:76,align:'center',sortable:true">建仓日期</th>
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
					<th data-options="field:'comment',width:300,align:' '">备注</th>
				 
				</tr>
				
			</thead>
		 
		       </table>
	
		</div>
		
		   <div title="止盈" style="padding:10px;display:none">
			<table  id="zhiying" class="easyui-datagrid"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=2',
			method:'get',
			toolbar:'#tb', 
			multiSort:true" 
			pagination="true" >
			
			<div id="tbzy" style="padding:5px;height:auto;">
				<div style="margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改" onclick="getSelected(2)"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除" onclick="toDelete(2)"></a>
					<span style="margin-left:40px;">开始时间:</span> <input id="beginTimezy" class="easyui-datebox  start2"   style="width:100px">
					<span style="margin-left:10px;">结束时间:</span> <input id ="endTimezy" class="easyui-datebox" validType="md['.start2']"  style="width:100px">
					<span style="margin-left:10px;">所属经理:</span>
					 
					<input id="managerBackzy" class="easyui-combobox "  panelHeight="auto" 
					data-options=" 
					width:100,
					valueField: 'id', 
					textField: 'manager', 
					url: '../gp/backManager',
					method:'get'"></>
				 
					<span style="margin-left:10px;">股票代码:</span>
					<input id="gpcodezy" class="ttgpdm " style="width:100px" data-options="prompt: '例如：sh…' ">
					<span style="margin-left:10px;">客户名称:</span>
					<input id ="customnamezy" class="ttgpdm " style="width:100px"/>
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;" onclick="beginSearch(2)">搜索一下</a>
						 
			   </div>
			</div>
			
			<thead >
				<tr>
				    <th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'createtime',width:76,align:'center',sortable:true">建仓日期</th>
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
					<th data-options="field:'comment',width:300,align:' '">备注</th>
				 
				</tr>
				
			</thead>
		 
		    </table>
	
		</div>
		
		
	<div title="止损" style="padding:10px;display:none">
			<table  id="zhisun" class="easyui-datagrid"  
			data-options="rownumbers:true,
			singleSelect:true,
			url:'../gp/showJsonData?code=3',
			method:'get',
			toolbar:'#tb', 
			multiSort:true" 
			pagination="true" >
			
			<div id="tbzs" style="padding:5px;height:auto;">
				<div style="margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/gp/addUi" class="easyui-linkbutton" iconCls="icon-add" plain="true" title="添加"></a>
					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" title="修改" onclick="getSelected(3)"></a>
					<!--<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>-->
					 <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>-->
					<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" title="删除" onclick="toDelete(3)"></a>
					<span style="margin-left:40px;">开始时间:</span> <input id="beginTimezs" class="easyui-datebox  start2"   style="width:100px">
					<span style="margin-left:10px;">结束时间:</span> <input id="endTimezs" class="easyui-datebox " validType="md['.start2']"  style="width:100px">
					<span style="margin-left:10px;">所属经理:</span>
					 
					<input id="managerBackzs" class="easyui-combobox "  panelHeight="auto" 
					data-options=" 
					width:100,
					valueField: 'id', 
					textField: 'manager', 
					url: '../gp/backManager',
					method:'get'"></>
				 
					<span style="margin-left:10px;">股票代码:</span>
					<input id="gpcodezs" class="ttgpdm " style="width:100px" data-options="prompt: '例如：sh…' ">
					<span style="margin-left:10px;">客户名称:</span>
					<input id="customnamezs" class="ttgpdm " style="width:100px"/>
					<a href="#" class="easyui-linkbutton" iconCls="icon-search" style="margin-left:10px;" onclick="beginSearch(3)">搜索一下</a>
						 
			   </div>
			</div>
			
			<thead >
				<tr>
				    <th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'createtime',width:76,align:'center',sortable:true">建仓日期</th>
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
					<th data-options="field:'comment',width:300,align:' '">备注</th>
				 
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
    
    <!-- 模糊查询弹出框 -->
    <div region="center" border="false">  
        <table id="fuzzySearch"></table>  
      </div>
</div>
</body>
</html>
<script>

 // 页面验证需要的js begin
 
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
		
		
		$.extend($.fn.validatebox.defaults.rules, {//验证开始时间小于结束时间  
	         md: {  
	             validator: function(value, param){  
	              startTime2 = $(param[0]).datetimebox('getValue');   
	                 var d1 = $.fn.datebox.defaults.parser(startTime2);  
	                 var d2 = $.fn.datebox.defaults.parser(value);  
	                 varify=d2>d1;  
	                 return varify;  
	                
	             },  
	             message: '结束时间要大于开始时间！'  
	           
	         }  
	     })  
		
// 页面验证需要的js end	
		
		//  编辑股票信息
		function getSelected(tab){
			var row="";
			
			if("1" == tab){
				row = $('#chicang').datagrid('getSelected');
			}else if("2" == tab){
				row = $('#zhiying').datagrid('getSelected');
			}else if("3" == tab){
				row = $('#zhisun').datagrid('getSelected');
			}	
		 
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
				
					//$('.dg').datagrid('reload');
					 
				}
			})
		}
		// 提交表单
		function submitForm(){
			$('#ffupdate').form('submit',{
				onSubmit:function(){
					return $(this).form('enableValidation').form('validate');
				},
				success:function(){
					window.location.href="${pageContext.request.contextPath}/gp/showAll";
				}
				
			});
		}
		// 删除一条记录
		function toDelete(tab){
			
			var row="";
			
			if("1" == tab){
				row = $('#chicang').datagrid('getSelected');
			}else if("2" == tab){
				row = $('#zhiying').datagrid('getSelected');
			}else if("3" == tab){
				row = $('#zhisun').datagrid('getSelected');
			}	
			$.messager.confirm('提示', '你确定要删除这条记录么？', function(r){
				 
				if (r){
					$.ajax({
						url: "${pageContext.request.contextPath}/gp/delete",
						type: "POST",
						data: {"id":row.id},
						dataType:"json",
					 
						success:function(){
							 
							$('#chicang').datagrid('reload');
							$('#zhiying').datagrid('reload');
							$('#zhisun').datagrid('reload');
						}

					})
				}
			});
		}
		
		//页面内查找
		function beginSearch(tab){
			// 1代表 持仓的查询，2代表止盈 ，3代表止损
			 
			if("1" == tab){
				var beginTime=$("#beginTimect").datetimebox("getValue");
			    var endTime=$("#endTimect").datetimebox("getValue");
				var gpcode =$("#gpcodect").val();
				var customname =$("#customnamect").val();
				var manager = $('#managerBackct').combobox('getText');
	 	        var ccstate ="1"
	 	    	$.ajax({
					url: "${pageContext.request.contextPath}/gp/fuzzySearch",
					type: "POST",
					data: {"beginTime":beginTime,
						"endTime":endTime,
						"code":gpcode,
						"customer":customname,
						"manager":manager,
						"ccstate":ccstate
					},
					 
					dataType:"json",
				 
					success:function(data){
						var rows = [];
						for(var i=0; i<data.length; i++){
							rows.push({
								 createtime:data[i].createtime,
								 code:data[i].code,
								 name:data[i]. name,
								 num:data[i].num,
								 costprice: data[i].costprice,
								 money: data[i].money,
								 currentprice:data[i].currentprice,
								 zsprice:data[i].zsprice,
								 daypercent:data[i].daypercent,
								 percent:data[i].percent,
								 ccstate :data[i].ccstate,
							 	 customer :data[i].customer,
								 phone :data[i].phone,
								 manager :data[i].manager,
								 comment:data[i].comment,
							});
							 
						}
						$('#chicang').datagrid('loadData', rows);
					}

				})
				
	    	  	

			}else if("2" == tab){
				var beginTime=$("#beginTimezy").datetimebox("getValue");
			    var endTime=$("#endTimezy").datetimebox("getValue");
				var gpcode =$("#gpcodezy").val();
				var customname =$("#customnamezy").val();
				var manager = $('#managerBackzy').combobox('getText');
			    var ccstate ="2"
		 	    	$.ajax({
						url: "${pageContext.request.contextPath}/gp/fuzzySearch",
						type: "POST",
						data: {"beginTime":beginTime,
							"endTime":endTime,
							"code":gpcode,
							"customer":customname,
							"manager":manager,
							"ccstate":ccstate
						},
						 
						dataType:"json",
					 
						success:function(data){
							console.log(data);
							var rows = [];
							for(var i=0; i<data.length; i++){
								rows.push({
									 createtime:data[i].createtime,
									 code:data[i].code,
									 name:data[i]. name,
									 num:data[i].num,
									 costprice: data[i].costprice,
									 money: data[i].money,
									 currentprice:data[i].currentprice,
									 zsprice:data[i].zsprice,
									 daypercent:data[i].daypercent,
									 percent:data[i].percent,
									 ccstate :data[i].ccstate,
								 	 customer :data[i].customer,
									 phone :data[i].phone,
									 manager :data[i].manager,
									 comment:data[i].comment,
								});
							}
							 $('#zhiying').datagrid('loadData', rows);
							 
						}

					})
			}else if("3" == tab){
				var beginTime=$("#beginTimezs").datetimebox("getValue");
			    var endTime=$("#endTimezs").datetimebox("getValue");
				var gpcode =$("#gpcodezs").val();
				var customname =$("#customnamezs").val();
				var manager = $('#managerBackzs').combobox('getText');
			    var ccstate ="3"
		 	    	$.ajax({
						url: "${pageContext.request.contextPath}/gp/fuzzySearch",
						type: "POST",
						data: {"beginTime":beginTime,
							"endTime":endTime,
							"code":gpcode,
							"customer":customname,
							"manager":manager,
							"ccstate":ccstate
						},
						 
						dataType:"json",
					 
						success:function(data){
							var rows = [];
							for(var i=0; i<data.length; i++){
								rows.push({
									 createtime:data[i].createtime,
									 code:data[i].code,
									 name:data[i]. name,
									 num:data[i].num,
									 costprice: data[i].costprice,
									 money: data[i].money,
									 currentprice:data[i].currentprice,
									 zsprice:data[i].zsprice,
									 daypercent:data[i].daypercent,
									 percent:data[i].percent,
									 ccstate :data[i].ccstate,
								 	 customer :data[i].customer,
									 phone :data[i].phone,
									 manager :data[i].manager,
									 comment:data[i].comment,
								});
							}
							
							 $('#zhisun').datagrid('loadData', rows);
						}

					})
			}
			
		}
		//排序
		/*$("#chicang").datagrid({
			 onSortColumn: function (sort, order,e) {
				 
				 e=e||window.event;
				 e.stopPropagation();
				// sort 点击的字段
				// order 排序方式: desc asc 空
				 $.ajax({
						url: "${pageContext.request.contextPath}/gp/sortAble",
						type: "POST",
						data: {"sheet":"1",
							"order":order,
							"column":sort
						},
						 
						dataType:"json",
					 
						success:function(data){
							var rows = [];
							for(var i=0; i<data.length; i++){
								rows.push({
									 createtime:data[i].createtime,
									 code:data[i].code,
									 name:data[i]. name,
									 num:data[i].num,
									 costprice: data[i].costprice,
									 money: data[i].money,
									 currentprice:data[i].currentprice,
									 zsprice:data[i].zsprice,
									 daypercent:data[i].daypercent,
									 percent:data[i].percent,
									 ccstate :data[i].ccstate,
								 	 customer :data[i].customer,
									 phone :data[i].phone,
									 manager :data[i].manager,
									 comment:data[i].comment,
								});
							}
							debugger
							$('#chicang').datagrid('loadData', rows);
						}

					}) 
			      
			  }
			})*/
 

		
	</script>
