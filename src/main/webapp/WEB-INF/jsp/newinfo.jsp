<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>股票基本信息录入</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="./css/layui.css" media="all">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/i/favicon.png">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

	<blockquote class="layui-elem-quote layui-text">温馨提示：股票代码
		要录入前面的字母</blockquote>

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>股票基本信息录入</legend>
	</fieldset>

	<form class="layui-form" action="addUiData" method="POST">
		<div class="layui-form-item">
			<label class="layui-form-label">股票代码</label>
			<div class="layui-input-block">
				<input type="text" name="code" lay-verify="required"
					lay-verify="title" autocomplete="off" placeholder="请输入代码"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">股票数量</label>
			<div class="layui-input-block">
				<input type="text" name="num" lay-verify="required|number"
					placeholder="请输入数量" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">客户姓名</label>
			<div class="layui-input-block">
				<input type="text" name="customer" lay-verify="required"
					lay-verify="title" autocomplete="off" placeholder="请输入客户姓名"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户经理</label>
			<div class="layui-input-block">
				<input type="text" name="manager" lay-verify="required"
					placeholder="请输入客户经理" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">成本价</label>
			<div class="layui-input-block">
				<input type="text" name="costprice" lay-verify="required|number"
					placeholder="请输入成本价" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入电话"
					autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注信息</label>
			<div class="layui-input-block">
				<textarea name="comment" placeholder="请输入内容" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>


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
							//form.on('submit(demo1)', function(data) {
							//	layer.alert(JSON.stringify(data.field), {
							//		title : '最终的提交信息'
							//	})
							//	return false;
							//});

						});
	</script>

</body>
</html>