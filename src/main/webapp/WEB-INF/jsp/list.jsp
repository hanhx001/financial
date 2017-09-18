<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>股票信息操作</title>
<meta name="keywords" content="table">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin.css">
</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器， 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<style type="text/css">
body {
	font-size: 1.4rem;
}

.am-btn {
	padding: .5em .8em;
}

.clearfix {
	clear: both;
}

.clearfix:after {
	clear: both;
	content: "";
	display: block;
	height: 0;
	visibility: hidden;
}

.fl {
	float: left;
}

.fr {
	float: right;
}

.pager {
	max-width: 800px;
	text-align: center;
	margin-bottom: 30px;
	display: inline-block;
}

.pager a {
	cursor: pointer;
}

.pager a, .pager span {
	width: 29px;
	height: 28px;
	border: 1px #cccccc solid;
	margin-left: -1px;
	color: #8a8a8a;
	display: inline-block;
	line-height: 28px;
	float: left;
	font-size: 12px;
	text-decoration: none;
	margin: 0 2px;
}

.pager a:hover, .pager span:hover {
	border-color: #3897cd;
	color: #3897cd;
	position: relative;
	z-index: 1;
}

.pager span.current {
	background-color: #3897cd;
	color: #fff;
	border-color: #3897cd;
	position: relative;
	z-index: 1;
}

.pager .pg-first, .pager .pg-prev, .pager .pg-next, .pager .pg-last {
	background: url(assets/i/page_bg.jpg) 0 0 no-repeat;
}

.pager .pg-first:hover, .pager .pg-prev:hover, .pager .pg-next:hover,
	.pager .pg-last:hover {
	background: url(assets/i/page_bg_hover.jpg) 0 0 no-repeat;
}

.pager .pg-prev, .pager .pg-prev:hover {
	background-position: 0 -28px;
}

.pager .pg-next, .pager .pg-next:hover {
	background-position: -29px -28px;
}

.pager .pg-last, .pager .pg-last:hover {
	background-position: -29px 0;
}

.pager .pg-prev[disabled='true'], .pager .pg-prev[disabled='true']:hover
	{
	cursor: default;
	background-image: url(assets/i/page_bg.jpg);
}

.pager .pg-next[disabled='true'], .pager .pg-next[disabled='true']:hover
	{
	cursor: default;
	background-image: url(assets/i/page_bg.jpg);
}

.pager .pg-prev[disabled='true'], .pager .pg-next[disabled='true'] {
	border-color: #eeeeee;
}

.pager span.els {
	border-color: transparent;
}
.cleanUser{
	cursor: pointer;
}

</style>
	<header class="am-topbar am-topbar-inverse admin-header">
		<div class="am-topbar-brand">
			<strong>股票列表</strong> <small></small>
		</div>

		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
			data-am-collapse="{target: '#topbar-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">

			<ul
				class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
				<li class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;"> <span class="am-icon-users"></span> 管理员 <span
						class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="${pageContext.request.contextPath}/"><span
								class="am-icon-power-off"></span> 退出</a></li>
					</ul></li>
				<li class="am-hide-sm-only"><a href="javascript:;"
					id="admin-fullscreen"><span class="am-icon-arrows-alt"></span>
						<span class="admin-fullText">开启全屏</span></a></li>
			</ul>
		</div>
	</header>

	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<ul class="am-list admin-sidebar-list">
					<li class="active"><a href="${pageContext.request.contextPath}/statcPage?page=1"><span class="am-icon-bar-chart-o am-icon-sm"></span> 持仓</a></li>
			        <li><a href="${pageContext.request.contextPath}/statcPage?page=2"><span class="am-icon-line-chart am-icon-sm"></span> 止盈</a></li>
			        <li><a href="${pageContext.request.contextPath}/statcPage?page=3"><span class="am-icon-area-chart am-icon-sm"></span> 止损</a></li>
			        <li><a href="${pageContext.request.contextPath}/statcPage?page=4"><span class="am-icon-star-half-o am-icon-sm"></span> 意向客户</a></li>
			        <li><a href="${pageContext.request.contextPath}/statcPage?page=5"><span class="am-icon-star am-icon-sm"></span> 合作客户</a></li>
     			    <li><a href="${pageContext.request.contextPath}/statcPage?page=5"><span class="am-icon-bell-slash am-icon-sm"></span> 黑名单</a></li>
          			<li><a href="${pageContext.request.contextPath}/statcPage?page=5"><span class="am-icon-fire am-icon-sm"></span> 回款管理</a></li>
    				 <li><a href="${pageContext.request.contextPath}/statcPage?page=5"><span class="am-icon-search am-icon-sm"></span> 客户查询</a></li>
				</ul>
			</div>
		</div>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">
				<div class="am-cf am-padding am-padding-bottom-0">
					<div class="am-fl am-cf">
						<strong class="am-text-primary am-text-lg">首页</strong> / <small>
							清除历史</small>
					</div>
					<div class="am-fr am-cf"></div>
				</div>
				<hr>
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-3">
					</div>
					<div class="am-u-sm-12 am-u-md-3">
						<div class="am-input-group am-input-group-sm">
							<input type="text" class="am-form-field" id="keyword" placeholder="请输入微信号或手机号搜索"> <span
								class="am-input-group-btn">
								<button class="am-btn am-btn-default" type="button" onclick="keyword()">搜索</button>
							</span>
						</div>
					</div>
				</div>

				<div class="am-g">
					<div class="am-u-sm-12">
						<form class="am-form">
							<table
								class="am-table am-table-striped am-table-hover table-main" id="table_wjx">
								<thead>
									<tr>
										<th>序号</th>
										<th class="table-phone">手机号</th>
										<th class="table-weixin">微信号</th>
										<th class="table-set">
											销售量
										</th>
										<th class="table-set">
										库存量 
										</th>
										<th class="table-author">会员有效期</th>
										<th class="table-date ">注册日期</th>
										<th class="table-set">最终备份时间</th>
										<th class="table-set">清理</th>
									</tr>
								</thead>
								<tbody class="statc_list">
								</tbody>
							</table>
							<div class="am-cf">
								共 <span id="totalData">0</span> 条记录
								<div style="text-align: center; margin: 20px auto;">
									<div id="pager" class="pager clearfix"></div>
								</div>
							</div>
						</form>
					</div>

				</div>
			</div>


		</div>
		<!-- content end -->
	</div>

	<a href="#"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"></a>



	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script
		src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/jquery.z-pager.js"
		charset="utf-8"></script>
	<script type="text/javascript">
	function keyword(){
		var $radios = $('[name="options"]');
		statePage("",1,$("#keyword").val());
	}
	//设置导出多少页设置jquery.z-pager.js中最下面的pageData值当前为50条数据
	$(function() {
		
		var $radios = $('[name="options"]');
		statePage("",1,$("#keyword").val());
		$("#pager").click(
				function() {
					statePage("",$("#pager [class=current]").text(),$("#keyword").val());

				});
	});
	function statePage(uid,pageNum,keyword) {
		var pageSize = 50;//一页50条数据
		var url="./ableCleanList";
		var data ={
				"keyword":keyword,
				"pageNum" : pageNum,
				"pageSize" : pageSize
			};
		if(uid!=""&&uid!=null&&uid!="null"&&uid!=undefined&&uid!="undefined"){
			url="./cleanByUid";
			data ={
					"uid":uid,
					"keyword":keyword,
					"pageNum" : pageNum,
					"pageSize" : pageSize
				};
		}
			$.ajax({
						type : "POST",
						url : url,
						data : data,
						dataType : "json",
						success : function(data) {
							var html = "";
							var totalData = 0
							if (data != null) {
								totalData = data.total;
								if (data.list != null && data.list.length > 0) {
									for (var i = 0; i < data.list.length; i++) {
										var n = 50*(pageNum-1)+i+1;
										html += '<tr data-uid='+data.list[i].uid+'>';
										html += '<td>' + n+ '</td>';
										html += '<td>' + data.list[i].phone+ '</td>';
										html += '<td>' + data.list[i].wechat
												+ '</td>';
						
										html += '<td class="num"> ' + data.list[i].orderNum + '</td>';
										html += '<td class="num"> '
												+ data.list[i].goodsOrder
												+ '</td>';
										html += '<td >';
										if (data.list[i].validTime != null) {
											html += data.list[i].validTime;
										}
										html += '</td>';
										html += '<td >';
										if (data.list[i].signinTime != null) {
											html += data.list[i].signinTime;
										}
										html += '</td>';

										html += ' <td >';
										if (data.list[i].lastBackupTime != null) {
											html += data.list[i].lastBackupTime;
										}
										html += '</td>';
										html +='<td><span title="点击清除历史数据" class="am-icon-trash am-icon-sm cleanUser" data-uid='+data.list[i].uid+'></span></td>'
										html += '</tr>';
									}
								} else {
									html = "<tr><td colspan='9'style='  text-align: center;'> 暂无数据！</td></tr>";
								}
							}
							if (pageNum == 1) {

								$("#totalData").text(totalData);
								if (totalData == 0) {
									totalData = 1;
								}
								$("#pager").zPager({
									totalData : totalData
								});
							}
							$(".statc_list").html(html);
	                     	$(".admin-content").scrollTop(0);
							$(".cleanUser").mouseover(function(){
								$(this).attr("class","am-icon-trash-o am-icon-sm cleanUser");
							});
							$(".cleanUser").mouseout(function(){
								$(this).attr("class","am-icon-trash am-icon-sm cleanUser");
							});
							$(".cleanUser").click(function(){
								var data_uid = $(this).attr("data-uid");
								statePage(data_uid,pageNum,keyword);
								$(this).parent().siblings(".num").text(0);
							});
							if(uid!=""&&uid!=null&&uid!="null"&&uid!=undefined&&uid!="undefined"){
								alert("数据清理成功!");
							}
						}
					});
		}
	</script>
</body>
</html>
