<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>登陆认证-失败</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3> 欢迎 </h3>
						<form action="${pageContext.request.contextPath}/loginloading" id="f" method="POST">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" class="text" style="color: #FFFFFF !important" type="text" placeholder="写下你的登录名">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit" href="#"  onclick="document.getElementById('f').submit();" style="color: #FFFFFF">登陆</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
		<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
	 
	</body>
</html>