<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理股票信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="./css/layui.css" media="all">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/i/favicon.png">
</head>
<body>
	<blockquote class="layui-elem-quote layui-text">温馨提示：本页面主要功能是更新用户信息</blockquote>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>更新客户基本信息</legend>
	</fieldset>

	<form class="layui-form" action="updateOneSharesDetail" method="POST">
		<div class="layui-form-item">
			<label class="layui-form-label">客户名称</label>
			<div class="layui-input-block">
				<input type="text" name="customer" lay-verify="required"
					lay-verify="title" autocomplete="off" placeholder="请输入客户名称"
					class="layui-input" value="${requestScope.data.customer}">
			</div>
		</div>
		<input type="hidden" value="${requestScope.data.id}" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">人员状态</label>
			<div class="layui-input-block">
				<select classs="sharestate" name="state" lay-filter="aihao"
					lay-verify="required">
					<option value="" selected=""></option>
					<option value="0">合作</option>
					<option value="1">意向</option>
					<option value="4">拉黑</option>
					<option value="2">停用</option>

				</select>
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">客户经理</label>
			<div class="layui-input-block">
				<input type="text" name="manager" lay-verify="required"
					placeholder="请输入客户经理" autocomplete="off" class="layui-input"
					value="${requestScope.data.manager}">
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">客户电话</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入电话"
					autocomplete="off" class="layui-input"
					value="${requestScope.data.phone}">
			</div>
		</div>


		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">黑名单备注</label>
			<div class="layui-input-block">
				<textarea name="comment" placeholder="请输入将此用户加入黑名单的原因"
					class="layui-textarea"></textarea>
			</div>
		</div>


		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<!-- 不弹出提示，直接关闭当前页面 -->
				<button class="layui-btn layui-btn-primary" lay-submit=""
					lay-filter="demo1"
					onclick="javascript:window.opener=null;window.open('','_self');window.close();">关闭</button>

			</div>
		</div>
	</form>

</body>
</html>

<script type="text/javascript" src="./layui.js" charset="utf-8"></script>


<script>
	layui
			.use(
					[ 'form', 'layedit', 'laydate' ],
					function() {
						var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

						//日期
						laydate.render({
							elem : '#date'
						});
						laydate.render({
							elem : '#date1'
						});

						//创建一个编辑器
						var editIndex = layedit.build('LAY_demo_editor');

						//自定义验证规则
						form.verify({
							title : function(value) {
								if (value.length < 5) {
									return '标题至少得5个字符啊';
								}
							},
							pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
							content : function(value) {
								layedit.sync(editIndex);
							}
						});

						//监听指定开关
						form.on('switch(switchTest)', function(data) {
							layer.msg('开关checked：'
									+ (this.checked ? 'true' : 'false'), {
								offset : '6px'
							});
							layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF',
									data.othis)
						});

						//监听提交
						form.on('submit(demo1)', function(data) {
							layer.alert(JSON.stringify(data.field), {
								title : '最终的提交信息'
							})
							return false;
						});

					});
</script>
