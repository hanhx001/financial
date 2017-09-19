<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>页面找不到</title>
<!-- Bootstrap core CSS -->
<link href="./404/css/bootstrap.css" rel="stylesheet">
<!-- FONT AWESOME CSS -->
<link href="./404/css/font-awesome.min.css" rel="stylesheet" />
<!--GOOGLE FONT -->

<!-- custom CSS here -->
<link href="./404/css/style.css" rel="stylesheet" />
</head>
<body>


	<div class="container">

		<div class="row pad-top text-center">
			<div class="col-md-6 col-md-offset-3 text-center">
				<h1>你刚才到底干了什么?</h1>

				<span id="error-link"></span>
				<h2>! 页面找不到了 !</h2>
			</div>
		</div>

		<div class="row text-center">
			<div class="col-md-8 col-md-offset-2">

				<h3>
					<i class="fa fa-lightbulb-o fa-5x"></i>
				</h3>
				<a href="${pageContext.request.contextPath}/navigation?page=1"
					class="btn btn-primary">带你回首页</a>

			</div>
		</div>

	</div>


	<!--Core JavaScript file  -->
	<script src="./404/js/jquery-1.10.2.js"></script>
	<!--bootstrap JavaScript file  -->
	<script src="./404/js/bootstrap.js"></script>
	<!--Count Number JavaScript file  -->
	<script src="./404/js/countUp.js"></script>
	<!--Custom JavaScript file  -->
	<script src="./404/js/custom.js"></script>
</body>
</html>
