<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>回款管理</title>
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

	<blockquote class="layui-elem-quote layui-text">温馨提示：不可编辑项为编辑股票信息中回写数据</blockquote>

	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>提交回款管理信息</legend>
	</fieldset>

	<form class="layui-form" action="addUiData" method="POST">

		<div class="layui-form-item">
			<label class="layui-form-label">股票代码</label>
			<div class="layui-input-block">
				<input type="text" name="costprice" lay-verify="required|number"
					placeholder="请输入股票代码" autocomplete="off" class="layui-input"
					disabled="disabled"  value="${requestScope.data.code}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">股票名称</label>
			<div class="layui-input-block">
				<input type="text" name="costprice" lay-verify="required|number"
					placeholder="请输入股票名称" autocomplete="off" class="layui-input"
					disabled="disabled"  value="${requestScope.data.sharseName}">
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">客户姓名</label>
			<div class="layui-input-block">
				<input type="text" name="customer" lay-verify="required"
					lay-verify="title" autocomplete="off" placeholder="请输入客户姓名"
					class="layui-input" disabled="disabled"  value="${requestScope.data.customer}">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">客户经理</label>
			<div class="layui-input-block">
				<input type="text" name="manager" lay-verify="required"
					placeholder="请输入客户经理" autocomplete="off" class="layui-input"
					disabled="disabled"  value="${requestScope.data.manager}">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入电话"
					autocomplete="off" class="layui-input" disabled="disabled" value="${requestScope.data.phone}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">止盈时间</label>
			<div class="layui-input-block">
				<input type="text" name="costprice" lay-verify="required|number"
					placeholder="请输入止盈时间" autocomplete="off" class="layui-input"
					disabled="disabled" value="${requestScope.data.updatetime2String}">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">总盈亏</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入总盈亏"
					autocomplete="off" class="layui-input" disabled="disabled" value="${requestScope.data.percent}">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label"> 卖出价</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入卖出价"
					autocomplete="off" class="layui-input">
			</div>
		</div>



		<div class="layui-form-item">
			<label class="layui-form-label">客户盈亏</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入客户盈亏"
					autocomplete="off" class="layui-input">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">分成比例</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入分成比例"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">分成次数</label>
			<div class="layui-input-block">
				<input type="text" name="costprice" lay-verify="required|number"
					placeholder="请输入分成次数" autocomplete="off" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">回款金额</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入回款金额"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">回款银行</label>
			<div class="layui-input-block">
				<input type="text" name="phone" placeholder="请输入回款银行"
					autocomplete="off" class="layui-input">
			</div>
		</div>



		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">备注信息</label>
			<div class="layui-input-block">
				<textarea name="comment" placeholder="请输入备注信息" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				 
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
							form.on('submit(demo1)', function(data) {
								layer.alert(JSON.stringify(data.field), {
									title : '最终的提交信息'
								})
								return false;
							});

						});
	</script>

</body>
</html>