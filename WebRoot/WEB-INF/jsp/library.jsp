<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>广财突突突</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../css/index.css">
<script type="text/javascript" src="../js/jquery.js"></script>
</head>

<body class="body1">
	<a href="<%=basePath%>index"><button class='subbtn' style="width: 150px; height: 50px; position: absolute;" type='button'>返回主界面</button></a>
	<div class="agile-heading heading">
		<h3 style="color:#fc636b">图书服务</h3>
	</div>
	<div class="services" id="services" style="margin-top: 15px; margin-left: 250px">
		<div class="container"> 
			<div class="wthree-services-grids"> 
				<a href="<%=basePath%>hisBollowed?pageNow=1">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg1">
								<h3 id="his" style="">历史借阅</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>历史借阅</h4>
								<p>点击查询历史借阅信息，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="<%=basePath%>nowBollowed?pageNow=1">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg2">
								<h3 id="now" style="">当前借阅</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>当前借阅</h4>
								<p>点击当前借阅信息，突突突</p>
							</div>
						</div>
					</div>
				</a> <a href="<%=basePath%>search">
					<div class="col-sm-3 wthree-services">
						<div class="wthree-services-grid">
							<div class="wthree-services-info bg3">
								<h3 id="search" style="">搜索图书</h3>
							</div>
							<div class="wthree-services-captn">
								<h4>搜索图书</h4>
								<p>点击搜索图书，突突突</p>
							</div>
						</div>
					</div>
				</a>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var system = {};
	var p = navigator.platform;
	system.win = p.indexOf("Win") == 0;
	system.mac = p.indexOf("Mac") == 0;
	system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
	if (!(system.win || system.mac || system.xll)) { //如果是手机
		$("body").attr("class", "body2");
		$("#his").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#now").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
		$("#search").attr("style","padding-top:60px;margin: 1em 0 -40px 0;");
	}
</script>
</html>
