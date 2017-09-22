<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>股票详情</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="./css/layui.css" media="all">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/i/favicon.png">
</head>
<body>
	<blockquote class="layui-elem-quote layui-text">温馨提示：这里是你点击股票代码后
		跳转的详情界面</blockquote>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>查看股票基本信息</legend>
	</fieldset>

	<form class="layui-form" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">股票代码</label>
			<div class="layui-input-block">
				<input type="text" name="code" lay-verify="required"
					lay-verify="title" autocomplete="off" placeholder="请输入代码"
					class="layui-input" value="${requestScope.data.code}"
					disabled="disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">股票数量</label>
			<div class="layui-input-block">
				<input type="text" name="num" lay-verify="required|number"
					placeholder="请输入数量" autocomplete="off" class="layui-input"
					value="${requestScope.data.num}" disabled="disabled">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户姓名</label>
			<div class="layui-input-block">
				<input type="text" name="customer" lay-verify="required"
					lay-verify="title" autocomplete="off" placeholder="请输入客户姓名"
					class="layui-input" value="${requestScope.data.customer}"
					disabled="disabled">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户经理</label>
			<div class="layui-input-block">
				<input type="text" name="manager" lay-verify="required"
					placeholder="请输入客户经理" autocomplete="off" class="layui-input"
					value="${requestScope.data.manager}" disabled="disabled">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">成本价</label>
			<div class="layui-input-block">
				<input type="text" name="costprice" lay-verify="required|number"
					placeholder="请输入成本价" autocomplete="off" class="layui-input"
					value="${requestScope.data.costPrice}" disabled="disabled">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入电话"
					autocomplete="off" class="layui-input"
					value="${requestScope.data.phone}" disabled="disabled">
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注信息</label>
			<div class="layui-input-block">
				<textarea name="comment" placeholder="请输入内容" class="layui-textarea"
					disabled="disabled">${requestScope.data.comment}</textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<!-- 不弹出提示，直接关闭当前页面 -->
				<button class="layui-btn" lay-submit="" lay-filter="demo1"
					onclick="javascript:window.opener=null;window.open('','_self');window.close();">关闭</button>

			</div>
		</div>
	</form>

</body>
</html>

